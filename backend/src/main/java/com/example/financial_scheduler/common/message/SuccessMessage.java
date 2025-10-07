package com.example.financial_scheduler.common.message;

import lombok.Getter;

@Getter
public class SuccessMessage extends Message {

    private final String message;
    private final String status;
    private final boolean error = false;

    public SuccessMessage(String message, String status) {
        super(message, status, false);
        this.message = message;
        this.status = status;
    }

}
