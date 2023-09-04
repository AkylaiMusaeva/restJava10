package com.example.restjava10.service;

import com.example.restjava10.dto.AuthenticationResponse;
import com.example.restjava10.dto.SignInRequest;
import com.example.restjava10.dto.SignUpRequest;
import org.springframework.stereotype.Service;

/**
 * Akylai Musaeva
 */

public interface AuthenticationService {
    AuthenticationResponse signUp(SignUpRequest signUpRequest);
    AuthenticationResponse signIn(SignInRequest signInRequest);

}
