package com.sparta.thespringsons.finalapiproject.controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/comments")
public class CommentsController {

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
//        @GetMapping("/allComments")
//        public List<Comment> getAllComments() {
//            return commentService.getAllComments();
//        }

        // @PostMapping("/{commentId}")
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
