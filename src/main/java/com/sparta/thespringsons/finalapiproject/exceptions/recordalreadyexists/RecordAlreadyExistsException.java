package com.sparta.thespringsons.finalapiproject.exceptions.recordalreadyexists;

public class RecordAlreadyExistsException extends Exception {

    private String path;
    public RecordAlreadyExistsException(String recordType, String path) {
        super("Error: " + recordType + " with given id already exists");
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
