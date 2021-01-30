package com.xmen.dnasentinel.exceptions.handler;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.xmen.dnasentinel.exceptions.ContaminatedDnaSampleException;
import com.xmen.dnasentinel.resources.exceptions.handlers.ApiExceptionHandler;
import com.xmen.dnasentinel.resources.exceptions.handlers.ErrorMessage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApiExceptionHandlerTest {

    private ApiExceptionHandler handler = new ApiExceptionHandler();

    @Test
    public void handlerException(){
        ResponseEntity actual = handler.handler(new Exception());
        ResponseEntity expected = ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ErrorMessage.builder().errorMessage("Please contact Charles Francis Xavier - Professor X").build());
        assertEquals(expected.getStatusCode(),actual.getStatusCode());
    }

    @Test
    public void handlerContaminatedDnaSampleException(){
        ResponseEntity actual = handler.handler(new ContaminatedDnaSampleException("DNA Sample Contaminated"));
        ResponseEntity expected = ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ErrorMessage.builder().errorMessage("DNA Sample Contamined please contact Charles Francis Xavier - Professor X").build());
        assertEquals(expected.getStatusCode(),actual.getStatusCode());
    }

    @Test
    public void handlerContaminatedDnaSampleMethodArgumentNotValidException(){
        ResponseEntity actual = handler.handler(Mockito.mock(MethodArgumentNotValidException.class));
        ResponseEntity expected = ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body(ErrorMessage.builder().errorMessage("Not Human or Mutant DNA Sequence maybe Alien").build());
        assertEquals(expected.getStatusCode(),actual.getStatusCode());
    }
}
