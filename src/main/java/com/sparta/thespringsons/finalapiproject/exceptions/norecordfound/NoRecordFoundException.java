package com.sparta.thespringsons.finalapiproject.exceptions.norecordfound;

public class NoRecordFoundException extends Exception {

    private String path;

    public NoRecordFoundException(String message, String path) {
        super("Error: No " + message + " found");
        this.path = path;
    }

    public String getPath() {
        return path;
    }

}
