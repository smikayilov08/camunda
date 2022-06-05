package com.smof.data;

import org.springframework.http.HttpStatus;

import java.io.Serializable;

public class ErrorDTO implements Serializable {
    public String getMessage() {
        return message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public ErrorDTO(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }

    private String message;
    private HttpStatus status;
}
