package com.example.user_app.infrustracture.exceptionhandler;

import com.example.user_app.infrustracture.response.models.ErrorResponse;
import com.example.user_app.infrustracture.shared.exceptions.BadRequestException;
import com.example.user_app.infrustracture.shared.exceptions.DataNotFoundException;
import com.example.user_app.infrustracture.shared.exceptions.ForBiddenException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(value = {BadRequestException.class})
    public ResponseEntity<ErrorResponse> exception(BadRequestException exception) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        ErrorResponse errorResponse = new ErrorResponse(now.format(dtf), 400, exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value = {DataNotFoundException.class})
    public ResponseEntity<ErrorResponse> exception(DataNotFoundException exception) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        ErrorResponse errorResponse = new ErrorResponse(now.format(dtf), 404, exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value = {ForBiddenException.class})
    public ResponseEntity<ErrorResponse> exception(ForBiddenException exception) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        ErrorResponse errorResponse = new ErrorResponse(now.format(dtf), 403, exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.FORBIDDEN);
    }
}
