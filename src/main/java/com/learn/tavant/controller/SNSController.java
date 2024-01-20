package com.learn.tavant.controller;

import com.learn.tavant.model.ResponseModel;
import com.learn.tavant.service.S3BucketService;
import com.learn.tavant.service.SNSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SNSController {

    @Autowired
    SNSService snsService;

    @GetMapping(path = "/tavant/create-sns-topic")
    public ResponseEntity<ResponseModel> createTopic(@RequestParam String topicName){
        return new ResponseEntity<>(new ResponseModel(snsService.createTopic(topicName)), HttpStatus.OK);
    }

    @DeleteMapping(path = "/tavant/delete-sns-topic")
    public ResponseEntity<ResponseModel> deleteTopic(@RequestParam String topicARNNumber){
        return new ResponseEntity<>(new ResponseModel(snsService.deleteTopic(topicARNNumber)), HttpStatus.OK);
    }

    @GetMapping(path = "/tavant/subscribe-sns-topic")
    public ResponseEntity<ResponseModel> subscribeSNSTopic(@RequestParam String topicARNNumber, @RequestParam String subscriberEmail){
        return new ResponseEntity<>(new ResponseModel(snsService.subscribeSNSTopic(topicARNNumber, subscriberEmail)), HttpStatus.OK);
    }

    @PostMapping(path = "/tavant/publish-sns-message")
    public ResponseEntity<ResponseModel> publishSnsMessage(@RequestParam String topicARNNumber, @RequestParam String snsMessage){
        return new ResponseEntity<>(new ResponseModel(snsService.publishMessageToTopic(topicARNNumber, snsMessage)), HttpStatus.OK);
    }


}
