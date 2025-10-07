package com.example.financial_scheduler.common.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class RuleException extends Exception {
    
    private static final long serialVersionUID = 1L;
    private final HttpStatus status = HttpStatus.BAD_REQUEST;

    public RuleException(String message) {
        super(message);
    }

}
