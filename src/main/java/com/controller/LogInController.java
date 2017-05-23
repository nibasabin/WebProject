package com.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.codehaus.jettison.json.JSONString;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rest.client.RestClient;
import com.sun.jersey.api.client.ClientResponse;
import com.web.entity.UserInformation;

@Controller
public class LogInController {
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(
		@RequestParam(value ="error" ,required = false) String error,
		@RequestParam(value = "logout", required = false) String logout) {
		ModelAndView model = new ModelAndView();
		if (error !=null ) {
			model.addObject("error", "Invalid username and password!");
		}
		
		if(logout != null){
			model.addObject("logour","You Have successfully logout");
		}
		model.setViewName("javaScriptFiles/html/login");

		
		return model;
	}
	
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth !=null){
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}

		model.setViewName("javaScriptFiles/html/login");
		
		return model;
	}
	
	@RequestMapping(value="/signUp",method=RequestMethod.POST ,consumes="application/json",produces="application/json")
	public @ResponseBody Integer signUpUser(HttpServletRequest request, @RequestBody String jsonString){
		JSONObject jsonObject =null;
		try {
			jsonObject = new JSONObject(jsonString);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		RestClient restClient = new RestClient();
		ClientResponse response = restClient.POST("http://localhost:8080/Ir-Service/rest/userManagerEndPoint/addUser",jsonObject);
		if (response.getStatus()==200){
			System.out.println("User added successfully");
		}

		
		return response.getStatus();
	}
	
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public String loginFailure(){
		return "javaScriptFiles/html/test.html";
	}
	
}
