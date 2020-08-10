package com.example.eventApplication.service.serviceInterface;

import com.example.eventApplication.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Interface for User Service.
 *
 * @author Margarita Zargaryan
 */

@Service
public interface UserService {
    public List<User> getAllUsers();

    public Optional<User> postUser(User user);

    public Optional<User> getUserById(Long id);

    public void deleteUser(Long userId) throws Exception;

    public Optional<User> getByUsername(String username);

    public Optional<User> updateUserById(Long userId, User updatedUser) throws Exception;


}
