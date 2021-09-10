package com.openclassroom.projet12.dto;


import com.openclassroom.projet12.exceptions.ErrorCode;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorDTO {
    private ErrorCode errorCode;
    private String message;
}
