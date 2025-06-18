package com.fitness.exception;

import com.fitness.rest.RestResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<?> handle(Exception exception){
        return ResponseEntity.badRequest().body(RestResponse.error(exception.getMessage()));
    }
}