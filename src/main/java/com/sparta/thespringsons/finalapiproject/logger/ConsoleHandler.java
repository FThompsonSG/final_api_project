package com.sparta.thespringsons.finalapiproject.logger;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsoleHandler {
    public static void setUpConsoleHandler(Logger logger) {
        java.util.logging.ConsoleHandler consoleHandler = new java.util.logging.ConsoleHandler();
        consoleHandler.setLevel(Level.INFO);
        consoleHandler.setFormatter(new ConsoleCustomFormatter());
        logger.addHandler(consoleHandler);
    }
}
