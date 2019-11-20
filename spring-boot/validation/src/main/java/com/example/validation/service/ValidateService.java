package com.example.validation.service;

import javax.validation.Valid;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.example.validation.InputRequest;

@Service
@Validated
public class ValidateService {

    void validateInputRequest(@Valid InputRequest input) {
    }
}
