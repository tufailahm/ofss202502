package com.hello;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


@Path("/products")
public class ProductResource {

    // RESTful API methods go here...
    @GET()
    @Path("/tufail")
    @Produces(MediaType.APPLICATION_JSON)
    public String list() {
        return "Hello Tufail";
    }
}
