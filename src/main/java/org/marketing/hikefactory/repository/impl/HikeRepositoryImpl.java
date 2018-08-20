package org.marketing.hikefactory.repository.impl;

import java.util.UUID;
import org.marketing.hikefactory.model.Hike;
import org.marketing.hikefactory.repository.HikeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class HikeRepositoryImpl implements HikeRepository {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void saveHike(Hike hike) {
		
		logger.info("'save' {} now..." + hike);
		
		final String sql = "INSERT INTO hikes (id, name, location, startdate, duration, difficulty) VALUES (?, ?, ?, ?, ?, ?)"; 
		final String id = UUID.randomUUID().toString();
		
		jdbcTemplate.update(sql, id, hike.getName(), hike.getLocation(), hike.getStartDate(), hike.getDuration(), hike.getDifficulty());
	    logger.info("'update' {} now...");
	    
	}

}
