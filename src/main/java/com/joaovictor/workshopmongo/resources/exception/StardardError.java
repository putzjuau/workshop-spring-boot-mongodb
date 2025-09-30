package com.joaovictor.workshopmongo.resources.exception;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
public class StardardError implements Serializable {
    private Long timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;

    public StardardError(){

    }

    public StardardError(Long timestamp, Integer status, String error, String message, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }
}
