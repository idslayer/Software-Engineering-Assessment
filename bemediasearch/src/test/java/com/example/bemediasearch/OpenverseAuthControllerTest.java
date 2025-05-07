package com.example.bemediasearch;

import com.example.bemediasearch.controller.OpenverseAuthController;
import com.example.bemediasearch.entity.User;
import com.example.bemediasearch.payload.resquest.LoginRequest;
import com.example.bemediasearch.payload.resquest.RegisterRequest;
import com.example.bemediasearch.service.OpenverseAuthService;
import com.example.bemediasearch.utils.JwtUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(OpenverseAuthController.class)
class OpenverseAuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OpenverseAuthService openverseAuthService;

    @MockBean
    private JwtUtil jwtUtil;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    void testRegister() throws Exception {
        RegisterRequest request = new RegisterRequest("username", "fullName", "password");

        Mockito.when(openverseAuthService.register(any(String.class), any(String.class), any(String.class))).thenReturn(true);

        mockMvc.perform(post("/api/openverse/v1/auth/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
            .andExpect(status().isOk())
            .andExpect(content().string("Registered successfully"));
    }

    @Test
    void testLogin() throws Exception {
        LoginRequest request = new LoginRequest("username", "password");

        Mockito.when(openverseAuthService.authenticate(any(String.class), any(String.class))).thenReturn(new User("username", "fullName", "password"));
        Mockito.when(jwtUtil.generateToken(any(String.class), any(String.class))).thenReturn("jwtToken");

        mockMvc.perform(post("/api/openverse/v1/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.token").value("jwtToken"));
    }
}