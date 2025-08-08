package com.training.loanappsystem.service;

import com.netflix.discovery.converters.Auto;
import com.training.loanappsystem.dao.UserDAO;
import org.springframework.security.core.userdetails.User;
//import com.training.loanappsystem.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
/*
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired()
    private final UserDAO userDAO;
    @Autowired
    private UserDetailService userDetailService;

    public CustomUserDetailsService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        UserDetails user = userDetailService.loadUserByUsername(username);

        System.out.println("#####User details here ::"+user);
     //   return user.withUsername(user.getUsername())
      //          .password(user.getPassword())
    //            .roles("USER")
     //           .build();
        return null;
    }
}
*/
