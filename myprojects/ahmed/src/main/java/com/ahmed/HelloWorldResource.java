package com.ahmed;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello") // Relative path for this resource
public class HelloWorldResource {

    @GET // HTTP GET method
    @Produces(MediaType.TEXT_PLAIN) // Specifies the media type of the response
    public String getHello() {
        return "Hello, Jakarta EE with Jersey!";
    }
}