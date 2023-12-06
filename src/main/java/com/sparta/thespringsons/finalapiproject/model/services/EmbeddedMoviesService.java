package com.sparta.thespringsons.finalapiproject.model.services;

import com.sparta.thespringsons.finalapiproject.model.entities.EmbeddedMovie;
import com.sparta.thespringsons.finalapiproject.model.entities.Movie;
import com.sparta.thespringsons.finalapiproject.model.fields.Awards;
import com.sparta.thespringsons.finalapiproject.model.repositories.EmbeddedMoviesRepository;
import com.sparta.thespringsons.finalapiproject.model.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        return embeddedMoviesRepository.findByFieldNameContaining("Oscar");
    }
}