package com.jongmin.example;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.jongmin.example.domain.Person;
import com.jongmin.example.exception.NonExistingPersonException;
import com.jongmin.example.service.PersonService;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class PersonControllerSpringBootTest {

    @MockBean
    private PersonService personService;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getPersonByNameWhenExists() {
        final Person person = new Person("name", 10);
        when(personService.getPerson("name"))
                .thenReturn(person);

        final ResponseEntity<Person> response = restTemplate.getForEntity("/persons/name", Person.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(person);
    }

    @Test
    public void handleNonExistingPersonException() {
        when(personService.getPerson(anyString()))
                .thenThrow(NonExistingPersonException.class);

        final ResponseEntity<Person> response = restTemplate.getForEntity("/persons/name", Person.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    public void headerIsPresent() {
        final Person person = new Person("name", 10);
        when(personService.getPerson("name"))
                .thenReturn(person);

        final ResponseEntity<Person> response = restTemplate.getForEntity("/persons/name", Person.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getHeaders().get("X-HEADER-1")).containsOnly("filter-value");
        assertThat(response.getHeaders().get("X-HEADER-2")).containsOnly("interceptor-value");
    }
}
