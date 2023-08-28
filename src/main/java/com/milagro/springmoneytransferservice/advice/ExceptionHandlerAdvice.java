package com.milagro.springmoneytransferservice.advice;

import com.milagro.springmoneytransferservice.exceptions.InvalidOperationCode;
import com.milagro.springmoneytransferservice.exceptions.NoSuchCard;
import com.milagro.springmoneytransferservice.exceptions.NoSuchReceiver;
import com.milagro.springmoneytransferservice.model.ExceptionDTO;
import com.milagro.springmoneytransferservice.model.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerAdvice {
    @ExceptionHandler(NoSuchCard.class)
    public ResponseEntity<ExceptionDTO> nscHandler(NoSuchCard e){
        return new ResponseEntity<>(new ExceptionDTO(e.getMessage(), 400), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(NoSuchReceiver.class)
    public ResponseEntity<ExceptionDTO> nsrHandler(NoSuchReceiver e){
        return new ResponseEntity<>(new ExceptionDTO(e.getMessage(), 400), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<ExceptionDTO> iseHandler(IllegalStateException e){
        return new ResponseEntity<>(new ExceptionDTO(e.getMessage(), 500), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(InvalidOperationCode.class)
    public ResponseEntity<ExceptionDTO> iocHandler(InvalidOperationCode e){
        return new ResponseEntity<>(new ExceptionDTO(e.getMessage(), 400), HttpStatus.BAD_REQUEST);
    }
}
