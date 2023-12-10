package com.sparta.thespringsons.finalapiproject.model.services;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CommentServiceTests {

    @Autowired
    private CommentService commentService;

    @Test
    @DisplayName("Test get all Comments By Name")
    void TestCommentByName(){
        Assertions.assertEquals("5a9427648b0beebeb69579e7",commentService.getAllByName("Mercedes Tyler").get(0).getId());
    }

    @Test
    @DisplayName("Test get all Comments By Movie Title")
    void TestCommentMovieTitle(){
        Assertions.assertEquals("John Bishop",commentService.getAllCommentsByMovieTitle("A Corner in Wheat").get("A Corner in Wheat 1909").get(0).getName());
    }


}
