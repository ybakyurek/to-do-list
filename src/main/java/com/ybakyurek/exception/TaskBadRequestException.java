package com.ybakyurek.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// 400:Kötü istek
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TaskBadRequestException extends RuntimeException{
    public TaskBadRequestException(String message) {
        super(message);
    }
}
