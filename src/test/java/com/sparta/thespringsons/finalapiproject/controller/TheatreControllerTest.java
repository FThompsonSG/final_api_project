package com.sparta.thespringsons.finalapiproject.controller;

import com.sparta.thespringsons.finalapiproject.model.entities.Theater;
import com.sparta.thespringsons.finalapiproject.model.fields.Address;
import com.sparta.thespringsons.finalapiproject.model.fields.Geo;
import com.sparta.thespringsons.finalapiproject.model.fields.Location;
import com.sparta.thespringsons.finalapiproject.model.services.TheaterService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = TheatreController.class)
class TheatreControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    TheaterService theaterService;

    float[] coords = {21f, 22f};
    Geo geo = new Geo(coords, "Point");
    Address address = new Address("MyCity", "MyState", "MySt","1234567");
    Location location = new Location(geo, address);
    Theater mockTheater = new Theater(null, location, 999999);

    @Test
    public void getAllTheatres() throws Exception {
        ArrayList<Theater> theaterList = new ArrayList<>();
        theaterList.add(mockTheater);
        Mockito.when(theaterService.getAllTheaters()).thenReturn(theaterList);
        mockMvc
                .perform(MockMvcRequestBuilders.get("http://localhost:8080/theatres"))
                .andExpect(status().is(200))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(handler().methodName("getAllTheatres"))
                .andDo(print());
    }

    @Test
    void getAllTheatersByZipcode() throws Exception {
        ArrayList<Theater> theaterList = new ArrayList<>();
        theaterList.add(mockTheater);
        Mockito.when(theaterService.getTheatersByZipcode("1234567")).thenReturn(theaterList);
        mockMvc
                .perform(MockMvcRequestBuilders.get("http://localhost:8080/theatres/zipcode/{zipcode}", "1234567"))
                .andExpect(status().is(200))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(handler().methodName("getAllTheatersByZipcode"))
                .andDo(print());
    }

    @Test
    void testGetAllTheatres() throws Exception {
        ArrayList<Theater> theaterList = new ArrayList<>();
        theaterList.add(mockTheater);
        Mockito.when(theaterService.getTheatersByZipcode("1234567")).thenReturn(theaterList);
        mockMvc
                .perform(MockMvcRequestBuilders.get("http://localhost:8080/theatres/theater_id/{theater_id}", "1234567"))
                .andExpect(status().is(200))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(handler().methodName("getAllTheatersByZipcode"))
                .andDo(print());
    }

    @Test
    void addTheatre() {
        // Bianca
    }

    @Test
    void deleteTheatre() {
        // Artie
    }

    @Test
    void updateTheatre() {
        // Affoq
    }
}