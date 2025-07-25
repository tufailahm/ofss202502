package com.hello;

import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/api") // Base path for your REST endpoints
public class MyApplication extends ResourceConfig {
    public MyApplication() {
        System.out.println("####packages are set #####");
        // Register your resource classes
        packages("com.ahmed"); // Package containing your resource classes
    }
}