package com.example.validation.service;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.stereotype.Service;

import com.example.validation.InputEntity;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DirectlyValidateService {

    private final Validator validator;

    public void validateInput(InputEntity inputEntity) {
        final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        final Validator validator = factory.getValidator();
        final Set<ConstraintViolation<InputEntity>> violations = validator.validate(inputEntity);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }

    public void validateInputWithInjectedValidator(InputEntity inputEntity) {
        final Set<ConstraintViolation<InputEntity>> violations = validator.validate(inputEntity);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }
}
