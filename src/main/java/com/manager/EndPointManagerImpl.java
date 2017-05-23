package com.manager;

import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rest.client.RestClient;
import com.sun.jersey.api.client.ClientResponse;

@Component
public class EndPointManagerImpl implements EndPointManager {
	@Autowired
	public RestClient restClient;
	
	@Override
	public Integer createUser(JSONObject jsonObject) {
		
		ClientResponse response = restClient.POST("http://localhost:8080/Ir-Service/rest/userManagerEndPoint/addUser",jsonObject);
		return response.getStatus();
	}

	@Override
	public Integer addInventory(JSONObject jsonObject) {
		ClientResponse response = restClient.POST("http://localhost:8080/Ir-Service/rest/InventoryEndPoint/addInventory",jsonObject);
		return response.getStatus();
	}

	@Override
	public String getUserFirstLastName(String emailId) {
		ClientResponse response = restClient.GET("http://localhost:8080/Ir-Service/rest/userManagerEndPoint/firstLastName/"+emailId);
		return response.getEntity(String.class);
	}



}
