package org.marketing.hikefactory.service.impl;

import java.util.List;

import org.marketing.hikefactory.model.Hike;
import org.marketing.hikefactory.repository.HikeRepository;
import org.marketing.hikefactory.service.HikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class HikeServiceImpl implements HikeService {

	@Autowired
	private HikeRepository hikeRepository;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void registerHike(Hike hike) {
		System.out.println("Registration: " + hike);
		hikeRepository.saveHike(hike);

	}

	@Override
	public List<Hike> findAll() {
		 
		final String sql2 = "SELECT * FROM hikes";

	    List<Hike> hikes = jdbcTemplate.query(sql2, new BeanPropertyRowMapper<Hike>(Hike.class));
	    return hikes;
	}
}
