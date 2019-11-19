package com.example.validation.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.validation.InputRequest;

@RestController
public class ValidateRequestBodyController {

    @PostMapping("/validateBody")
    ResponseEntity<String> validateBody(@Valid @RequestBody InputRequest request) {
        return ResponseEntity.ok("valid");
    }
}
