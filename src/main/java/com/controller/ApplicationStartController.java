package com.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class ApplicationStartController {

	@RequestMapping(value ="/homePage")
	public ModelAndView homePage (){
		return new ModelAndView("index");
	}
	
	@RequestMapping(value ="/red")
	public String red (){
		return"javaScriptFiles/html/red.html";
	}
//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//	public String login(){
//		return "javaScriptFiles/html/login.html";
//	}
//	

}
