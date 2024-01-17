package com.learn.tavant.service;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.*;
import com.learn.tavant.config.SNSConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SNSService {

    @Autowired
    SNSConfig snsConfig;


    public String createTopic(String topicName){

        CreateTopicRequest topicRequest = new CreateTopicRequest().withName(topicName);
        CreateTopicResult result = snsConfig.getClient().createTopic(topicRequest);
        //String topicARNNumber = result.getTopicArn();
        return result.getTopicArn();
    }


    public String publishMessageToTopic(String topicARNNumber, String snsMessage){
        PublishRequest publishRequest = new PublishRequest(topicARNNumber, snsMessage);
        PublishResult result = snsConfig.getClient().publish(publishRequest);
        return "message published -> " + result.getMessageId();
    }

    public String subscribeSNSTopic(String topicARNNumber, String subscriberEmail){
        SubscribeRequest subscribeRequest = new SubscribeRequest(topicARNNumber, "sms", subscriberEmail);
        SubscribeResult subscribeResult = snsConfig.getClient().subscribe(subscribeRequest);
        return "subscribed to -> " + subscribeResult.getSubscriptionArn();
    }

    public String deleteTopic(String topicARNNumber){
        DeleteTopicRequest deleteTopicRequest = new DeleteTopicRequest(topicARNNumber);
        DeleteTopicResult deleteTopicResult = snsConfig.getClient().deleteTopic(deleteTopicRequest);
        return "topic with arn number " + topicARNNumber + " deleted successfully";
    }
}
