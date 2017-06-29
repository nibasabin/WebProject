package com.manager;

import java.util.List;

import org.json.JSONObject;

import com.web.entity.ItemObject;


public interface EndPointManager {

	public String getUserFirstLastName(String emailId);
	public Integer addInventory(JSONObject jsonObject);
	
	public Integer createUser(JSONObject jsonObject);
	public List<ItemObject> getFilteredResult(JSONObject filterCriteria);
	public List<ItemObject> getAllInventory();
	public List<ItemObject> getUsersInventory(String userName);
	public void addToGlobalInventory(Integer itemId);
	public void deleteItem(Integer itemId);
}
