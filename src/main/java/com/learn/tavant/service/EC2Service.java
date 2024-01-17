package com.learn.tavant.service;

import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.model.*;
import com.amazonaws.services.lightsail.model.DeleteInstanceRequest;
import com.amazonaws.services.lightsail.model.DeleteInstanceResult;
import com.amazonaws.services.lightsail.model.StartInstanceResult;
import com.learn.tavant.config.EC2Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EC2Service {

    @Autowired
    EC2Config ec2Config;

    /* image id are - OS that we want to use
       key is unique for each instance that make instance publicly accessible*/
    public String createEC2Instance(String imageId, String instanceKey){
        Instance instance = null;
        try {
            CreateKeyPairRequest keyPairRequest = new CreateKeyPairRequest().withKeyName(instanceKey);
            ec2Config.getEC2Client().createKeyPair(keyPairRequest);
            RunInstancesRequest instancesRequest = new RunInstancesRequest().withImageId(imageId).withKeyName(instanceKey).withInstanceType(InstanceType.T2Nano).withMaxCount(1).withMinCount(1);
            RunInstancesResult result =  ec2Config.getEC2Client().runInstances(instancesRequest);
            instance = result.getReservation().getInstances().get(0);
        } catch (Exception e) {
            return "Exception occurred :: message :: " + e.getMessage();
        }
        return "created instance with ID :: " + instance.getInstanceId();
    }


    public String setTagsForInstance(String instanceId){
        try {
            CreateTagsRequest tagsRequest = new CreateTagsRequest().withTags(new Tag("name", "anil")).withResources(instanceId);
            CreateTagsResult createTagsResult = ec2Config.getEC2Client().createTags(tagsRequest);
        } catch (Exception e) {
            return "Error in setting tags" + e.getMessage();
        }
        return "tags created";
    }

    public String startInstance(String instanceId){
        try {
            StartInstancesRequest startInstancesRequest = new StartInstancesRequest().withInstanceIds(instanceId);
            StartInstancesResult instancesResult = ec2Config.getEC2Client().startInstances(startInstancesRequest);
            return "instance with id :: " + instancesResult.getStartingInstances().get(0).getInstanceId() + " started";
        } catch (Exception e) {
            return "Error in starting instance :: " + e.getMessage();
        }
    }

    public String stopInstance(String instanceId){
        try {
            StopInstancesRequest stopInstancesRequest = new StopInstancesRequest().withInstanceIds(instanceId);
            StopInstancesResult stopInstancesResult = ec2Config.getEC2Client().stopInstances(stopInstancesRequest);
            return "instance with id :: " + stopInstancesResult.getStoppingInstances().get(0) + " stopped";
        } catch (Exception e) {
            return "Error in stopping instance :: " + e.getMessage();
        }
    }

}
