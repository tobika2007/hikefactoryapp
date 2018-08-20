package org.marketing.hikefactory.repository.impl;

import org.marketing.hikefactory.model.User;
import org.marketing.hikefactory.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void saveUser(User user) {
		
		logger.info("'save' {} now..." + user);
		
		final String sql = "INSERT INTO users (id, firstname, lastname, email) VALUES (?, ?, ?, ?)";
	       
	    jdbcTemplate.update(sql, user.getIdHike(), user.getFirstName(), user.getLastName(), user.getEmailAddress());
	    logger.info("'update' {} now...");

	}

}
