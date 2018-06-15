package com.service.processor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.service.bean.AirportBean;
import com.service.bean.CountryBean;
import com.service.bean.RunwayBean;
import com.service.db.dao.CommonDaoImpl;
import com.service.util.CacheUtil;
import com.service.util.IConstants;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

@Component
public abstract class BaseServerPreProcesor {

	public static Map<Integer, CountryBean> mapCountry = null;
	public static Map<Integer, AirportBean> mapAirport = null;
	public static Map<Integer, RunwayBean> mapRunway = null;

	protected static final CacheManager cacheManager = CacheManager.getInstance();
	protected static final Cache cache1 = cacheManager.getCache(IConstants.CACHE1_VALUE);

	@Autowired
	private CommonDaoImpl beanDaoImpl;

	final protected void loadAllCache() {
		new Thread(() -> loadCountryData()).start();
		new Thread(() -> loadAirportsData()).start();
		new Thread(() -> loadRunwayData()).start();
	}

	/*
	 * final protected void loadDeriveCache() { Map<String, CountryBean>
	 * countryMap=(Map<String,
	 * CountryBean>)cache1.get(IConstants.COUNTRY_CACHE_KEY).getObjectValue();
	 * Map<String, AirportBean> airportMap=(Map<String,
	 * AirportBean>)cache1.get(IConstants.AIRPORT_CACHE_KEY).getObjectValue();
	 * countryMap.keySet().forEach(n->{ airportMap.values().forEach(v->{
	 * if(n.equals(v.getIsoCountry())) { countryMap.get(n).get } }); });
	 * 
	 * }
	 */

	/**
	 * This method loads the country data to the cache by reading the csv files
	 */
	private  final void loadCountryData() {

		String line = null;
		try{
			Map<String, CountryBean> countryMap=new BufferedReader(new FileReader(IConstants.COUNTRY_FILE_PATH_VALUE)).
					lines().
					skip(1).
					map(CacheUtil::loadCountryBean).
					collect(
							Collectors.toMap(m -> m.getCode(), m -> m));
			for(Map.Entry<String, CountryBean> entry:countryMap.entrySet())
			{
				System.out.println(entry.getKey()+"  "+entry.getValue());
			}
							cache1.put(new Element(IConstants.COUNTRY_CACHE_KEY,  countryMap));
			
			List<CountryBean> countryList = new BufferedReader(new FileReader(IConstants.COUNTRY_FILE_PATH_VALUE)).
					lines().
					skip(1).
					map(CacheUtil::loadCountryBean).
					collect(
							Collectors.toList());
			beanDaoImpl.updateCountryBatch(countryList);


		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method loads the Airport data to the cache by reading the csv files
	 */
	private final void loadAirportsData() {

		String line = null;
		try {
			cache1.put(new Element(IConstants.AIRPORT_CACHE_KEY,
					new BufferedReader(new FileReader(IConstants.AIRPORT_FILE_PATH_VALUE)).lines().skip(1)
							.map(CacheUtil::loadAirportBean).collect(Collectors.toMap(m -> m.getId(), m -> m))));

			List<AirportBean> airportList = new BufferedReader(new FileReader(IConstants.AIRPORT_FILE_PATH_VALUE))
					.lines().skip(1).map(CacheUtil::loadAirportBean).collect(Collectors.toList());
			beanDaoImpl.updateAirportBatch(airportList);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method loads the Runway data to the cache by reading the csv files
	 */
	private final void loadRunwayData() {

		String line = null;
		try {
			cache1.put(new Element(IConstants.RUNWAY_CACHE_KEY,
					new BufferedReader(new FileReader(IConstants.RUNWAY_FILE_PATH_VALUE)).lines().skip(1)
							.map(CacheUtil::loadRunwayBean).collect(Collectors.toMap(m -> m.getId(), m -> m))));

			List<RunwayBean> runwayList =new BufferedReader(new FileReader(IConstants.RUNWAY_FILE_PATH_VALUE)).lines().skip(1)
					.map(CacheUtil::loadRunwayBean).collect(Collectors.toList());
			beanDaoImpl.updateRunwayBatch(runwayList);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
