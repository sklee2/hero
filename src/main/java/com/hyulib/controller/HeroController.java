package com.hyulib.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hyulib.dao.HeroDao;
import com.hyulib.domain.Hero;

@CrossOrigin

@RestController
@RequestMapping("heroes")
public class HeroController {
	@Autowired
	private HeroDao heroDao;

	@RequestMapping(method = RequestMethod.GET)
	public List<Hero> getAll() {
		return heroDao.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public Hero get(@PathVariable String id) {
		return heroDao.findOne(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Hero create(@RequestBody Hero hero) {
		return heroDao.save(hero);

	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public void delete(@PathVariable String id) {
		heroDao.delete(id);

	}

	@RequestMapping(method = RequestMethod.PUT, value = "{id}")
	public Hero update(@PathVariable String id, @RequestBody Hero hero) {
		return heroDao.update(id, hero);

	}
	@RequestMapping(value="search",method = RequestMethod.GET)
	public List<Hero> searchName(@RequestParam(value = "name") String term) {
		System.out.println(term);
		return heroDao.findName(term);
	}
}
