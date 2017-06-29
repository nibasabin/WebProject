package com.controller;

import java.security.Principal;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.manager.serviceManager;
import com.web.entity.ItemObject;

@Controller
@RequestMapping("/service")
public class serviceController {
	@Autowired
	private serviceManager serviceManager;
	
	@RequestMapping(value="/getFilterdResults",method = RequestMethod.POST ,consumes="application/json",produces ={"application/json"})
	public @ResponseBody List<ItemObject> getFilteredResult(@RequestBody String jsonString){
		List<ItemObject> item =null;
		try {
				JSONObject jsonObject = new JSONObject(jsonString);
				item=	serviceManager.getFilteredResult(jsonObject);
				System.out.println("item"+item);
				
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return item;
	}

	@RequestMapping(value="/getAllInventory",method = RequestMethod.POST,produces ="application/json")
	public @ResponseBody List<ItemObject> getAllInventory(@RequestBody String category){
		List<ItemObject> item = serviceManager.getAllInventory(category);
		return item;
	}

	@RequestMapping(value="/getUsersInventory",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody List<ItemObject> getUsersInventory(Principal principal){
		String userName = principal.getName();
		List<ItemObject> item = serviceManager.getUsersInventory(userName);
		return item;
	}
	
	@RequestMapping(value="/addToGlobalInventory",method = RequestMethod.POST,produces ="application/json")
	public @ResponseBody void addToGlobalInventory(@RequestBody String itemId){
		serviceManager.addToGlobalInventory(Integer.parseInt(itemId));
	}
	
	@RequestMapping(value="/deleteItem",method = RequestMethod.POST,produces ="application/json")
	public @ResponseBody void deleteItem(@RequestBody String itemId){
		serviceManager.deleteItem(Integer.parseInt(itemId));
	}
	
}
