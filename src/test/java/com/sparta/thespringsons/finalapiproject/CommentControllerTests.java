package com.sparta.thespringsons.finalapiproject;


import com.sparta.thespringsons.finalapiproject.controller.CommentController;
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
        testClient.get().uri("https://localhost:8080/commentsbymovietitle/A Corner in Wheat").exchange().expectStatus().isEqualTo(200);
    }

    @Test
    @DisplayName("Test Get Comments By Name")
    void testGetCommentsByName() {
        testClient.get().uri("https://localhost:8080/commentsbyname/Mercedes Tyler").exchange().expectStatus().isEqualTo(200);
    }
}
