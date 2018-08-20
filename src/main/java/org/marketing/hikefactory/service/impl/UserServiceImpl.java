package org.marketing.hikefactory.service.impl;

import org.marketing.hikefactory.model.User;
import org.marketing.hikefactory.repository.UserRepository;
import org.marketing.hikefactory.service.UserService;
import org.marketing.hikefactory.service.exception.SubscriptionAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void registerUser(User user) throws SubscriptionAlreadyExistsException  {
		
		System.out.println("Registration: "+ user);
		
		try {
		userRepository.saveUser(user);
		} catch (RuntimeException e) {
			throw new SubscriptionAlreadyExistsException("Subscription already exists with:" + user.getEmailAddress());
		}

	}

}
