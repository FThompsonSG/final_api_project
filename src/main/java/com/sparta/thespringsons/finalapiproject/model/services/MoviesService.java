package com.sparta.thespringsons.finalapiproject.model.services;
import com.sparta.thespringsons.finalapiproject.model.entities.Movie;
import com.sparta.thespringsons.finalapiproject.model.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MoviesService {

    private MovieRepository movieRepository;

    @Autowired
    public MoviesService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies() {
        List<Movie> movies = movieRepository.findAll();
        return movies;
    }

    public Optional<Movie> getFilmByTitle(String title) {
        //return lists instead of optional
        Optional<Movie> movie = Optional.ofNullable(movieRepository.findByTitle(title));

        if(movie.isPresent() && movie.get().toString().contains(title)) {
            return movie;
        }
        return movie;
    }

    public List<Movie> getAllMoviesByDirector(List<String> directors) {
        List<Movie> movies = new ArrayList<>();
        for (Movie movie : movieRepository.findAllByDirectors(directors)) {
            for (String director : directors) {
                if(directors.contains(director)){
                    movies.add(movie);
                }
            }

        }
        return movies;
    }
    public Optional<List<Movie>> findAllByWriter(String writerName) {
        List<Movie> movies = new ArrayList<>();
        for (Movie movie : movieRepository.findAll()) {
            for (String actor : movie.getCast()) {
                if (actor.equals(writerName)) {
                    movies.add(movie);
                }
            }
        }
        return Optional.of(movies);
    }

    public Optional<List<Movie>> findAllByGenre(String genreName) {
        List<Movie> movies = new ArrayList<>();
        for (Movie movie : movieRepository.findAll()) {
            for (String genre : movie.getGenres()) {
                if (genre.equals(genreName)) {
                    movies.add(movie);
                }
            }
        }
        return Optional.of(movies);
    }

    public Optional<List<Movie>> findAllByLanguage(String languageName) {
        List<Movie> movies = new ArrayList<>();
        for (Movie movie : movieRepository.findAll()) {
            for (String langauge : movie.getLanguages()) {
                if (langauge.equals(languageName)) {
                    movies.add(movie);
                }
            }
        }
        return Optional.of(movies);
    }

    public Optional<List<Movie>> findAllByTomatoesRotten() {
        List<Movie> movies = new ArrayList<>();
        for (Movie movie : movieRepository.findAll()) {
            if (movie.getTomatoes().getRotten() == 0) {
                movies.add(movie);
            }
        }
        return Optional.of(movies);
    }

    public Optional<List<Movie>> findAllByTomatoesFresh() {
        List<Movie> movies = new ArrayList<>();
        for (Movie movie : movieRepository.findAll()) {
            if (movie.getTomatoes().getFresh() == 5) {
                movies.add(movie);
            }
        }
        return Optional.of(movies);
    }

    public Optional<List<Movie>> findAllByTomatoesNumReviewsLarger(double numReviews) {
        List<Movie> movies = new ArrayList<>();
        for (Movie movie : movieRepository.findAll()) {
            if (movie.getTomatoes().getNumberReviews() > numReviews) {
                movies.add(movie);
            }
        }
        return Optional.of(movies);
    }

    public Optional<List<Movie>> findAllByTomatoesNumReviewsSmaller(double numReviews) {
        List<Movie> movies = new ArrayList<>();
        for (Movie movie : movieRepository.findAll()) {
            if (movie.getTomatoes().getNumberReviews() < numReviews) {
                movies.add(movie);
            }
        }
        return Optional.of(movies);
    }






}
