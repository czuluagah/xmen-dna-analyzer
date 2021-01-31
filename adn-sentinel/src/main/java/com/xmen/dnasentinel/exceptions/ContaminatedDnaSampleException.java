package com.xmen.dnasentinel.exceptions;

import lombok.Getter;

@Getter
public class ContaminatedDnaSampleException extends RuntimeException{

    private final String message;

    public ContaminatedDnaSampleException(String message){
        this.message = message;
    }
}
