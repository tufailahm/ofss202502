package com.training.config;

import com.training.util.Greeting;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfig {
    @Bean(name = "greeting")
    public Greeting greeting10() {
       // System.out.println("Greeting bean created ");
        return new Greeting();
    }
    @Bean
    public Greeting greeting5() {
        return new Greeting();
    }

    @Bean(name="greet1")
    @Primary
    public Greeting greeting1() {
        return new Greeting("Jay");
    }
    @Bean(name="greet2")
    public Greeting greeting2() {
        return new Greeting("Neha");
    }
}
