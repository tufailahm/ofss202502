package com.ahmed;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/welcome")
public class SendMessage {

	@GET
	@Path("/sayHello")
	public String sayHello(){
		return "Welcome to Bangalore";
	}
}