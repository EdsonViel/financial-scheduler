package com.example.financial_scheduler.common.message;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Message {

    private String message;
    private String status;
    private boolean error;

}
