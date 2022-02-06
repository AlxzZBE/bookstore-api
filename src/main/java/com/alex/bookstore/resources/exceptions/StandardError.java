package com.alex.bookstore.resources.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class StandardError {

    private Long timestamp;
    private Integer status;
    private String error;

    public StandardError() {
        super();
    }

    public StandardError(Long timestamp, Integer status, String error) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
    }
}
