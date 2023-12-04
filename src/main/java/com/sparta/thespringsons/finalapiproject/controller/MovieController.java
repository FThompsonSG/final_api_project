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

    @GetMapping("/movies/country")
    public void getFilmByCountry(@Requestparam(name = "country", required = true) String country) {
        //List<MovieDTO> movies = movieRepository.findByCountry(country);
        List<MovieDTO> movies = movieRepository.findAllMoviesByCountry(country);

        if(movie.isPresent() && movie.getCountry().equals(country)) {
            return movies;
        } else {
            return new CountryNotFoundException(country);
        }
    }

    @GetMapping("/movies/yearOfRelease")
    public void getFilmByYearOfRelease(@Requestparam(name = "lowerYear", required = true) Integer lowerYear, @RequestParam(name = "upperYear", required = true)Integer upperYear) {
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
    public void getFilmByRatings(@Requestparam(name = "lowerRating", required = true) Double lowerRating, @RequestParam(name = "upperRating", required = true)Double upperRating) {
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






     */
}
