package com.training.loanappsystem.controller;

import com.training.loanappsystem.model.User;
import com.training.loanappsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegistrationController {

    @Autowired
    private final UserService service;

    public RegistrationController(UserService service) {
        this.service = service;
    }

    @GetMapping("/register")
    public String registerForm() {
        return "register";
    }

    @GetMapping("/saveUser")
    public String register(User user) {
        System.out.println("#####Request Recived in Register  Successfully");// hash password
        service.register(user.getUsername(), user.getPassword());
        return "redirect:/login";
    }
}
