package com.manager;

import java.util.List;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rest.client.RestClient;
import com.web.entity.ItemObject;

@Component
public class EndPointManagerImpl implements EndPointManager {
	@Autowired
	public RestClient restClient;
	
	@Override
	public Integer createUser(JSONObject jsonObject) {
		
		Response response = restClient.POST("http://localhost:8080/Ir-Service/rest/userManagerEndPoint/addUser",jsonObject);
		return response.getStatus();
	}

	@Override
	public Integer addInventory(JSONObject jsonObject) {
		Response response = restClient.POST("http://localhost:8080/Ir-Service/rest/InventoryEndPoint/addInventory",jsonObject);
		return response.getStatus();
	}

	@Override
	public String getUserFirstLastName(String emailId) {
		Response response = restClient.GET("http://localhost:8080/Ir-Service/rest/userManagerEndPoint/firstLastName/"+emailId);
		return response.readEntity(String.class);
	}

	@Override
	public List<ItemObject> getFilteredResult(JSONObject filterCriteria) {
		Response response =  restClient.POST("http://localhost:8080/Ir-Service/rest/service/getFilterdResults", filterCriteria);
		return response.readEntity(new GenericType<List<ItemObject>>(){});
		}

	@Override
	public List<ItemObject> getAllInventory() {
		Response response =  restClient.GET("http://localhost:8080/Ir-Service/rest/service/getAllInventory");
		return response.readEntity(new GenericType<List<ItemObject>>(){});
		}


}
