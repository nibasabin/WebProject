package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.plaf.OptionPaneUI;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.manager.EndPointManager;

@Controller
public class LogInController {
	@Autowired
	private EndPointManager endPointManager;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(
		@RequestParam(value ="error" ,required = false) String error,
		@RequestParam(value = "logout", required = false) String logout) {
		ModelAndView model = new ModelAndView();

		if (error !=null ) {
			JOptionPane optionPane = new JOptionPane("Invalid UserName Or Password",JOptionPane.WARNING_MESSAGE);
			JDialog dialog = optionPane.createDialog("Error!");
			//dialog.setAlwaysOnTop(true); // to show top of all other application
			dialog.setVisible(true); 
		//	model.addObject("error", "Invalid username and password!");
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
			e.printStackTrace();
		}
		
		return endPointManager.createUser(jsonObject);
	}
	
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public String loginFailure(){
		return "javaScriptFiles/html/test.html";
	}
	
}
