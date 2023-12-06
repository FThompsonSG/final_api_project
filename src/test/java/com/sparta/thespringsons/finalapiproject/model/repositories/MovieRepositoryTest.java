package com.sparta.thespringsons.finalapiproject.model.repositories;

import com.sparta.thespringsons.finalapiproject.model.entities.Movie;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MovieRepositoryTest {

    @Autowired
    private MovieRepository movieRepository;

    @Test
    @DisplayName("Movie test")
    public void GetAllMovies() {
        Movie testMovie = movieRepository.findById("573a1390f29313caabcd42e8").get();
        analyze(testMovie);

        try {
            movieRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void analyze (Object obj){
        ReflectionUtils.doWithFields(obj.getClass(), field -> {

            System.out.println("Field name: " + field.getName());
            field.setAccessible(true);
            System.out.println("Field value: "+ field.get(obj));


        });
    }


}