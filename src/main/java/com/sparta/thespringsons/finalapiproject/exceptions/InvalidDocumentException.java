package com.sparta.thespringsons.finalapiproject.exceptions;

public class InvalidDocumentException extends RuntimeException {
    public InvalidDocumentException(String message) {
        super(message);
    }
}
