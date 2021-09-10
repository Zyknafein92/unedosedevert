package com.openclassroom.projet12.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Data
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TokenException extends RuntimeException {

    private ErrorCode errorCode;
    public TokenException(String s, ErrorCode errorCode) {
        super(s);
        this.errorCode = errorCode;
    }
}
