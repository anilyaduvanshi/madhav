package com.learn.tavant.controller;

import com.learn.tavant.service.S3BucketService;
import com.learn.tavant.service.SNSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SNSController {

    @Autowired
    SNSService snsService;

    @GetMapping(path = "/tavant/create-sns-topic")
    public String createTopic(@RequestParam String topicName){
        return snsService.createTopic(topicName);
    }

    @DeleteMapping(path = "/tavant/delete-sns-topic")
    public String deleteTopic(@RequestParam String topicARNNumber){
        return snsService.deleteTopic(topicARNNumber);
    }

    @GetMapping(path = "/tavant/subscribe-sns-topic")
    public String subscribeSNSTopic(@RequestParam String topicARNNumber, @RequestParam String subscriberEmail){
        return snsService.subscribeSNSTopic(topicARNNumber, subscriberEmail);
    }

    @PostMapping(path = "/tavant/publish-sns-message")
    public String publishSnsMessage(@RequestParam String topicARNNumber, @RequestParam String snsMessage){
        return snsService.publishMessageToTopic(topicARNNumber, snsMessage);
    }


}
