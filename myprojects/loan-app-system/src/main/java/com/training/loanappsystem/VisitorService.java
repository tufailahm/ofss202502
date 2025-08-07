package com.training.loanappsystem;

import com.netflix.discovery.converters.Auto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
    public class VisitorService {

        @Autowired
        RestTemplate restTemplate;

        @CircuitBreaker(name = "visitorServiceCircuitBreaker", fallbackMethod = "fallbackForMyMethod")
        public String myMethodCallingExternalService() throws InterruptedException {
            // Logic to call an external service
      //   Thread.sleep(10000);
            String url = "http://localhost:9090/visitors/102";

            try {
                String value =  restTemplate.getForObject(url, String.class);
                return "Success";
              //  Visitor visitor = restTemplate.getForObject(url, Visitor.class);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }

        public String fallbackForMyMethod() throws InterruptedException{

            return "Fallback response due to: ";

        }
    }