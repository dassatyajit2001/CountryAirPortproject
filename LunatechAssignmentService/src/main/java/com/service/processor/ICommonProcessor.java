package com.service.processor;

import java.util.List;
import java.util.Map;

public interface ICommonProcessor {

	List<Map<String,Object>> processRequestForQuery(String entity,Map<String, String> criteriaMap);
	List<Map<String,Object>> noOfAirportsPerCountry(Map<String, String> criteriaMap) ;
	Object processGetCountryByCode(String code);
	List<Map<String,Object>> topCommonUncommonRunwayAttribute(Map<String, String> criteriaMap);
	List<Map<String,Object>> getRunwayTypesPerCountry(String country);
	
}
