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
    @GetMapping("/movies")
    public void getFilmByTitle(@Requestparam(name = "title", required = true) String title) {
        Optional<MovieDTO> movie = movieRepository.findByTitle();

        if(movie.isPresent() && movie.getTitle().contains(title)) {
            return movie;
        }
    }



     */
}
