package com.example.validation.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.example.validation.InputRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = ValidateRequestBodyController.class)
class ValidateRequestBodyControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void whenInputRequestIsValid_thenReturnStatus200() throws Exception {
        final InputRequest request = new InputRequest();
        request.setNumberBetweenOneAndTen(5);
        request.setNotEmptyString("not empty");
        request.setPinCode("123456");

        final String body = objectMapper.writeValueAsString(request);

        mvc.perform(post("/validateBody")
                            .contentType("application/json")
                            .content(body))
           .andExpect(status().isOk());
    }

    @Test
    void whenInputRequestIsInvalid_thenReturnStatus400() throws Exception {
        final InputRequest request = new InputRequest();
        request.setNumberBetweenOneAndTen(50);
        request.setNotEmptyString("");
        request.setPinCode("1234");

        final String body = objectMapper.writeValueAsString(request);

        mvc.perform(post("/validateBody")
                            .contentType("application/json")
                            .content(body))
           .andExpect(status().isBadRequest());
    }
}
