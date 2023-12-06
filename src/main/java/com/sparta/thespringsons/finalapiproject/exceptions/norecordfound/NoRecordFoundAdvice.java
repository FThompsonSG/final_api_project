package com.sparta.thespringsons.finalapiproject.exceptions.norecordfound;

import com.sparta.thespringsons.finalapiproject.exceptions.CustomResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class NoRecordFoundAdvice {

    @ResponseBody
    @ExceptionHandler(NoRecordFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<CustomResponse> noRecordFoundHandler(NoRecordFoundException e) {
        CustomResponse response = new CustomResponse(e.getMessage(), 404, "NoRecordFoundException", e.getPath());
        return ResponseEntity
                .badRequest()
                .body(response);
    }

}
