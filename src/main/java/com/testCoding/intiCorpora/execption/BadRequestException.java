package com.testCoding.intiCorpora.execption;

import org.springframework.web.bind.annotation.ResponseStatus;

import com.testCoding.intiCorpora.constant.CodeMessage;

import lombok.Data;

@ResponseStatus
@Data
public class BadRequestException extends RuntimeException{
    private String code = CodeMessage.Data_Unique_Contstraint.toString();
    private String status = "BAD REQUEST";

    public BadRequestException() {
        super("Bad request");
    }

    public BadRequestException(String message) {
        super(message);
    }
}
