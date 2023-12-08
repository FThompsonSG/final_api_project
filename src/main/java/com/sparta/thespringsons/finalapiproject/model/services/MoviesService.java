package com.sparta.thespringsons.finalapiproject.model.services;
import com.sparta.thespringsons.finalapiproject.exceptions.InvalidDocumentException;
import com.sparta.thespringsons.finalapiproject.model.entities.EmbeddedMovie;
import com.sparta.thespringsons.finalapiproject.model.entities.Movie;
import com.sparta.thespringsons.finalapiproject.model.entities.Movie;
import com.sparta.thespringsons.finalapiproject.model.fields.Awards;
import com.sparta.thespringsons.finalapiproject.model.fields.Imdb;
import com.sparta.thespringsons.finalapiproject.model.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class MoviesService {

    private static MovieRepository movieRepository;

    @Autowired
    public MoviesService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie getMovieById(String Id) {
        if(movieRepository.findById(Id).isPresent()) {
            return movieRepository.findById(Id).get();
        } else {
            System.out.println("Movie not found. Please make sure you have the correct ID.");
            return null;
        }

    }
    public List<Movie> getAllMovies() {
        List<Movie> movies = movieRepository.findAll();
        return movies;
    }

    public List<Movie> getMovieByTitle(String title) {
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

    public List<Movie> getAllMoviesByWriter(String writerName) {
        return movieRepository.findAllByWriters(writerName);

    }

    public List<Movie> getMoviesByGenre(String genreName) {
        return movieRepository.findAllByGenres(genreName);
    }

    public List<Movie> getMoviesByLanguages(String language) {
        return movieRepository.findAllByLanguages(language);
    }

    public List<Movie> getMoviesByCountries(String country) {
        return movieRepository.findAllByCountries(country);
    }

    public List<Movie> getAllByFullPlot(String fullPlot){
        List<Movie> allMovies = movieRepository.findAll();
        List<Movie> selectedMovies = new ArrayList<>();
        for(Movie movie : allMovies) {
            String plot = movie.getFullplot();
            if(plot != null && plot.contains(fullPlot)) {
                selectedMovies.add(movie);
            }
        }
        return selectedMovies;
    }

    public List<Movie> getAllByPlot(String keyWord) {
        List<Movie> allMovies = movieRepository.findAll();
        List<Movie> selectedMovies = new ArrayList<>();
        for(Movie movie : allMovies) {
            String plot = movie.getPlot();
            if(plot != null && plot.contains(keyWord)) {
                selectedMovies.add(movie);
            }
        }
        return selectedMovies;
    }

    public List<Movie> findAllByTomatoesCriticRating(double minRating, double maxRating) {

        List<Movie> Movies = new ArrayList<>();
        List<Movie> MoviesFinal = new ArrayList<>();
        for (Movie Movie : movieRepository.findAll()) {
            if(Movie.getTomatoes() != null) {
                if (Movie.getTomatoes().getCritic() != null)
                    if(Movie.getTomatoes().getCritic().getRating() != null)
                        if (Movie.getTomatoes().getCritic().getRating() < maxRating && Movie.getTomatoes().getCritic().getRating() > minRating) {
                            MoviesFinal.add(Movie);
                        }

            }
        }
        return MoviesFinal;
    }

    public List<Movie> findAllByTomatoesViewerRating(double minRating, double maxRating) {
        List<Movie> Movies = new ArrayList<>();
        List<Movie> MoviesFinal = new ArrayList<>();
        for (Movie Movie : movieRepository.findAll()) {
            if(Movie.getTomatoes() != null) {
                if (Movie.getTomatoes().getViewer() != null)
                    if(Movie.getTomatoes().getViewer().getRating() != null)
                        if (Movie.getTomatoes().getViewer().getRating() < maxRating && Movie.getTomatoes().getViewer().getRating() > minRating) {
                            MoviesFinal.add(Movie);
                        }

            }
        }
        return MoviesFinal;
    }

    public List<Movie> findAllByTomatoesCriticMeter(double minMeter, double maxMeter) {
        List<Movie> Movies = new ArrayList<>();
        List<Movie> MoviesFinal = new ArrayList<>();
        for (Movie Movie : movieRepository.findAll()) {
            if(Movie.getTomatoes() != null) {
                if (Movie.getTomatoes().getCritic() != null)
                    if(Movie.getTomatoes().getCritic().getMeter() != null)
                        if (Movie.getTomatoes().getCritic().getMeter() < maxMeter && Movie.getTomatoes().getCritic().getMeter() > minMeter) {
                            MoviesFinal.add(Movie);
                        }

            }
        }
        return MoviesFinal;
    }

    public List<Movie> findAllByTomatoesViewerMeter(double minMeter, double maxMeter) {
        List<Movie> Movies = new ArrayList<>();
        List<Movie> MoviesFinal = new ArrayList<>();
        for (Movie Movie : movieRepository.findAll()) {
            if(Movie.getTomatoes() != null) {
                if (Movie.getTomatoes().getViewer() != null)
                    if(Movie.getTomatoes().getViewer().getMeter() != null)
                        if (Movie.getTomatoes().getViewer().getMeter() < maxMeter && Movie.getTomatoes().getViewer().getMeter() > minMeter) {
                            MoviesFinal.add(Movie);
                        }

            }
        }
        return MoviesFinal;
    }

    public List<Movie> findAllByTomatoesRottenReviews(int minRotten, int maxRotten) {
        List<Movie> Movies = new ArrayList<>();
        List<Movie> MoviesFinal = new ArrayList<>();
        for (Movie Movie : movieRepository.findAll()) {
            if(Movie.getTomatoes() != null) {
                if (Movie.getTomatoes().getRotten() != null)
                    if (Movie.getTomatoes().getRotten() < maxRotten && Movie.getTomatoes().getRotten() > minRotten) {
                        MoviesFinal.add(Movie);
                    }

            }
        }
        return MoviesFinal;
    }

    public List<Movie> findAllByTomatoesFreshReviews(int minFresh, int maxFresh) {
        List<Movie> Movies = new ArrayList<>();
        List<Movie> MoviesFinal = new ArrayList<>();
        for (Movie Movie : movieRepository.findAll()) {
            if(Movie.getTomatoes() != null) {
                if (Movie.getTomatoes().getFresh() != null)
                    if (Movie.getTomatoes().getFresh() < maxFresh && Movie.getTomatoes().getFresh() > minFresh) {
                        MoviesFinal.add(Movie);
                    }

            }
        }
        return MoviesFinal;
    }

    public List<Movie> findAllByTomatoesProduction(String production) {
        List<Movie> movies = new ArrayList<>();
        List<Movie> moviesfinal = new ArrayList<>();
        for (Movie movie : movieRepository.findAll()) {
            if(movie.getTomatoes() != null) {
                if (movie.getTomatoes().getProduction() != null)
                    if (movie.getTomatoes().getProduction().equals(production)) {
                        moviesfinal.add(movie);
                    }

            }
        }
        return moviesfinal;
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
            if (movieId != null) {
                String result = movieName + " IMDB ID : " + movieId;
                resultList.add(result);
            }
        }
        return resultList;
    }

    public List<String> getYearOfRelease(String name) {
        List<Movie> allMovies = movieRepository.findByTitle(name);
        List<String> movies = new ArrayList<>();
        for(Movie movie : allMovies) {
            String year = movie.getReleased().substring(24);
            String result = "";
            if(year != null){
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

    public List<Movie> getAllMoviesByReleaseRange(String lowerDate, String upperDate) throws NumberFormatException {
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

    //Deletes ---------------------------------------------------------------------------------------------------------------

    public void deleteMovieById(String Id) {
        Movie movie = null;
        if(movieRepository.findById(Id).isPresent()) {
            movie = movieRepository.findById(Id).get();
            movieRepository.delete(movie);
        }
    }

    //Create -----------------------------------------------------------------------------------------------------------------

    public Movie addMovie(Movie movie) {
        try {
            if(movie.getTitle().isEmpty() || movie.getTitle() == null) {
                throw new InvalidDocumentException("Movies must have title");
            } else if (movie.getDirectors().size() == 0 || movie.getDirectors() == null) {
                throw new InvalidDocumentException("Movies must have at least one director");
            } else if (movie.getCast().size() == 0 || movie.getCast() == null) {
                throw new InvalidDocumentException("Movies must have at least one cast member");
            } else if (movie.getLanguages().size() == 0 || movie.getLanguages() == null) {
                throw new InvalidDocumentException("Movies must be available in at least one language");
            } else if (movie.getGenres().size() == 0 || movie.getGenres() == null) {
                throw new InvalidDocumentException("Movies mush have at least one genre");
            } else {
                return movieRepository.save(movie);
            }
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
            return null;
        }
    }
    //Updates ----------------------------------------------------------------------------------------------------------------
    public Movie updateAwardsWins(String code, Integer wins) {
        Movie movieToUpdate = null;
        if(wins != null && code != null){
            if(movieRepository.findById(code).isPresent()){
                movieToUpdate = movieRepository.findById(code).get();
                Awards award = movieToUpdate.getAwards();
                award.setWins(wins);
                award.setText(updateText(movieToUpdate));
                movieToUpdate.setAwards(award);
                updateLastUpdated(movieToUpdate);
            }
        }
        movieRepository.save(movieToUpdate);
        return movieToUpdate;
    }

    public Movie updateAwardsNominations(String code, Integer nominations) {
        Movie movieToUpdate = null;
        if(nominations != null && code != null){
            if(movieRepository.findById(code).isPresent()){
                movieToUpdate = movieRepository.findById(code).get();
                Awards award = movieToUpdate.getAwards();
                award.setNominations(nominations);
                award.setText(updateText(movieToUpdate));
                movieToUpdate.setAwards(award);
                updateLastUpdated(movieToUpdate);
            }
        }
        movieRepository.save(movieToUpdate);
        return movieToUpdate;
    }

    public static void updateLastUpdated(Movie movieToUpdate) {
        LocalDateTime currentDate = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSSSSS");
        movieToUpdate.setLastupdated(currentDate.format(formatter));
    }

    private String updateText(Movie movieToUpdate) {
        StringBuilder stringBuilder = new StringBuilder();
        Awards awards = movieToUpdate.getAwards();

        if(awards.getWins() > 0) {
            stringBuilder.append(awards.getWins()).append(" win");
        } if (awards.getWins() > 1) {
            stringBuilder.append("s");
        }

        if(awards.getNominations() > 0) {
            if(awards.getWins() > 0) {
                stringBuilder.append(" and ");
            }
            stringBuilder.append(awards.getNominations()).append(" nomination");
            if(awards.getNominations() > 1) {
                stringBuilder.append("s");
            }
        }
        stringBuilder.append(".");
        return stringBuilder.toString();
    }

    public Movie updateImdbRating(String code, Double rating) {
        Movie movieToUpdate = null;
        if(rating != null && code != null) {
            if(movieRepository.findById(code).isPresent()){
                movieToUpdate = movieRepository.findById(code).get();
                Imdb imdb = movieToUpdate.getImdb();
                imdb.setRating(rating);
                movieToUpdate.setImdb(imdb);
                updateLastUpdated(movieToUpdate);
            }
        }
        movieRepository.save(movieToUpdate);
        return movieToUpdate;
    }

    public Movie updateImdbVotes(String code, Integer votes) {
        Movie movieToUpdate = null;
        if(votes != null && code != null) {
            if(movieRepository.findById(code).isPresent()){
                movieToUpdate = movieRepository.findById(code).get();
                Imdb imdb = movieToUpdate.getImdb();
                imdb.setVotes(votes);
                movieToUpdate.setImdb(imdb);
                updateLastUpdated(movieToUpdate);
            }
        }
        movieRepository.save(movieToUpdate);
        return movieToUpdate;
    }

    //Copied methods
    public Optional<Movie> updateTomatoesCriticMeter(String id, Integer meter ) {
        Optional<Movie> checkMovie = movieRepository.findById(id);
        if(checkMovie.isPresent()) {
            Movie updateMovie = checkMovie.get();
            updateMovie.getTomatoes().getCritic().setMeter(meter);
            movieRepository.save(updateMovie);
            updateTomatoesLastUpdated(id);

            return Optional.of(updateMovie);
        }

        return Optional.empty();
    }

    public Optional<Movie> updateTomatoesViewerMeter(String id, Integer meter ) {
        Optional<Movie> checkMovie = movieRepository.findById(id);
        if(checkMovie.isPresent()) {
            Movie updateMovie = checkMovie.get();
            updateMovie.getTomatoes().getViewer().setMeter(meter);
            movieRepository.save(updateMovie);
            updateTomatoesLastUpdated(id);

            return Optional.of(updateMovie);
        }

        return Optional.empty();
    }

    public Optional<Movie> updateTomatoesViewerNumReviews(String id, Integer numReviews) {
        Optional<Movie> checkMovie = movieRepository.findById(id);
        if(checkMovie.isPresent()) {
            Movie updateMovie = checkMovie.get();
            updateMovie.getTomatoes().getViewer().setNumReviews(numReviews);
            movieRepository.save(updateMovie);
            updateTomatoesLastUpdated(id);

            return Optional.of(updateMovie);
        }

        return Optional.empty();
    }

    public Optional<Movie> updateTomatoesCriticNumReviews(String id, Integer numReviews) {
        Optional<Movie> checkMovie = movieRepository.findById(id);
        if(checkMovie.isPresent()) {
            Movie updateMovie = checkMovie.get();
            updateMovie.getTomatoes().getCritic().setNumReviews(numReviews);
            movieRepository.save(updateMovie);
            updateTomatoesLastUpdated(id);

            return Optional.of(updateMovie);
        }

        return Optional.empty();
    }

    public Optional<Movie> updateTomatoesCriticRating(String id, Double rating) {
        Optional<Movie> checkMovie = movieRepository.findById(id);
        if(checkMovie.isPresent()) {
            Movie updateMovie = checkMovie.get();
            updateMovie.getTomatoes().getCritic().setRating(rating);
            movieRepository.save(updateMovie);
            updateTomatoesLastUpdated(id);

            return Optional.of(updateMovie);
        }

        return Optional.empty();
    }

    public Optional<Movie> updateTomatoesViewerRating(String id, Double rating) {
        Optional<Movie> checkMovie = movieRepository.findById(id);
        if(checkMovie.isPresent()) {
            Movie updateMovie = checkMovie.get();
            updateMovie.getTomatoes().getViewer().setRating(rating);
            movieRepository.save(updateMovie);
            updateTomatoesLastUpdated(id);

            return Optional.of(updateMovie);
        }

        return Optional.empty();
    }

    public Optional<Movie> updateTomatoesRotten(String id, Integer rotten) {
        Optional<Movie> checkMovie = movieRepository.findById(id);
        if(checkMovie.isPresent()) {
            Movie updateMovie = checkMovie.get();
            updateMovie.getTomatoes().setRotten(rotten);
            movieRepository.save(updateMovie);
            updateTomatoesLastUpdated(id);

            return Optional.of(updateMovie);
        }

        return Optional.empty();
    }

    public Optional<Movie> updateTomatoesFresh(String id, Integer fresh) {
        Optional<Movie> checkMovie = movieRepository.findById(id);
        if(checkMovie.isPresent()) {
            Movie updateMovie = checkMovie.get();
            updateMovie.getTomatoes().setFresh(fresh);
            movieRepository.save(updateMovie);
            updateTomatoesLastUpdated(id);

            return Optional.of(updateMovie);
        }

        return Optional.empty();
    }

    public Optional<Movie> updateTomatoesLastUpdated(String id) {
        Optional<Movie> checkMovie = movieRepository.findById(id);

        if(checkMovie.isPresent()) {
            Movie updateMovie = checkMovie.get();
            LocalDateTime currentDateTime = LocalDateTime.now(ZoneId.of("UTC"));
            Date currentDate = Date.from(currentDateTime.atZone(ZoneId.of("UTC")).toInstant());
            updateMovie.getTomatoes().setLastUpdated(currentDate);
            movieRepository.save(updateMovie);

            return Optional.of(updateMovie);
        }

        return Optional.empty();
    }

    public Movie updateMovieTitle(String Id, String newTitle) {
        Movie movie = null;
        if(movieRepository.findById(Id).isPresent()) {
            movie = movieRepository.findById(Id).get();
            movie.setTitle(newTitle);
            updateLastUpdated(movie);
        }
        return movieRepository.save(movie);
    }

    public Movie updateMovieWriters(String Id, String newWriter) {
        Movie movie = null;
        if(movieRepository.findById(Id).isPresent()) {
            movie = movieRepository.findById(Id).get();
            List<String> writers = movie.getWriters();
            writers.add(newWriter);
            movie.setWriters(writers);
            updateLastUpdated(movie);
        }
        return movieRepository.save(movie);
    }

    public Movie updateMovieCast(String Id, String newMember) {
        Movie movie = null;
        if(movieRepository.findById(Id).isPresent()) {
            movie = movieRepository.findById(Id).get();
            List<String> cast = movie.getCast();
            cast.add(newMember);
            movie.setWriters(cast);
            updateLastUpdated(movie);
        }
        return movieRepository.save(movie);
    }

    public Movie updateMovieGenres(String Id, String newGenre) {
        Movie movie = null;
        if(movieRepository.findById(Id).isPresent()) {
            movie = movieRepository.findById(Id).get();
            List<String> genres =movie.getGenres();
            genres.add(newGenre);
            movie.setWriters(genres);
            updateLastUpdated(movie);
        }
        return movieRepository.save(movie);
    }

    public Movie updateMovieLanguages(String Id, String newLanguage) {
        Movie movie = null;
        if(movieRepository.findById(Id).isPresent()) {
            movie = movieRepository.findById(Id).get();
            List<String> languages = movie.getLanguages();
            languages.add(newLanguage);
            movie.setWriters(languages);
            updateLastUpdated(movie);
        }
        return movieRepository.save(movie);
    }

    public Movie updateMovieCountries(String Id, String newCountry) {
        Movie movie = null;
        if(movieRepository.findById(Id).isPresent()) {
            movie = movieRepository.findById(Id).get();
            List<String> countries = movie.getCountries();
            countries.add(newCountry);
            movie.setWriters(countries);
            updateLastUpdated(movie);
        }
        return movieRepository.save(movie);
    }

    public Movie incrementCommentCount(String Id) {
        Movie movie = null;
        if(movieRepository.findById(Id).isPresent()) {
            movie = movieRepository.findById(Id).get();
            Integer comments = movie.getNum_mflix_comments();
            Integer newComments = comments++;
            movie.setNum_mflix_comments(newComments);
            updateLastUpdated(movie);
        }
        return movieRepository.save(movie);
    }

    public Movie updateReleaseDate(String Id, String date) {
        Movie movieToUpdate = null;
        if(movieRepository.findById(Id).isPresent()) {
            movieToUpdate = movieRepository.findById(Id).get();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSSSSS");
            LocalDate dateToUpdate = LocalDate.parse(date);
            movieToUpdate.setReleased(dateToUpdate.format(formatter));
        }
        return movieRepository.save(movieToUpdate);
    }

    public Movie updateRuntime(String Id, Integer runtime) {
        Movie movieToUpdate = null;
        if(movieRepository.findById(Id).isPresent()) {
            movieToUpdate = movieRepository.findById(Id).get();
            movieToUpdate.setRuntime(runtime);
            updateLastUpdated(movieToUpdate);
        }
        return movieRepository.save(movieToUpdate);
    }

    public Movie updateYear(String Id, String year) {
        Movie movieToUpdate = null;
        if(movieRepository.findById(Id).isPresent()) {
            movieToUpdate = movieRepository.findById(Id).get();
            movieToUpdate.setYear(year);
            updateLastUpdated(movieToUpdate);
        }
        return movieRepository.save(movieToUpdate);
    }


}