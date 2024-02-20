package com.example.StudentManagement.repository;

import com.example.StudentManagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    public User findUserByUserName(String id);

}
