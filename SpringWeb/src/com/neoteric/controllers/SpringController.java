package com.neoteric.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
 *  @ Contoller - declares the Class as Controller 
 *  @ RequestMapping - declares the Mapping with request url
 */


@Controller 
@RequestMapping("/spring")
public class SpringController {
	
	@RequestMapping(method= RequestMethod.GET)
	public String printWelcomeMessage(ModelMap model){
		model.addAttribute("message", "Hello Spring MVC Application");
		return "welcome";
	}
	
}
