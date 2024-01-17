package com.learn.tavant.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class welcome {

    @GetMapping(path = "/tavant/welcome")
    public String getWelcomeMessage(){
        return "welcome to my world";
    }

}
