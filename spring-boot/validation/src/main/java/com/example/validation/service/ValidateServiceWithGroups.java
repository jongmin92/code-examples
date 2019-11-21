package com.example.validation.service;

import javax.validation.Valid;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.example.validation.InputEntityWithCustomValidator;

@Service
@Validated
public class ValidateServiceWithGroups {

    @Validated(OnCreate.class)
    void validateForCreate(@Valid InputEntityWithCustomValidator input) {
        // do something
    }

    @Validated(OnUpdate.class)
    void validateForUpdate(@Valid InputEntityWithCustomValidator input) {
        // do something
    }
}
