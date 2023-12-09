package com.sparta.thespringsons.finalapiproject.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.thespringsons.finalapiproject.exceptions.norecordfound.NoRecordFoundException;
import com.sparta.thespringsons.finalapiproject.model.entities.Theater;
import com.sparta.thespringsons.finalapiproject.model.fields.Address;
import com.sparta.thespringsons.finalapiproject.model.fields.Geo;
import com.sparta.thespringsons.finalapiproject.model.fields.Location;
import com.sparta.thespringsons.finalapiproject.model.services.ApiKeyService;
import com.sparta.thespringsons.finalapiproject.model.services.TheaterService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.MultiValueMap;

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

    @MockBean
    ApiKeyService apiKeyService;

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
                .perform(MockMvcRequestBuilders.get("http://localhost:8080/theater"))
                .andExpect(status().is(200))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(handler().methodName("getAllTheaters"))
                .andDo(print());
    }

    @Test
    @DisplayName("Testing get all theaters by zipcode endpoint")
    public void getAllTheatersByZipcode() throws Exception {
        ArrayList<Theater> theaterList = new ArrayList<>();
        theaterList.add(mockTheater);
        Mockito.when(theaterService.getTheatersByZipcode("1234567")).thenReturn(theaterList);
        mockMvc
                .perform(MockMvcRequestBuilders.get("http://localhost:8080/theater/byZipCode/{zipcode}", "1234567"))
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
                .perform(MockMvcRequestBuilders.get("http://localhost:8080/theater/byId/{theater_id}", 999999))
                .andExpect(status().is(200))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(handler().methodName("getTheaterById"))
                .andDo(print());
    }

    @Test
    @DisplayName("Testing add theatre endpoint")
    public void testAddTheatre() throws Exception {
        Optional<Theater> noRecord = Optional.empty();
        Mockito.when(theaterService.getTheaterById(mockTheater.getId())).thenReturn(noRecord);
        Mockito.when(theaterService.saveTheater(mockTheater)).thenReturn(mockTheater);
        mockMvc
                .perform(MockMvcRequestBuilders.post("http://localhost:8080/theater/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsBytes(mockTheater)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(handler().methodName("addTheater"))
                .andDo(print());
    }


    @Test
    @DisplayName("Testing add theatre record already exists exception endpoint")
    public void testAddTheatreThrowsRecordExists() throws Exception {
        Optional<Theater> existingRecord = Optional.ofNullable(mockTheater);
        Mockito.when(theaterService.getTheaterById(mockTheater.getId())).thenReturn(existingRecord);
        Mockito.when(theaterService.saveTheater(mockTheater)).thenReturn(mockTheater);
        mockMvc
                .perform(MockMvcRequestBuilders.post("http://localhost:8080/theater/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsBytes(mockTheater)))
                .andExpect(status().is(400))
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
        Mockito.when(apiKeyService.checkIfApiKeyExists("1337404")).thenReturn(true);
        mockMvc
                .perform(MockMvcRequestBuilders
                        .delete("http://localhost:8080/theater/delete/{theater_id}", 999999)
                        .header("Key","1337404"))
                .andExpect(status().is(200))
                //.andExpect(content().string(mockMessage))
                .andExpect(handler().methodName("deleteTheater"))
                .andDo(print());
    }


    @Test
    @DisplayName("Test delete theatre throws record doesnt exist exception endpoint")
    void testDeleteTheatreThrowsRecordDoesNotException() throws Exception {
        String returned = " ";
        Optional<Theater> noRecord = Optional.empty();

        String mockMessage = "Theater deleted";
        Mockito.when(theaterService.getTheaterByTheaterId(999999)).thenReturn(noRecord);
        Mockito.when(theaterService.deleteTheater(999999)).thenReturn(mockMessage);
        Mockito.when(apiKeyService.checkIfApiKeyExists("1337404")).thenReturn(true);
        mockMvc
                .perform(MockMvcRequestBuilders.
                        delete("http://localhost:8080/theater/delete/{theater_id}", 999999)
                        .header("Key","1337404"))
                .andExpect(status().is(400))
                //.andExpect(content().string(mockMessage))
                .andExpect(handler().methodName("deleteTheater"))
                .andDo(print());
    }
    @Test
    @DisplayName("Testing update theater endpoint")
    void testUpdateTheatre() throws Exception {
        Optional<Theater> existingRecord = Optional.ofNullable(mockTheater);

        Mockito.when(theaterService.getTheaterByTheaterId(999999)).thenReturn(existingRecord);
        Mockito.when(theaterService.updateTheater(mockTheater, 999999)).thenReturn(mockTheater);
        Mockito.when(apiKeyService.checkIfApiKeyExists("1337404")).thenReturn(true);
        mockMvc
                .perform(MockMvcRequestBuilders
                        .post("http://localhost:8080/theater/update/{theater_id}", 999999)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsBytes(mockTheater))
                        .header("Key","1337404"))
                .andExpect(status().is(200))
                .andExpect(handler().methodName("updateTheater"))
                .andDo(print());
    }

    @Test
    @DisplayName("Testing update theater throws exception endpoint")
    void testUpdateTheatreThrowsException() throws Exception {
        Optional<Theater> noRecord = Optional.empty();

        Mockito.when(theaterService.getTheaterByTheaterId(999999)).thenReturn(noRecord);
        Mockito.when(apiKeyService.checkIfApiKeyExists("1337404")).thenReturn(true);
        Mockito.when(theaterService.updateTheater(mockTheater, 999999)).thenReturn(mockTheater);
        mockMvc
                .perform(MockMvcRequestBuilders.post("http://localhost:8080/theater/update/{theater_id}", 999999)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsBytes(mockTheater))
                        .header("Key","1337404"))
                .andExpect(status().is(400))
                .andExpect(handler().methodName("updateTheater"))
                .andDo(print());
    }
}