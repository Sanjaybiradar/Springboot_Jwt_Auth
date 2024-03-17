package com.learning.springbootjwtauth.repository;

import com.learning.springbootjwtauth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUserName(String username);
}
