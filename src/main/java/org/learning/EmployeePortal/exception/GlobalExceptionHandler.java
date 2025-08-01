package org.learning.EmployeePortal.exception;

import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.converter.HttpMessageNotReadableException;
import jakarta.validation.ConstraintViolationException;


@ControllerAdvice
public class GlobalExceptionHandler extends Throwable {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        Throwable cause = ex.getCause();

        String errorMessage = "Invalid input: ";
        if (cause instanceof com.fasterxml.jackson.databind.exc.InvalidFormatException) {
            errorMessage += "Please ensure that the field '"
                    + ((com.fasterxml.jackson.databind.exc.InvalidFormatException) cause).getPath().get(0)
                            .getFieldName()
                    + "' contains a valid value.";
        } else {
            errorMessage += "Please provide valid input data.";
        }

        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }
}