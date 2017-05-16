package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LogInController {
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(){
		return "javaScriptFiles/html/login.html";
	}
	
	@RequestMapping(value="/login/Authentication",method=RequestMethod.POST)
	public void validation(HttpServletRequest request, HttpServletResponse response){
		
		
	}
}
