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

    private static MovieRepository movieRepository;

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
        for (Movie movie : movies) {
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

//    public Optional<List<Movie>> findAllByLanguage(String languageName) {
//        List<Movie> movies = new ArrayList<>();
//        for (Movie movie : movieRepository.findAll()) {
//            for (String langauge : movie.getLanguages()) {
//                if (langauge.equals(languageName)) {
//                    movies.add(movie);
//                }
//            }
//        }
//        return Optional.of(movies);
//    }

    public List<Movie> getMoviesByCountries(String country) {
        return movieRepository.findAllByCountries(country);
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

    public List<Movie> getAllByFullPlot(String fullPlot) {
        List<Movie> allMovies = movieRepository.findAll();
        List<Movie> selectedMovies = new ArrayList<>();
        for (Movie movie : allMovies) {
            String plot = movie.getFullplot();
            if (plot != null && plot.contains(fullPlot)) {
                selectedMovies.add(movie);
            }
        }
        return selectedMovies;
    }

    public List<Movie> getAllByPlot(String keyWord) {
        List<Movie> allMovies = movieRepository.findAll();
        List<Movie> selectedMovies = new ArrayList<>();
        for (Movie movie : allMovies) {
            String plot = movie.getPlot();
            if (plot != null && plot.contains(keyWord)) {
                selectedMovies.add(movie);
            }
        }
        return selectedMovies;
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
        List<Movie> movieList = movieRepository.findByTitle(movieName);
        List<String> resultList = new ArrayList<>();
        for (Movie movie : movieList) {
            Integer numVotes = movie.getImdb().getVotes();
            String result = movieName + " IMDB Votes: " + numVotes;
            resultList.add(result);
        }

        return resultList;
    }

    public List<String> getMovieImdbRatingByName(String movieName) {
        List<Movie> movieList = movieRepository.findByTitle(movieName);
        List<String> resultList = new ArrayList<>();
        for (Movie movie : movieList) {
            Double movieRating = movie.getImdb().getRating();
            String result = movieName + " IMDB Rating: " + movieRating;
            resultList.add(result);
        }
        return resultList;
    }

    public List<String> getMovieImdbIdByName(String movieName) {
        List<Movie> movieList = movieRepository.findByTitle(movieName);
        List<String> resultList = new ArrayList<>();
        for (Movie movie : movieList) {
            Integer movieId = movie.getImdb().getId();
            String result = movieName + " IMDB ID : " + movieId;
            resultList.add(result);
        }
        return resultList;
    }

    public List<String> getYearOfRelease(String name) {
        List<Movie> allMovies = movieRepository.findByTitle(name);
        List<String> movies = new ArrayList<>();
        for (Movie movie : allMovies) {
            String year = movie.getReleased().substring(24);
            String result = "";
            if (year != null) {
                result = name + "'s year of release: " + year;
                movies.add(result);
            }
        }
        return movies;
    }

    public List<Movie> getMoviesByYearExact(String year) {
        try {
            Integer yearInt = Integer.parseInt(year);
            return movieRepository.findByYearExact(yearInt);
        } catch (Exception e) {
            System.out.println("Invalid String");
            return null;
        }
    }

    public List<Movie> getMoviesByYearBefore(String year) {
        try {
            Integer yearInt = Integer.parseInt(year);
            return movieRepository.findByYearBefore(yearInt);
        } catch (Exception e) {
            System.out.println("Invalid String");
            return null;
        }
    }

    public List<Movie> getMoviesByYearAfter(String year) {
        try {
            Integer yearInt = Integer.parseInt(year);
            return movieRepository.findByYearAfter(yearInt);
        } catch (Exception e) {
            System.out.println("Invalid String");
            return null;
        }
    }

    public List<String> getPosterLinkByTitle(String name) {
        List<Movie> allMovies = movieRepository.findByTitle(name);
        List<String> movies = new ArrayList<>();
        for (Movie movie : allMovies) {
            String posterLink = movie.getPoster();
            String result = "";
            if (posterLink != null) {
                result = name + "'s poster link: " + posterLink;
                movies.add(result);
            }
        }
        return movies;
    }

    public List<Movie> getMoviesByCastMember(String castMemberName) {
        return movieRepository.findByCastMember(castMemberName);
    }

    public List<Movie> getMoviesByNumberOfNominations(Integer noms) {
        return movieRepository.findMoviesByAwards_Nominations(noms);
    }

    public List<Movie> getMoviesByNumberOfWins(Integer wins) {
        return movieRepository.findMoviesByAwards_Wins(wins);
    }

    public List<Movie> getMoviesByAwardName(String awardName) {
        return movieRepository.findByFieldNameContaining(awardName);
    }

    public List<String> getLastUpdatedByMovieTitle(String name) {
        List<Movie> movies = movieRepository.findByTitle(name);
        List<String> resultList = new ArrayList<>();
        String result = "";
        for (Movie movie : movies) {
            result = name + " last updated on " + movie.getLastupdated();

            if (movie.getLastupdated() != null) {
                resultList.add(result);
            }
        }
        return resultList;
    }

//find the movie by rating
    public List<Movie> getAllRatedMoviesByRating(String rating){
        List<Movie> movies = movieRepository.findAllByRated(rating);
        List<Movie> ratedMovies = new ArrayList<>();


        for(Movie movie : movies){

            if (movie.getRated() != null) {
                ratedMovies.add(movie);}
        }

        return ratedMovies;
    }

//finds all rated movies
    public List<Movie> getAllRatedMovies(){
        List<Movie> movies = movieRepository.findAll();
        List<Movie> ratedMovies = new ArrayList<>();

        for(Movie movie : movies){

            if (movie.getRated() != null) {
                ratedMovies.add(movie);}
        }

        return ratedMovies;
    }


    public List<Movie> getAllUnratedMovies(){
        List<Movie> movies = movieRepository.findAll();
        List<Movie> unratedMovies = new ArrayList<>();


        for(Movie movie : movies){

            if (movie.getRated() == null) {
                unratedMovies.add(movie);
            }
        }

        return unratedMovies;
    }


    public List<Movie> getMoviesByNumberOfComments(Integer numberOfComments) {
        return movieRepository.findByNumberOfComments(numberOfComments);
    }

    public List<String> getNumberOfCommentsByTitle(String title) {
        List<Movie> movies = movieRepository.findByTitle(title);
        List<String> resultList = new ArrayList<>();
        String result = "";
        for (Movie movie : movies) {
            result = title + " type: " + movie.getNum_mflix_comments();
            if (movie.getNum_mflix_comments() != null) {
                resultList.add(result);
            }
        }
        return resultList;
    }

    public List<Movie> getMoviesByMaxRuntime(Integer mins) {
        return movieRepository.findByMaxRuntime(mins);
    }

    public List<Movie> getMoviesByRangeOfRuntime(Integer minRange, Integer maxRange) {
        List<Movie> allMovies = movieRepository.findAll();
        List<Movie> selectedMovies = new ArrayList<>();
        for (Movie movie : allMovies) {
            Integer movieRuntime = movie.getRuntime();
            if (movieRuntime != null && movieRuntime >= minRange && movieRuntime <= maxRange) {
                selectedMovies.add(movie);
            }
        }
        return selectedMovies;
    }

    public List<String> getTypeByTitle(String title) {
        List<Movie> movies = movieRepository.findByTitle(title);
        List<String> resultList = new ArrayList<>();
        String result = "";
        for (Movie movie : movies) {
            result = title + " type: " + movie.getType();
            if (movie.getType() != null) {
                resultList.add(result);
            }
        }
        return resultList;
    }

    public static List<Movie> getAllMoviesByReleaseRange(String lowerDate, String upperDate) throws NumberFormatException {
        List<Movie> movies = movieRepository.findAll();
        List<Movie> moviesInRange = new ArrayList<>();

        try {
            int lowDate = Integer.parseInt(lowerDate);
            int highDate = Integer.parseInt(upperDate);

            List<Movie> movieRangeList = movies.stream()
                    .filter(movie -> {
                        try {
                            int movieYear = Integer.parseInt(movie.getYear());
                            return movieYear >= lowDate && movieYear <= highDate;
                        } catch (NumberFormatException e) {
                            return false;
                        }
                    })
                    .toList();

            return movieRangeList;
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Invalid date format");
        }
    }


}
