package com.sparta.thespringsons.finalapiproject.model.services;

import com.sparta.thespringsons.finalapiproject.MflixApplication;
import com.sparta.thespringsons.finalapiproject.logger.OurLogger;
import com.sparta.thespringsons.finalapiproject.model.entities.User;
import com.sparta.thespringsons.finalapiproject.model.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class UserService {

    public static final Logger logger = Logger.getLogger(UserService.class.getName());

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        OurLogger.setUpLogger(logger);
        this.userRepository = userRepository;
    }

    public User getByName(String name) {
        logger.log(Level.INFO, "Entered get user by name method in user service");
        return userRepository.findByName(name);
    }

    public Optional<User> getById(String id) {
        logger.log(Level.INFO, "Entered get user by id method in user service");
        return userRepository.findById(id);
    }


}
