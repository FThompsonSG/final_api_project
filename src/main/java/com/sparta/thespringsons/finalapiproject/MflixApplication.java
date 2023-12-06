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
    public CommandLineRunner runner(UserRepository userRepository,EmbeddedMoviesService embeddedMoviesService,
                                    EmbeddedMoviesRepository embeddedMoviesRepository, MovieRepository movieRepository, CommentRepository commentRepository,MoviesService moviesService){
        return args -> {

//            User thisGuy = userRepository.findByName("Jon Snow");
//            System.out.println(thisGuy.email);
//            List<EmbeddedMovie> movies = embeddedMoviesRepository.findByTitle("Beau Geste");
//            System.out.println(movies.toString());
//            List<EmbeddedMovie> noms = embeddedMoviesRepository.findByAwardsNominations(1);
                //Movie thisMovie = movieRepository.findByTitle("The Four Horsemen of the Apocalypse");
//            Movie thisMovie2 = movieRepository.findByTitle("Wild and Woolly");
//            System.out.println(thisMovie.getImdb().rating);
//            System.out.println(thisMovie2.getTomatoes());
//            System.out.println(noms.toString());
//            System.out.println(thisGuy.email);
//            System.out.println(commentRepository.findAll());
            //System.out.println(embeddedMoviesService.findAllByTomatoesCriticRating(3.0, 4.0));
            System.out.println(embeddedMoviesService.findAllByTomatoesProduction("Paramount Pictures"));

//
                /*List<Movie> thisMovie = movieRepository.findByTitle("The Great Train Robbery");
                ArrayList<Movie> allMovies = (ArrayList<Movie>) movieRepository.findAll();
                List<Movie> movies = moviesService.getAllMoviesByDirector("Hal Roach");
                List<Movie> ratings = moviesService.getAllMoviesByImdbRating(3d,3.1d);
                ArrayList<Movie> movies2 = (ArrayList<Movie>) movieRepository.findAll();
//                System.out.println(imdbMovies);
//                for(Movie movie : ratings) {
//                    System.out.println(movie.getTitle());
//                }
                for(Movie movie : thisMovie) {
                    System.out.println(movie.getTitle());
                }



            List<String> str = moviesService.getNumberOfMovieImdbVotes("Dead Weekend");
                for(String s : str){
                    System.out.println(s);
                }

            List<String> str2 = moviesService.getMovieImdbRatingByName("Dead Weekend");
            for(String s2 : str2){
                System.out.println(s2);
            }
            List<String> str3 = moviesService.getMovieImdbRatingByName("The Great Train Robbery");
            for(String s3 : str3){
                System.out.println(s3);
            }
            List<String> str4 = moviesService.getNumberOfMovieImdbVotes("The Great Train Robbery");
            for(String s4 : str4){
                System.out.println(s4);
            }*/


        };
    }
}