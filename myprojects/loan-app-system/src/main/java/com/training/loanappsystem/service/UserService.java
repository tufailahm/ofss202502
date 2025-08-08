package com.training.loanappsystem.service;

import com.training.loanappsystem.dao.UserDAO;
import com.training.loanappsystem.model.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserDAO userDAO;
    private final PasswordEncoder encoder;


    public UserService(UserDAO userDAO, PasswordEncoder encoder) {
        this.userDAO = userDAO;
        this.encoder = encoder;
    }

    public User register(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        System.out.println("#####User Saved Successfully");// hash password
        return userDAO.save(user);
    }
}