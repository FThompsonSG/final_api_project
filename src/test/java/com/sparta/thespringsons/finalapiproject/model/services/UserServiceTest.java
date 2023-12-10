package com.sparta.thespringsons.finalapiproject.model.services;

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
        Assertions.assertEquals("kit_harington@gameofthron.es", userService.getByName("Jon Snow").get(0).getEmail());
    }

    @Test
    @DisplayName("Test get User By ID")
    void testUserById() {
        Assertions.assertEquals("kit_harington@gameofthron.es", userService.getById("59b99db9cfa9a34dcd7885bf").get().getEmail());
    }

    @Test
    @DisplayName("Test get User By Email")
    void testGetUserByEmail() {
        Assertions.assertEquals("Jon Snow", userService.getByEmail("kit_harington@gameofthron.es").get(0).getName());
    }

}
