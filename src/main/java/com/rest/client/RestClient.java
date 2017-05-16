package com.rest.client;

import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;


public class RestClient {
	public ClientResponse GET(String URL) {
		
		Client client = Client.create();
		WebResource webResource = client.resource(URL);
		ClientResponse response = webResource.get(ClientResponse.class);
		return response;

	}
	
//	public ClientResponse POST(String URL,String obj) {
//		
//		Client client = Client.create();
//		WebResource webResource = client.resource(URL);
//		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).accept(MediaType.TEXT_PLAIN).post(ClientResponse.class,obj);
//		return response;
//
//	}
	public ClientResponse POST(String URL,JSONObject obj) {
		
		Client client = Client.create();
		WebResource webResource = client.resource(URL);
		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).accept(MediaType.TEXT_PLAIN).post(ClientResponse.class,obj);
		return response;

	}
}
