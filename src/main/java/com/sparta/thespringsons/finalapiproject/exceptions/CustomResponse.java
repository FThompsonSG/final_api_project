package com.sparta.thespringsons.finalapiproject.exceptions;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class CustomResponse {

    private String message;
    private int statusCode;
    private String localDateTime;
    private String exception;
    private String path;

    public CustomResponse(String message, int statusCode, String exception, String path) {
        String localDate = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
        String localTime = LocalTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME);
        this.message = message;
        this.statusCode = statusCode;
        this.localDateTime = localDate + " " + localTime;
        this.exception = exception;
        this.path = path;
    }

    public String getMessage() {
        return message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getLocalDateTime() {
        return localDateTime;
    }

    public String getException() {
        return exception;
    }

    public String getPath() {
        return path;
    }
}
