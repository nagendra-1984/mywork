package com.neoteric.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SecondController {

	@RequestMapping(value="home",method=RequestMethod.GET)
	public String getHomePage(Model model){
		
		model.addAttribute("message", "Home Page Welcomes You");
		return "home";
	}
	
	@RequestMapping(value="welcome",method=RequestMethod.GET)
	
	public String getwelcomePage(Model model){
		
		model.addAttribute("message", "Welcome Page Welcomes You");
		return "welcome";
	}
	
	@RequestMapping(value="user",method=RequestMethod.GET, params="new")
	
	public String getNewUserPage(Model model){
		
		model.addAttribute("message", "Register New user");
		return "newuser";
	}	

	@RequestMapping(value="user",method=RequestMethod.GET, params="edit")
	
	public String getUserInfoPage(Model model){
		
		model.addAttribute("message", "Edit user");
		return "edituser";
	}	

}
