package org.example.restproductapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class GreetingController {

    @GetMapping("sayHi")        //  http://localhost:8080/sayHi
    public String getGreeting(){
        return "Hello OFSS";
    }
    @GetMapping("getDetails")        //  http://localhost:8080/getDetails
    public String getDetails(){
        return "Details about OFSS";
    }
    @GetMapping("date")
    public String getDate() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        return "Current Date and Time: " + currentDateTime;
    }
}
