package com.sparta.thespringsons.finalapiproject;

import com.sparta.thespringsons.finalapiproject.model.repositories.EmbeddedMoviesRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CachingTest {

    @Autowired
    private EmbeddedMoviesRepository embeddedMoviesRepository;

    @Test
    @Order(1)
    public void FindAllNum1() {
        System.out.println(embeddedMoviesRepository.findAll());
    }

    @Test
    @Order(2)
    public void FindAllNum2() {
        System.out.println(embeddedMoviesRepository.findAll());
    }

    @Test
    @Order(3)
    public void FindAllNum3() {
        System.out.println(embeddedMoviesRepository.findAll());
    }


}
