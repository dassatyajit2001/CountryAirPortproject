package com.service.util;

import com.service.bean.AirportBean;
import com.service.bean.CountryBean;
import com.service.bean.RunwayBean;

public class CacheUtil {

	/**
	 * Reads the string line and populates the Runway Bean
	 * 
	 * @param line
	 * @return
	 */
	public static RunwayBean loadRunwayBean(String line) {
		String[] runway = line.split(IConstants.CVS_SPLIT_VALUE);
		return new RunwayBean().
				setId(Integer.parseInt(runway[0])).
				setAirportRef(runway[1]).
				setAirportIdent(runway[2]).
				setLengthFt(runway[3]).
				setWidthFt(runway[4]).
				setSurface(runway[5]).
				setLighted(runway[6]).
				setClosed(runway.length == 8 ? runway[7] : null).
				setLeIdent(runway.length == 9 ? runway[8] : null).
				setLeLatitudeDeg(runway.length == 10 ? runway[9] : null).
				setLeLongitudeDeg(runway.length == 11 ? runway[10] : null).
				setLeElevationFt(runway.length == 12 ? runway[11] : null).
				setLeHeadingDegT(runway.length == 13 ? runway[12] : null).
				setLeDisplacedThresholdFt(runway.length == 14 ? runway[13] : null).
				setHeIdent(runway.length == 15 ? runway[14] : null).
				setHeLatitudeDeg(runway.length == 16 ? runway[15] : null).
				setHeLongitudeDeg(runway.length == 17 ? runway[16] : null).
				setHeElevationFt(runway.length == 18 ? runway[17] : null).
				setHeHeadingDegT(runway.length == 19 ? runway[18] : null).
				setHeDisplacedThresholdFt(runway.length == 20 ? runway[19] : null);
	}
	
	/**
	 * Reads the string line and populates the Airport Bean
	 * 
	 * @param line
	 * @return
	 */
	public static AirportBean loadAirportBean(String line) {
		String[] airport = line.split(IConstants.CVS_SPLIT_VALUE);
		return new AirportBean().
				setId(Integer.parseInt(airport[0])).
				setIdent(airport[1]).
				setType(airport[2]).
				setName(airport[3]).
				setLatitudeDeg(airport[4]).
				setLongitudeDeg(airport[5]).
				setElevationFt(airport[6]).
				setContinent(airport[7]).
				setIsoCountry(airport[8]).
				setIsoRegion(airport[9]).
				setMunicipality(airport.length >= 11 ? airport[10] : null).
				setScheduledService(airport.length >= 12 ? airport[11] : null).
				setGpsCode(airport.length >= 13 ? airport[12] : null).
				setIataCode(airport.length >= 14 ? airport[13] : null).
				setLocalCode(airport.length >= 15 ? airport[14] : null).
				setHomeLink(airport.length >= 16 ? airport[15] : null).
				setWikipediaLink(airport.length >= 17 ? airport[16] : null)
				.setKeywords(airport.length == 18 ? airport[17] : null);

	}
	
	/**
	 * Reads the string line and populates the country Bean
	 * 
	 * @param line
	 * @return
	 */
	public static CountryBean loadCountryBean(String line) {
		String[] country = line.split(IConstants.CVS_SPLIT_VALUE);
		return new CountryBean().
				setId(Integer.parseInt(country[0])).
				setCode(country[1]).
				setName(country[2]).
				setContinent(country[3]).
				setWikipediaLink(country[4])
				.setKeywords(country.length == 6 ? country[5] : null);

	}
}
