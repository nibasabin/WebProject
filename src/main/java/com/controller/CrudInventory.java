package com.controller;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.manager.EndPointManager;
import com.web.entity.ItemObject;


@Controller
@RequestMapping("/inventory")
public class CrudInventory {
	@Autowired
	private EndPointManager endPointManager;
	

	@RequestMapping(value="/addItem", method = RequestMethod.POST)
	public @ResponseBody Integer addInventory( HttpServletRequest request,Principal principal){	
		Integer output = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			ItemObject item = (ItemObject) mapper.readValue(request.getInputStream(), ItemObject.class);
			JSONObject jsonObject = new JSONObject();
		
				try {
					jsonObject.put("category",item.getCategory());
					jsonObject.put("type", item.getType());
					jsonObject.put("image", item.getImage());
					jsonObject.put("price", item.getPrice());
					jsonObject.put("description", item.getDescription());
					jsonObject.put("newItem", item.getNewItem());
					jsonObject.put("usedItem", item.getUsedItem());
					jsonObject.put("sellerName", principal.getName());
					jsonObject.put("itemSold", false);
					
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

