package com.openclassroom.projet12.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

    private ErrorCode errorCode;
    public NotFoundException(String s, ErrorCode errorCode) {
        super(s);
        this.errorCode = errorCode;
    }
}

