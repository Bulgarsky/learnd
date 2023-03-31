package com.example.demo.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(HelloController.class)
class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Test
    void getHello() throws Exception {
        mockMvc.perform(get("/spring/hello"))
                .andExpect(status().isOk())
                .andExpect(view().name("hello"))
                .andExpect(content().string(containsString("Spring App started ...")));
    }

    @Test
    void getMessage() throws Exception {
        mockMvc.perform(get("/spring/message"))
                .andExpect(status().isOk())
                .andExpect(view().name("message"))
                .andExpect(content().string(containsString("Message: Spring learning begin")));
    }
}