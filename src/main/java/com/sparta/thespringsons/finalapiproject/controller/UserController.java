package com.sparta.thespringsons.finalapiproject.controller;

import com.sparta.thespringsons.finalapiproject.MflixApplication;
import com.sparta.thespringsons.finalapiproject.exceptions.norecordfound.NoRecordFoundException;
import com.sparta.thespringsons.finalapiproject.logger.OurLogger;
import com.sparta.thespringsons.finalapiproject.model.entities.Comment;
import com.sparta.thespringsons.finalapiproject.model.entities.User;
import com.sparta.thespringsons.finalapiproject.model.repositories.UserRepository;
import com.sparta.thespringsons.finalapiproject.model.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class UserController {

    public static final Logger logger = Logger.getLogger(UserController.class.getName());

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
        OurLogger.setUpLogger(logger);
    }

    @Tag(name = "Get User by Name")
    @Operation(summary = "Get User by Name")
    @GetMapping("/userbyname/{name}")
    public Optional<User> getUserByName(@PathVariable String name) throws NoRecordFoundException {
        logger.log(Level.INFO, "Entered get user by name method in users controller");
        Optional<User> user = userService.getByName(name);
        if (user.isPresent()) {
            throw new NoRecordFoundException("users", "/userbyname/{name}");
        }
        return user;
    }

    @Tag(name = "Get User by ID")
    @Operation(summary = "Get User by ID")
    @GetMapping("/userbyid/{id}")
    public Optional<User> getUserById(@PathVariable String id) throws NoRecordFoundException {
        logger.log(Level.INFO, "Entered get user by id method in users controller");
        Optional<User> user = userService.getById(id);
        if (user.isPresent()) {
            throw new NoRecordFoundException("users", "/userbyid/{id}");
        }
        return user;
    }

}
