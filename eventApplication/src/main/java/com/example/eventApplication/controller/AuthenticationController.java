package com.example.eventApplication.controller;

import com.example.eventApplication.repository.UserRepository;
import com.example.eventApplication.repository.RoleRepository;
import com.example.eventApplication.message.request.SignInForm;
import com.example.eventApplication.message.request.SignUpForm;
import com.example.eventApplication.message.response.JwtResponse;
import com.example.eventApplication.security.jwt.JwtProvider;
import com.example.eventApplication.service.serviceInterface.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Authentication Rest controller class file for request handling and execution of CRUD operations.
 *
 * @author Margarita Zargaryan
 */

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    AuthenticationService authenticationService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtProvider jwtProvider;

    /**
     * Handle a post request to register a user.
     */
    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Validated @RequestBody SignInForm loginRequest) {

        String jwt = authenticationService.userAuthentication(loginRequest);

        return ResponseEntity.ok(new JwtResponse(jwt));
    }

    /**
     * Handle a post request to log in a user .
     */
    @PostMapping("/signup")
    public ResponseEntity<String> registerUser(@Validated @RequestBody SignUpForm signupRequest) {

        if (userRepository.existsByUsername(signupRequest.getUsername())) {

            return new ResponseEntity<String>("Fail -> Username is already taken!",
                    HttpStatus.BAD_REQUEST);
        }
        authenticationService.userRegistration(signupRequest);
        return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);

    }

}
