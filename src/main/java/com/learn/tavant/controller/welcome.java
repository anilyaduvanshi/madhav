package com.learn.tavant.controller;

import com.learn.tavant.config.LogMethods;
import com.learn.tavant.model.ResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class welcome {

    @LogMethods
    @GetMapping(path = "/tavant/welcome")
    public ResponseEntity<ResponseModel> getWelcomeMessage() {
        //Thread.sleep(2000);
        return new ResponseEntity<>(new ResponseModel("welcome to my world"), HttpStatus.OK);
    }
}
