package com.service.processor;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.cache.CacheManager;
import com.service.db.dao.DaoWrapper;

@Service
public class CommonProcessorImpl implements ICommonProcessor{

	@Autowired
	CacheManager cachemanager;
	
@Autowired
	DaoWrapper dao; 
	
	
	
	
	public Object processGetCountryByCode(String code) {
		
		
		return cachemanager.getCountryDataByCode(code);
	}
		
	@Override
	public List<Map<String,Object>> noOfAirportsPerCountry(Map<String, String> criteriaMap){
		
		
		return dao.noOfAirportsPerCountry(criteriaMap);
	}
	
	@Override
	public List<Map<String,Object>> processRequestForQuery(String entity, Map<String, String> criteriaMap) {
		List<Map<String,Object>> list=null;
		if(entity.equals("country"))
		{
			list=	dao.processCustomObjectByCriteria(entity, criteriaMap);
		}
		return list;
	}
	
	@Override
	public List<Map<String,Object>> topCommonUncommonRunwayAttribute(Map<String, String> criteriaMap){
		
		List<Map<String,Object>> list=null;
		list=	dao.topCommonUncommonRunwayAttribute(criteriaMap);
		return list;
	}
	
	
	@Override
	public List<Map<String,Object>> getRunwayTypesPerCountry(String country){
		
		List<Map<String,Object>> list=null;
		
			list=	dao.getRunwayTypesPerCountry(country);
		
		return list; 
	}
	
}
