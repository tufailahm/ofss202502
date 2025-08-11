package com.training.loanappsystem.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests
                        (requests -> requests
                                .requestMatchers("/").permitAll()
                                .requestMatchers("/register").permitAll()
                                .requestMatchers("/saveUser").permitAll()
                                .requestMatchers("/index").hasAnyRole("USER", "ADMIN")
                                .requestMatchers("/viewAllProducts").hasAnyRole("USER", "ADMIN")
                                .requestMatchers("/addProduct").hasAnyRole("ADMIN")
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

    @Autowired
    DataSource dataSource;

    //Enable jdbc authentication
    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select username, password,enabled from users_ofss where  username = ?");
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }

    /*
        @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {
        authenticationMgr.inMemoryAuthentication()
                .withUser("neha").password("tech").authorities("ROLE_USER")
                .and()
                .withUser("tufail").password("ahmed").authorities("ROLE_USER", "ROLE_ADMIN")
                .and()
                .withUser("admin").password("admin").authorities("ROLE_ADMIN");
    }



*/
    /*
    @Bean
    public PasswordEncoder passwordEncoder(){
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }
*/
}
