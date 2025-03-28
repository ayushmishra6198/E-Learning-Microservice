package com.service.category.exceptions;


import com.service.category.dto.CustomMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CustomMessage> handleResourceNotFound(ResourceNotFoundException ex) {
        CustomMessage customMessage = new CustomMessage();
        customMessage.setMessage(ex.getMessage());
        customMessage.setSuccess(false);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(customMessage);

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationError(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);

        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);


    }

//    @ExceptionHandler(AuthorizationDeniedException.class)
//    public ResponseEntity<CustomMessage> handleAuthDeniedException(AuthorizationDeniedException ex) {
//        CustomMessage customMessage = new CustomMessage();
//        customMessage.setSuccess(false);
//        customMessage.setMessage(ex.getMessage());
//        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(customMessage);
//    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<CustomMessage> handleSQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException ex) {
        CustomMessage customMessage = new CustomMessage();
        customMessage.setSuccess(false);
        if (ex.getMessage().toLowerCase().contains("duplicate entry")) {
            customMessage.setMessage("User already there in database !!");
        } else {
            customMessage.setMessage(ex.getMessage());
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(customMessage);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomMessage> handleGenericException(Exception ex) {
        CustomMessage message = new CustomMessage();
        message.setMessage("An error occurred: " + ex.getMessage());
        message.setSuccess(false);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(message);
    }
}
