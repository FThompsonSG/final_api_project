package com.sparta.thespringsons.finalapiproject.model.services;

import com.sparta.thespringsons.finalapiproject.model.entities.Theater;
import com.sparta.thespringsons.finalapiproject.model.fields.Address;
import com.sparta.thespringsons.finalapiproject.model.fields.Geo;
import com.sparta.thespringsons.finalapiproject.model.fields.Location;
import jakarta.validation.constraints.AssertTrue;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TheaterServiceTest {

    @Autowired
    private TheaterService theaterService;

    float[] coords = {100.27F, 0.87F};
    Geo geo = new Geo(coords, "Point");
    Address address = new Address("TestCity", "TestState","TestSt1","1234567");
    Location location = new Location(geo,address);
    Theater theaterTestRec = new Theater(null, location, 9999999);

    @Test
    @Order(1)
    @DisplayName("Testing get all theaters method has more than 5 theaters")
    public void getAllTheaterTests() {
        List<Theater> theaterList = theaterService.getAllTheaters();
        int numTheaters = theaterList.size();
        Assertions.assertTrue(numTheaters > 5);
    }

    @Test
    @Order(2)
    @DisplayName("Testing get theater by theaterID")
    public void getTheaterByTheaterId() {
        Optional<Theater> testTheater = theaterService.getTheaterByTheaterId(1000);

            Assertions.assertEquals("MN",
                    testTheater.get().getLocation().getAddress().getState());
    }

    @Test
    @Order(3)
    @DisplayName("Testing get theater by ID")
        public void getTheaterById() {
        Optional<Theater> testTheater = theaterService.getTheaterById("59a47286cfa9a3a73e51e72c");

        Assertions.assertEquals("MN",
                testTheater.get().getLocation().getAddress().getState());
    }

    @Test
    @Order(4)
    @DisplayName("Testing find by zipcode partial matching")
        public void testFindByZipcode() {
        List<Theater> matchingTheaters = theaterService.getTheatersByZipcode("19");
        Assertions.assertTrue(matchingTheaters.size() > 0);

        for (Theater theater : matchingTheaters)
            Assertions.assertTrue(theater.getLocation().getAddress().getZipcode().contains("19"));
    }

    @Test
    @Order(5)
    @DisplayName("Testing create theater")
    public void testCreateTheaterMethod() throws Exception {
        // We assume theater is created through the BeforeAll setup method.

        theaterService.saveTheater(theaterTestRec);
        Optional<Theater> theater = theaterService.getTheaterByTheaterId(9999999);
        Assertions.assertTrue(theater.isPresent());

        theater.ifPresent(value -> Assertions.assertEquals("TestCity", value.getLocation().getAddress().getCity()));
    }

    @Test
    @Order(6)
    @DisplayName("Testing update theater method throws not exists exception")
    public void testUpdateFunctionThrowsNoRecordExistsException() {
        Optional<Theater> theater = theaterService.getTheaterByTheaterId(9999998);
        Assertions.assertThrows(Exception.class,
                () -> theaterService.updateTheater(theater.get(),9999998))
        ;
    }


    @Test
    @Order(7)
    @DisplayName("Testing update theater method in service")
    public void testUpdateFunction() throws Exception {
        Optional<Theater> theater = theaterService.getTheaterByTheaterId(9999999);
        Assertions.assertTrue(theater.isPresent());

        if (theater.isPresent()) {
            theater.get().getLocation().getAddress().setCity("MyNewCity");
            theaterService.updateTheater(theater.get(), 9999999);
            Assertions.assertEquals("MyNewCity", theater.get().getLocation().getAddress().getCity());
        }
    }

    @Test
    @Order(8)
    @DisplayName("Testing delete theater method in service")
    public void testDeleteFunction() throws Exception {
        Optional<Theater> theater = theaterService.getTheaterByTheaterId(9999999);
        Assertions.assertTrue(theater.isPresent());

        if (theater.isPresent()) {
            theaterService.deleteTheater(theater.get().getTheaterId());
            theater = theaterService.getTheaterByTheaterId(9999999);
            Assertions.assertTrue(theater.isEmpty());
        }
    }

    @Test
    @Order(9)
    @DisplayName("Test delete theater throws exception")
    public void testDeleteTheaterThrowsException() {
        Assertions.assertThrows(Exception.class,
                () -> theaterService.deleteTheater(9999998));
    }

}