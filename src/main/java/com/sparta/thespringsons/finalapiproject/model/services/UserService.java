package com.sparta.thespringsons.finalapiproject.model.services;

import com.sparta.thespringsons.finalapiproject.model.entities.User;
import com.sparta.thespringsons.finalapiproject.model.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getByName(String name) {
        return userRepository.findByName(name);
    }

    public Optional<User> getById(String id) {
        return userRepository.findById(id);
    }


}
