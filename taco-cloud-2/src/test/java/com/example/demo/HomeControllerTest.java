package com.example.demo;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import com.example.demo.tacos.HomeController;  // Import HomeController properly

@ExtendWith(SpringExtension.class)  // Use SpringExtension for JUnit 5
@WebMvcTest(HomeController.class)    // Focuses on HomeController for testing
public class HomeControllerTest {

    @Autowired
    private MockMvc mockMvc;  // Inject MockMvc to simulate HTTP requests

    @Test
    public void testHomePage() throws Exception {
        // Simulate a GET request to the homepage and check for the response
        mockMvc.perform(get("/"))  // Perform GET request for root ("/") path
            .andExpect(status().isOk())  // Expect HTTP 200 (OK) status
            .andExpect(view().name("home"))  // Expect the "home" view name
            .andExpect(content().string(containsString("Welcome to...")));  // Expect the content to contain "Welcome to..."
    }
}
