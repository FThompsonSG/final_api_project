package com.sparta.thespringsons.finalapiproject.exceptions.recordalreadyexists;

import com.sparta.thespringsons.finalapiproject.exceptions.CustomResponse;
import com.sparta.thespringsons.finalapiproject.logger.OurLogger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.logging.Level;
import java.util.logging.Logger;

@ControllerAdvice
public class RecordAlreadyExistsAdvice {

    public static final Logger logger = Logger.getLogger(RecordAlreadyExistsException.class.getName());

    @ResponseBody
    @ExceptionHandler(RecordAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<CustomResponse> recordAlreadyExistsHandler(RecordAlreadyExistsException e) {
        OurLogger.setUpLogger(logger);
        logger.log(Level.WARNING, "RecordAlreadyExistsException thrown");
        CustomResponse response = new CustomResponse(e.getMessage(), 400, "RecordAlreadyExistsException", e.getPath());
        return ResponseEntity
                .badRequest()
                .body(response);
    }
}
