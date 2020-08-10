package com.example.eventApplication.service.serviceImplementation;

import com.example.eventApplication.repository.EventRepository;
import com.example.eventApplication.repository.UserRepository;
import com.example.eventApplication.model.User;
import com.example.eventApplication.security.service.UserPrinciple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * User Details Service Implementation for the integration of business logic.
 *
 * @author Margarita Zargaryan
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    EventRepository articleRepository;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found" + username));
        return UserPrinciple.build(user);
    }

}
