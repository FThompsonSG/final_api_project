package com.sparta.thespringsons.finalapiproject.security;

import java.util.Random;
import java.util.UUID;

public class ApiKeyGenerator {

    public static String generateApiKey() {
        // 5 Digit Api Key
        int randomNumber = new Random().nextInt(90000) + 10000;
        return String.valueOf(randomNumber);
    }
}
