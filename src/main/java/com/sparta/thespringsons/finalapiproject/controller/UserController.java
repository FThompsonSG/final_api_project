package com.sparta.thespringsons.finalapiproject.controller;

import com.sparta.thespringsons.finalapiproject.MflixApplication;
import com.sparta.thespringsons.finalapiproject.logger.OurLogger;
import com.sparta.thespringsons.finalapiproject.model.entities.User;
import com.sparta.thespringsons.finalapiproject.model.repositories.UserRepository;
import com.sparta.thespringsons.finalapiproject.model.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/userbyname/{name}")
    public User getUserByName(@PathVariable String name) {
        logger.log(Level.INFO, "Entered get user by name method in user controller");
        return userService.getByName(name);
    }

    @GetMapping("/userbyid/{id}")
    public Optional<User> getUserById(@PathVariable String id) {
        logger.log(Level.INFO, "Entered get user by id method in user controller");
        return userService.getById(id);
    }

}
