package com.sparta.thespringsons.finalapiproject.logger;

import java.util.logging.Level;
import java.util.logging.Logger;

public class OurLogger {
    public static void setUpLogger(Logger logger) {
        logger.setUseParentHandlers(false);
        logger.setLevel(Level.ALL);
        FileHandler.setUpFileHandler(logger);
        ConsoleHandler.setUpConsoleHandler(logger);
    }
}
