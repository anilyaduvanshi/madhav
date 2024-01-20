package com.learn.tavant.controller;

import com.learn.tavant.model.ResponseModel;
import com.learn.tavant.service.EC2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EC2Controller {

    @Autowired
    EC2Service ec2Service;

    @GetMapping(path = "/tavant/create-ec2-instance")
    public String createInstance(@RequestParam String imageId, @RequestParam String instanceKey){
        return ec2Service.createEC2Instance(imageId, instanceKey);
    }

    @GetMapping(path = "/tavant/set-ec2-instance-tags")
    public ResponseEntity<ResponseModel> setInstanceTags(@RequestParam String instanceId){
        return new ResponseEntity<>(new ResponseModel(ec2Service.setTagsForInstance(instanceId)), HttpStatus.OK);
    }

    @GetMapping(path = "/tavant/start-ec2-instance")
    public ResponseEntity<ResponseModel> startInstance(@RequestParam String instanceId){
        return new ResponseEntity<>(new ResponseModel(ec2Service.startInstance(instanceId)), HttpStatus.OK);
    }

    @GetMapping(path = "/tavant/stop-ec2-instance")
    public ResponseEntity<ResponseModel> stopInstance(@RequestParam String instanceId){
        return new ResponseEntity<>(new ResponseModel(ec2Service.stopInstance(instanceId)), HttpStatus.OK);
    }
}
