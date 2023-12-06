package com.sparta.thespringsons.finalapiproject.controller;

import com.sparta.thespringsons.finalapiproject.exceptions.norecordfound.NoRecordFoundException;
import com.sparta.thespringsons.finalapiproject.exceptions.recordalreadyexists.RecordAlreadyExistsException;
import com.sparta.thespringsons.finalapiproject.logger.OurLogger;
import com.sparta.thespringsons.finalapiproject.model.entities.Theater;
import com.sparta.thespringsons.finalapiproject.model.services.TheaterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;


@RestController
public class TheatreController {

    public static final Logger logger = Logger.getLogger(CommentController.class.getName());

    private final TheaterService theaterService;
    @Autowired
    public TheatreController(TheaterService theaterService) {
        this.theaterService = theaterService;
        OurLogger.setUpLogger(logger);
    }

    @Tag(name = "Get All Theatres")
    @Operation(summary = "Gets all theatres")
    @GetMapping("/theatres")
    public List<Theater> getAllTheatres() throws NoRecordFoundException {
        logger.log(Level.INFO, "Entered get all theatres method in theatre controller");
        List<Theater> allTheatres = theaterService.getAllTheaters();
        if (allTheatres.isEmpty()) {
            throw new NoRecordFoundException("theatres", "/theatres");
        }
        return allTheatres;
    }

    @Tag(name = "Get Theatre by zip code")
    @Operation(summary = "Gets all theatres with a specific zipcode")
    @GetMapping("/theatres/{zipcode}")
    public List<Theater> getAllTheatersByZipcode(@PathVariable String zipcode) throws NoRecordFoundException {
        logger.log(Level.INFO, "Entered get all theatres by zipcode method in theatre controller");
        List<Theater> theatersMatchingZipcode = theaterService.getTheatersByZipcode(zipcode);
        if(theatersMatchingZipcode.isEmpty()) {
            throw new NoRecordFoundException("theatres", "/theatres/{zipcode}");
        }
        return theatersMatchingZipcode;
    }

    @Tag(name = "Get Theatre by Id")
    @Operation(summary = "Get Theatres by Id")
    @GetMapping("/theatres/{theatre_id}")
    public Optional<Theater> getTheatreById(@PathVariable Integer theatre_id) throws NoRecordFoundException {
        logger.log(Level.INFO, "Entered get theatres by id method in theatre controller");
        Optional<Theater> theater = theaterService.getTheaterByTheaterId(theatre_id);
        if(theater.isPresent()) {
            throw new NoRecordFoundException("theatres", "/theatres/{theatre_id}");
        }
        return theater;
    }

    @Tag(name = "Add New Theatre")
    @Operation(summary = "Add new Theatre")
    @PostMapping("/theatres")
    public Theater addTheatre(@RequestBody Theater newTheater) throws Exception {
        logger.log(Level.INFO, "Entered add theatre method in theatre controller");
        Optional<Theater> theatre = theaterService.getTheaterById(newTheater.getId());
        if (theatre.isPresent()) {
            throw new RecordAlreadyExistsException("theatre", "/theatres");
        }
        return theaterService.saveTheater(newTheater);
    }

    @Tag(name = "Delete Theatre")
    @Operation(summary = "Delete a Theatre")
    @DeleteMapping("/theatres/delete/{theatre_id}")
    public String deleteTheatre(@PathVariable Integer theatre_id) throws Exception {
        logger.log(Level.INFO, "Entered delete theatre method in theatre controller");
        Optional<Theater> theatreToDelete = theaterService.getTheaterByTheaterId(theatre_id);
        if (theatreToDelete.isEmpty()) {
            throw new NoRecordFoundException("theatre", "/theatres/delete/{theatre_id}");
        }
        return theaterService.deleteTheater(theatre_id);
    }

    @Tag(name = "Update Theatre Record")
    @Operation(summary = "Update theatre record")
    @PostMapping("/theatres/update/{theatre_id}")
    public Theater updateTheatre(
            @RequestBody Theater newTheater,
            @PathVariable Integer theatre_id) throws Exception {
        logger.log(Level.INFO, "Entered update theatre method in theatre controller");
        Optional<Theater> theatreToUpdate = theaterService.getTheaterByTheaterId(theatre_id);
        if (theatreToUpdate.isEmpty()) {
            throw new NoRecordFoundException("theatre", "/theatres/update/{theatre_id}");
        }
        return theaterService.updateTheater(newTheater, theatre_id);
    }


}
