package com.learn.tavant.controller;

import com.learn.tavant.service.EC2Service;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String setInstanceTags(@RequestParam String instanceId){
        return ec2Service.setTagsForInstance(instanceId);
    }

    @GetMapping(path = "/tavant/start-ec2-instance")
    public String startInstance(@RequestParam String instanceId){
        return ec2Service.startInstance(instanceId);
    }

    @GetMapping(path = "/tavant/stop-ec2-instance")
    public Object stopInstance(@RequestParam String instanceId){
        return ec2Service.stopInstance(instanceId);
    }
}
