package com.sparta.thespringsons.finalapiproject.model.services;


import com.sparta.thespringsons.finalapiproject.controller.CommentController;
import com.sparta.thespringsons.finalapiproject.controller.UserController;
import com.sparta.thespringsons.finalapiproject.model.entities.Comment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class UserControllerTests {

    @Autowired
    private UserController userController;

    private WebTestClient testClient;

    @BeforeEach
    void setup() {
        testClient = WebTestClient.bindToController(userController).build();
    }

    @Test
    @DisplayName("Test Get Users By Name")
    void testGetAllUserByName() {
        testClient.get().uri("https://localhost:8080/usersbyname/Jon").exchange().expectStatus().isEqualTo(200);
    }

    @Test
    @DisplayName("Test Get Users By ID")
    void testGetUserById() {
        testClient.get().uri("https://localhost:8080/userbyid/59b99db4cfa9a34dcd7885b6").exchange().expectStatus().isEqualTo(200);
    }

    @Test
    @DisplayName("Test Get Users By Email")
    void testGetUsersByEmail() {
        testClient.get().uri("https://localhost:8080/usersbyemail/ja").exchange().expectStatus().isEqualTo(200);
    }

}
