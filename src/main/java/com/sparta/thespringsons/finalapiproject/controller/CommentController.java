package com.sparta.thespringsons.finalapiproject.controller;

import com.sparta.thespringsons.finalapiproject.MflixApplication;
import com.sparta.thespringsons.finalapiproject.exceptions.norecordfound.NoRecordFoundException;
import com.sparta.thespringsons.finalapiproject.logger.OurLogger;
import com.sparta.thespringsons.finalapiproject.model.entities.Comment;
import com.sparta.thespringsons.finalapiproject.model.services.CommentService;
import jakarta.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class CommentController {

    public static final Logger logger = Logger.getLogger(CommentController.class.getName());

    private final CommentService commentService;
    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
        OurLogger.setUpLogger(logger);
    }

    @GetMapping("/comment")
    public List<Comment> getAllComments() throws NoRecordFoundException {
        logger.log(Level.INFO, "Entered get all comments method in comments controller");
        List<Comment> allComments = commentService.getAllComments();
        if (allComments.isEmpty()) {
            throw new NoRecordFoundException("comments", "/comment");
        }
        return allComments;
    }

    @GetMapping("/commentsbyname/{name}")
    public List<Comment> getAllCommentsByName(@PathVariable String name) throws NoRecordFoundException {
        logger.log(Level.INFO, "Entered comments by user name method in comments controller");
        List<Comment> allComments = commentService.getAllByName(name);
        if (allComments.isEmpty()) {
            throw new NoRecordFoundException("comments", "/commentsbyname/{name}");
        }
        return allComments;
    }

    @GetMapping("/commentsbymovietitle/{movieTitle}")
    public List<Comment> getAllCommentsByMovieTitle(@PathVariable String movieTitle) throws NoRecordFoundException {
        logger.log(Level.INFO, "Entered comments by movie title method in comments controller");
        List<Comment> allComments = commentService.getAllCommentsByMovieTitle(movieTitle);
        if (allComments.isEmpty()) {
            throw new NoRecordFoundException("comments", "/commentsbymovietitle/{movieTitle}");
        }
        return allComments;
    }
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
