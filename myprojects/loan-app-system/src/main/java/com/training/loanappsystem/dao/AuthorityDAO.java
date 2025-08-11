package com.training.loanappsystem.dao;

import com.training.loanappsystem.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityDAO extends JpaRepository<Authority, Long> {
}