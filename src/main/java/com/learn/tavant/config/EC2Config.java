package com.learn.tavant.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2ClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.Annotation;


@Configuration
public class EC2Config{

    @Autowired
    AWSKeys awsKeys;

    public AmazonEC2 getEC2Client(){
        AWSCredentials credentials = new BasicAWSCredentials(awsKeys.getAccessKey(), awsKeys.getSecretKey());
        return AmazonEC2ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(credentials)).withRegion(Regions.US_EAST_1).build();
    }
}

