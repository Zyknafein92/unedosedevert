package com.openclassroom.projet12.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
@Data
public class BadRequest extends RuntimeException {

    private ErrorCode errorCode;
    public BadRequest(String s, ErrorCode errorCode) {
        super(s);
        this.errorCode = errorCode;
    }
}
