package com.sparta.thespringsons.finalapiproject.controller;

import com.sparta.thespringsons.finalapiproject.model.entities.Comment;
import com.sparta.thespringsons.finalapiproject.model.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommentController {
    private final CommentRepository commentRepository;
    @Autowired
    public CommentController(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @GetMapping("/comment")
    public List<Comment> getAllComments(){
        return commentRepository.findAll();
    }

    //
//
//        // Assuming we'll have a service for handling comments
//        private final CommentService commentService;
//
//        @Autowired
//        public CommentsController(CommentService commentService) {
//            this.commentService = commentService;
//        }
//
//        @Tag(name = "Comments API")
//        @Operation(summary = "Get all comments")
//        @GetMapping
//        public List<Comment> getAllComments() {
//            return commentService.getAllComments();
//        }

    // @PostMapping
    // public Comment createComment(@RequestBody CommentRequest commentRequest) {
    //    return commentService.createComment(commentRequest);
    // }

    // @PutMapping("/{commentId}")
    // public Comment updateComment(@PathVariable String commentId, @RequestBody CommentRequest commentRequest) {
    //    return commentService.updateComment(commentId, commentRequest);
    // }

    // @DeleteMapping("/{commentId}")
    // public void deleteComment(@PathVariable String commentId) {
    //    commentService.deleteComment(commentId);
    // }
}
