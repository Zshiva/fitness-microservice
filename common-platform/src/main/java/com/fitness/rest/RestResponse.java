package com.fitness.rest;

import io.soabase.recordbuilder.core.RecordBuilder;

@RecordBuilder
public record RestResponse<T>(String code, String message, T data) {

    public static <T> RestResponse success(){
        return RestResponseBuilder.builder()
                .code("0")
                .message("SUCCESS")
                .data(null)
                .build();
    }
    public static <T> RestResponse success(T data) {
        return RestResponseBuilder.builder()
                .code("0")
                .message("SUCCESS")
                .data(data)
                .build();
    }
    public static RestResponse error(String code, String message) {
        return RestResponseBuilder.builder()
                .code(code)
                .message(message)
                .build();
    }

    public static RestResponse error(String message) {
        return RestResponseBuilder.builder()
                .code("400")
                .message(message)
                .build();
    }
}
