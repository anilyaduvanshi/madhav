package com.learn.tavant.controller;

import com.learn.tavant.config.LogMethods;
import com.learn.tavant.model.common.ResponseModel;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class FullFunctionalRestAPI {


    /*
    @RequestHeader(HttpHeaders.CONTENT_TYPE) String contentType; --> when accepting single header
    @RequestHeader HashMap<Object, Object> headers; --> multiple but only one value
    @RequestHeader MultiValueMap headers; --> multiple
    @RequestHeader HttpHeaders headers; --> headers object

    Principle Object is to get user basic auth details. no need to send
    Pageable object is used when implementing pagination

    */


    @LogMethods
    @PostMapping(path = "/full-api/{number}")
    public ResponseEntity<ResponseModel> getResult(
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




        responseHeaders.add(HttpHeaders.CONTENT_ENCODING, "utf-8");
        responseHeaders.add(HttpHeaders.CONTENT_LANGUAGE, "en");
        responseHeaders.add(HttpHeaders.SERVER, "localhost");
        return new ResponseEntity<>(new ResponseModel(number), responseHeaders, HttpStatus.OK);
    }
}
