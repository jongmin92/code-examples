package com.example.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = PinCodeValidator.class)
@Documented
public @interface PinCode {

    String message() default "{PinCode.invalid}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
