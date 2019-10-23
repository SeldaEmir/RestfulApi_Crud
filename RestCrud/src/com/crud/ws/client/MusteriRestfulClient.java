package com.crud.ws.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class MusteriRestfulClient {
	
	public static void main(String[] args) {
		try {
			
			Client client = Client.create();
			WebResource webResource = client.resource("http://localhost:8081/RestCrud/rest/customer/all");
			ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
			//ClientResponse response = webResource.accept("application/xml").get(ClientResponse.class);
					
					if (response.getStatus() == 200) {
						System.out.println(response.getEntity(String.class));
						
					}else {
						System.out.println("HATA");
					}
			
		} catch (Exception e) {
			System.out.println("hata :" +e);
		}
	}
	
}
