package com.digital.crud.saladereuniao.saladereuniao.exception;

import lombok.Data;

import java.util.Date;

@Data
public class errorDetails {

    private Date timestamp;

    private String message;

    private String details;

    public errorDetails(Date timestamp, String message, String details) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }
}
