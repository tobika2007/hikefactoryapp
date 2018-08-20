package org.marketing.hikefactory.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.marketing.hikefactory.model.Hike;
import org.marketing.hikefactory.service.HikeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HikeController {
	
	@Autowired
	private HikeService hikeService;
	
	private static final String CREATION_FORM_ATTRIBUTE = "creationForm";

	private static final String PATH_CREATE = "/create";
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	//Hike creation in modal form creationForm
	@GetMapping(value= {"/", PATH_CREATE})
	public String getIndex(@ModelAttribute(CREATION_FORM_ATTRIBUTE) Hike s) {
		return "index";
	}
	
	@PostMapping(PATH_CREATE)
	public String submitHike(@ModelAttribute(CREATION_FORM_ATTRIBUTE) @Valid Hike hike,
			BindingResult result, HttpServletResponse reponse) {
		logger.debug("User creates this hike: {}", hike);
		
		if (result.hasErrors()) {
			reponse.setStatus(HttpStatus.BAD_REQUEST.value());
			result.reject("creationForm.error.incompleteInput");
			return "index";
		} else {
			hikeService.registerHike(hike);
			return "redirect:/thank-you";
		}
	}
	    
	//Hike query 
	@GetMapping(value="/hikelist") 
	public ModelAndView showHikes() {

	        List<Hike> hikes = hikeService.findAll();
	        logger.debug("User queries actual hikes: {}", hikes);

	        Map<String, Object> params = new HashMap<>();
	        params.put("hikes", hikes);

	        return new ModelAndView("hikelist", params);
	    }
}
