package com.example.restjava10.dto;

import lombok.Builder;

/**
 * Akylai Musaeva
 */
@Builder
public record SignInRequest(
        String email,
        String password) {
}
