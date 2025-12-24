package com.learningspringboot.finsmart.exception;

import java.time.LocalDateTime;

public class ApiError {

    private int status;
    private String message;
    private LocalDateTime dateTime;

    public ApiError(int status, String message) {
        this.status = status;
        this.message = message;
        this.dateTime = LocalDateTime.now();
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
