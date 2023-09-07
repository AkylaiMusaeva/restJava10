package com.example.restjava10.service.serviceImpl;

import com.example.restjava10.dto.AuthenticationResponse;
import com.example.restjava10.dto.SignInRequest;
import com.example.restjava10.dto.SignUpRequest;
import com.example.restjava10.entity.User;
import com.example.restjava10.exception.AlreadyExistsException;
import com.example.restjava10.exception.BadCredentialException;
import com.example.restjava10.exception.NotFoundException;
import com.example.restjava10.repository.UserRepository;
import com.example.restjava10.security.jwt.JwtService;
import com.example.restjava10.service.AuthenticationService;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

/**
 * Akylai Musaeva
 */

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    @Override
    public AuthenticationResponse signUp(SignUpRequest signUpRequest) {
        if (userRepository.existsByEmail(signUpRequest.email())) {
            throw new AlreadyExistsException(
                    "Already exists user with email " + signUpRequest.email());
        }
        User user = User.builder()
                .firstName(signUpRequest.firstName())
                .lastName(signUpRequest.lastName())
                .email(signUpRequest.email())
                .password(passwordEncoder.encode(signUpRequest.password()))
                .role(signUpRequest.role())
                .build();
        userRepository.save(user);
        // token generate method
        String token=jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(token)
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }

    @Override
    public AuthenticationResponse signIn(SignInRequest signInRequest) {
        User user=userRepository.getUserByEmail(signInRequest.email())
                .orElseThrow(
                        ()-> new NotFoundException(
                                "User with email: "+signInRequest.email()+" doesn't exists!"));
        if(signInRequest.email().isBlank()){
            throw new BadCredentialException("Email is blank!");
        }
        if(!passwordEncoder.matches(signInRequest.password(), user.getPassword())){
            throw new BadCredentialException("Wrong password!");
        }
        String token=jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(token)
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }

}




