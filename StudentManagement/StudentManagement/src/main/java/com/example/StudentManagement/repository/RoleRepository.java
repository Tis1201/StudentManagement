package com.example.StudentManagement.repository;

import com.example.StudentManagement.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,String> {
    public Role findRoleByRoleName(String name);
}
