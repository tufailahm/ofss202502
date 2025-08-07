package com.training.ldapdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.ldap.userdetails.DefaultLdapAuthoritiesPopulator;
import org.springframework.security.ldap.userdetails.LdapAuthoritiesPopulator;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {


    // Optional: Configure LDAP authorities populator for role mapping
    @Bean
    public LdapAuthoritiesPopulator ldapAuthoritiesPopulator() {
        DefaultLdapAuthoritiesPopulator populator =
                new DefaultLdapAuthoritiesPopulator(contextSource(), "ou=groups,dc=springframework,dc=org"); // Adjust base DN
        populator.setGroupSearchFilter("uniqueMember={0}"); // Adjust filter
        return populator;
    }

    // Configure your ContextSource (e.g., using LdapContextSourceBuilder)
    // This typically picks up properties from application.properties
    // or can be explicitly configured.

    @Bean
    public LdapContextSource contextSource() {
        LdapContextSource contextSource = new LdapContextSource();
        contextSource.setUrl("ldap://localhost:8389");
        contextSource.setBase("dc=springframework,dc=org");
        contextSource.setUserDn("cn=admin,dc=springframework,dc=org"); // optional for embedded
        contextSource.setPassword("admin"); // optional for embedded
        contextSource.afterPropertiesSet(); // IMPORTANT: triggers initialization
        return contextSource;
    }

    //Previous version
    /*

        //@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
          .ldapAuthentication()
          .userDnPatterns("uid={0},ou=people")
          .contextSource()
          .url("ldap://localhost:8389/dc=springframework,dc=org");
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
          .authorizeRequests()
          .anyRequest().fullyAuthenticated()
          .and()
          .formLogin();
    }
*/
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/public/**").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form.permitAll())
                .logout(logout -> logout.permitAll());
        return http.build();
    }

}
