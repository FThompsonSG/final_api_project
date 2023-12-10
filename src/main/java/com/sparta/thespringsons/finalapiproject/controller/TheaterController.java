package com.sparta.thespringsons.finalapiproject.controller;

import com.sparta.thespringsons.finalapiproject.exceptions.norecordfound.NoRecordFoundException;
import com.sparta.thespringsons.finalapiproject.exceptions.recordalreadyexists.RecordAlreadyExistsException;
import com.sparta.thespringsons.finalapiproject.logger.OurLogger;
import com.sparta.thespringsons.finalapiproject.model.entities.Theater;
import com.sparta.thespringsons.finalapiproject.model.services.ApiKeyService;
import com.sparta.thespringsons.finalapiproject.model.services.TheaterService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ArraySchema;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@OpenAPIDefinition(
        info = @Info(
                title = "Tech242 MFlix API",
                version = "1.0",
                description = "Summary: \n" +
                        "\n" +
                        " An open API developed by Tech 242 to allow users to access MongoDB's" +
                        " sample MFlix database. Currently, the system allows access to the movies, " +
                        "embedded movies, users, theaters and comments collection. " +
                        "Any users can create or read data, but an API key is needed to update or delete " +
                        "records. Keys should be placed under a header labeled 'key'. A key can be retrieved" +
                        " from the Key API listed below. \n\n" +
                        "\n " +
                        "Consumption Guidelines: \n " +
                        "\n" +
                        "To effectively use our open API, we recommend carefully choosing" +
                        " parameters for given queries, as queries with larger results will typically tend to take " +
                        "longer to return. Some get operations can perform subsequent gets faster given that there is " +
                        "no Create, Update or Deletes to a collection - it is recommended to batch Create, Updates or Deletes " +
                        " consecutively as to reduce possible downtime for Get Requests. Sample request bodies can be found " +
                        "below under the Schema heading. \n" +
                        "\n" +
                        "Additional information: \n " +
                        "\n" +
                        "Currently, we are under the base URL of http://localhost:8080.\n" +
                        " " +
                        "Please contact akhairuddin@spartaglobal.com for any further queries or information regarding " +
                        "Tech242 MFlix API"
        )
)
@RestController
public class TheaterController {

    public static final Logger logger = Logger.getLogger(CommentController.class.getName());

    private final TheaterService theaterService;
    private final ApiKeyService apiKeyService;
    @Autowired
    public TheaterController(TheaterService theaterService, ApiKeyService apiKeyService) {
        this.theaterService = theaterService;
        this.apiKeyService = apiKeyService;
        OurLogger.setUpLogger(logger);
    }

    @Tag(name = "Theater API")
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

    @Tag(name = "Theater API")
    @Operation(summary = "Gets all theaters with a specific zipcode")
    @GetMapping("/theater/get/byZipCode/{zipcode}")
    public List<Theater> getAllTheatersByZipcode(@PathVariable String zipcode) throws NoRecordFoundException {
        logger.log(Level.INFO, "Entered get all theaters by zipcode method in theater controller");
        List<Theater> theatersMatchingZipcode = theaterService.getTheatersByZipcode(zipcode);
        if(theatersMatchingZipcode.isEmpty()) {
            throw new NoRecordFoundException("theaters", "/theater/get/byZipcode/{zipcode}");
        }
        return theatersMatchingZipcode;
    }

    @Tag(name = "Theater API")
    @Operation(summary = "Get Theaters by Id")
    @GetMapping("/theater/get/byId/{theater_id}")
    public Optional<Theater> getTheaterById(@PathVariable Integer theater_id) throws NoRecordFoundException {
        logger.log(Level.INFO, "Entered get theaters by id method in theater controller");
        Optional<Theater> theater = theaterService.getTheaterByTheaterId(theater_id);
        if(theater.isEmpty()) {
            throw new NoRecordFoundException("theaters", "/theater/get/byId/{theater_id}");
        }
        return theater;
    }

    @Tag(name = "Theater API")
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

    @Tag(name = "Theater API")
    @Operation(summary = "Delete a Theater")
    @DeleteMapping("/theater/delete/byId/{theater_id}")
    public String deleteTheater(@PathVariable Integer theater_id,@RequestHeader(name = "Key") String apiKey) throws Exception {
        if(!apiKeyService.checkIfApiKeyExists(apiKey)){
            return "Invalid Api-Key entered";
        }
        logger.log(Level.INFO, "Entered delete theater method in theater controller");
        Optional<Theater> theaterToDelete = theaterService.getTheaterByTheaterId(theater_id);
        if (theaterToDelete.isEmpty()) {
            throw new NoRecordFoundException("theaters", "/theater/delete/byId/{theater_id}");
        }
        return theaterService.deleteTheater(theater_id);
    }

    @Tag(name = "Theater API")
    @Operation(summary = "Update theater record")
    @PostMapping("/theater/update/byId/{theater_id}")
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
            throw new NoRecordFoundException("theatres", "/theater/update/byId/{theater_id}");
        }
        return Optional.ofNullable(theaterService.updateTheater(newTheater, theater_id));
    }


}
