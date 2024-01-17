package com.learn.tavant.controller;

import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.MultiValueMapAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersSpec;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.HashMap;
import java.util.function.Consumer;

@RestController
public class CallExternalAPI {

    WebClient.Builder builder = WebClient.builder();

    @GetMapping(path = "/call-api")
    public ResponseEntity<Object> getResult() throws URISyntaxException {
        ResponseEntity<Object> resp = new ResponseEntity<>(null, HttpStatus.OK);
//        Object response = builder.build().get().uri("https://restcountries.com/v3.1/name/deutschland").retrieve().bodyToMono(Object.class).block();
//        return new ResponseEntity<>(response, HttpStatus.OK);
        URI uri = new URI("https://restcountries.com/v3.1/name/deutschland");
        Object res2 = builder.build().method(HttpMethod.GET).uri(uri).retrieve().bodyToMono(Object.class).block();
        return new ResponseEntity<>(res2, HttpStatus.valueOf("anil"));
    }
}
