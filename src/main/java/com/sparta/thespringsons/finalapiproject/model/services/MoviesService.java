//package com.sparta.thespringsons.finalapiproject.model.services;
//import com.sparta.thespringsons.finalapiproject.model.entities.Movie;
//import com.sparta.thespringsons.finalapiproject.model.repositories.MovieRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class MoviesService {
//
//    private MovieRepository movieRepository;
//
//    @Autowired
//    public MoviesService(MovieRepository movieRepository) {
//        this.movieRepository = movieRepository;
//    }
//
//    public List<Movie> getAllMovies() {
//        List<Movie> movies = movieRepository.findAllMovies();
//        return movies;
//    }
//
//    public Optional<Movie> getFilmByTitle(String title) {
//        //return lists instead of optional
//        Optional<Movie> movie = Optional.ofNullable(movieRepository.findByTitle(title));
//
//        if(movie.isPresent() && movie.get().toString().contains(title)) {
//            return movie;
//        }
//        return movie;
//    }
//
//    public List<Movie> getAllMoviesByDirectors(List<String> directors) {
//        List<Movie> allMovies = movieRepository.findAllByDirectors(directors);
//        return allMovies;
//    }
//
//    public List<Movie> getAllMoviesByActors(List<String> directors) {
//        List<Movie> allMovies = movieRepository.findAllByDirectors(directors);
//        return allMovies;
//    }
//}
