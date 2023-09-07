package com.example.restjava10.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.Email;

import java.lang.annotation.*;

/**
 * Akylai Musaeva
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PhoneNumberValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})

public @interface PhoneNumberValidation {

    String message() default "Phone number should start with +996 and consist of 13 digits";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}

