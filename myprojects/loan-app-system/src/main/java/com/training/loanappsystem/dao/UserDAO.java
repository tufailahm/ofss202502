package com.training.loanappsystem.dao;

import com.training.loanappsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.security.core.userdetails.User;

import java.util.Optional;

public interface UserDAO extends JpaRepository<User, String> {
   // Optional<User> findByUsername(String username);
}