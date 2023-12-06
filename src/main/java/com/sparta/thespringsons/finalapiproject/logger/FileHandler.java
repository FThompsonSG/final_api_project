package com.sparta.thespringsons.finalapiproject.logger;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

public class FileHandler {
    public static void setUpFileHandler(Logger logger) {
        try {
            java.util.logging.FileHandler fileHandler = new java.util.logging.FileHandler("src/main/resources/logFile.log", true);
            fileHandler.setLevel(Level.WARNING);
            fileHandler.setFormatter(new FileCustomFormatter());
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
