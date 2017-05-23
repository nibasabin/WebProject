package com.manager;

import org.codehaus.jettison.json.JSONObject;

public interface EndPointManager {

	public String getUserFirstLastName(String emailId);
	public Integer addInventory(JSONObject jsonObject);
	
	public Integer createUser(JSONObject jsonObject);
}
