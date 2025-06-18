package com.fitness.exception;

import com.fitness.rest.RestResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class FitnessExceptionHandler {
    @ExceptionHandler(value = {Exception.class,FitnessException.class})
    public ResponseEntity<?> handleException(FitnessException e){
        String message = e.getFitnessErrorMessage().getMessage();
        String code = e.getFitnessErrorMessage().getCode();
        return ResponseEntity.badRequest().body(RestResponse.error(code,message));
    }
}
