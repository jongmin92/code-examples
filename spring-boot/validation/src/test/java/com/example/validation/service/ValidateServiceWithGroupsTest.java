package com.example.validation.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.validation.ConstraintViolationException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.validation.InputEntityWithCustomValidator;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ValidateServiceWithGroupsTest {

    @Autowired
    private ValidateServiceWithGroups service;

    @Test
    void whenInputIsInvalidForCreate_thenThrowsException() {
        InputEntityWithCustomValidator input = new InputEntityWithCustomValidator();
        input.setId(17L);
        input.setNumberBetweenOneAndTen(5);
        input.setNotEmptyString("not empty");
        input.setPinCode("123456");

        assertThrows(ConstraintViolationException.class, () -> {
            service.validateForCreate(input);
        });
    }

    @Test
    void whenInputIsInvalidForUpdate_thenThrowsException() {
        InputEntityWithCustomValidator input = new InputEntityWithCustomValidator();
        input.setId(null);
        input.setNumberBetweenOneAndTen(5);
        input.setNotEmptyString("not empty");
        input.setPinCode("123456");

        assertThrows(ConstraintViolationException.class, () -> {
            service.validateForUpdate(input);
        });
    }
}