//package com.learn.tavant.controller;
//
//import org.springframework.http.HttpMethod;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//@RestController
//public class CallExternalAPI {
//
//    @GetMapping(path = "/call-api")
//    public ResponseEntity<Object> getResult(){
//        RestTemplate restTemplate = new RestTemplate();
//        String url = "https://restcountries.com/v3.1/all";
//        ArrayList result = restTemplate.getForObject(url, ArrayList.class);
//        restTemplate.exchange()
//        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
//    }
//
//}
