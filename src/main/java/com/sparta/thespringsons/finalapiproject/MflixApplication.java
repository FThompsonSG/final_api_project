package com.sparta.thespringsons.finalapiproject;

import com.sparta.thespringsons.finalapiproject.model.entities.Movie;
import com.sparta.thespringsons.finalapiproject.model.entities.User;
import com.sparta.thespringsons.finalapiproject.model.repositories.MovieRepository;
import com.sparta.thespringsons.finalapiproject.model.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableMongoRepositories
public class MflixApplication {

    public static void main(String[] args) {
        SpringApplication.run(MflixApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(UserRepository usersRepository, MovieRepository movieRepository) {
        return args -> {
            User thisGuy = usersRepository.findByName("Jon Snow");
            Movie thisMovie = movieRepository.findByTitle("The Four Horsemen of the Apocalypse");
            Movie thisMovie2 = movieRepository.findByTitle("Wild and Woolly");

            System.out.println(thisMovie.getImdb());
            System.out.println(thisMovie2.getTomatoes());
            System.out.println(thisGuy.email);
        };
    }
}