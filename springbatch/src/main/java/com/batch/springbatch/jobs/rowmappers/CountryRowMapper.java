package com.batch.springbatch.jobs.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.batch.springbatch.jobs.model.CountryModel;

public class CountryRowMapper implements RowMapper<CountryModel> {

	/*
	 * (non-Javadoc)
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
	 */
	public CountryModel mapRow(ResultSet resultSet, int rowNum) throws SQLException {

	  CountryModel model = new CountryModel();
	  model.setIsoCode(resultSet.getString("ISO_CODE"));
	  model.setCountry(resultSet.getString("COUNTRY"));
		
	  return model;
	  
	}

}
