package com.milagro.springmoneytransferservice.advice;

import com.milagro.springmoneytransferservice.exceptions.InvalidOperationCode;
import com.milagro.springmoneytransferservice.exceptions.NoSuchCard;
import com.milagro.springmoneytransferservice.exceptions.NoSuchReceiver;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerAdvice {
    @ExceptionHandler(NoSuchCard.class)
    public ResponseEntity<String> nscHandler(NoSuchCard e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(NoSuchReceiver.class)
    public ResponseEntity<String> nsrHandler(NoSuchReceiver e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(InvalidOperationCode.class)
    public ResponseEntity<String> iocHandler(InvalidOperationCode e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
