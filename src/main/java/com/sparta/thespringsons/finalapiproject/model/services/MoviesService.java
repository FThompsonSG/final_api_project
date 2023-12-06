package com.sparta.thespringsons.finalapiproject.model.services;
import com.sparta.thespringsons.finalapiproject.model.entities.EmbeddedMovie;
import com.sparta.thespringsons.finalapiproject.model.entities.Movie;
import com.sparta.thespringsons.finalapiproject.model.fields.Imdb;
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

    public List<Movie> getFilmByTitle(String title) {
        //return lists instead of optional
        List<Movie> movies = movieRepository.findByTitle(title);
        List<Movie> selectedMovies = new ArrayList<>();
        for(Movie movie : movies) {
            if (movie != null && movie.getTitle().contains(title)) {
                selectedMovies.add(movie);
            }
        }
        return movies;
    }

    public ArrayList<Movie> getAllMoviesByDirector(String directors) {
        ArrayList<Movie> movies = movieRepository.findAllByDirectors(directors);
        return movies;
    }

    public List<Movie> getMoviesByWriter(String writerName) {
        return movieRepository.findAllByWriters(writerName);

    }
//    public Optional<List<Movie>> findAllByWriter(String writerName) {
//        List<Movie> movies = new ArrayList<>();
//        for (Movie movie : movieRepository.findAll()) {
//            for (String actor : movie.getCast()) {
//                if (actor.equals(writerName)) {
//                    movies.add(movie);
//                }
//            }
//        }
//        return Optional.of(movies);
//
//    }
    public List<Movie> getMoviesByGenre(String genreName) {
        return movieRepository.findAllByGenres(genreName);
    }
//    public Optional<List<Movie>> findAllByGenre(String genreName) {
//        List<Movie> movies = new ArrayList<>();
//        for (Movie movie : movieRepository.findAll()) {
//            for (String genre : movie.getGenres()) {
//                if (genre.equals(genreName)) {
//                    movies.add(movie);
//                }
//            }
//        }
//        return Optional.of(movies);
//    }
    public List<Movie> getMoviesByLanguages(String language) {
        return movieRepository.findAllByLanguages(language);
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

    public List<Movie> getAllMoviesByImdbRating(Double lowerRating, Double upperRating) {
        List<Movie> movies = movieRepository.findAll();
        List<Movie> selectedMovies = new ArrayList<>();
        for (Movie movie : movies) {
            Imdb imdb = movie.getImdb();
            if (imdb.getRating() != null) {
                Double movieRating = imdb.getRating();
                if (movieRating >= lowerRating && movieRating <= upperRating) {
                    selectedMovies.add(movie);
                }
            }
        }
        return selectedMovies;
    }

    //String
    public List<String> getNumberOfMovieImdbVotes(String movieName) {
        List<Movie> movieList= movieRepository.findByTitle(movieName);
        List<String> resultList = new ArrayList<>();
        for(Movie movie : movieList) {
            Integer numVotes = movie.getImdb().getVotes();
            String result = movieName + " IMDB Votes: " + numVotes;
            resultList.add(result);
        }

        return resultList;
    }

    public List<String> getMovieImdbRatingByName(String movieName) {
        List<Movie> movieList= movieRepository.findByTitle(movieName);
        List<String> resultList = new ArrayList<>();
        for(Movie movie : movieList) {
            Double movieRating = movie.getImdb().getRating();
            String result = movieName + " IMDB Rating: " + movieRating;
            resultList.add(result);
        }
        return resultList;
    }

    public List<String> getMovieImdbIdByName(String movieName) {
        List<Movie> movieList = movieRepository.findByTitle(movieName);
        List<String> resultList = new ArrayList<>();
        for(Movie movie : movieList) {
            Integer movieId = movie.getImdb().getId();
            String result = movieName + " IMDB ID : " + movieId;
            resultList.add(result);
        }
        return resultList;
    }
}
