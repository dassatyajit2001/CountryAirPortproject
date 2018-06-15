package com.service.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.service.bean.CntryArptrtRnwyRespBean;

public class CntryArptrtRnwyRespBeanMapper implements RowMapper<CntryArptrtRnwyRespBean>{

	@Override
	public CntryArptrtRnwyRespBean mapRow(ResultSet rs, int val) throws SQLException {
		return (new CntryArptrtRnwyRespBean()).
				setCountryId(rs.getInt("countryId")).
				setAirportId(rs.getInt("airportId")).
				setRunwayId(rs.getInt("runwayId")).
				setAirportType(rs.getString("airportType")).
				setAirportName(rs.getString("airportName")).
				setCountryCode(rs.getString("countryCode")).
				setCountryName(rs.getString("countryName"));
		//		setRunwaySurface(rs.getString("runwaySurface"));
		
	}
}
