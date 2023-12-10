package com.sparta.thespringsons.finalapiproject.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.thespringsons.finalapiproject.model.entities.User;
import com.sparta.thespringsons.finalapiproject.model.services.ApiKeyService;
import com.sparta.thespringsons.finalapiproject.model.services.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Optional;

@WebMvcTest(UserController.class)
public class UserControllerMockTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ApiKeyService apiKeyService;

    @MockBean
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("Test add user")
    void testAddUser() throws Exception {
        User mockUser = new User();
        mockUser.setId("TestID");
        mockUser.setName("Test Name");
        Mockito.when(userService.saveUser(Mockito.any(User.class))).thenReturn(Optional.of(mockUser));

        mockMvc
                .perform(post("http://localhost:8080/user/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(mockUser)))
                .andExpect(status().is(200))
                .andExpect(content().contentType("application/json"))
                .andExpect(handler().methodName("addUser"))
//                .andExpect(content().string("This is text"))
                .andDo(print());
    }

    @Test
    @DisplayName("Test Delete user")
    void testDeleteUser() throws Exception {
        User mockUser = new User();
        mockUser.setId("5a9427648b0beebeb69810b6");
        Mockito.when(userService.getById(Mockito.anyString())).thenReturn(Optional.of(mockUser));
        Mockito.when(apiKeyService.checkIfApiKeyExists("68660983")).thenReturn(true);

        mockMvc
                .perform(delete("http://localhost:8080/user/delete/byId/5a9427648b0beebeb69810b6")
                        .header("Key","68660983"))
                .andExpect(status().is(200))
                .andExpect(content().contentType("application/json"))
                .andExpect(handler().methodName("deleteUser"))
                .andDo(print());
    }

    @Test
    @DisplayName("Test update user")
    void testUpdateUser() throws Exception {
        User mockUser = new User();
        mockUser.setId("5a9427648b0beebeb69810b6");
        Mockito.when(userService.getById(Mockito.anyString())).thenReturn(Optional.of(mockUser));
        Mockito.when(apiKeyService.checkIfApiKeyExists("68660983")).thenReturn(true);

        mockMvc
                .perform(post("http://localhost:8080/user/update/byId/5a9427648b0beebeb69810b6")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(mockUser))
                        .header("Key","68660983"))
                .andExpect(status().is(200))
                .andExpect(content().contentType("application/json"))
                .andExpect(handler().methodName("updateUser"))
                .andDo(print());
    }
}
