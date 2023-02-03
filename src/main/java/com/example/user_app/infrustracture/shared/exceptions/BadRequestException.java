package com.example.user_app.infrustracture.shared.exceptions;


public class BadRequestException extends Exception{
    public BadRequestException(String message) {
        super(message);
    }
}
