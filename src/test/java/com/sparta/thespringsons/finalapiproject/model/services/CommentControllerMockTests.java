package com.sparta.thespringsons.finalapiproject.model.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@WebMvcTest(CommentController.class)
public class CommentControllerMockTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CommentService commentService;

    @MockBean
    private CommentRepository commentRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("Test add comment")
    void testAddComment() throws Exception {
        Comment mockComment = new Comment();
        mockComment.setId("5a9427648b0beebeb69810b6");
        mockComment.setText("This is text");
        Mockito.when(commentRepository.save(Mockito.any(Comment.class))).thenReturn(mockComment);

        mockMvc
                .perform(post("http://localhost:8080/comment/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(mockComment)))
                .andExpect(content().contentType("application/json"))
                .andExpect(handler().methodName("addComment"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    @DisplayName("Test Delete comment")
    void testDeleteComment() throws Exception {
//        Comment mockComment = new Comment();
//        mockComment.setId("id1");
//        mockComment.setText("This is text");
//        Mockito.when(commentService.getCommentById(Mockito.anyString())).thenReturn(Optional.of(mockComment));

        List<String> commentIdsToDelete = List.of("id1");

        mockMvc.perform(delete("/comment/delete")
                        .param("confirm", "true")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(commentIdsToDelete)))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content().string("Comment deleted successfully."))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("Test update comment")
    void testUpdateComment() throws Exception {
        Comment mockComment = new Comment();
        mockComment.setId("5a9427648b0beebeb69810b6");
        mockComment.setText("This is text");
        Mockito.when(commentService.getCommentById(Mockito.anyString())).thenReturn(Optional.of(mockComment));

        mockMvc
                .perform(post("http://localhost:8080/comment/update/5a9427648b0beebeb69810b6")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(mockComment)))
                .andExpect(status().is(200))
                .andExpect(content().contentType("application/json"))
                .andExpect(handler().methodName("updateComment"))
                .andDo(print());
    }
}
