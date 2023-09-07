package com.example.restjava10.api;

import com.example.restjava10.dto.AuthenticationResponse;
import com.example.restjava10.dto.SignInRequest;
import com.example.restjava10.dto.SignUpRequest;
import com.example.restjava10.service.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Akylai Musaeva
 */
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Tag(name = "Authentication Api")
public class AuthenticationApi {
    private final AuthenticationService authenticationService;

    @PostMapping("/signUp")
    @Operation(summary = "Sign up",description = "To sign up fill all the fields")
    AuthenticationResponse signUp(@RequestBody SignUpRequest signUpRequest){
        return authenticationService.signUp(signUpRequest);
    }
    @PostMapping("/signIn")
    AuthenticationResponse signIn(@RequestBody SignInRequest signInRequest){
        return authenticationService.signIn(signInRequest);
    }





}
