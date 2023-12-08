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
    public Optional<Theater> getTheatresById(@PathVariable Integer theater_id) {
        return theaterService.getTheaterByTheaterId(theater_id);
    }

    @Tag(name = "Add New Theater")
    @Operation(summary = "Add new Theater")
    @PostMapping("/theaters")
    public Optional<Theater> addTheater(@RequestBody Theater newTheater) throws Exception {
        logger.log(Level.INFO, "Entered add theater method in theater controller");
        Optional<Theater> theater = theaterService.getTheaterById(newTheater.getId());
        if (theater.isPresent()) {
            throw new RecordAlreadyExistsException("theater", "/theaters");
        }
        return Optional.ofNullable(theaterService.saveTheater(newTheater));
    }

    @Tag(name = "Delete Theater")
    @Operation(summary = "Delete a Theater")
    @DeleteMapping("/theaters/delete/{theater_id}")
    public String deleteTheater(@PathVariable Integer theater_id) throws Exception {
        logger.log(Level.INFO, "Entered delete theater method in theater controller");
        Optional<Theater> theaterToDelete = theaterService.getTheaterByTheaterId(theater_id);
        if (theaterToDelete.isEmpty()) {
            throw new NoRecordFoundException("theater", "/theaters/delete/{theater_id}");
        }
        return theaterService.deleteTheater(theater_id);
    }

    @Tag(name = "Update Theater Record")
    @Operation(summary = "Update theater record")
    @PostMapping("/theaters/update/{theater_id}")
    public Optional<Theater> updateTheater(
            @RequestBody Theater newTheater,
            @PathVariable Integer theater_id) throws Exception {
        logger.log(Level.INFO, "Entered update theater method in theater controller");
        Optional<Theater> theaterToUpdate = theaterService.getTheaterByTheaterId(theater_id);
        if (theaterToUpdate.isEmpty()) {
            throw new NoRecordFoundException("theatre", "/theaters/update/{theater_id}");
        }
        return Optional.ofNullable(theaterService.updateTheater(newTheater, theater_id));
    }


}
