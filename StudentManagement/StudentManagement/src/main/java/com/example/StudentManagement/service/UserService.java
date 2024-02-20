package com.example.StudentManagement.service;

import com.example.StudentManagement.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    public User findUserByUserName(String id);

}
