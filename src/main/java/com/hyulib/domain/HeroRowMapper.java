package com.hyulib.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class HeroRowMapper implements RowMapper<Hero> {

	@Override
	public Hero mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Hero hero = new Hero();		
		hero.setId(rs.getInt("ID"));
		hero.setName(rs.getString("NAME"));	
		return hero;
	}

}