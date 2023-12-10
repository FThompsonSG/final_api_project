package com.sparta.thespringsons.finalapiproject.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

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
        testClient.get().uri("https://localhost:8080/user/get/byName/Jon").exchange().expectStatus().isEqualTo(200);
    }

    @Test
    @DisplayName("Test Get Users By ID")
    void testGetUserById() {
        testClient.get().uri("https://localhost:8080/user/get/byId/59b99db4cfa9a34dcd7885b6").exchange().expectStatus().isEqualTo(200);
    }

    @Test
    @DisplayName("Test Get Users By Email")
    void testGetUsersByEmail() {
        testClient.get().uri("https://localhost:8080/user/get/byEmail/ja").exchange().expectStatus().isEqualTo(200);
    }

}
