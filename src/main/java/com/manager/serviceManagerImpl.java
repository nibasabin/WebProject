package com.manager;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.web.entity.ItemObject;

@Component
public class serviceManagerImpl implements serviceManager{

	@Autowired
	EndPointManager endPointManager;

	
	@Override
	public List<ItemObject> getFilteredResult(JSONObject filterCriteria) {
		return	endPointManager.getFilteredResult(filterCriteria);
	}


	@Override
	public List<ItemObject> getAllInventory() {
	
		return endPointManager.getAllInventory();
	}


	@Override
	public List<ItemObject> getUsersInventory(String userName) {
		
		return endPointManager.getUsersInventory(userName);
	}


	@Override
	public void addToGlobalInventory(Integer itemId) {
		endPointManager.addToGlobalInventory(itemId);
		
	}


	@Override
	public void deleteItem(Integer itemId) {
		endPointManager.deleteItem(itemId);		
	}

}
