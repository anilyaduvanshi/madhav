package com.learn.tavant.model.common;

import org.springframework.http.HttpStatus;

import java.time.Instant;


public class ResponseModel {

    private String message = "";
    private Instant timeStamp = Instant.now();
    //private String path;
    private HttpStatus status;
    private Object response = null;

    public ResponseModel(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }

    public ResponseModel(Object response){
        this.response = response;
    }

    public Object getResponse() {
        return response;
    }

    public void setResponse(Object response) {
        this.response = response;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Instant getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Instant timeStamp) {
        this.timeStamp = timeStamp;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
