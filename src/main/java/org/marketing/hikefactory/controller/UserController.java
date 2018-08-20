package org.marketing.hikefactory.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.marketing.hikefactory.model.User;
import org.marketing.hikefactory.service.UserService;
import org.marketing.hikefactory.service.exception.SubscriptionAlreadyExistsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
	
		@Autowired
		private UserService userService;

		private static final String SUB_FORM_ATTRIBUTE = "subscriptionForm";

		private static final String PATH_SUB = "/subscribe";
		
		private Logger logger = LoggerFactory.getLogger(getClass());
		
		@GetMapping(PATH_SUB)
		public String getSubscriptionForm(@ModelAttribute(SUB_FORM_ATTRIBUTE) User u) {
			return "subscribe";
		}
		
		@PostMapping(PATH_SUB)
		public String submitUser(@ModelAttribute(SUB_FORM_ATTRIBUTE) @Valid User user,
				BindingResult result, HttpServletResponse reponse) throws SubscriptionAlreadyExistsException {
			
			logger.debug("User creates this subscription: {}", user);
			
			if (result.hasErrors()) {
				reponse.setStatus(HttpStatus.BAD_REQUEST.value());
				result.reject("subscriptionForm.error.incompleteInput");
				return "subscribe";
			} else {
				userService.registerUser(user);
				return "redirect:/thank-you";
			}
		}
}
