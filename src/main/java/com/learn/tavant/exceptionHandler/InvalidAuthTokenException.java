package com.learn.tavant.exceptionHandler;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;


@Component
public class  InvalidAuthTokenException extends RuntimeException{

    public HttpStatus status;
    public String message;
    public Throwable cause;

    public InvalidAuthTokenException(HttpStatus status, String message, Throwable cause){
        this.status = status;
        this.message = message;
        this.cause = cause;
    }

    public InvalidAuthTokenException(HttpStatus status, String message){
        this.status = status;
        this.message = message;
    }
    public InvalidAuthTokenException(String message){
        this.message = message;
    }

    public InvalidAuthTokenException() {
    }
}
