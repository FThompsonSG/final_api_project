package com.sparta.thespringsons.finalapiproject.controller;

import com.sparta.thespringsons.finalapiproject.exceptions.norecordfound.NoRecordFoundException;
import com.sparta.thespringsons.finalapiproject.exceptions.recordalreadyexists.RecordAlreadyExistsException;
import com.sparta.thespringsons.finalapiproject.logger.OurLogger;
import com.sparta.thespringsons.finalapiproject.model.entities.User;
import com.sparta.thespringsons.finalapiproject.model.services.ApiKeyService;
import com.sparta.thespringsons.finalapiproject.model.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class UserController {

    public static final Logger logger = Logger.getLogger(UserController.class.getName());

    private final ApiKeyService apiKeyService;
    private final UserService userService;

    @Autowired
    public UserController(HttpServletRequest request, ApiKeyService apiKeyService, UserService userService) {
        this.apiKeyService = apiKeyService;
        this.userService = userService;
        OurLogger.setUpLogger(logger);
    }

    @Tag(name = "Get User by Name")
    @Operation(summary = "Get User by Name")
    @GetMapping("/user/get/byName/{name}")
    public List<User> getUsersByName(@PathVariable String name) throws NoRecordFoundException {


        logger.log(Level.INFO, "Entered get user by name method in users controller");
        List<User> users = userService.getByName(name);
        if (users.isEmpty()) {
            throw new NoRecordFoundException("users", "/user/byName/{name}");
        }
        return users;
    }

    @Tag(name = "Get User by ID")
    @Operation(summary = "Get User by ID")
    @GetMapping("/user/get/byId/{id}")
    public Optional<User> getUserById(@PathVariable String id) throws NoRecordFoundException {
        logger.log(Level.INFO, "Entered get user by id method in users controller");
        Optional<User> user = userService.getById(id);
        if (user.isEmpty()) {
            throw new NoRecordFoundException("users", "/user/byId/{id}");
        }
        return user;
    }

    @Tag(name = "Get User by Email")
    @Operation(summary = "Get User by Email")
    @GetMapping("/user/get/byEmail/{email}")
    public List<User> getUsersByEmail(@PathVariable String email) throws NoRecordFoundException {
        logger.log(Level.INFO, "Entered get user by email method in users controller");
        List<User> users = userService.getByEmail(email);
        if (users.isEmpty()) {
            throw new NoRecordFoundException("users", "/user/byEmail/{email}");
        }
        return users;
    }

    @Tag(name = "Add New User")
    @Operation(summary = "Add new User")
    @PostMapping("/user/add")
    public Optional<User> addUser(@RequestBody User newUser) throws Exception {

        logger.log(Level.INFO, "Entered add user method in user controller");
        Optional<User> user = userService.getById(newUser.getId());
        if (user.isPresent()) {
            throw new RecordAlreadyExistsException("user", "/user/add");
        }
        return userService.saveUser(newUser);
    }

    @Tag(name = "Delete User")
    @Operation(summary = "Delete a User")
    @DeleteMapping("/user/delete/byId/{id}")
    public Optional<User> deleteUser(@PathVariable String id,@RequestHeader(name = "Key") String apiKey) throws Exception {

        if(!apiKeyService.checkIfApiKeyExists(apiKey)){
            return Optional.empty();
        };

        logger.log(Level.INFO, "Entered delete user method in user controller");
        Optional<User> userToDelete = userService.getById(id);
        if (userToDelete.isEmpty()) {
            throw new NoRecordFoundException("user", "/user/delete/{id}");
        }
        return userService.deleteUser(id);
    }

    @Tag(name = "Update User Record")
    @Operation(summary = "Update user record")
    @PostMapping("/user/update/byId/{id}")
    public Optional<User> updateUser(
            @RequestBody User newUser,
            @PathVariable String id,
            @RequestHeader(name = "Key") String apiKey) throws Exception {

        if(!apiKeyService.checkIfApiKeyExists(apiKey)){
            return Optional.empty();
        };

        logger.log(Level.INFO, "Entered update user method in user controller");
        Optional<User> userToUpdate = userService.getById(id);
        if (userToUpdate.isEmpty()) {
            throw new NoRecordFoundException("user", "/user/update/{id}");
        }
        return userToUpdate;
    }

}
