package com.sparta.thespringsons.finalapiproject.model.services;

import com.sparta.thespringsons.finalapiproject.exceptions.InvalidDocumentException;
import com.sparta.thespringsons.finalapiproject.model.entities.EmbeddedMovie;
import com.sparta.thespringsons.finalapiproject.model.entities.Movie;
import com.sparta.thespringsons.finalapiproject.model.fields.Awards;
import com.sparta.thespringsons.finalapiproject.model.repositories.EmbeddedMoviesRepository;
import com.sparta.thespringsons.finalapiproject.model.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmbeddedMoviesService  {

    private EmbeddedMoviesRepository embeddedMoviesRepository;

    @Autowired
    public EmbeddedMoviesService(EmbeddedMoviesRepository embeddedMoviesRepository) {
        this.embeddedMoviesRepository = embeddedMoviesRepository;
    }

    public List<String> findAllByTomatoesCriticRating(double minRating, double maxRating) {
        List<EmbeddedMovie> embeddedMovies = new ArrayList<>();
        List<String> embeddedMoviesTitles = new ArrayList<>();
        for (EmbeddedMovie embeddedMovie : embeddedMoviesRepository.findAll()) {
            if(embeddedMovie.getTomato() != null) {
                if (embeddedMovie.getTomato().getCritic() != null)
                    if(embeddedMovie.getTomato().getCritic().getRating() != null)
                        if (embeddedMovie.getTomato().getCritic().getRating() < maxRating && embeddedMovie.getTomato().getCritic().getRating() > minRating) {
                        embeddedMoviesTitles.add(embeddedMovie.getTitle());
                    }

            }
        }
        return embeddedMoviesTitles;
    }

    public List<String> findAllByTomatoesViewerRating(double minRating, double maxRating) {
        List<EmbeddedMovie> embeddedMovies = new ArrayList<>();
        List<String> embeddedMoviesTitles = new ArrayList<>();
        for (EmbeddedMovie embeddedMovie : embeddedMoviesRepository.findAll()) {
            if(embeddedMovie.getTomato() != null) {
                if (embeddedMovie.getTomato().getViewer() != null)
                    if(embeddedMovie.getTomato().getViewer().getRating() != null)
                        if (embeddedMovie.getTomato().getViewer().getRating() < maxRating && embeddedMovie.getTomato().getViewer().getRating() > minRating) {
                            embeddedMoviesTitles.add(embeddedMovie.getTitle());
                        }

            }
        }
        return embeddedMoviesTitles;
    }

    public List<String> findAllByTomatoesCriticMeter(double minMeter, double maxMeter) {
        List<EmbeddedMovie> embeddedMovies = new ArrayList<>();
        List<String> embeddedMoviesTitles = new ArrayList<>();
        for (EmbeddedMovie embeddedMovie : embeddedMoviesRepository.findAll()) {
            if(embeddedMovie.getTomato() != null) {
                if (embeddedMovie.getTomato().getCritic() != null)
                    if(embeddedMovie.getTomato().getCritic().getMeter() != null)
                        if (embeddedMovie.getTomato().getCritic().getMeter() < maxMeter && embeddedMovie.getTomato().getCritic().getMeter() > minMeter) {
                            embeddedMoviesTitles.add(embeddedMovie.getTitle());
                        }

            }
        }
        return embeddedMoviesTitles;
    }

    public List<String> findAllByTomatoesViewerMeter(double minMeter, double maxMeter) {
        List<EmbeddedMovie> embeddedMovies = new ArrayList<>();
        List<String> embeddedMoviesTitles = new ArrayList<>();
        for (EmbeddedMovie embeddedMovie : embeddedMoviesRepository.findAll()) {
            if(embeddedMovie.getTomato() != null) {
                if (embeddedMovie.getTomato().getViewer() != null)
                    if(embeddedMovie.getTomato().getViewer().getMeter() != null)
                        if (embeddedMovie.getTomato().getViewer().getMeter() < maxMeter && embeddedMovie.getTomato().getViewer().getMeter() > minMeter) {
                            embeddedMoviesTitles.add(embeddedMovie.getTitle());
                        }

            }
        }
        return embeddedMoviesTitles;
    }

    public List<String> findAllByTomatoesRottenReviews(int minRotten, int maxRotten) {
        List<EmbeddedMovie> embeddedMovies = new ArrayList<>();
        List<String> embeddedMoviesTitles = new ArrayList<>();
        for (EmbeddedMovie embeddedMovie : embeddedMoviesRepository.findAll()) {
            if(embeddedMovie.getTomato() != null) {
                if (embeddedMovie.getTomato().getRotten() != null)
                        if (embeddedMovie.getTomato().getRotten() < maxRotten && embeddedMovie.getTomato().getRotten() > minRotten) {
                            embeddedMoviesTitles.add(embeddedMovie.getTitle());
                        }

            }
        }
        return embeddedMoviesTitles;
    }

    public List<String> findAllByTomatoesFreshReviews(int minFresh, int maxFresh) {
        List<EmbeddedMovie> embeddedMovies = new ArrayList<>();
        List<String> embeddedMoviesTitles = new ArrayList<>();
        for (EmbeddedMovie embeddedMovie : embeddedMoviesRepository.findAll()) {
            if(embeddedMovie.getTomato() != null) {
                if (embeddedMovie.getTomato().getFresh() != null)
                    if (embeddedMovie.getTomato().getFresh() < maxFresh && embeddedMovie.getTomato().getFresh() > minFresh) {
                        embeddedMoviesTitles.add(embeddedMovie.getTitle());
                    }

            }
        }
        return embeddedMoviesTitles;
    }

    public List<String> findAllByTomatoesProduction(String production) {
        List<EmbeddedMovie> embeddedMovies = new ArrayList<>();
        List<String> embeddedMoviesTitles = new ArrayList<>();
        for (EmbeddedMovie embeddedMovie : embeddedMoviesRepository.findAll()) {
            if(embeddedMovie.getTomato() != null) {
                if (embeddedMovie.getTomato().getProduction() != null)
                    if (embeddedMovie.getTomato().getProduction().equals(production)) {
                        embeddedMoviesTitles.add(embeddedMovie.getTitle());
                    }

            }
        }
        return embeddedMoviesTitles;
    }

    public List<EmbeddedMovie> getEmbeddedMoviesByCountry(String countryName) {
        return embeddedMoviesRepository.findByCountries(countryName);
    }

    public List<EmbeddedMovie> getEmbeddedMoviesByNumberOfNominations(Integer noms) {
        return embeddedMoviesRepository.findEmbeddedMoviesByAwards_Nominations(noms);
    }

    public List<EmbeddedMovie> getEmbeddedMoviesByNumberOfWins(Integer wins) {
        return embeddedMoviesRepository.findEmbeddedMoviesByAwards_Wins(wins);
    }

    public List<EmbeddedMovie> getEmbeddedMoviesByAwardName(String awardName) {
        return embeddedMoviesRepository.findByFieldNameContaining(awardName);
    }

    public List<EmbeddedMovie> getEmbeddedMoviesByTitleContaining(String filmTitle) {
        return embeddedMoviesRepository.findByTitleContaining(filmTitle);
    }

    public List<EmbeddedMovie> getEmbeddedMoviesByCastMember(String castMemberName) {
        return embeddedMoviesRepository.findByCastMember(castMemberName);
    }

    public List<EmbeddedMovie> getEmbeddedMoviesByDirector(String directorName) {
        return embeddedMoviesRepository.findByDirector(directorName);
    }

    public List<EmbeddedMovie> getEmbeddedMoviesByFullPlot(String fullPlot) {
        return embeddedMoviesRepository.findByFullPlot(fullPlot);
    }

    public List<EmbeddedMovie> getEmbeddedMoviesByGenre(String genre) {
        return embeddedMoviesRepository.findByGenre(genre);
    }

    public List<EmbeddedMovie> getEmbeddedMoviesByLanguage(String language) {
        return embeddedMoviesRepository.findByLanguage(language);
    }

    public List<EmbeddedMovie> getEmbeddedMoviesByNumberOfCommentsLowerBound(Integer numberOfComments) {
        return embeddedMoviesRepository.findByNumberOfComments(numberOfComments);
    }

    public List<EmbeddedMovie> getEmbeddedMoviesByPlot(String plot) {
        String plotPadded = " " + plot + " ";
        return embeddedMoviesRepository.findByPlot(plotPadded);
    }

    public List<EmbeddedMovie> getEmbeddedMoviesByMaxRuntime(Integer mins) {
        return embeddedMoviesRepository.findByMaxRuntime(mins);
    }

    public List<EmbeddedMovie> getEmbeddedMoviesByWriter(String writerName) {
        return embeddedMoviesRepository.findByWriter(writerName);
    }

    public List<EmbeddedMovie> getEmbeddedMoviesByYearExact(String year) {
        try {
            Integer yearInt = Integer.parseInt(year);
            return embeddedMoviesRepository.findByYearExact(yearInt);
        } catch (Exception e) {
            System.out.println("Invalid String");
            return null;
        }
    }

    public List<EmbeddedMovie> getEmbeddedMoviesByYearBefore(String year) {
        try {
            Integer yearInt = Integer.parseInt(year);
            return embeddedMoviesRepository.findByYearBefore(yearInt);
        } catch (Exception e) {
            System.out.println("Invalid String");
            return null;
        }
    }

    public List<EmbeddedMovie> getEmbeddedMoviesByYearAfter(String year) {
        try {
            Integer yearInt = Integer.parseInt(year);
            return embeddedMoviesRepository.findByYearAfter(yearInt);
        } catch (Exception e) {
            System.out.println("Invalid String");
            return null;
        }
    }

    //------------------>07/12/2023<------------------------
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

//    --------------->Test from here<-----------------
    public EmbeddedMovie updateEmbeddedMovieTitle(String Id, String newTitle) {
        EmbeddedMovie movie = null;
        if(embeddedMoviesRepository.findById(Id).isPresent()) {
            movie = embeddedMoviesRepository.findById(Id).get();
            movie.setTitle(newTitle);
        }
        return embeddedMoviesRepository.save(movie);
    }

    public EmbeddedMovie updateEmbeddedMovieWriters(String Id, String newWriter) {
        EmbeddedMovie movie = null;
        if(embeddedMoviesRepository.findById(Id).isPresent()) {
            movie = embeddedMoviesRepository.findById(Id).get();
            List<String> writers = Arrays.asList(movie.getWriters());
            writers.add(newWriter);
            movie.setWriters(writers.toArray(new String[0]));
        }
        return embeddedMoviesRepository.save(movie);
    }

    public EmbeddedMovie updateEmbeddedMovieCast(String Id, String newMember) {
        EmbeddedMovie movie = null;
        if(embeddedMoviesRepository.findById(Id).isPresent()) {
            movie = embeddedMoviesRepository.findById(Id).get();
            List<String> cast = Arrays.asList(movie.getCast());
            cast.add(newMember);
            movie.setWriters(cast.toArray(new String[0]));
        }
        return embeddedMoviesRepository.save(movie);
    }

    public EmbeddedMovie updateEmbeddedMovieGenres(String Id, String newGenre) {
        EmbeddedMovie movie = null;
        if(embeddedMoviesRepository.findById(Id).isPresent()) {
            movie = embeddedMoviesRepository.findById(Id).get();
            List<String> genres = Arrays.asList(movie.getGenres());
            genres.add(newGenre);
            movie.setWriters(genres.toArray(new String[0]));
        }
        return embeddedMoviesRepository.save(movie);
    }

    public EmbeddedMovie updateEmbeddedMovieLanguages(String Id, String newLanguage) {
        EmbeddedMovie movie = null;
        if(embeddedMoviesRepository.findById(Id).isPresent()) {
            movie = embeddedMoviesRepository.findById(Id).get();
            List<String> languages = Arrays.asList(movie.getLanguages());
            languages.add(newLanguage);
            movie.setWriters(languages.toArray(new String[0]));
        }
        return embeddedMoviesRepository.save(movie);
    }

    public EmbeddedMovie updateEmbeddedMovieCountries(String Id, String newCountry) {
        EmbeddedMovie movie = null;
        if(embeddedMoviesRepository.findById(Id).isPresent()) {
            movie = embeddedMoviesRepository.findById(Id).get();
            List<String> countries = Arrays.asList(movie.getCountries());
            countries.add(newCountry);
            movie.setWriters(countries.toArray(new String[0]));
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
        }
        return embeddedMoviesRepository.save(movie);
    }





}