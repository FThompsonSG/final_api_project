package com.sparta.thespringsons.finalapiproject.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.thespringsons.finalapiproject.model.entities.Theater;
import com.sparta.thespringsons.finalapiproject.model.fields.Address;
import com.sparta.thespringsons.finalapiproject.model.fields.Geo;
import com.sparta.thespringsons.finalapiproject.model.fields.Location;
import com.sparta.thespringsons.finalapiproject.model.services.TheaterService;
import org.junit.jupiter.api.Test;
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
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
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
    Theater mockTheater = new Theater("9999999", location, 999999);

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
        Optional<Theater> mockTheaterOp = Optional.of(mockTheater);
        Mockito.when(theaterService.getTheaterByTheaterId(999999)).thenReturn(mockTheaterOp);
        mockMvc
                .perform(MockMvcRequestBuilders.get("http://localhost:8080/theatres/theater_id/{theater_id}", 999999))
                .andExpect(status().is(200))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(handler().methodName("getTheatersById"))
                .andDo(print());
    }

    @Test
    void addTheatre() throws Exception {
        ArrayList<Theater> theaterList = new ArrayList<>();
        theaterList.add(mockTheater);
        mockTheater.setId("000111");
        Mockito.when(theaterService.getTheaterById("000111")).thenReturn(Optional.empty());
        mockMvc
                .perform(MockMvcRequestBuilders.post("http://localhost:8080/theaters")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsBytes(mockTheater)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(handler().methodName("addTheater"))
                .andDo(print());
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