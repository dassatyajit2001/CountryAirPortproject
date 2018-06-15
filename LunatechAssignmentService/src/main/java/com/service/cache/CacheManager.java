package com.service.cache;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.service.bean.CountryBean;
import com.service.db.dao.DaoWrapper;
import com.service.processor.BaseServerPreProcesor;
import com.service.util.IConstants;

@Controller
public class CacheManager extends BaseServerPreProcesor{
	
	@Autowired
	DaoWrapper dao; 
	
	public void getAirportData()
	{
		cache1.get(IConstants.AIRPORT_CACHE_KEY).getObjectValue();
	}
	
	public void getRunwayData()
	{
		cache1.get(IConstants.RUNWAY_CACHE_KEY).getObjectValue();
	}
	
	public CountryBean getCountryDataByCode(String code)
	{
		if(((Map<String, CountryBean>)cache1.get(IConstants.COUNTRY_CACHE_KEY).getObjectValue()).get(code)==null){
			CountryBean bean=(CountryBean)dao.processGetCountryByCode(code);
			((Map<String, CountryBean>)cache1.get(IConstants.COUNTRY_CACHE_KEY).getObjectValue()).put(code, (bean));
		}
		return ((Map<String, CountryBean>)cache1.get(IConstants.COUNTRY_CACHE_KEY).getObjectValue()).get(code);
	}
	
	public void loadData()
	{
		super.loadAllCache();
	}

}
