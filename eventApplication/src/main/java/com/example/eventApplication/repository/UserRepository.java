package com.example.eventApplication.repository;

import com.example.eventApplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * User JPA Repository for data access.
 *
 * @Author Margarita Zargaryan
 */

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

}


