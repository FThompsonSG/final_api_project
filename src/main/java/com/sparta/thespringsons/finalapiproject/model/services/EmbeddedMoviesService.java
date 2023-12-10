package com.sparta.thespringsons.finalapiproject.model.services;

import com.sparta.thespringsons.finalapiproject.exceptions.InvalidDocumentException;
import com.sparta.thespringsons.finalapiproject.model.entities.EmbeddedMovie;
import com.sparta.thespringsons.finalapiproject.model.fields.Awards;
import com.sparta.thespringsons.finalapiproject.model.fields.Imdb;
import com.sparta.thespringsons.finalapiproject.model.repositories.EmbeddedMoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EmbeddedMoviesService  {

    private EmbeddedMoviesRepository embeddedMoviesRepository;

    @Autowired
    public EmbeddedMoviesService(EmbeddedMoviesRepository embeddedMoviesRepository) {
        this.embeddedMoviesRepository = embeddedMoviesRepository;
    }

    public List<EmbeddedMovie> findAllByTomatoesCriticRating(double minRating, double maxRating) {

        List<EmbeddedMovie> embeddedMovies = new ArrayList<>();
        List<EmbeddedMovie> embeddedMoviesFinal = new ArrayList<>();
        for (EmbeddedMovie embeddedMovie : embeddedMoviesRepository.findAll()) {
            if(embeddedMovie.getTomato() != null) {
                if (embeddedMovie.getTomato().getCritic() != null)
                    if(embeddedMovie.getTomato().getCritic().getRating() != null)
                        if (embeddedMovie.getTomato().getCritic().getRating() < maxRating && embeddedMovie.getTomato().getCritic().getRating() > minRating) {
                        embeddedMoviesFinal.add(embeddedMovie);
                    }

            }
        }
        return embeddedMoviesFinal;
    }

    public List<EmbeddedMovie> findAllByTomatoesViewerRating(double minRating, double maxRating) {
        List<EmbeddedMovie> embeddedMovies = new ArrayList<>();
        List<EmbeddedMovie> embeddedMoviesFinal = new ArrayList<>();
        for (EmbeddedMovie embeddedMovie : embeddedMoviesRepository.findAll()) {
            if(embeddedMovie.getTomato() != null) {
                if (embeddedMovie.getTomato().getViewer() != null)
                    if(embeddedMovie.getTomato().getViewer().getRating() != null)
                        if (embeddedMovie.getTomato().getViewer().getRating() < maxRating && embeddedMovie.getTomato().getViewer().getRating() > minRating) {
                            embeddedMoviesFinal.add(embeddedMovie);
                        }

            }
        }
        return embeddedMoviesFinal;
    }

    public List<EmbeddedMovie> findAllByTomatoesCriticMeter(double minMeter, double maxMeter) {
        List<EmbeddedMovie> embeddedMovies = new ArrayList<>();
        List<EmbeddedMovie> embeddedMoviesFinal = new ArrayList<>();
        for (EmbeddedMovie embeddedMovie : embeddedMoviesRepository.findAll()) {
            if(embeddedMovie.getTomato() != null) {
                if (embeddedMovie.getTomato().getCritic() != null)
                    if(embeddedMovie.getTomato().getCritic().getMeter() != null)
                        if (embeddedMovie.getTomato().getCritic().getMeter() < maxMeter && embeddedMovie.getTomato().getCritic().getMeter() > minMeter) {
                            embeddedMoviesFinal.add(embeddedMovie);
                        }

            }
        }
        return embeddedMoviesFinal;
    }

    public List<EmbeddedMovie> findAllByTomatoesViewerMeter(double minMeter, double maxMeter) {
        List<EmbeddedMovie> embeddedMovies = new ArrayList<>();
        List<EmbeddedMovie> embeddedMoviesFinal = new ArrayList<>();
        for (EmbeddedMovie embeddedMovie : embeddedMoviesRepository.findAll()) {
            if(embeddedMovie.getTomato() != null) {
                if (embeddedMovie.getTomato().getViewer() != null)
                    if(embeddedMovie.getTomato().getViewer().getMeter() != null)
                        if (embeddedMovie.getTomato().getViewer().getMeter() < maxMeter && embeddedMovie.getTomato().getViewer().getMeter() > minMeter) {
                            embeddedMoviesFinal.add(embeddedMovie);
                        }

            }
        }
        return embeddedMoviesFinal;
    }

    public List<EmbeddedMovie> findAllByTomatoesRottenReviews(int minRotten, int maxRotten) {
        List<EmbeddedMovie> embeddedMovies = new ArrayList<>();
        List<EmbeddedMovie> embeddedMoviesFinal = new ArrayList<>();
        for (EmbeddedMovie embeddedMovie : embeddedMoviesRepository.findAll()) {
            if(embeddedMovie.getTomato() != null) {
                if (embeddedMovie.getTomato().getRotten() != null)
                        if (embeddedMovie.getTomato().getRotten() < maxRotten && embeddedMovie.getTomato().getRotten() > minRotten) {
                            embeddedMoviesFinal.add(embeddedMovie);
                        }

            }
        }
        return embeddedMoviesFinal;
    }

    public List<EmbeddedMovie> findAllByTomatoesFreshReviews(int minFresh, int maxFresh) {
        List<EmbeddedMovie> embeddedMovies = new ArrayList<>();
        List<EmbeddedMovie> embeddedMoviesFinal = new ArrayList<>();
        for (EmbeddedMovie embeddedMovie : embeddedMoviesRepository.findAll()) {
            if(embeddedMovie.getTomato() != null) {
                if (embeddedMovie.getTomato().getFresh() != null)
                    if (embeddedMovie.getTomato().getFresh() < maxFresh && embeddedMovie.getTomato().getFresh() > minFresh) {
                        embeddedMoviesFinal.add(embeddedMovie);
                    }

            }
        }
        return embeddedMoviesFinal;
    }

    public List<EmbeddedMovie> findAllByTomatoesProduction(String production) {
        List<EmbeddedMovie> embeddedMovies = new ArrayList<>();
        List<EmbeddedMovie> embeddedMoviesfinal = new ArrayList<>();
        for (EmbeddedMovie embeddedMovie : embeddedMoviesRepository.findAll()) {
            if(embeddedMovie.getTomato() != null) {
                if (embeddedMovie.getTomato().getProduction() != null)
                    if (embeddedMovie.getTomato().getProduction().equals(production)) {
                        embeddedMoviesfinal.add(embeddedMovie);
                    }

            }
        }
        return embeddedMoviesfinal;
    }

    public List<EmbeddedMovie> findAllMoviesByImdbRating(double lowerRating, double upperRating) {
        List<EmbeddedMovie> movies = embeddedMoviesRepository.findAll();
        List<EmbeddedMovie> selectedMovies = new ArrayList<>();
        for (EmbeddedMovie movie : movies) {
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
    public List<String> findAllNumberOfMovieImdbVotes(String movieName) {
        List<EmbeddedMovie> movieList= embeddedMoviesRepository.findByTitle(movieName);
        List<String> resultList = new ArrayList<>();
        for(EmbeddedMovie movie : movieList) {
            Integer numVotes = movie.getImdb().getVotes();
            String result = movieName + " IMDB Votes: " + numVotes;
            resultList.add(result);
        }

        return resultList;
    }

    public List<String> findAllMovieImdbRatingByName(String movieName) {
        List<EmbeddedMovie> movieList= embeddedMoviesRepository.findByTitle(movieName);
        List<String> resultList = new ArrayList<>();
        for(EmbeddedMovie movie : movieList) {
            Double movieRating = movie.getImdb().getRating();
            String result = movieName + " IMDB Rating: " + movieRating;
            resultList.add(result);
        }
        return resultList;
    }

    public List<String> findAllMovieImdbIdByName(String movieName) {
        List<EmbeddedMovie> movieList = embeddedMoviesRepository.findByTitle(movieName);
        List<String> resultList = new ArrayList<>();
        for(EmbeddedMovie movie : movieList) {
            Integer movieId = movie.getImdb().getId();
            if (movieId != null) {
                String result = movieName + " IMDB ID : " + movieId;
                resultList.add(result);
            }
        }
        return resultList;
    }

    public List<EmbeddedMovie> findAllEmbeddedMoviesByCountry(String countryName) {
        return embeddedMoviesRepository.findByCountries(countryName);
    }

    public List<EmbeddedMovie> findAllEmbeddedMoviesByNumberOfNominations(Integer noms) {
        return embeddedMoviesRepository.findEmbeddedMoviesByAwards_Nominations(noms);
    }

    public List<EmbeddedMovie> findAllEmbeddedMoviesByNumberOfWins(Integer wins) {
        return embeddedMoviesRepository.findEmbeddedMoviesByAwards_Wins(wins);
    }

    public List<EmbeddedMovie> findAllEmbeddedMoviesByAwardName(String awardName) {
        return embeddedMoviesRepository.findByFieldNameContaining(awardName);
    }

    public List<EmbeddedMovie> findAllEmbeddedMoviesByTitleContaining(String filmTitle) {
        return embeddedMoviesRepository.findByTitleContaining(filmTitle);
    }

    public List<EmbeddedMovie> findAllEmbeddedMoviesByCastMember(String castMemberName) {
        return embeddedMoviesRepository.findByCastMember(castMemberName);
    }

    public List<EmbeddedMovie> findAllEmbeddedMoviesByDirector(String directorName) {
        return embeddedMoviesRepository.findByDirector(directorName);
    }

    public List<EmbeddedMovie> findAllEmbeddedMoviesByFullPlot(String fullPlot) {
        return embeddedMoviesRepository.findByFullPlot(fullPlot);
    }

    public List<EmbeddedMovie> findAllEmbeddedMoviesByGenre(String genre) {
        return embeddedMoviesRepository.findByGenre(genre);
    }

    public List<EmbeddedMovie> findAllEmbeddedMoviesByLanguage(String language) {
        return embeddedMoviesRepository.findByLanguage(language);
    }

    public List<EmbeddedMovie> findAllEmbeddedMoviesByNumberOfCommentsLowerBound(Integer numberOfComments) {
        return embeddedMoviesRepository.findByNumberOfComments(numberOfComments);
    }

    public List<EmbeddedMovie> findAllEmbeddedMoviesByPlot(String plot) {
        String plotPadded = " " + plot + " ";
        return embeddedMoviesRepository.findByPlot(plotPadded);
    }

    public List<EmbeddedMovie> findAllEmbeddedMoviesByMaxRuntime(Integer mins) {
        return embeddedMoviesRepository.findByMaxRuntime(mins);
    }

    public List<EmbeddedMovie> findAllEmbeddedMoviesByWriter(String writerName) {
        return embeddedMoviesRepository.findByWriter(writerName);
    }

    public List<EmbeddedMovie> findAllEmbeddedMoviesByYearExact(String year) {
        try {
            Integer yearInt = Integer.parseInt(year);
            return embeddedMoviesRepository.findByYearExact(yearInt);
        } catch (Exception e) {
            System.out.println("Invalid String");
            return null;
        }
    }

    public List<String> findAllPosterLinkByTitle(String name) {
        List<EmbeddedMovie> allMovies = embeddedMoviesRepository.findByTitle(name);
        List<String> movies = new ArrayList<>();
        for (EmbeddedMovie movie : allMovies) {
            String posterLink = movie.getPoster();
            String result = "";
            if (posterLink != null) {
                result = name + "'s poster link: " + posterLink;
                movies.add(result);
            }
        }
        return movies;
    }

    public List<EmbeddedMovie> findAllEmbeddedMoviesByYearBefore(String year) {
        try {
            Integer yearInt = Integer.parseInt(year);
            return embeddedMoviesRepository.findByYearBefore(yearInt);
        } catch (Exception e) {
            System.out.println("Invalid String");
            return null;
        }
    }

    public List<EmbeddedMovie> findAllEmbeddedMoviesByYearAfter(String year) {
        try {
            Integer yearInt = Integer.parseInt(year);
            return embeddedMoviesRepository.findByYearAfter(yearInt);
        } catch (Exception e) {
            System.out.println("Invalid String");
            return null;
        }
    }

    public List<EmbeddedMovie> findAllMoviesByReleaseRange(String lowerDate, String upperDate) throws NumberFormatException {
        List<EmbeddedMovie> movies = embeddedMoviesRepository.findAll();
        List<EmbeddedMovie> moviesInRange = new ArrayList<>();

        try {
            int lowDate = Integer.parseInt(lowerDate);
            int highDate = Integer.parseInt(upperDate);

            List<EmbeddedMovie> movieRangeList = movies.stream()
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

    public EmbeddedMovie addEmbeddedMovie(EmbeddedMovie movie) {
        try {
            if(movie.getTitle().isEmpty() || movie.getTitle() == null) {
                throw new InvalidDocumentException("Movies must have title");
            } else if (movie.getDirectors().length == 0 || movie.getDirectors() == null) {
                throw new InvalidDocumentException("Movies must have at least one director");
            } else if (movie.getCast().length == 0 || movie.getCast() == null) {
                throw new InvalidDocumentException("Movies must have at least one cast member");
            } else if (movie.getLanguages().length == 0 || movie.getLanguages() == null) {
                throw new InvalidDocumentException("Movies must be available in at least one language");
            } else if (movie.getGenres().length == 0 || movie.getGenres() == null) {
                throw new InvalidDocumentException("Movies mush have at least one genre");
            } else {
                return embeddedMoviesRepository.save(movie);
            }
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
            return null;
        }
    }

    public void updateEmbeddedMovieTitle(String Id, String newTitle) {
        EmbeddedMovie movie = null;
        if(embeddedMoviesRepository.findById(Id).isPresent()) {
            movie = embeddedMoviesRepository.findById(Id).get();
            movie.setTitle(newTitle);
            updateLastUpdated(movie);
        }
        embeddedMoviesRepository.save(movie);
    }

    public EmbeddedMovie updateEmbeddedMovieWriters(String Id, String newWriter) {
        EmbeddedMovie movie = null;
        if(embeddedMoviesRepository.findById(Id).isPresent()) {
            movie = embeddedMoviesRepository.findById(Id).get();
            List<String> writers = new ArrayList<>(List.of(movie.getWriters()));
            writers.add(newWriter);
            movie.setWriters(writers.toArray(new String[0]));
            updateLastUpdated(movie);
        }
        return embeddedMoviesRepository.save(movie);
    }

    public void updateEmbeddedMovieCast(String Id, String newMember) {
        EmbeddedMovie movie = null;
        if(embeddedMoviesRepository.findById(Id).isPresent()) {
            movie = embeddedMoviesRepository.findById(Id).get();
            List<String> cast = new ArrayList<>(List.of(movie.getCast()));
            cast.add(newMember);
            movie.setWriters(cast.toArray(new String[0]));
            updateLastUpdated(movie);
        }
        embeddedMoviesRepository.save(movie);
    }

    public void updateEmbeddedMovieGenres(String Id, String newGenre) {
        EmbeddedMovie movie = null;
        if(embeddedMoviesRepository.findById(Id).isPresent()) {
            movie = embeddedMoviesRepository.findById(Id).get();
            List<String> genres = new ArrayList<>(List.of(movie.getGenres()));
            genres.add(newGenre);
            movie.setWriters(genres.toArray(new String[0]));
            updateLastUpdated(movie);
        }
        embeddedMoviesRepository.save(movie);
    }

    public EmbeddedMovie updateEmbeddedMovieLanguages(String Id, String newLanguage) {
        EmbeddedMovie movie = null;
        if(embeddedMoviesRepository.findById(Id).isPresent()) {
            movie = embeddedMoviesRepository.findById(Id).get();
            List<String> languages = new ArrayList<>(List.of(movie.getLanguages()));
            languages.add(newLanguage);
            movie.setWriters(languages.toArray(new String[0]));
            updateLastUpdated(movie);
        }
        return embeddedMoviesRepository.save(movie);
    }

    public EmbeddedMovie updateEmbeddedMovieCountries(String Id, String newCountry) {
        EmbeddedMovie movie = null;
        if(embeddedMoviesRepository.findById(Id).isPresent()) {
            movie = embeddedMoviesRepository.findById(Id).get();
            List<String> countries = new ArrayList<>(List.of(movie.getCountries()));
            countries.add(newCountry);
            movie.setWriters(countries.toArray(new String[0]));
            updateLastUpdated(movie);
        }
        return embeddedMoviesRepository.save(movie);
    }

    public EmbeddedMovie incrementCommentCount(String Id) {
        EmbeddedMovie movie = null;
        if(embeddedMoviesRepository.findById(Id).isPresent()) {
            movie = embeddedMoviesRepository.findById(Id).get();
            Integer comments = movie.getNum_mflix_comments();
            Integer newComments = comments++;
            movie.setNum_mflix_comments(newComments);
            updateLastUpdated(movie);
        }
        return embeddedMoviesRepository.save(movie);
    }

    public Optional<EmbeddedMovie> updateTomatoesCriticMeter(String id, Integer meter ) {
        Optional<EmbeddedMovie> checkMovie = embeddedMoviesRepository.findById(id);
        if(checkMovie.isPresent()) {
            EmbeddedMovie updateMovie = checkMovie.get();
            updateMovie.getTomato().getCritic().setMeter(meter);
            embeddedMoviesRepository.save(updateMovie);
            updateTomatoesLastUpdated(id);

            return Optional.of(updateMovie);
        }

        return Optional.empty();
    }

    public Optional<EmbeddedMovie> updateTomatoesViewerMeter(String id, Integer meter ) {
        Optional<EmbeddedMovie> checkMovie = embeddedMoviesRepository.findById(id);
        if(checkMovie.isPresent()) {
            EmbeddedMovie updateMovie = checkMovie.get();
            updateMovie.getTomato().getViewer().setMeter(meter);
            embeddedMoviesRepository.save(updateMovie);
            updateTomatoesLastUpdated(id);

            return Optional.of(updateMovie);
        }

        return Optional.empty();
    }

    public Optional<EmbeddedMovie> updateTomatoesViewerNumReviews(String id, Integer numReviews) {
        Optional<EmbeddedMovie> checkMovie = embeddedMoviesRepository.findById(id);
        if(checkMovie.isPresent()) {
            EmbeddedMovie updateMovie = checkMovie.get();
            updateMovie.getTomato().getViewer().setNumReviews(numReviews);
            embeddedMoviesRepository.save(updateMovie);
            updateTomatoesLastUpdated(id);

            return Optional.of(updateMovie);
        }

        return Optional.empty();
    }

    public Optional<EmbeddedMovie> updateTomatoesCriticNumReviews(String id, Integer numReviews) {
        Optional<EmbeddedMovie> checkMovie = embeddedMoviesRepository.findById(id);
        if(checkMovie.isPresent()) {
            EmbeddedMovie updateMovie = checkMovie.get();
            updateMovie.getTomato().getCritic().setNumReviews(numReviews);
            embeddedMoviesRepository.save(updateMovie);
            updateTomatoesLastUpdated(id);

            return Optional.of(updateMovie);
        }

        return Optional.empty();
    }

    public Optional<EmbeddedMovie> updateTomatoesCriticRating(String id, Double rating) {
        Optional<EmbeddedMovie> checkMovie = embeddedMoviesRepository.findById(id);
        if(checkMovie.isPresent()) {
            EmbeddedMovie updateMovie = checkMovie.get();
            updateMovie.getTomato().getCritic().setRating(rating);
            embeddedMoviesRepository.save(updateMovie);
            updateTomatoesLastUpdated(id);

            return Optional.of(updateMovie);
        }

        return Optional.empty();
    }

    public Optional<EmbeddedMovie> updateTomatoesViewerRating(String id, Double rating) {
        Optional<EmbeddedMovie> checkMovie = embeddedMoviesRepository.findById(id);
        if(checkMovie.isPresent()) {
            EmbeddedMovie updateMovie = checkMovie.get();
            updateMovie.getTomato().getViewer().setRating(rating);
            embeddedMoviesRepository.save(updateMovie);
            updateTomatoesLastUpdated(id);

            return Optional.of(updateMovie);
        }
        return Optional.empty();
    }

    public Optional<EmbeddedMovie> updateTomatoesRotten(String id, Integer rotten) {
        Optional<EmbeddedMovie> checkMovie = embeddedMoviesRepository.findById(id);
        if(checkMovie.isPresent()) {
            EmbeddedMovie updateMovie = checkMovie.get();
            updateMovie.getTomato().setRotten(rotten);
            embeddedMoviesRepository.save(updateMovie);
            updateTomatoesLastUpdated(id);

            return Optional.of(updateMovie);
        }

        return Optional.empty();
    }

    public Optional<EmbeddedMovie> updateTomatoesFresh(String id, Integer fresh) {
        Optional<EmbeddedMovie> checkMovie = embeddedMoviesRepository.findById(id);
        if(checkMovie.isPresent()) {
            EmbeddedMovie updateMovie = checkMovie.get();
            updateMovie.getTomato().setFresh(fresh);
            embeddedMoviesRepository.save(updateMovie);
            updateTomatoesLastUpdated(id);

            return Optional.of(updateMovie);
        }

        return Optional.empty();
    }

    public Optional<EmbeddedMovie> updateTomatoesLastUpdated(String id) {
        Optional<EmbeddedMovie> checkMovie = embeddedMoviesRepository.findById(id);

        if(checkMovie.isPresent()) {
            EmbeddedMovie updateMovie = checkMovie.get();
            LocalDateTime currentDateTime = LocalDateTime.now(ZoneId.of("UTC"));
            Date currentDate = Date.from(currentDateTime.atZone(ZoneId.of("UTC")).toInstant());
            updateMovie.getTomato().setLastUpdated(currentDate);
            embeddedMoviesRepository.save(updateMovie);

            return Optional.of(updateMovie);
        }

        return Optional.empty();
    }

    public EmbeddedMovie updateAwardsWins(String code, Integer wins) {
        EmbeddedMovie movieToUpdate = null;
        if(wins != null && code != null){
            if(embeddedMoviesRepository.findById(code).isPresent()){
                movieToUpdate = embeddedMoviesRepository.findById(code).get();
                Awards award = movieToUpdate.getAwards();
                award.setWins(wins);
                award.setText(updateText(movieToUpdate));
                movieToUpdate.setAwards(award);
                updateLastUpdated(movieToUpdate);
            }
        }
        embeddedMoviesRepository.save(movieToUpdate);
        return movieToUpdate;
    }

    public EmbeddedMovie updateAwardsNominations(String code, Integer nominations) {
        EmbeddedMovie movieToUpdate = null;
        if(nominations != null && code != null){
            if(embeddedMoviesRepository.findById(code).isPresent()){
                movieToUpdate = embeddedMoviesRepository.findById(code).get();
                Awards award = movieToUpdate.getAwards();
                award.setNominations(nominations);
                award.setText(updateText(movieToUpdate));
                movieToUpdate.setAwards(award);
                updateLastUpdated(movieToUpdate);
            }
        }
        embeddedMoviesRepository.save(movieToUpdate);
        return movieToUpdate;
    }

    public static void updateLastUpdated(EmbeddedMovie movieToUpdate) {
        LocalDateTime currentDate = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSSSSS");
        movieToUpdate.setLastupdated(currentDate.format(formatter));
    }

    private String updateText(EmbeddedMovie movieToUpdate) {
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

    public EmbeddedMovie updateReleaseDate(String Id, String date) {
        EmbeddedMovie embeddedMovieToUpdate = null;
        if(embeddedMoviesRepository.findById(Id).isPresent()) {
            embeddedMovieToUpdate = embeddedMoviesRepository.findById(Id).get();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSSSSS");
            LocalDate dateToUpdate = LocalDate.parse(date);
            embeddedMovieToUpdate.setReleased(dateToUpdate.format(formatter));
        }
        return embeddedMoviesRepository.save(embeddedMovieToUpdate);
    }

    public EmbeddedMovie updateRuntime(String Id, Integer runtime) {
        EmbeddedMovie embeddedMovieToUpdate = null;
        if(embeddedMoviesRepository.findById(Id).isPresent()) {
            embeddedMovieToUpdate = embeddedMoviesRepository.findById(Id).get();
            embeddedMovieToUpdate.setRuntime(runtime);
            updateLastUpdated(embeddedMovieToUpdate);
        }
        return embeddedMoviesRepository.save(embeddedMovieToUpdate);
    }

    public void updateYear(String Id, String year) {
        EmbeddedMovie movieToUpdate = null;
        if(embeddedMoviesRepository.findById(Id).isPresent()) {
            movieToUpdate = embeddedMoviesRepository.findById(Id).get();
            movieToUpdate.setYear(year);
//            updateLastUpdated(movieToUpdate);
        }
        embeddedMoviesRepository.save(movieToUpdate);
    }

    public void deleteMovieById(String Id) {
        Optional<EmbeddedMovie> movie = embeddedMoviesRepository.findById(Id);
        movie.ifPresent(embeddedMovie -> embeddedMoviesRepository.delete(embeddedMovie));
    }

    public List<EmbeddedMovie> findEmbeddedMovieFromEmbedding(EmbeddedMovie originalMovie, double wantedDistance) {
        List<EmbeddedMovie> embeddedMovie = embeddedMoviesRepository.findAll();
        for (EmbeddedMovie movie : embeddedMovie) {
            double distance = calculateEuclid(originalMovie.getPlot_embedding(), movie.getPlot_embedding());
            if (distance <= wantedDistance) {
                embeddedMovie.add(movie);
            }
        }
        return embeddedMovie;
    }

    public double calculateEuclid(double[] originalEmbeds, double[] embeds) {
        double total = 0.0;
        for (int i = 0; i < originalEmbeds.length; i++) {
            total += Math.pow(originalEmbeds[i] - embeds[i], 2);
        }
        return Math.abs(Math.sqrt(total));
    }
}