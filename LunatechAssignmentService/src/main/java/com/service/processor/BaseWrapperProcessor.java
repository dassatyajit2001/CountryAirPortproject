package com.service.processor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaseWrapperProcessor {

	@Autowired
	ICommonProcessor commonProcessor;

	public List<Map<String,Object>> processQuery(String entity,String queryType, String value,boolean fuzzyLogic) {
		Map<String, String> criteriaMap=new HashMap<>();
		if(fuzzyLogic)
			value+="%";
		
				criteriaMap.put(queryType, value);
		return commonProcessor.processRequestForQuery(entity,criteriaMap);
	}
	
	public List<Map<String,Object>> noOfAirportsPerCountry(String order, String value) {	
		Map<String, String> criteriaMap=new HashMap<>();
		criteriaMap.put("sortOrder", order);
		criteriaMap.put("num", value);
		return commonProcessor.noOfAirportsPerCountry(criteriaMap);
	}
	
	public List<Map<String,Object>> topCommonUncommonRunwayAttribute(String attribute,String order, String value) {	
		Map<String, String> criteriaMap=new HashMap<>();
		criteriaMap.put("attribute", attribute);
		criteriaMap.put("sortOrder", order);
		criteriaMap.put("num", value);
		return commonProcessor.topCommonUncommonRunwayAttribute(criteriaMap);
	}
	public List<Map<String,Object>> getRunwayTypesPerCountry(String country) {	
		
		
		return commonProcessor.getRunwayTypesPerCountry(country);
	}

	public Object processGetEntityById(String code) {

		return commonProcessor.processGetCountryByCode(code);
	}

}
