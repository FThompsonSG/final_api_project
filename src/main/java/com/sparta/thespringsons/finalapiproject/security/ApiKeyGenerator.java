package com.sparta.thespringsons.finalapiproject.security;

import java.util.Random;

public class ApiKeyGenerator {

    public static String generateApiKey() {
        // 8 Digit Api Key
        int randomNumber = new Random().nextInt(90000000) + 10000000;
        return String.valueOf(randomNumber);
    }
}
