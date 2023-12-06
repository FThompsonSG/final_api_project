package com.sparta.thespringsons.finalapiproject;

import com.sparta.thespringsons.finalapiproject.model.entities.User;
import com.sparta.thespringsons.finalapiproject.model.fields.Imdb;
import com.sparta.thespringsons.finalapiproject.model.repositories.CommentRepository;
import com.sparta.thespringsons.finalapiproject.model.repositories.UserRepository;
import com.sparta.thespringsons.finalapiproject.model.entities.EmbeddedMovie;
import com.sparta.thespringsons.finalapiproject.model.entities.Movie;
import com.sparta.thespringsons.finalapiproject.model.repositories.MovieRepository;
import com.sparta.thespringsons.finalapiproject.model.repositories.EmbeddedMoviesRepository;
import com.sparta.thespringsons.finalapiproject.model.services.EmbeddedMoviesService;
import com.sparta.thespringsons.finalapiproject.model.services.MoviesService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableMongoRepositories
public class MflixApplication {
    private MoviesService moviesService;
    public static void main(String[] args) {
        SpringApplication.run(MflixApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(UserRepository userRepository,
                                    EmbeddedMoviesRepository embeddedMoviesRepository, MovieRepository movieRepository, CommentRepository commentRepository,MoviesService moviesService){
        return args -> {
            List<EmbeddedMovie> movies = embeddedMoviesRepository.findByCountries("germany");
            if(movies.isEmpty()) {
                System.out.println("Empty Array");
            } else {
                for(EmbeddedMovie movie: movies) {
                    System.out.println(Arrays.toString(movie.getCountries()));
                }
            }
        };
    }
}