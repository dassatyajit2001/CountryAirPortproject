package com.service.db.dao;

import java.util.List;

import com.service.bean.RunwayBean;

public interface IRunwayDAO {

	/** 
	  * This is the method to be used to create
	  * a in the Runway table.
	  */
	 void create(RunwayBean RunwayBean);
	 
	 
	 /** 
	  * This is the method to be used get a row form Runway
	  * table based on Id
	  */

	 void getRunway(Integer id);
	 
	 
	 /** 
	  * This is the method to get to list 
	  * the records from the Countries table.
	  */
	 List<RunwayBean> getRunways();
	 
	 
	 /** 
	  * This is the method to be used to delete
	  * a record from the Runway table corresponding
	  * to the id.
	  */
	 void delete(Integer id);
	 
	
}
