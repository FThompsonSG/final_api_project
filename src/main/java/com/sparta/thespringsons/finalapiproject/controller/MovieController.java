package com.sparta.thespringsons.finalapiproject.controller;

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


    //Partial search for movie title
    @Tag(name = "Movie Controller API")
    @Operation(summary = "")
    @GetMapping("/movies/title")
    public void getFilmByTitle(@RequestParam(name = "title", required = true) String title) {
        //return lists instead of optional
        Optional<MovieDTO> movie = movieRepository.findByTitle(title);



    /*
    @GetMapping("/movies/director")
    public void getFilmByDirector(@RequestParam(name = "director", required = true) String director) {
        Optional<MovieDTO> movie = movieRepository.findByDirector(director);

        if(movie.isPresent() && movie.getDirector().contains(director)) {
            return movie;
        }
    }



    @GetMapping("/movies/performer")
    public void getFilmByPerformer(@RequestParam(name = "performer", required = true) String performer) {
        List<MovieDTO> movies = movieRepository.findAllMoviesByActors(performer);

        if(movie.isPresent() && movie.getActors().contains(performer)) {
            return movies;
        } else {
            return new PerformerNotFoundException(performer);
        }
    }



    @GetMapping("/movies/genre")
    public void getFilmByGenre(@RequestParam(name = "genre", required = true) String genre) {
        List<MovieDTO> movies = movieRepository.findAllMoviesByGenre(genre);

        if(movie.isPresent() && movie.getGenre().contains(genre)) {
            return movies;
        } else {
            return new GenreNotFoundException(performer);
        }
    }

    @GetMapping("/movies/country")
    public void getFilmByCountry(@RequestParam(name = "country", required = true) String country) {
        //List<MovieDTO> movies = movieRepository.findByCountry(country);
        List<MovieDTO> movies = movieRepository.findAllMoviesByCountry(country);

        if(movie.isPresent() && movie.getCountry().equals(country)) {
            return movies;
        } else {
            return new CountryNotFoundException(country);
        }
    }

    @GetMapping("/movies/yearOfRelease")
    public void getFilmByYearOfRelease(@RequestParam(name = "lowerYear", required = true) Integer lowerYear, @RequestParam(name = "upperYear", required = true)Integer upperYear) {
        List<MovieDTO> movies = movieRepository.findAll();
        List<MovieDTO> selectedMovies = new ArrayList();
        for(MovieDTO movie : movies) {
            Integer yearOfRelease = movie.get().getYearOfRelease();
            if (yearOfRelease >= lowerYear && yearOfRelease <= upperYear) {
                selectedMovies.add(movie);
            }
        }
        return selectedMovies;
    }

    @GetMapping("/movies/rating")
    public void getFilmByRatings(@RequestParam(name = "lowerRating", required = true) Double lowerRating, @RequestParam(name = "upperRating", required = true)Double upperRating) {
        List<MovieDTO> movies = movieRepository.findAll();
        List<MovieDTO> selectedMovies = new ArrayList();
        for(MovieDTO movie : movies) {
            Double movieRating = movie.get().getRating();
            if (movieRating >= lowerRating && movieRating <= upperRating) {
                selectedMovies.add(movie);
            }
        }
        return selectedMovies;
    }

    @GetMapping("/movies/runtime")
    public void getFilmByRuntime(@RequestParam(name = "minimumRuntime", required = true) Integer minimumRuntime, @RequestParam(name = "maximumRuntime", required = true)Integer maximumRating) {
        List<MovieDTO> movies = movieRepository.findAll();
        List<MovieDTO> selectedMovies = new ArrayList();
        for(MovieDTO movie : movies) {
            Integer movieRuntime = movie.get().getRuntime();
            if (movieRuntime >= minimumRuntime && movieRuntime <= maximumRuntime) {
                selectedMovies.add(movie);
            }
        }
        return selectedMovies;
    }








     */
}
