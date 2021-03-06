package com.jongmin.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jongmin.example.domain.Person;
import com.jongmin.example.service.PersonService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonService personService;

    @GetMapping("/{name}")
    public Person getPersonByName(@PathVariable String name) {
        return personService.getPerson(name);
    }
}
