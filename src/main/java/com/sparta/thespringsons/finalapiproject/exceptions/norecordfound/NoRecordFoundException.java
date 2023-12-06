package com.sparta.thespringsons.finalapiproject.exceptions.norecordfound;

public class NoRecordFoundException extends Exception {

    private String path;

    public NoRecordFoundException(String recordType, String path) {
        super("Error: No " + recordType + " found");
        this.path = path;
    }

    public String getPath() {
        return path;
    }

}
