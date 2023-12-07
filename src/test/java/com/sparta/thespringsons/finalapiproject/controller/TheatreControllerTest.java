package com.sparta.thespringsons.finalapiproject.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.thespringsons.finalapiproject.exceptions.norecordfound.NoRecordFoundException;
import com.sparta.thespringsons.finalapiproject.model.entities.Theater;
import com.sparta.thespringsons.finalapiproject.model.fields.Address;
import com.sparta.thespringsons.finalapiproject.model.fields.Geo;
import com.sparta.thespringsons.finalapiproject.model.fields.Location;
import com.sparta.thespringsons.finalapiproject.model.services.TheaterService;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("Test get all theaters endpoint")
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
    @DisplayName("Testing get all theaters by zipcode endpoint")
    public void getAllTheatersByZipcode() throws Exception {
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
    @DisplayName("Testing get theatre by theater_id endpoint")
    public void testGetTheatreByTheaterId() throws Exception {
        Optional<Theater> mockTheaterOp = Optional.of(mockTheater);
        Mockito.when(theaterService.getTheaterByTheaterId(999999)).thenReturn(mockTheaterOp);
        mockMvc
                .perform(MockMvcRequestBuilders.get("http://localhost:8080/theatres/theater_id/{theater_id}", 999999))
                .andExpect(status().is(200))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(handler().methodName("getTheatresById"))
                .andDo(print());
    }

    @Test
    @DisplayName("Testing add theatre endpoint")
    public void testAddTheatre() throws Exception {
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
    @DisplayName("Test delete theatre endpoint")
    void testDeleteTheatre() throws Exception {
        String returned = " ";
        Optional<Theater> mockTheaterOp = Optional.of(mockTheater);

        String mockMessage = "Theater deleted";
        Mockito.when(theaterService.getTheaterByTheaterId(999999)).thenReturn(mockTheaterOp);
        Mockito.when(theaterService.deleteTheater(999999)).thenReturn(mockMessage);
        mockMvc
                .perform(MockMvcRequestBuilders.delete("http://localhost:8080/theaters/delete/{theater_id}", Integer.valueOf(999999)))
                .andExpect(status().is(200))
                //.andExpect(content().string(mockMessage))
                .andExpect(handler().methodName("deleteTheater"))
                .andDo(print());
    }


    @Test
    @DisplayName("Test delete theatre throws exception endpoint")
    void testDeleteTheatreThrowsException() throws Exception {
        String returned = " ";
        Optional<Theater> noRecord = Optional.empty();

        String mockMessage = "Theater deleted";
        Mockito.when(theaterService.getTheaterByTheaterId(999999)).thenReturn(noRecord);
        Mockito.when(theaterService.deleteTheater(999999)).thenReturn(mockMessage);
        mockMvc
                .perform(MockMvcRequestBuilders.delete("http://localhost:8080/theaters/delete/{theater_id}", Integer.valueOf(999999)))
                .andExpect(status().is(400))
                //.andExpect(content().string(mockMessage))
                .andExpect(handler().methodName("deleteTheater"))
                .andDo(print());
    }
    @Test
    void updateTheatre() {
        // Affoq
    }
}