package com.thoughtworks.capacity.gtb.mvc.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ErrorResult {

    private String message;
    private String statusCode;

    public ErrorResult(String statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}
