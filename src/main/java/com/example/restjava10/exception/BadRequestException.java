package com.example.restjava10.exception;

/**
 * Akylai Musaeva
 */
public class BadRequestException extends RuntimeException{
    public BadRequestException(String message) {
        super(message);
    }
}
