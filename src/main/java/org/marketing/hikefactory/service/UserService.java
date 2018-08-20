package org.marketing.hikefactory.service;

import org.marketing.hikefactory.model.User;
import org.marketing.hikefactory.service.exception.SubscriptionAlreadyExistsException;

public interface UserService {

	void registerUser(User user) throws SubscriptionAlreadyExistsException;
}
