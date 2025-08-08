package com.training.loanappsystem.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
@Service
public class UserDetailService implements UserDetailsService {

    private static final Map<String, String> ofssUsers = new HashMap<>();
    static {
        ofssUsers.put("aniket", "{noop}aniket");
        ofssUsers.put("darsh", "{noop}darsh");
        ofssUsers.put("sahni", "{noop}sahni");
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        ArrayList<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();

        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_USER");
        GrantedAuthority grantedAuthority2 = new SimpleGrantedAuthority("ROLE_ADMIN");

        grantedAuthorities.add(grantedAuthority);
        grantedAuthorities.add(grantedAuthority2);

        String password = ofssUsers.get(username);
        if (password == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }
        User user = new User(username, password, grantedAuthorities);
        System.out.println("#### " + user);
        return user;
    }
}
