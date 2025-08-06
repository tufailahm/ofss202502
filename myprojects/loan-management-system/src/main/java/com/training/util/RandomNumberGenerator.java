package com.training.util;

import org.springframework.stereotype.Component;

@Component
public class RandomNumberGenerator {

    int min, max;

    public RandomNumberGenerator(){
        this.min = 0;
        this.max = 100;
    }

    public RandomNumberGenerator(int min, int max){
        this.min = min;
        this.max = max;
    }

    public String generateRandomNumber() {
        double random = Math.random();
        Integer result = (int) (random * (max - min + 1) + min);
        return String.valueOf(result) ;
    }
}
