package com.sparta.thespringsons.finalapiproject.controller;

import com.sparta.thespringsons.finalapiproject.model.entities.Theater;
import com.sparta.thespringsons.finalapiproject.model.repositories.TheatersRepository;
import com.sparta.thespringsons.finalapiproject.model.services.TheaterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class TheatreController {
    private final TheaterService theaterService;
    @Autowired
    public TheatreController(TheaterService theaterService) {
        this.theaterService = theaterService;
    }


    @Tag(name = "Get All Theatres")
    @Operation(summary = "Gets all theatres")
    @GetMapping("/theatres")
    public List<Theater> getAllTheatres(){
      return theaterService.getAllTheaters();
    }

    @Tag(name = "Get Theatre by zip code")
    @Operation(summary = "Gets all theatres with a specific zipcode")
    @GetMapping("/theatres/zipcode/{zipcode}")
    public List<Theater> getAllTheatersByZipcode(@PathVariable String zipcode){
      return theaterService.getTheatersByZipcode(zipcode);
    }

    @Tag(name = "Get Theatre by Id")
    @Operation(summary = "Get Theatres by Id")
    @GetMapping("/theatres/theater_id/{theater_id}")
    public Optional<Theater> getAllTheatres(@PathVariable Integer theater_id){
      return theaterService.getTheaterByTheaterId(theater_id);
    }

    @Tag(name = "Add New Theatre")
    @Operation(summary = "Add new Theatre")
    @PostMapping("/theatres")
    public Theater addTheatre(@RequestBody Theater newTheater) throws Exception {
      return theaterService.saveTheater(newTheater);
    }

    @Tag(name = "Delete Theatre")
    @Operation(summary = "Delete a Theatre")
    @DeleteMapping("/theatres/delete/{theater_id}")
    public String deleteTheatre(@PathVariable Integer theater_id) throws Exception {
        return theaterService.deleteTheater(theater_id);
    }

    @Tag(name = "Update Theatre Record")
    @Operation(summary = "Update theatre record")
    @PostMapping("/theatres/update/{theater_id}")
    public Theater updateTheatre(
            @RequestBody Theater newTheater,
            @PathVariable Integer theater_id) throws Exception {
        return theaterService.updateTheater(newTheater, theater_id);
    }


}
