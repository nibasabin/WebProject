package com.controller;

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

	@RequestMapping(value="/getAllInventory",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody List<ItemObject> getAllInventory(){
		List<ItemObject> item = serviceManager.getAllInventory();
		return item;
	}

	
}
