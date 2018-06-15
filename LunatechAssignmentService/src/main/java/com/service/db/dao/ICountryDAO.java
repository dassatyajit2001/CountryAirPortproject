package com.service.db.dao;

import java.util.List;

import com.service.bean.AirportBean;
import com.service.bean.CountryBean;
import com.service.bean.RunwayBean;

public interface ICountryDAO {

	/** 
	  * This is the method to be used to create
	  * a in the Country table.
	  */
	 void create(CountryBean countryBean);
	 
	 
	 /** 
	  * This is the method to be used get a row form country
	  * table based on Id
	  */

	 CountryBean getCountryByCode(String code);
	 
	 
	 /** 
	  * This is the method to be used to delete
	  * a record from the Country table corresponding
	  * to the id.
	  */
	 void delete(Integer id);
	 
	 
	  void updateCountryBatch(List<CountryBean> beans);
	  
	  public void updateAirportBatch(List<AirportBean> beans) ;
	  
	  public void updateRunwayBatch(List<RunwayBean> beans) ;
	 
	
}
