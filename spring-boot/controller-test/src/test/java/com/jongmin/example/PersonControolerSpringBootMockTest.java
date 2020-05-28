package com.jongmin.example;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.ResultMatcher.matchAll;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import com.jongmin.example.domain.Person;
import com.jongmin.example.exception.NonExistingPersonException;
import com.jongmin.example.service.PersonService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PersonControolerSpringBootMockTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonService personService;

    @Test
    public void getPersonByNameWhenExists() throws Exception {
        when(personService.getPerson("name"))
                .thenReturn(new Person("name", 10));

        mockMvc.perform(get("/persons/name")
                                .accept(MediaType.APPLICATION_JSON))
               .andExpect(ResultMatcher.matchAll(
                       status().isOk(),
                       jsonPath("$.name").value("name"),
                       jsonPath("$.age").value(10)
               ));
    }

    @Test
    public void handleNonExistingPersonException() throws Exception {
        when(personService.getPerson(anyString()))
                .thenThrow(NonExistingPersonException.class);

        mockMvc.perform(get("/persons/name")
                                .accept(MediaType.APPLICATION_JSON))
               .andExpect(matchAll(
                       status().isNotFound()
               ));
    }

    @Test
    public void headerIsPresent() throws Exception {
        when(personService.getPerson("name"))
                .thenReturn(new Person("name", 10));

        mockMvc.perform(get("/persons/name")
                                .accept(MediaType.APPLICATION_JSON))
               .andExpect(matchAll(
                       status().isOk(),
                       header().string("X-HEADER-1", "filter-value"),
                       header().string("X-HEADER-2", "interceptor-value")
               ));
    }
}
