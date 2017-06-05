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
	
	@RequestMapping(value="/getFilterdResults",consumes="application/json",produces ="application/json")
	public @ResponseBody List<ItemObject> getFilteredResult(@RequestBody String jsonString){
		List<ItemObject> item =null;
	//	FilterCriteriaObject filterCriteria = new FilterCriteriaObject();
		try {
				JSONObject jsonObject = new JSONObject(jsonString);
		/*		filterCriteria.setCategory(jsonObject.get("category").toString());
				filterCriteria.setMinAmount(Float.parseFloat(jsonObject.get("minAmount").toString()));
				filterCriteria.setMaxAmount(Float.parseFloat(jsonObject.get("maxAmount").toString()));
				filterCriteria.setNewItem(Boolean.parseBoolean(jsonObject.get("newItem").toString()));
				filterCriteria.setUsedItem(Boolean.parseBoolean(jsonObject.get("usedItem").toString()));
				
				ArrayList<String> subCategoryList = new ArrayList<String>();     
				JSONArray jsonArray = (JSONArray)jsonObject.get("subCategoryList"); 
				if (jsonArray != null) { 
				   int len = jsonArray.length();
				   for (int i=0;i<len;i++){ 
					   subCategoryList.add(jsonArray.get(i).toString());
				   } 
				} 
				filterCriteria.setSubCategoryList(subCategoryList);*/
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
