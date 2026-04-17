package com.adeo.kobi.weblate.poc.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class GreetingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void greeting_defaultsToEnglish() throws Exception {
        mockMvc.perform(get("/greeting"))
                .andExpect(status().isOk())
                .andExpect(view().name("greeting"))
                .andExpect(content().string(org.hamcrest.Matchers.containsString("Hello, World!")));
    }

    @Test
    void greeting_returnsFrench() throws Exception {
        mockMvc.perform(get("/greeting").header("Accept-Language", "fr"))
                .andExpect(status().isOk())
                .andExpect(view().name("greeting"))
                .andExpect(content().string(org.hamcrest.Matchers.containsString("Bonjour, le Monde !")));
    }

    @Test
    void greeting_returnsSpanish() throws Exception {
        mockMvc.perform(get("/greeting").header("Accept-Language", "es"))
                .andExpect(status().isOk())
                .andExpect(view().name("greeting"))
                .andExpect(content().string(org.hamcrest.Matchers.containsString("¡Hola, Mundo!")));
    }

    @Test
    void greeting_returnsEnglish() throws Exception {
        mockMvc.perform(get("/greeting").header("Accept-Language", "en"))
                .andExpect(status().isOk())
                .andExpect(view().name("greeting"))
                .andExpect(content().string(org.hamcrest.Matchers.containsString("Hello, World!")));
    }
}
