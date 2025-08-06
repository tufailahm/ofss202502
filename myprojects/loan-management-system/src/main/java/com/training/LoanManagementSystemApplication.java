package com.training;

import com.training.util.Greeting;
import com.training.util.RandomNumberGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class LoanManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoanManagementSystemApplication.class, args);
    }

    // @Autowired
   // @Qualifier("greet2")
    private Greeting greeting100;

    @Autowired
    public void setGreeting100(Greeting greeting100) {
        this.greeting100 = greeting100;
    }


RandomNumberGenerator randomNumberGenerator;

    @Autowired(required = false)
    public void setRandomNumberGenerator(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    @GetMapping     //l
    public String getGreeting(){
        return greeting100.getMessage();       //Null pointer exception
    }

    @GetMapping  ("/getRandomNumber")   //l
    public String getRandomNumber(){
        return randomNumberGenerator.generateRandomNumber();       //Null pointer exception
    }
}
