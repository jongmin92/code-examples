package com.jongmin.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jongmin.example.domain.Person;
import com.jongmin.example.exception.NonExistingPersonException;

@Service
public class PersonService {

    private final List<Person> persons;

    public PersonService() {
        persons = new ArrayList<>();
        persons.add(new Person("papa", 59));
        persons.add(new Person("mama", 55));
        persons.add(new Person("jm", 29));
        persons.add(new Person("js", 26));
    }

    public Person getPerson(String name) {
        return persons.stream()
                      .filter(p -> p.getName().equals(name))
                      .findAny()
                      .orElseThrow(() -> new NonExistingPersonException());
    }

    public void addPerson(Person person) {
        this.persons.add(person);
    }
}
