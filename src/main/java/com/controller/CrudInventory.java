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
import com.rest.client.RestClient;
import com.sun.jersey.api.client.ClientResponse;


@Controller
@RequestMapping("/inventory")
public class CrudInventory {
	@Autowired
	private ItemObject itemObject;

	@RequestMapping(value="/addItem", method = RequestMethod.POST)
	public @ResponseBody Integer addInventory( HttpServletRequest request){	
		Integer output =0;
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

			
			RestClient restClient = new RestClient();
			ClientResponse response = restClient.POST("http://localhost:8080/Ir-Service/rest/InventoryEndPoint/addInventory",jsonObject);
			if (response.getStatus()==200){
				output= output+response.getStatus();
				System.out.println("this is response : "+output);
			}

/*			String jsonString = mapper.writeValueAsString(item);
			ClientResponse response1 = restClient.POST("http://localhost:8080/Ir-Service/rest/InventoryEndPoint/addInventory",jsonString);
			if (respons1.getStatus()==200){
				String output = respons1.getEntity(String.class );
				System.out.println("this is response : "+output);
			}*/
			

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

