package com.openclassroom.projet12.exceptions;


import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
@Data
public class CreationError extends RuntimeException {

    private ErrorCode errorCode;
    public CreationError(String s, ErrorCode errorCode) {
        super(s);
        this.errorCode = errorCode;
    }
}
