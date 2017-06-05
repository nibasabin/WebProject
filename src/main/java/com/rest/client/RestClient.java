package com.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class RestClient {

	/*Using Jersey2*/
	public Response GET(String url) {	
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target(url);
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		return response;
	}

	public Response POST(String url,JSONObject obj) {
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target(url);
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.post(Entity.entity(obj.toString(), MediaType.APPLICATION_JSON));
		return response;


	}
}
		
//Using Jersey 1
/*	public ClientResponse GET(String URL) {
		
		Client client = Client.create();
		WebResource webResource = client.resource(URL);
		ClientResponse response = webResource.get(ClientResponse.class);
		return response;

	}*/
/*	public ClientResponse POST(String URL,JSONObject obj) {
		
		Client client = Client.create();
		WebResource webResource = client.resource(URL);
		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).post(ClientResponse.class,obj);
		return response;

	}*/	
		

