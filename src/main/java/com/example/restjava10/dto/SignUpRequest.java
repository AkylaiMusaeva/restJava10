package com.example.restjava10.dto;

import com.example.restjava10.enums.Role;
import lombok.Builder;

/**
 * Akylai Musaeva
 */
@Builder
public record SignUpRequest(
        String firstName,
        String lastName,
        String email,
        String password,
        Role role) {
}
