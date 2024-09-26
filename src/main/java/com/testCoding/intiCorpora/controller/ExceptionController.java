package com.testCoding.intiCorpora.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.testCoding.intiCorpora.constant.CodeMessage;
import com.testCoding.intiCorpora.execption.BadRequestException;
import com.testCoding.intiCorpora.execption.NotFoundException;
import com.testCoding.intiCorpora.model.WebResponse;

@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<WebResponse<String>> handleBadRequestException(BadRequestException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new WebResponse<>(CodeMessage.Data_Not_Applicable.toString(), "Data tidak ditemui"));
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<WebResponse<String>> handleNotFoundException(NotFoundException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new WebResponse<>(CodeMessage.Data_Not_Applicable.toString(), "Data tidak ditemui"));
    }

    
}
