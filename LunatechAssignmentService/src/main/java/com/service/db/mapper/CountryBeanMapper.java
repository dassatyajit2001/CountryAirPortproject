package com.service.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.service.bean.CountryBean;

public class CountryBeanMapper implements RowMapper<CountryBean>{

	@Override
	public CountryBean mapRow(ResultSet rs, int val) throws SQLException {
		return (new CountryBean()).
				setId(rs.getInt("id")).
				setCode(rs.getString("code")).
				setContinent(rs.getString("continent")).
				setName(rs.getString("name")).
				setWikipediaLink(rs.getString("wikipedialink")).
				setKeywords(rs.getString("keywords"));
		
	}

}
