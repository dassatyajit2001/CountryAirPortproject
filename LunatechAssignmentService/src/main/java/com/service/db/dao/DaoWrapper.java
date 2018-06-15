package com.service.db.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DaoWrapper {

	@Autowired
	CommonDaoImpl countryDAO;
	
	public Object processGetCountryByCode(String code)
	{
		Object row=null;
		
				row=countryDAO.getCountryByCode(code);
		
		
		return row;
	}
	
	public List<Map<String,Object>> processCustomObjectByCriteria(String entity,Map<String, String> criteria)
	{
		List<Map<String,Object>> row=null;
		switch(entity)
		{
			case "country":
			{
				row=countryDAO.getAirportAndRunwayDetailsViaCountry(criteria);
			}
		}
		return row;
	}
	
	
	public List<Map<String,Object>> noOfAirportsPerCountry(Map<String, String> criteria)
	{
		List<Map<String,Object>> row=null;
		row=countryDAO.noOfAirportsPerCountry(criteria);
		return row;
	}
	
	public List<Map<String,Object>> topCommonUncommonRunwayAttribute(Map<String, String> criteria){
		
		List<Map<String,Object>> row=null;
		row=countryDAO.topCommonUncommonRunwayAttribute(criteria);
		
		return row;
	}
	
	public List<Map<String,Object>> getRunwayTypesPerCountry(String country){
		List<Map<String,Object>> row=null;
		row=countryDAO.getRunwayTypesPerCountry(country);
		return row;
	}
}
