package com.fitness.exception;

import com.fitness.rest.RestResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class FitnessExceptionHandler {
    @ExceptionHandler(value = {Exception.class,FitnessException.class})
    public ResponseEntity<?> handleException(FitnessException exception){
        String message = exception.getFitnessErrorMessage().getMessage();
        String code = exception.getFitnessErrorMessage().getCode();
        return ResponseEntity.badRequest().body(RestResponse.error(code,message));
    }
}
