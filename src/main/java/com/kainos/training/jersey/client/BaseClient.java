package com.kainos.training.jersey.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

public class BaseClient 
{

	public Boolean getLogin(String username, String password){
		Client client = ClientBuilder.newClient();
		ClientConfig register = new ClientConfig();
		WebTarget webTarget = client.target("http://localhost:8080");
		WebTarget loginWebTarget = webTarget.path("login");		
		Form form = new Form();
		form.param("username", username);
		form.param("password", password);
		Invocation.Builder invocationBuilder = loginWebTarget.request();
		Response response = invocationBuilder.post(Entity.entity(form, "application/x-www-form-urlencoded"));
		if (response.getStatus() == 204){
			return true;
		}
		throw new RuntimeException("Failed:" + response.getStatus());		
	}
}
