package com.xmen.dnasentinel.exceptions;

public class ContaminatedDnaSampleException extends RuntimeException{

    private String message;

    public ContaminatedDnaSampleException(String message){
        this.message = message;
    }
}
