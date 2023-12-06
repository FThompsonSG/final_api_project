package com.sparta.thespringsons.finalapiproject.model.services;

import com.sparta.thespringsons.finalapiproject.MflixApplication;
import com.sparta.thespringsons.finalapiproject.logger.OurLogger;
import com.sparta.thespringsons.finalapiproject.model.entities.Comment;
import com.sparta.thespringsons.finalapiproject.model.entities.Movie;
import com.sparta.thespringsons.finalapiproject.model.repositories.CommentRepository;
import com.sparta.thespringsons.finalapiproject.model.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
}
