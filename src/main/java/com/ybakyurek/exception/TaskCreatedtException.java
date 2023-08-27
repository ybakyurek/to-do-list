package com.ybakyurek.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// 201: Createt
@ResponseStatus(HttpStatus.CREATED)
public class TaskCreatedtException extends RuntimeException{
    public TaskCreatedtException(String message) {
        super(message);
    }
}
