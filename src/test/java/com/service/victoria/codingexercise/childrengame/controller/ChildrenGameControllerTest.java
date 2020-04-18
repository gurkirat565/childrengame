package com.service.victoria.codingexercise.childrengame.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.service.victoria.codingexercise.AppApplicationTests;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;

public class ChildrenGameControllerTest extends AppApplicationTests {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testExecute() throws Exception {

        mockMvc.perform(get("/game/5/3")).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(jsonPath("$.winner").value(4))
                .andExpect(jsonPath("$.eliminationSequence", Matchers.hasSize(4)))
                .andExpect(jsonPath("$.eliminationSequence[0]").value(3))
                .andExpect(jsonPath("$.eliminationSequence[1]").value(1))
                .andExpect(jsonPath("$.eliminationSequence[2]").value(5))
                .andExpect(jsonPath("$.eliminationSequence[3]").value(2));
    }

    @Test
    public void testException() throws Exception {

        mockMvc.perform(get("/game/0/3")).andExpect(status().isBadRequest())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().string("Number and position should be non-negative and greater than zero"));
    }
}
