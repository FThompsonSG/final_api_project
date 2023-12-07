package com.sparta.thespringsons.finalapiproject.model.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.thespringsons.finalapiproject.controller.CommentController;
import com.sparta.thespringsons.finalapiproject.controller.UserController;
import com.sparta.thespringsons.finalapiproject.model.entities.Comment;
import com.sparta.thespringsons.finalapiproject.model.entities.User;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@WebMvcTest(UserController.class)
public class UserControllerMockTests {

    @Autowired
    private MockMvc mockMvc;

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
        Mockito.when(userService.saveUser(mockUser)).thenReturn(Optional.of(mockUser));

        mockMvc
                .perform(post("http://localhost:8080/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(mockUser)))
                .andExpect(status().is(200))
                .andExpect(content().contentType("application/json"))
                .andExpect(handler().methodName("addUser"))
//                .andExpect(content().string("This is text"))
                .andDo(print());
    }

//    @Test
//    @DisplayName("Test Delete comment")
//    void testDeleteComment() throws Exception {
//        Comment mockComment = new Comment();
//        mockComment.setId("5a9427648b0beebeb69810b6");
//        mockComment.setText("This is text");
//        Mockito.when(commentService.deleteComment(mockComment.getId())).thenReturn("Comment has been deleted");
//
//        mockMvc
//                .perform(delete("http://localhost:8080/comments/delete/5a9427648b0beebeb69810b6"))
//                .andExpect(status().is(200))
//                .andExpect(content().contentType("application/json"))
//                .andExpect(handler().methodName("deleteComment"))
//                .andDo(print());
//    }
//
//    @Test
//    @DisplayName("Test update comment")
//    void testUpdateComment() throws Exception {
//        Comment mockComment = new Comment();
//        mockComment.setId("5a9427648b0beebeb69810b6");
//        mockComment.setText("This is text");
//        Mockito.when(commentService.getCommentById(mockComment.getId())).thenReturn(Optional.of(mockComment));
//
//        mockMvc
//                .perform(post("http://localhost:8080/comment/update/5a9427648b0beebeb69810b6")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(mockComment)))
//                .andExpect(status().is(200))
//                .andExpect(content().contentType("application/json"))
//                .andExpect(handler().methodName("updateComment"))
//                .andDo(print());
//    }
}
