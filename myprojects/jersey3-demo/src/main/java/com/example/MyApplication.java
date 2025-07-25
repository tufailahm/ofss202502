package com.example;

import org.glassfish.jersey.server.ResourceConfig;
import jakarta.ws.rs.ApplicationPath;

@ApplicationPath("/api")
public class MyApplication extends ResourceConfig {
    public MyApplication() {
        packages("com.example");
    }
}