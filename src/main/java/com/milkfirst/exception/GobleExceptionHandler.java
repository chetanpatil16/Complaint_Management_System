package com.milkfirst.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GobleExceptionHandler {

    @ExceptionHandler(ComplaintNotFound.class)
    public ResponseEntity<String> complaintNotFound(ComplaintNotFound complaintNotFound){
        return new ResponseEntity<>(complaintNotFound.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> hsndlestatusRequest(){
        return new ResponseEntity<>("Invalid status", HttpStatus.NOT_FOUND);
    }
}
