package com.sparta.thespringsons.finalapiproject;

import com.sparta.thespringsons.finalapiproject.entities.EmbeddedMovies;
import com.sparta.thespringsons.finalapiproject.entities.User;
import com.sparta.thespringsons.finalapiproject.repositories.EmbeddedMoviesRepository;
import com.sparta.thespringsons.finalapiproject.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableMongoRepositories
public class MflixApplication {

    public static void main(String[] args) {
        SpringApplication.run(MflixApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(UserRepository userRepository,
                                    EmbeddedMoviesRepository embeddedMoviesRepository) {
        return args -> {
            User thisGuy = userRepository.findByName("Jon Snow");
            //System.out.println(thisGuy.email);
            List<EmbeddedMovies> movies = embeddedMoviesRepository.findByTitle("Beau Geste");
            //System.out.println(movies.toString());
            List<EmbeddedMovies> noms = embeddedMoviesRepository.findByAwardsNominations(1);
            System.out.println(noms.toString());
        };
    }

}