package com.learn.tavant.controller;

import com.learn.tavant.config.LogMethods;
import com.learn.tavant.model.common.ResponseModel;
import com.learn.tavant.model.response.WelcomeResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class welcome {

    @LogMethods
    @GetMapping(path = "/tavant/welcome")
    public ResponseEntity<ResponseModel> getWelcomeMessage() {
        WelcomeResponse response = new WelcomeResponse();
        return new ResponseEntity<>(new ResponseModel(response), HttpStatus.OK);
    }
}
