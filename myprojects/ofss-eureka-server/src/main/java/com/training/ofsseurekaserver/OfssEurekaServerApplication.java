package com.training.ofsseurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class OfssEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OfssEurekaServerApplication.class, args);
    }

}
