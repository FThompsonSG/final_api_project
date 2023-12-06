package com.sparta.thespringsons.finalapiproject.controller;

import com.sparta.thespringsons.finalapiproject.model.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {


//    private final MovieRepository movieRepository;
//
//    @Autowired
//    public MovieController(MovieRepository movieRepository1) {
//        this.movieRepository = movieRepository1;
//    }
//    /*
//    */
//    //Partial search for movie title



    /*
    @GetMapping("/movies/director")
    public void getFilmByDirector(@Requestparam(name = "director", required = true) String director) {
        Optional<MovieDTO> movie = movieRepository.findByDirector(director);

        if(movie.isPresent() && movie.getDirector().contains(director)) {
            return movie;
        }
    }



    @GetMapping("/movies/performer")
    public void getFilmByPerformer(@Requestparam(name = "performer", required = true) String performer) {
        List<MovieDTO> movies = movieRepository.findAllMoviesByActors(performer);

        if(movie.isPresent() && movie.getActors().contains(performer)) {
            return movies;
        } else {
            return new PerformerNotFoundException(performer);
        }
    }



    @GetMapping("/movies/genre")
    public void getFilmByGenre(@Requestparam(name = "genre", required = true) String genre) {
        List<MovieDTO> movies = movieRepository.findAllMoviesByGenre(genre);

        if(movie.isPresent() && movie.getGenre().contains(genre)) {
            return movies;
        } else {
            return new GenreNotFoundException(performer);
        }
    }

    @GetMapping("/movies/genre")
    public void getFilmByGenre(@Requestparam(name = "genre", required = true) String genre) {
        List<MovieDTO> movies = movieRepository.findAllMoviesByGenre(genre);

        if(movie.isPresent() && movie.getGenre().contains(genre)) {
            return movies;
        } else {
            return new GenreNotFoundException(performer);
        }
    }












     */
}
