package com.xmen.dnasentinel.resources.exceptions.handlers;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ErrorMessage {
    private String message;
}
