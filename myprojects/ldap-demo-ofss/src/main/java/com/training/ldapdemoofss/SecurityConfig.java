package com.training.ldapdemoofss;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests
                        (requests -> requests
                                .requestMatchers("/").permitAll()
                                .requestMatchers("/home").permitAll()
                      //          .requestMatchers("/index").hasAnyRole("USER", "ADMIN")
                      //          .requestMatchers("/viewAllProducts").hasAnyRole("USER", "ADMIN")
                      //          .requestMatchers("/addProduct").hasAnyRole("ADMIN")
                                .anyRequest().authenticated())
                .formLogin(login -> login.loginPage("/login").permitAll())
                .exceptionHandling(exception -> exception
                        .accessDeniedPage("/access-denied")
                )
                .logout(logout -> logout.permitAll()
                        .logoutUrl("/logout").permitAll()
                        .logoutSuccessUrl("/login").permitAll()
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                );

        //	http.csrf().disable();
        return http.build();
    }

}
