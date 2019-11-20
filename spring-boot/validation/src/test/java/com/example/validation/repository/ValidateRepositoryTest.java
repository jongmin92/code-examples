package com.example.validation.repository;

import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.persistence.EntityManager;
import javax.validation.ConstraintViolationException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.validation.InputEntity;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class ValidateRepositoryTest {

    @Autowired
    private ValidateRepository repository;

    @Autowired
    private EntityManager entityManager;

    @Test
    void whenInputEntityIsInvalid_thenThrowsException() {
        final InputEntity inputEntity = new InputEntity();
        inputEntity.setNumberBetweenOneAndTen(50);
        inputEntity.setNotEmptyString("");
        inputEntity.setPinCode("1234");

        assertThrows(ConstraintViolationException.class, () -> {
            repository.save(inputEntity);
            entityManager.flush();
        });
    }
}