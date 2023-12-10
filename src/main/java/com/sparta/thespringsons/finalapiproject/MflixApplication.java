package com.sparta.thespringsons.finalapiproject;


import com.sparta.thespringsons.finalapiproject.logger.OurLogger;

import com.sparta.thespringsons.finalapiproject.model.repositories.CommentRepository;
import com.sparta.thespringsons.finalapiproject.model.repositories.UserRepository;
import com.sparta.thespringsons.finalapiproject.model.repositories.MovieRepository;
import com.sparta.thespringsons.finalapiproject.model.repositories.EmbeddedMoviesRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.logging.Logger;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableMongoRepositories
@Import(MongoConfig.class)
public class MflixApplication {

    public static final Logger logger = Logger.getLogger(MflixApplication.class.getName());


    public static void main(String[] args) {
        OurLogger.setUpLogger(logger);
        SpringApplication.run(MflixApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(UserRepository userRepository,
                                    EmbeddedMoviesRepository embeddedMoviesRepository, MovieRepository movieRepository, CommentRepository commentRepository) {
        return args -> {
//            User thisGuy = userRepository.findByName("Jon Snow");
//            System.out.println(thisGuy.email);
//            List<EmbeddedMovie> movies = embeddedMoviesRepository.findByTitle("Beau Geste");
//            System.out.println(movies.toString());
//            List<EmbeddedMovie> noms = embeddedMoviesRepository.findByAwardsNominations(1);
//            Movie thisMovie = movieRepository.findByTitle("A Corner in Wheat");
//            String thisID = thisMovie.getId();
//            System.out.println(thisID);
//            System.out.println(commentService.getAllCommentsByMovieTitle("A Corner in Wheat"));
//            Comment comment = commentRepository.findByMovieId(thisID);
//            System.out.println(comment.getName());
//            Movie thisMovie2 = movieRepository.findByTitle("Wild and Woolly");
//            System.out.println(thisMovie.getImdb().rating);
//            System.out.println(thisMovie2.getTomatoes());
//            System.out.println(noms.toString());
//            System.out.println(thisGuy.email);
//            System.out.println(commentRepository.findAll());

        };
    }
}