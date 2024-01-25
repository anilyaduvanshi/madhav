package com.learn.tavant.controller;

import com.learn.tavant.model.common.ResponseModel;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class CallExternalAPIRestTemplate {

    WebClient.Builder builder = WebClient.builder();

    @GetMapping(path = "/call-api")
    public ResponseEntity<Object> getResult() throws URISyntaxException {
        ResponseEntity<Object> resp = new ResponseEntity<>(null, HttpStatus.OK);
//        Object response = builder.build().get().uri("https://restcountries.com/v3.1/name/deutschland").retrieve().bodyToMono(Object.class).block();
//        return new ResponseEntity<>(response, HttpStatus.OK);
        URI uri = new URI("https://restcountries.com/v3.1/name/deutschland");
        Object res2 = builder.build().method(HttpMethod.GET).uri(uri).retrieve().bodyToMono(Object.class).block();
        return new ResponseEntity<>(new ResponseModel(res2), HttpStatus.valueOf("anil"));
    }
}
