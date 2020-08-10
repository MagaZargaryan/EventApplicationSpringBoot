package com.example.eventApplication.service.serviceInterface;

import com.example.eventApplication.message.request.SignInForm;
import com.example.eventApplication.message.request.SignUpForm;
import org.springframework.stereotype.Service;

/**
 * Interface for Authentication service.
 */

@Service
public interface AuthenticationService {

    public void userRegistration(SignUpForm signUpRequest);

    public String userAuthentication(SignInForm signInRequest);
}
