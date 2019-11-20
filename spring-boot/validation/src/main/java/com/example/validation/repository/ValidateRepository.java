package com.example.validation.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.validation.InputEntity;

public interface ValidateRepository extends CrudRepository<InputEntity, Long> {
}
