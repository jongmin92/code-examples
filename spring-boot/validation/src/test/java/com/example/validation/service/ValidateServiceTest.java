package com.example.validation.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.validation.ConstraintViolationException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.validation.InputRequest;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ValidateServiceTest {

    @Autowired
    private ValidateService service;

    @Test
    void whenInputRequestIsValid_thenThrowsNoException() {
        final InputRequest request = new InputRequest();
        request.setNumberBetweenOneAndTen(5);
        request.setNotEmptyString("not empty");
        request.setPinCode("123456");

        service.validateInputRequest(request);
    }

    @Test
    void whenInputRequestIsInvalid_thenThrowException() {
        final InputRequest request = new InputRequest();
        request.setNumberBetweenOneAndTen(50);
        request.setNotEmptyString("");
        request.setPinCode("1234");

        assertThrows(ConstraintViolationException.class, () -> {
            service.validateInputRequest(request);
        });
    }
}