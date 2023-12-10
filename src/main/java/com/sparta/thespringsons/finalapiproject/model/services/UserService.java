package com.sparta.thespringsons.finalapiproject.model.services;

import com.sparta.thespringsons.finalapiproject.logger.OurLogger;
import com.sparta.thespringsons.finalapiproject.model.entities.User;
import com.sparta.thespringsons.finalapiproject.model.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
@Component
public class UserService {

    public static final Logger logger = Logger.getLogger(UserService.class.getName());

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        OurLogger.setUpLogger(logger);
        this.userRepository = userRepository;
    }

    public List<User> getByName(String name) {
        logger.log(Level.INFO, "Entered get user by name method in user service");
        List<User> allUsers = userRepository.findAll();
        List<User> matchingUsers = new ArrayList<>();
        for (User user : allUsers) {
            if (user.getName().contains(name)) {
                matchingUsers.add(user);
            }
        }
        return matchingUsers;
    }

    public Optional<User> getById(String id) {
        logger.log(Level.INFO, "Entered get user by id method in user service");
        return userRepository.findById(id);
    }


    public Optional<User> saveUser(User newUser) {
        return Optional.of(userRepository.save(newUser));
    }

    public Optional<User> deleteUser(String id) {
        Optional<User> userToDelete = userRepository.findById(id);
        userRepository.deleteById(id);
        return userToDelete;
    }

    public Optional<User> updateUser(User user, String id) throws Exception {
        Optional<User> retrievedUser = userRepository.findById(id);
        User userToUpdate = retrievedUser.get();
        userToUpdate = user;
        userToUpdate.setId(id);
        userRepository.save(userToUpdate);
        return Optional.of(userToUpdate);
    }

    public List<User> getByEmail(String email) {
        logger.log(Level.INFO, "Entered get user by email method in user service");
        List<User> allUsers = userRepository.findAll();
        List<User> matchingUsers = new ArrayList<>();
        for (User user : allUsers) {
            if (user.getEmail().contains(email)) {
                matchingUsers.add(user);
            }
        }
        return matchingUsers;
    }
}
