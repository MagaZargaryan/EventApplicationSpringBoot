package com.example.eventApplication.service.serviceImplementation;

import com.example.eventApplication.repository.UserRepository;
import com.example.eventApplication.model.User;
import com.example.eventApplication.service.serviceInterface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * User Service Implementation for the integration of business logic.
 *
 * @author Margarita Zargaryan
 */

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Get all users from DB.
     */

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Add user in DB.
     */

    @Override
    public Optional<User> postUser(User user) {
        return Optional.of(userRepository.save(user));
    }

    /**
     * Get user from DB by user id.
     */
    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    /**
     * Delete user from DB by user id.
     */

    @Override
    public void deleteUser(Long userId) throws Exception {
        User user = getUserById(userId)
                .orElseThrow(() -> new Exception(("User" + userId + "not found")));

        userRepository.delete(user);
    }

    @Override
    public Optional<User> getByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    /**
     * Update user in DB.
     */

    @Override
    public Optional<User> updateUserById(Long userId, User updatedUser) throws Exception {
        User user = getUserById(userId)
                .orElseThrow(() -> new Exception(("User" + userId + "not found")));

        user.setName(updatedUser.getName());
        postUser(user);
        return Optional.of(user);
    }


}
