package com.example.validation.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.validation.ConstraintViolationException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.validation.InputEntity;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class DirectlyValidateServiceTest {

    @Autowired
    private DirectlyValidateService service;

    @Test
    void whenInputEntityIsInvalid_thenThrowsException() {
        final InputEntity inputEntity = new InputEntity();
        inputEntity.setNumberBetweenOneAndTen(50);
        inputEntity.setNotEmptyString("");
        inputEntity.setPinCode("1234");

        assertThrows(ConstraintViolationException.class, () -> {
            service.validateInput(inputEntity);
        });
    }

    @Test
    void givenInjectedValidator_whenInputEntityIsInvalid_thenThrowsException() {
        final InputEntity inputEntity = new InputEntity();
        inputEntity.setNumberBetweenOneAndTen(50);
        inputEntity.setNotEmptyString("");
        inputEntity.setPinCode("1234");

        assertThrows(ConstraintViolationException.class, () -> {
            service.validateInputWithInjectedValidator(inputEntity);
        });
    }
}