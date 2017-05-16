package com.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value ="/admin")
public class ApplicationStartController {
	
	@RequestMapping(value ="/homePage")
	public String homePage (){
		return"javaScriptFiles/html/homePage.html";
	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(){
		return "javaScriptFiles/html/login.html";
	}
	

}
