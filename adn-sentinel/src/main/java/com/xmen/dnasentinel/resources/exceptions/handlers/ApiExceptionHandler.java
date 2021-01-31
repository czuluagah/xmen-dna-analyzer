package com.xmen.dnasentinel.resources.exceptions.handlers;

import lombok.extern.slf4j.Slf4j;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.xmen.dnasentinel.exceptions.ContaminatedDnaSampleException;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class ApiExceptionHandler {

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<ErrorMessage> handler(MethodArgumentNotValidException e){
        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body(ErrorMessage.builder().message("Not Human or Mutant DNA Sequence maybe Alien").build());
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ErrorMessage> handler(Exception e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ErrorMessage.builder().message("Please contact Charles Francis Xavier - Professor X").build());
    }

    @ExceptionHandler({ContaminatedDnaSampleException.class})
    public ResponseEntity<ErrorMessage> handler(ContaminatedDnaSampleException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ErrorMessage.builder().message("DNA Sample Contamined please contact Charles Francis Xavier - Professor X").build());
    }
}
