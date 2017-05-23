package com.controller;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.manager.UserInformationManager;

@Controller
@RequestMapping("/user")
public class ApplicationStartController {
	@Autowired
	private UserInformationManager userInformationManager;

	@RequestMapping(value ="/homePage")
	public ModelAndView homePage (Principal principal){
		ModelAndView model = new ModelAndView();
		String emailId = principal.getName();
		String firstLastName = userInformationManager.getUserFirstLastName(emailId);
		
		model.addObject("firstLastName", firstLastName);
		model.setViewName("index");
		return model;
	}
	
	@RequestMapping(value ="/red")
	public String red (){
		return"javaScriptFiles/html/red.html";
	}

}
