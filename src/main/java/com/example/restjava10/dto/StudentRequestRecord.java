package com.example.restjava10.dto;

import com.example.restjava10.validation.PhoneNumberValidation;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;

import java.time.LocalDate;

public record StudentRequestRecord(
        String firstName,
        String lastName,
        int age,
        @Email(message = "Error")
        @Column(unique = true)
        String email,
        LocalDate createdDate,
        LocalDate graduationDate,
        boolean isBlocked,
        @PhoneNumberValidation
        String phoneNumber)
{
}
