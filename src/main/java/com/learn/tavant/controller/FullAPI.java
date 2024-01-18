package com.learn.tavant.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.awt.print.Pageable;
import java.security.Principal;
import java.util.List;

@RestController
public class FullAPI {


    /*
    @RequestHeader(HttpHeaders.CONTENT_TYPE) String contentType; --> when accepting single header
    @RequestHeader HashMap<Object, Object> headers; --> multiple but only one value
    @RequestHeader MultiValueMap headers; --> multiple
    @RequestHeader HttpHeaders headers; --> headers object

    Principle Object is to get user basic auth details. no need to send
    Pageable object is used when implementing pagination

    */


    @GetMapping(path = "/full-api/{number}")
    public ResponseEntity<Object> getResult(
            @PathVariable int number,
            @RequestParam String pathVariable,
            @RequestBody List<String> list,
            @RequestHeader HttpHeaders headers
//            HttpServletRequest request,
//            Principal principal,
//            Pageable pageable
    ){
        System.out.println(headers.get("Version"));
        System.out.println(headers.get("Accept-Content"));
        System.out.println(headers.get("my-number"));
        HttpHeaders responseHeaders = new HttpHeaders();




        //setting response headers
        responseHeaders.add(HttpHeaders.CONTENT_ENCODING, "utf-8");
        responseHeaders.add(HttpHeaders.CONTENT_LANGUAGE, "en");
        responseHeaders.add(HttpHeaders.SERVER, "localhost");
        return ResponseEntity.ok().headers(responseHeaders).body(number);
    }
}
