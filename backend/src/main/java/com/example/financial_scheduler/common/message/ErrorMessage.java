package com.example.financial_scheduler.common.message;

import lombok.Getter;

@Getter
public class ErrorMessage  extends Message {

    private final String message;
    private final String status;
    private final boolean error = true;

    public ErrorMessage(String message, String status) {
        super(message, status, true);
        this.message = message;
        this.status = status;
    }

}
