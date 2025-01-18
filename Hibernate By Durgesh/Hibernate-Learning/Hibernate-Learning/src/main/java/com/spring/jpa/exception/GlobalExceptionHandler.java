package com.spring.jpa.exception;

import com.spring.jpa.payload.EmployeeDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ExceptionDetails> handleEmployeeNotFoundException(
            EmployeeNotFoundException ex, WebRequest request) throws Exception
    {
        ExceptionDetails details = new ExceptionDetails(
                LocalDateTime.now(), ex.getMessage(),
                request.getDescription(false));

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(details);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDetails> handleAllException(
            EmployeeNotFoundException ex, WebRequest request) throws Exception
    {
        ExceptionDetails details = new ExceptionDetails(
                LocalDateTime.now(), ex.getMessage(),
                request.getDescription(false));

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(details);
    }
}
