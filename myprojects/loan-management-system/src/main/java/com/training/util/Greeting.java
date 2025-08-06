package com.training.util;

import org.springframework.stereotype.Component;

@Component
//Greeting greeting = new Greeting();
public class Greeting {
    private String name;

    public Greeting() {
        System.out.println("Greeting bean created ");
        name = "Tufail";
    }

    public Greeting(String name) {
        System.out.println("Greeting bean created with name " + name);
        this.name = name;
    }

    public String getMessage(){
        return "Hello "+name+ " , Good morning";
    }
}
