package com.sparta.thespringsons.finalapiproject.controller;

import com.sparta.thespringsons.finalapiproject.exceptions.norecordfound.NoRecordFoundException;
import com.sparta.thespringsons.finalapiproject.exceptions.recordalreadyexists.RecordAlreadyExistsException;
import com.sparta.thespringsons.finalapiproject.logger.OurLogger;
import com.sparta.thespringsons.finalapiproject.model.entities.Comment;
import com.sparta.thespringsons.finalapiproject.model.services.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
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

    @Tag(name = "Get All Comments")
    @Operation(summary = "Get All Comments")
    @GetMapping("/comment")
    public List<Comment> getAllComments() throws NoRecordFoundException {
        logger.log(Level.INFO, "Entered get all comments method in comments controller");
        List<Comment> allComments = commentService.getAllComments();
        if (allComments.isEmpty()) {

            throw new NoRecordFoundException("comments", "/comment");
        }
        return allComments;
    }

    @Tag(name = "Get Comment By Name")
    @Operation(summary = "Get Comment By Name")
    @GetMapping("/comment/byName/{name}")
    public List<Comment> getAllCommentsByName(@PathVariable String name) throws NoRecordFoundException {
        logger.log(Level.INFO, "Entered comments by user name method in comments controller");
        List<Comment> allComments = commentService.getAllByName(name);
        if (allComments.isEmpty()) {
            throw new NoRecordFoundException("comments", "/comment/ByName/{name}");
        }
        return allComments;
    }

    @Tag(name = "Get All Comments For Movie")
    @Operation(summary = "Get All Comments For Movie")
    @GetMapping("/comment/byMovieTitle/{movieTitle}")
    public List<Comment> getAllCommentsByMovieTitle(@PathVariable String movieTitle) throws NoRecordFoundException {
        logger.log(Level.INFO, "Entered comments by movie title method in comments controller");
        List<Comment> allComments = commentService.getAllCommentsByMovieTitle(movieTitle);
        if (allComments.isEmpty()) {
            throw new NoRecordFoundException("comments", "/comment/byMovieTitle/{movieTitle}");
        }
        return allComments;
    }

    @Tag(name = "Add New Comment")
    @Operation(summary = "Add new Comment")
    @PostMapping("/comment/add")
    public Optional<Comment> addComment(@RequestBody Comment newComment) throws Exception {
        logger.log(Level.INFO, "Entered add comment method in comment controller");
        Optional<Comment> commentToAdd = commentService.getCommentById(newComment.getId());
        if (commentToAdd.isPresent()) {
            throw new RecordAlreadyExistsException("comment", "/comment/add");
        }
        return Optional.ofNullable(commentService.saveComment(newComment));
    }

    @Tag(name = "Delete Comment")
    @Operation(summary = "Delete a Comment")
    @DeleteMapping("/comment/delete/{id}")
    public Optional<Comment> deleteComment(@PathVariable String id) throws Exception {
        logger.log(Level.INFO, "Entered delete comment method in comment controller");
        Optional<Comment> commentToDelete = commentService.getCommentById(id);
        if (commentToDelete.isEmpty()) {
            throw new NoRecordFoundException("comment", "/comments/delete/{id}");
        }
        return commentService.deleteComment(id);
    }

    @Tag(name = "Update Comment Record")
    @Operation(summary = "Update Comment record")
    @PostMapping("/comment/update/{id}")
    public Optional<Comment> updateComment(
            @RequestBody Comment newComment,
            @PathVariable String id) throws Exception {
        logger.log(Level.INFO, "Entered update comment method in comment controller");
        Optional<Comment> commentToUpdate = commentService.getCommentById(id);
        if (commentToUpdate.isEmpty()) {
            throw new NoRecordFoundException("comment", "/comment/update/{id}");
        }
        return Optional.ofNullable(commentService.updateComment(newComment, id));
    }
}

