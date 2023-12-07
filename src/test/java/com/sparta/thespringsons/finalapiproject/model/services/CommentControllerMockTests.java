package com.sparta.thespringsons.finalapiproject.model.services;

import com.sparta.thespringsons.finalapiproject.controller.CommentController;
import com.sparta.thespringsons.finalapiproject.model.entities.Comment;
import com.sparta.thespringsons.finalapiproject.model.repositories.CommentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Optional;

@WebMvcTest(CommentController.class)
public class CommentControllerMockTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CommentRepository commentRepository;

    @MockBean
    private CommentService commentService;

    @MockBean
    private CommentController commentController;

    @Test
    @DisplayName("Test add comment")
    void testAddComment() throws Exception {
        Comment mockComment = new Comment();
        mockComment.setId("5a9427648b0beebeb69810b6");
        mockComment.setText("This is text");
        Mockito.when(commentService.getCommentById(mockComment.getId())).thenReturn(Optional.of(mockComment));

        mockMvc
                .perform(post("http://localhost:3001/comment"))
                .andExpect(status().is(200))
//                .andExpect(content().contentType("application/json"))
//                .andExpect(handler().methodName("addComment"))
                .andDo(print());
    }

}
