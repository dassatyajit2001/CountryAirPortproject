package com.service.db.dao;

import java.util.List;

import com.service.bean.AirportBean;

public interface IAirportDAO {

	/** 
	  * This is the method to be used to create
	  * a in the Airport table.
	  */
	 void create(AirportBean AirportBean);
	 
	 
	 /** 
	  * This is the method to be used get a row form Airport
	  * table based on Id
	  */

	 void getAirport(Integer id);
	 
	 
	 /** 
	  * This is the method to get to list 
	  * the records from the Countries table.
	  */
	 List<AirportBean> getAirports();
	 
	 
	 /** 
	  * This is the method to be used to delete
	  * a record from the Airport table corresponding
	  * to the id.
	  */
	 void delete(Integer id);
	 
	
}
