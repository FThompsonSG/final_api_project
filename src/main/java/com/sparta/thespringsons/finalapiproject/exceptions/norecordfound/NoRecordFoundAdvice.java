package com.sparta.thespringsons.finalapiproject.exceptions.norecordfound;

import com.sparta.thespringsons.finalapiproject.controller.CommentController;
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
public class NoRecordFoundAdvice {

    public static final Logger logger = Logger.getLogger(NoRecordFoundAdvice.class.getName());

    @ResponseBody
    @ExceptionHandler(NoRecordFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<CustomResponse> noRecordFoundHandler(NoRecordFoundException e) {
        OurLogger.setUpLogger(logger);
        logger.log(Level.WARNING, "NoRecordFoundException thrown");
        CustomResponse response = new CustomResponse(e.getMessage(), 404, "NoRecordFoundException", e.getPath());
        return ResponseEntity
                .badRequest()
                .body(response);
    }

}
