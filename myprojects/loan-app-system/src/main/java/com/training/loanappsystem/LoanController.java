package com.training.loanappsystem;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("applyLoan")
public class LoanController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    VisitorService visitorService;

    @GetMapping("{visitorId}")      //localhost:7070/applyLoan/102
    @CircuitBreaker(name = "visitorServiceCircuitBreaker", fallbackMethod = "ofssFallbackmethod")
    public ResponseEntity<String> applyLoan(@PathVariable String visitorId){


        String name = null;
        //Make a rest call to another service
        String url = "http://localhost:9090/visitors/"+visitorId;

        String value =  restTemplate.getForObject(url, String.class);
        Visitor visitor = restTemplate.getForObject(url, Visitor.class);

        String message= null;
        if(visitor!=null){
             message = visitor.getVisitorName() + " Your loan application has been successfully applied.";
        }
        else {
            message = "No loan application has been successfully applied. Please register as visitor first\nhttp://localhost:9090/visitors/";
        }
        return new ResponseEntity<String>(message,HttpStatusCode.valueOf(200));
    }


    @GetMapping("hello")      //localhost:7070/applyLoan/hello
    public String getMessage() throws InterruptedException {
        return visitorService.myMethodCallingExternalService();
    }


    public ResponseEntity<String> ofssFallbackmethod(String id,Throwable t) {
        return new ResponseEntity<String>("Visitor service is currently unavailable. Please try again later.",HttpStatusCode.valueOf(200));
    }
}
