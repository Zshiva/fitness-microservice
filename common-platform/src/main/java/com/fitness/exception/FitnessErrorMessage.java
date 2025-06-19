package com.fitness.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;


public enum FitnessErrorMessage {
    USER_NOT_FOUND("F1","User not found"),
    INVALID_REQUEST("F2", "Invalid_Request"),
    ACTIVITY_NOT_FOUND_FOR_GIVEN_USERID("F3","Activity not found" );
    private String code;
    private String message;

    FitnessErrorMessage(String code, String message){
        this.code = code;
        this.message = message;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

