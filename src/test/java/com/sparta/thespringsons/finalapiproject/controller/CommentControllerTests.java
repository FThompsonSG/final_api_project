package com.sparta.thespringsons.finalapiproject.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest
public class CommentControllerTests {

    @Autowired
    private CommentController commentController;

    private WebTestClient testClient;

    @BeforeEach
    void setup() {
        testClient = WebTestClient.bindToController(commentController).build();
    }

    @Test
    @DisplayName("Test Get Comments By Movie Title")
    void testGetAllCommentsByMovieTitle() throws Exception {
        testClient.get().uri("https://localhost:8080/comment/get/byMovieTitle/A Corner in Wheat").exchange().expectStatus().isEqualTo(200);
    }

    @Test
    @DisplayName("Test Get Comments By Name")
    void testGetCommentsByName() {
        testClient.get().uri("https://localhost:8080/comment/get/byUsersName/Mercedes Tyler").exchange().expectStatus().isEqualTo(200);
    }
}
