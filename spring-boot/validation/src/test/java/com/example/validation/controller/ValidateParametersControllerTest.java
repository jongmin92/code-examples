package com.example.validation.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = ValidateParametersController.class)
class ValidateParametersControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void whenPathVariableIsValid_thenReturnStatus200() throws Exception {
        mvc.perform(get("/validatePathVariable/10"))
           .andExpect(status().isOk());
    }

    @Test
    void whenPathVariableIsInValid_thenReturnStatus400() throws Exception {
        mvc.perform(get("/validatePathVariable/1"))
           .andExpect(status().isBadRequest());
    }

    @Test
    void whenRequestParameterIsInvalid_thenReturnStatus400() throws Exception {
        mvc.perform(get("/validateRequestParameter")
                            .param("param", "1"))
           .andExpect(status().isBadRequest());
    }
}
