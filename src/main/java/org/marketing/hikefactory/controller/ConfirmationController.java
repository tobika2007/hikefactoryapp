package org.marketing.hikefactory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ConfirmationController {
			
	@GetMapping(value= {"/thank-you"})
	public String getConfirmation(Model model) {
		return "confirmation";
	}
}
