package com.ybakyurek.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// 401:Yetkisiz Giriş
@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class TaskUnAuthorizedException extends RuntimeException{
    public TaskUnAuthorizedException(String message) {
        super(message);
    }
}
