package com.example.annotations.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = StartsWithValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface StartsWith {

    String message() default "must start with given prefix";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String prefix();
}
