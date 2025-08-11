package com.training.loanappsystem.service;

import com.training.loanappsystem.dao.AuthorityDAO;
import com.training.loanappsystem.dao.UserDAO;
import com.training.loanappsystem.model.Authority;
import com.training.loanappsystem.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserService {
    private final UserDAO userDAO;

    @Autowired
    private AuthorityDAO authorityDAO;

    private final PasswordEncoder encoder;


    public UserService(UserDAO userDAO, PasswordEncoder encoder) {
        this.userDAO = userDAO;
        this.encoder = encoder;
    }

    public User register(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(encoder.encode(password));
        user.setEnabled(true);

        Authority auth = new Authority();
        auth.setAuthority("ROLE_ADMIN");
        auth.setUser(user);
        user.setAuthorities(Set.of(auth));

        User result = userDAO.save(user);
      //  authorityDAO.save(auth);
        System.out.println("#####User with authorities Saved Successfully");// hash password

        return result;
    }
}