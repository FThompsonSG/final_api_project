package com.sparta.thespringsons.finalapiproject.model.services;

import com.sparta.thespringsons.finalapiproject.MflixApplication;
import com.sparta.thespringsons.finalapiproject.logger.OurLogger;
import com.sparta.thespringsons.finalapiproject.model.entities.Comment;
import com.sparta.thespringsons.finalapiproject.model.entities.Movie;
import com.sparta.thespringsons.finalapiproject.model.entities.Theater;
import com.sparta.thespringsons.finalapiproject.model.repositories.CommentRepository;
import com.sparta.thespringsons.finalapiproject.model.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
@Component
public class CommentService {

    public static final Logger logger = Logger.getLogger(CommentService.class.getName());

    private final CommentRepository commentRepository;
    private final MovieRepository movieRepository;
    @Autowired
    public CommentService(CommentRepository commentRepository, MovieRepository movieRepository) {
        this.commentRepository = commentRepository;
        this.movieRepository = movieRepository;
        OurLogger.setUpLogger(logger);
    }

    public List<Comment> getAllComments(){
        logger.log(Level.INFO, "Entered get all comments method in comment service");
        return commentRepository.findAll();
    }

    public List<Comment> getAllByName(String name){
        logger.log(Level.INFO, "Entered get all comments by user name method in comment service");
        return commentRepository.findAllByName(name);
    }

    public List<Comment> getAllCommentsByMovieTitle(String movieTitle){
        logger.log(Level.INFO, "Entered get all comments by movie title method in comment service");
        Movie movie = movieRepository.findByTitle(movieTitle);
        return commentRepository.findAllByMovieId(movie.getId());
    }

    public Optional<Comment> getCommentById(String id) {
        logger.log(Level.INFO, "Entered get comment by id method in comment service");
        return commentRepository.findById(id);
    }

    public Comment saveComment(Comment newComment) {
        logger.log(Level.INFO, "Entered save new comment method in comment service");
        return commentRepository.save(newComment);
    }

    public Optional<Comment> deleteComment(String id) {
        logger.log(Level.INFO, "Entered delete comment method in comment service");
        Optional<Comment> commentToDelete = commentRepository.findById(id);
        commentRepository.deleteById(id);
        return commentToDelete;
    }

    public Comment updateComment(Comment newComment, String id) throws Exception {
        Optional<Comment> retrievedComment = commentRepository.findById(id);
        Comment commentToUpdate = retrievedComment.get();
        commentToUpdate = newComment;
        commentToUpdate.setId(id);
        commentRepository.save(commentToUpdate);
        return commentToUpdate;
    }
}
