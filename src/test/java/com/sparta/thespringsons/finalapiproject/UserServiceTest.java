package com.sparta.thespringsons.finalapiproject;

import com.sparta.thespringsons.finalapiproject.model.repositories.UserRepository;
import com.sparta.thespringsons.finalapiproject.model.services.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    @DisplayName("Test get User By Name")
    void testUserByName() {
        Assertions.assertEquals("kit_harington@gameofthron.es", userService.getByName("Jon Snow").getEmail());
    }

    @Test
    @DisplayName("Test get User By ID")
    void testUserById() {
        Assertions.assertEquals("kit_harington@gameofthron.es", userService.getById("59b99db9cfa9a34dcd7885bf").get().getEmail());
    }

}
