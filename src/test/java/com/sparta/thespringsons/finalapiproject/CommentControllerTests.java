package com.sparta.thespringsons.finalapiproject;


import com.sparta.thespringsons.finalapiproject.controller.CommentController;
import com.sparta.thespringsons.finalapiproject.model.entities.Comment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CommentController.class)
public class CommentControllerTests {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private CommentController commentController;

    @Test
    @DisplayName("Test Get City")
    void testGetAllComments() throws Exception {
        Comment mockComment = new Comment();
        Mockito.when(commentController.getAllComments()).thenReturn(new ArrayList<>(List.of(mockComment)));
        mockMvc
                .perform(MockMvcRequestBuilders.get("https://localhost:8080/comment"))
                .andExpect(status().is(200));
    }

}
