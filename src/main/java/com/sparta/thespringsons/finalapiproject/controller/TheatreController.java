package com.sparta.thespringsons.finalapiproject.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class TheatreController {
//
//    private final MovieRepository movieRepository;
//    private final CommentsRepository commentsRepository;
//    private final TheatreRepository theatreRepository;
//
//    @Autowired
//    public TheatreController(MovieRepository movieRepository,
//                             CommentsRepository commentsRepository,
//                             TheatreRepository theatreRepository) {
//        this.movieRepository = movieRepository;
//        this.commentsRepository = commentsRepository;
//        this.theatreRepository = theatreRepository;
//    }
//
//    @Tag(name = "Get All Theatres")
//    @Operation(summary = "Gets all theatres")
//    @GetMapping("/theatres")
//    public List<TheatreDTO> getAllTheatres(){
//      return theatreRepository.findall();
//    }
//
//    @Tag(name = "Get Theatre by zip code")
//    @Operation(summary = "Gets all theatres with a specific zipcode")
//    @GetMapping("/theatres/{zipcode}")
//    public List<TheatreDTO> getAllTheatres(@PathVariable Integer zipcode){
//      return theatreRepository.findById(zipcode);
//    }
//
//    @Tag(name = "Get Theatre by Id")
//    @Operation(summary = "Get Theatres by Id")
//    @GetMapping("/theatres/{id}")
//    public List<TheatreDTO> getAllTheatres(@PathVariable Integer id){
//      return theatreRepository.findById(id);
//    }
//
//    @Tag(name = "Add New Theatre")
//    @Operation(summary = "Add new Theatre")
//    @PostMapping("/theatres")
//    public TheatreDTO addTheatre(@RequestBody TheatreDTO newTheatre){
//      return theatreRepository.save(newTheatre);
//    }
//
//    @Tag(name = "Delete Theatre")
//    @Operation(summary = "Delete a Theatre")
//    @DeleteMapping("/theatres/delete/{id}")
//    public TheatreDTO addTheatre(@PathVariable Integer id){
//        TheatreDTO theatre = null;
//
//        return theatre;
//    }
//
//    @Tag(name = "Update Theatre Record")
//    @Operation(summary = "Update theatre record")
//    @PatchMapping("/theatres/update/{id}")
//    public TheatreDTO addTheatre(@RequestBody TheatreDTO newTheatre, @PathVariable Integer id){
//        TheatreDTO theatre = null;
//
//        return theatre;
//    }


}
