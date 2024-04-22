package com.abhinav3254.flight.exception;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomException.class)
    private ResponseEntity<?> handleCustomException(CustomException e) {
        ExceptionWrapper exceptionWrapper = new ExceptionWrapper(e.getMessage());
        return ResponseEntity.status(e.getHttpStatus()).body(exceptionWrapper);
    }

    @ExceptionHandler(NullPointerException.class)
    private ResponseEntity<?> handleNullPointerException(NullPointerException e) {
        ExceptionWrapper exceptionWrapper = new ExceptionWrapper(e.getMessage());
        return ResponseEntity.status(400).body(exceptionWrapper);
    }

    @ExceptionHandler(Exception.class)
    private ResponseEntity<?> handleException(Exception e) {
        ExceptionWrapper exceptionWrapper = new ExceptionWrapper(e.getMessage());
        return ResponseEntity.status(500).body(exceptionWrapper);
    }

}
