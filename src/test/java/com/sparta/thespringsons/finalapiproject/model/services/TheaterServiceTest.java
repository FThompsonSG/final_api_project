package com.sparta.thespringsons.finalapiproject.model.services;

import com.sparta.thespringsons.finalapiproject.model.entities.Theater;
import com.sparta.thespringsons.finalapiproject.model.fields.Address;
import com.sparta.thespringsons.finalapiproject.model.fields.Geo;
import com.sparta.thespringsons.finalapiproject.model.fields.Location;
import jakarta.validation.constraints.AssertTrue;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@FixMethodOrder(MethodSorters.DEFAULT)
class TheaterServiceTest {

    @Autowired
    private TheaterService theaterService;

    @BeforeAll
    public static void setUp(@Autowired TheaterService theaterService) throws Exception {
        // Init test data
        float[] coords = {100.27F, 0.87F};
        Geo geo = new Geo(coords, "Point");
        Address address = new Address("TestCity", "TestState","TestSt1","1234567");
        Location location = new Location(geo,address);
        Theater theater = new Theater("99999", location, 9999999);
        theaterService.saveTheater(theater);
    }

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

        for (Theater theater : matchingTheaters)
            Assertions.assertTrue(theater.getLocation().getAddress().getZipcode().contains("19"));
    }

    @Test
    @DisplayName("Testing create theater")
    public void t1TestCreateTheaterMethod() {
        // We assume theater is created through the BeforeAll setup method.
        Optional<Theater> theater = theaterService.getTheaterByTheaterId(9999999);

        Assertions.assertTrue(theater.isPresent());

        if (theater.isPresent()) {
            Assertions.assertEquals("TestCity", theater.get().getLocation().getAddress().getCity());
        }
    }

    @Test
    @DisplayName("Testing update theater method in service")
    public void t2TestUpdateFunction() throws Exception {
        Optional<Theater> theater = theaterService.getTheaterByTheaterId(9999999);
        Assertions.assertTrue(theater.isPresent());

        if (theater.isPresent()) {
            theater.get().getLocation().getAddress().setCity("MyNewCity");
            theaterService.updateTheater(theater.get(), 9999999);
            Assertions.assertEquals("MyNewCity", theater.get().getLocation().getAddress().getCity());
        }
    }

    @Test
    @DisplayName("Testing delete theater method in service")
    public void t3TestDeleteFunction() throws Exception {
        Optional<Theater> theater = theaterService.getTheaterByTheaterId(9999999);
        Assertions.assertTrue(theater.isPresent());

        if (theater.isPresent()) {
            theaterService.deleteTheater(theater.get().getTheaterId());
            theater = theaterService.getTheaterByTheaterId(9999999);
            Assertions.assertTrue(theater.isEmpty());
        }
    }

}