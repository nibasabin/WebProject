package com.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.manager.EndPointManager;
import com.rest.client.RestClient;
import com.sun.jersey.api.client.ClientResponse;


@Controller
@RequestMapping("/inventory")
public class CrudInventory {
	@Autowired
	private EndPointManager endPointManager;
	

	@RequestMapping(value="/addItem", method = RequestMethod.POST)
	public @ResponseBody Integer addInventory( HttpServletRequest request){	
		Integer output = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			ItemObject item = (ItemObject) mapper.readValue(request.getInputStream(), ItemObject.class);
			JSONObject jsonObject = new JSONObject();
		
				try {
					jsonObject.put("type", item.getType());
					jsonObject.put("description", item.getDescription());
					jsonObject.put("image", item.getImage());
					jsonObject.put("price", item.getPrice());
				} catch (JSONException e) {
					e.printStackTrace();
				}

			
			output = endPointManager.addInventory(jsonObject);

			} catch (IOException e) {
				e.printStackTrace();
			}
		return output;

	}
	
	@RequestMapping(value="/testController")
	public @ResponseBody String testController(){
		return "controller works fine" ;
	}
}

