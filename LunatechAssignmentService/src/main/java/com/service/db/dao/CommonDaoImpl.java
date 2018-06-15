package com.service.db.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;

import com.service.bean.AirportBean;
import com.service.bean.CountryBean;
import com.service.bean.RunwayBean;
import com.service.db.mapper.CountryBeanMapper;
import com.service.exception.CustomException;
import com.service.exception.ExceptionBean;
import com.service.util.IConstants;
import com.service.util.IQueryConstants;

@Repository
public class CommonDaoImpl implements ICountryDAO, IAirportDAO, IRunwayDAO {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public void create(CountryBean countryBean) {
		// TODO Auto-generated method stub

	}

	@Override
	public CountryBean getCountryByCode(String code) {
		String SQL = IQueryConstants.COUNTRY_QUERY_GET_BY_ID;
		SqlParameterSource namedParameters = new MapSqlParameterSource("code", code);
		CountryBean countryBean = (CountryBean) namedParameterJdbcTemplate.queryForObject(SQL, namedParameters,
				new CountryBeanMapper());
		return countryBean;

	}

	public List<Map<String, Object>> getAirportAndRunwayDetailsViaCountry(Map<String, String> criteria) {
		String SQL = null;
		if (criteria.keySet().size() == 1) {
			if (criteria.keySet().contains("code")) {
				SQL = IQueryConstants.COUNTRY_AIRPORT_RUNWAY_QUERY_GET_BY_COUNTRY_CODE;
			} else {
				SQL = IQueryConstants.COUNTRY_AIRPORT_RUNWAY_QUERY_GET_BY_COUNTRY_NAME;
			}

		}
		List<Map<String, Object>> countryBean = namedParameterJdbcTemplate.queryForList(SQL, criteria);
		if (countryBean != null && countryBean.isEmpty()) {
			throw new CustomException((new ExceptionBean()).setExceptionCode(IConstants.NODATAFOUNDEXCEPTION)
					.setExceptionMessage(IConstants.NODATAFOUNDEXCEPTION_DESCR));
		}
		return countryBean;

	}

	public List<Map<String, Object>> noOfAirportsPerCountry(Map<String, String> criteria) {

		List<Map<String, Object>> countryReportList = null;
		String sql;

		sql = IQueryConstants.COUNTRY_NO_OF_AIRPORT_REPORT;
		for (Entry<String, String> entry : criteria.entrySet()) {
			sql = sql.replace(entry.getKey(), entry.getValue());
		}
		;
		countryReportList = namedParameterJdbcTemplate.queryForList(sql, criteria);
		if (countryReportList != null && countryReportList.isEmpty()) {
			throw new CustomException((new ExceptionBean()).setExceptionCode(IConstants.NODATAFOUNDEXCEPTION)
					.setExceptionMessage(IConstants.NODATAFOUNDEXCEPTION_DESCR));
		}

		return countryReportList;
	}

	public List<Map<String, Object>> topCommonUncommonRunwayAttribute(Map<String, String> criteriaMap) {
		List<Map<String, Object>> countryReportList = null;
		String sql;

		sql = IQueryConstants.RUNWAY_COMMON_UNCOMMON_REPORT;
		for (Entry<String, String> entry : criteriaMap.entrySet()) {
			sql = sql.replace(entry.getKey(), entry.getValue());
		}
		;
		countryReportList = namedParameterJdbcTemplate.queryForList(sql, criteriaMap);
		if (countryReportList != null && countryReportList.isEmpty()) {
			throw new CustomException((new ExceptionBean()).setExceptionCode(IConstants.NODATAFOUNDEXCEPTION)
					.setExceptionMessage(IConstants.NODATAFOUNDEXCEPTION_DESCR));
		}
		return countryReportList;
	}

	public List<Map<String, Object>> getRunwayTypesPerCountry(String countrycode) {
		List<Map<String, Object>> countryReportList = null;
		Map<String, String> criteria = new HashMap<>();
		criteria.put("countrycode", countrycode);
		String sql;
		sql = IQueryConstants.RUNWAYS_TYPES_PER_COUNTRY_REPORT;
		countryReportList = namedParameterJdbcTemplate.queryForList(sql, criteria);
		if (countryReportList != null && countryReportList.isEmpty()) {
			throw new CustomException((new ExceptionBean()).setExceptionCode(IConstants.NODATAFOUNDEXCEPTION)
					.setExceptionMessage(IConstants.NODATAFOUNDEXCEPTION_DESCR));
		}
		return countryReportList;
	}

	@Override
	public List<AirportBean> getAirports() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateCountryBatch(List<CountryBean> beans) {

		String query = IQueryConstants.INSERT_COUNTRY_QUERY;

		SqlParameterSource[] listofforests = SqlParameterSourceUtils.createBatch(beans.toArray());
		// Return's the number of rows inserted.
		namedParameterJdbcTemplate.batchUpdate(query, listofforests);

	}

	@Override
	public void updateAirportBatch(List<AirportBean> beans) {

		String query = IQueryConstants.INSERT_AIRPORT_QUERY;

		SqlParameterSource[] listofAirport = SqlParameterSourceUtils.createBatch(beans.toArray());
		// Return's the number of rows inserted.
		namedParameterJdbcTemplate.batchUpdate(query, listofAirport);

	}

	@Override
	public void updateRunwayBatch(List<RunwayBean> beans) {

		String query = IQueryConstants.INSERT_RUNWAY_QUERY;

		SqlParameterSource[] listofRunway = SqlParameterSourceUtils.createBatch(beans.toArray());
		// Return's the number of rows inserted.
		namedParameterJdbcTemplate.batchUpdate(query, listofRunway);

	}

	@Override
	public void create(RunwayBean RunwayBean) {
		// TODO Auto-generated method stub

	}

	@Override
	public void getRunway(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void create(AirportBean AirportBean) {
		// TODO Auto-generated method stub

	}

	@Override
	public void getAirport(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<RunwayBean> getRunways() {
		// TODO Auto-generated method stub
		return null;
	}

}
