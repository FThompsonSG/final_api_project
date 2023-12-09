package com.sparta.thespringsons.finalapiproject.controller;

import com.sparta.thespringsons.finalapiproject.exceptions.norecordfound.NoRecordFoundException;
import com.sparta.thespringsons.finalapiproject.exceptions.recordalreadyexists.RecordAlreadyExistsException;
import com.sparta.thespringsons.finalapiproject.logger.OurLogger;
import com.sparta.thespringsons.finalapiproject.model.entities.Theater;
import com.sparta.thespringsons.finalapiproject.model.services.ApiKeyService;
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
    private final ApiKeyService apiKeyService;
    @Autowired
    public TheatreController(TheaterService theaterService, ApiKeyService apiKeyService) {
        this.theaterService = theaterService;
        this.apiKeyService = apiKeyService;
        OurLogger.setUpLogger(logger);
    }

    @Tag(name = "Get All Theaters")
    @Operation(summary = "Gets all theaters")
    @GetMapping("/theater")
    public List<Theater> getAllTheaters() throws NoRecordFoundException {
        logger.log(Level.INFO, "Entered get all theaters method in theater controller");
        List<Theater> allTheaters = theaterService.getAllTheaters();
        if (allTheaters.isEmpty()) {
            throw new NoRecordFoundException("theaters", "/theater");
        }
        return allTheaters;
    }

    @Tag(name = "Get Theater by zip code")
    @Operation(summary = "Gets all theaters with a specific zipcode")
    @GetMapping("/theater/byZipCode/{zipcode}")
    public List<Theater> getAllTheatersByZipcode(@PathVariable String zipcode) throws NoRecordFoundException {
        logger.log(Level.INFO, "Entered get all theaters by zipcode method in theater controller");
        List<Theater> theatersMatchingZipcode = theaterService.getTheatersByZipcode(zipcode);
        if(theatersMatchingZipcode.isEmpty()) {
            throw new NoRecordFoundException("theaters", "/theater/byZipcode/{zipcode}");
        }
        return theatersMatchingZipcode;
    }

    @Tag(name = "Get Theater by Id")
    @Operation(summary = "Get Theaters by Id")
    @GetMapping("/theater/byId/{theater_id}")
    public Optional<Theater> getTheaterById(@PathVariable Integer theater_id) throws NoRecordFoundException {
        logger.log(Level.INFO, "Entered get theaters by id method in theater controller");
        Optional<Theater> theater = theaterService.getTheaterByTheaterId(theater_id);
        if(theater.isEmpty()) {
            throw new NoRecordFoundException("theaters", "/theater/byId/{theater_id}");
        }
        return theater;
    }

    @Tag(name = "Add New Theater")
    @Operation(summary = "Add new Theater")
    @PostMapping("/theater/add")
    public Optional<Theater> addTheater(@RequestBody Theater newTheater) throws Exception {
        logger.log(Level.INFO, "Entered add theater method in theater controller");
        Optional<Theater> theater = theaterService.getTheaterById(newTheater.getId());
        if (theater.isPresent()) {
            throw new RecordAlreadyExistsException("theaters", "/theater/add");
        }
        return Optional.ofNullable(theaterService.saveTheater(newTheater));
    }

    @Tag(name = "Delete Theater")
    @Operation(summary = "Delete a Theater")
    @DeleteMapping("/theater/delete/{theater_id}")
    public String deleteTheater(@PathVariable Integer theater_id,@RequestHeader(name = "Key") String apiKey) throws Exception {
        if(!apiKeyService.checkIfApiKeyExists(apiKey)){
            return "Invalid Api-Key entered";
        }
        logger.log(Level.INFO, "Entered delete theater method in theater controller");
        Optional<Theater> theaterToDelete = theaterService.getTheaterByTheaterId(theater_id);
        if (theaterToDelete.isEmpty()) {
            throw new NoRecordFoundException("theaters", "/theater/delete/{theater_id}");
        }
        return theaterService.deleteTheater(theater_id);
    }

    @Tag(name = "Update Theater Record")
    @Operation(summary = "Update theater record")
    @PostMapping("/theater/update/{theater_id}")
    public Optional<Theater> updateTheater(
            @RequestBody Theater newTheater,
            @PathVariable Integer theater_id,
            @RequestHeader(name = "Key") String apiKey) throws Exception {
        if(!apiKeyService.checkIfApiKeyExists(apiKey)){
            return Optional.empty();
        }
        logger.log(Level.INFO, "Entered update theater method in theater controller");
        Optional<Theater> theaterToUpdate = theaterService.getTheaterByTheaterId(theater_id);
        if (theaterToUpdate.isEmpty()) {
            throw new NoRecordFoundException("theatres", "/theater/update/{theater_id}");
        }
        return Optional.ofNullable(theaterService.updateTheater(newTheater, theater_id));
    }


}
