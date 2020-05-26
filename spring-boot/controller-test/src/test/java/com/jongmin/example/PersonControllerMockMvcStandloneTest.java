package com.jongmin.example;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.lenient;
import static org.springframework.test.web.servlet.ResultMatcher.matchAll;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.jongmin.example.controller.PersonController;
import com.jongmin.example.controller.PersonExceptionHandler;
import com.jongmin.example.controller.PersonFilter;
import com.jongmin.example.controller.PersonInterceptor;
import com.jongmin.example.domain.Person;
import com.jongmin.example.exception.NonExistingPersonException;
import com.jongmin.example.service.PersonService;

@ExtendWith(MockitoExtension.class)
public class PersonControllerMockMvcStandloneTest {

    @Mock
    private PersonService personService;

    @InjectMocks
    private PersonController underTest;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(underTest)
                                 .setControllerAdvice(new PersonExceptionHandler())
                                 .addFilters(new PersonFilter())
                                 .addInterceptors(new PersonInterceptor())
                                 .build();
    }

    @Test
    public void getPersonByNameWhenExists() throws Exception {
        lenient().when(personService.getPerson("name"))
                 .thenReturn(new Person("name", 10));

        mockMvc.perform(get("/persons/name")
                                .accept(MediaType.APPLICATION_JSON))
               .andExpect(matchAll(
                       status().isOk(),
                       jsonPath("$.name").value("name"),
                       jsonPath("$.age").value(10)
               ));
    }

    @Test
    public void handleNonExistingPersonException() throws Exception {
        lenient().when(personService.getPerson(anyString()))
                 .thenThrow(NonExistingPersonException.class);

        mockMvc.perform(get("/persons/name")
                                .accept(MediaType.APPLICATION_JSON))
               .andExpect(matchAll(
                       status().isNotFound()
               ));
    }

    @Test
    public void headerIsPresent() throws Exception {
        lenient().when(personService.getPerson("name"))
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
