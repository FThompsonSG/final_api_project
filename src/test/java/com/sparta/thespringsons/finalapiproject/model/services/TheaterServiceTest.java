package com.sparta.thespringsons.finalapiproject.model.services;

import com.sparta.thespringsons.finalapiproject.model.entities.Theater;
import jakarta.validation.constraints.AssertTrue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TheaterServiceTest {

    @Autowired
    private TheaterService theaterService;

    @Test
    @DisplayName("Testing get all theaters method has more than 5 theaters")
    public void getAllTheaterTests() {
        List<Theater> theaterList = theaterService.getAllTheaters();
        int numTheaters = theaterList.size();
        Assertions.assertTrue(numTheaters > 5);
    }

    @Test
    @DisplayName("Testing get theater by theaterID")
    public void getTheaterByTheaterId() {
        Optional<Theater> testTheater = theaterService.getTheaterByTheaterId(1000);

            Assertions.assertEquals("MN",
                    testTheater.get().getLocation().getAddress().getState());
    }

    @Test
    @DisplayName("Testing get theater by ID")
        public void getTheaterById() {
        Optional<Theater> testTheater = theaterService.getTheaterById("59a47286cfa9a3a73e51e72c");

        Assertions.assertEquals("MN",
                testTheater.get().getLocation().getAddress().getState());
    }

    @Test
    @DisplayName("Testing find by zipcode partial matching")
        public void testFindByZipcode() {
        List<Theater> matchingTheaters = theaterService.getTheatersByZipcode("19");
        Assertions.assertTrue(matchingTheaters.size() > 0);
        System.out.println(matchingTheaters.size());

        for (Theater theater : matchingTheaters)
            System.out.println(theater.getLocation().getAddress().getZipcode());
    }

}