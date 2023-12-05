package com.sparta.thespringsons.finalapiproject.model.services;

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

@Service
@Component
public class CommentService {
    private final CommentRepository commentRepository;
    private final MovieRepository movieRepository;
    @Autowired
    public CommentService(CommentRepository commentRepository, MovieRepository movieRepository) {
        this.commentRepository = commentRepository;
        this.movieRepository = movieRepository;
    }

    public List<Comment> getAllComments(){
        return commentRepository.findAll();
    }

    public List<Comment> getAllByName(String name){
        return commentRepository.findAllByName(name);
    }

    public List<Comment> getAllCommentsByMovieTitle(String movieTitle){
        Movie movie = movieRepository.findByTitle(movieTitle);
        return commentRepository.findAllByMovieId(movie.getId());
    }

    public boolean getBoool(String movieId){
        boolean bla = false;
        List<Comment> sss = commentRepository.findAllByMovieId(movieId);
        if(!sss.isEmpty()){
            bla =  true;
        }
        return bla;
    }

    public List<Comment> getAllByMovieId(String id){
        return commentRepository.findAllById(id);
    }
}
