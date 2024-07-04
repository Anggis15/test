package com.testCoding.intiCorpora.execption;

import org.springframework.web.bind.annotation.ResponseStatus;

import com.testCoding.intiCorpora.constant.CodeMessage;

import lombok.Data;

@ResponseStatus
@Data
public class NotFoundException extends RuntimeException{
    private String code = CodeMessage.Data_Not_Applicable.toString();
    private String status = "NOT FOUND";

    public NotFoundException() {
        super("Not found");
    }

    public NotFoundException(String message) {
        super(message);
    }
}
