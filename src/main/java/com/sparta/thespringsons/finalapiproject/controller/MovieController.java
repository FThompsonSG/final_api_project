package com.sparta.thespringsons.finalapiproject.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {


    /*
    private final MovieRepository movieRepository;

    @Autowired
    public MovieController(MovieRepository movieRepository) {
        this.movieController = movieController;
    }

    //Partial search for movie title
    @Tag(name = "Movie Controller API")
    @Operation(summary = "")
    @GetMapping("/movies/title")
    public void getFilmByTitle(@Requestparam(name = "title", required = true) String title) {
        //return lists instead of optional
        Optional<MovieDTO> movie = movieRepository.findByTitle(title);

        if(movie.isPresent() && movie.getTitle().contains(title)) {
            return movie;
        }
    }

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
