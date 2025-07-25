package com.hello;

import java.net.*;
import java.util.*;

import javax.ws.rs.*;
import javax.ws.rs.core.*;


@Path("/products")
public class ProductResource {

    // RESTful API methods go here...
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String list() {
        return "Hello Tufail";
    }
}
