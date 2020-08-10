package com.example.eventApplication.repository;

import com.example.eventApplication.model.Role;
import com.example.eventApplication.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName rolename);

 }
