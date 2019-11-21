package com.example.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PinCodeValidator implements ConstraintValidator<PinCode, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        final Pattern pattern = Pattern.compile("^[0-9]{6}$");
        final Matcher matcher = pattern.matcher(value);

        try {
            return matcher.matches();
        } catch (Exception e) {
            return false;
        }
    }
}
