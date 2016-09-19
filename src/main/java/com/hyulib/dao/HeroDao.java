package com.hyulib.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hyulib.domain.Hero;
import com.hyulib.domain.HeroRowMapper;

@Repository
public class HeroDao {

	@Autowired
	JdbcTemplate jdbcTemplate = new JdbcTemplate();

	public List<Hero> findAll() {

		String sql = "SELECT * FROM Hero order by ID ";
		List<Hero> heroes = jdbcTemplate.query(sql, new HeroRowMapper());
		return heroes;
	}

	public Hero findOne(String id) {
		String sql = "SELECT * FROM Hero WHERE ID= ?";
		Hero hero = (Hero) jdbcTemplate.queryForObject(sql, new Object[] { id }, new HeroRowMapper());
		return hero;
	}

	public Hero save(Hero hero) {
		String sql = "INSERT INTO Hero (name) VALUES (?)";
		jdbcTemplate.update(sql, new Object[] {hero.getName()});
		return hero;
	}

	public void delete(String id) {
		String sql = "DELETE FROM Hero WHERE ID=?";
		jdbcTemplate.update(sql, id);
	}

	public Hero update(String id, Hero hero) {
		String sql = "UPDATE Hero SET NAME=? WHERE ID=?";
		jdbcTemplate.update(sql, new Object[] { hero.getName(), id });
		return hero;
	}
	
	public List<Hero> findName(String term) {
		String sql = "SELECT * FROM HERO WHERE NAME like ?";
		List<Hero> heroes = jdbcTemplate.query(sql, new HeroRowMapper(), new Object[] { term+"%" });
		return heroes;
	
	}
}
