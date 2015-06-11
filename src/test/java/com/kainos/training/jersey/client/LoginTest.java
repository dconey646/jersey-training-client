package com.kainos.training.jersey.client;

import javax.ws.rs.WebApplicationException;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class LoginTest{
	
	private BaseClient baseClient;
	
	@Before
	public void setup(){
		baseClient = new BaseClient();
	}

	@Test
    public void shouldSuccessfullyLoginWithRightCredentials(){
		String username = "admin";
		String password = "password";
		
		assertThat(baseClient.getLogin(username, password), is(true));
	}
	
	@Test
	public void shouldFailLoginWithIncorrectCredentials(){
		String username = "test";
		String password = "not the password";
		try {
			baseClient.getLogin(username, password);
		}catch(WebApplicationException e) {
			assertThat(e.getResponse().getStatus(), is(500));
		}
	}
}
