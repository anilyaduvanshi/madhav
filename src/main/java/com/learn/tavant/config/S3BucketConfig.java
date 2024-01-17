package com.learn.tavant.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value = "singleton")
@Component
public class S3BucketConfig {

    @Autowired
    public AWSKeys awsKeys;

    public AmazonS3 client;

    private boolean flag=false;

    public AWSCredentials getAwsCredentials(){
        return new BasicAWSCredentials(awsKeys.getAccessKey(), awsKeys.getSecretKey());
    }

    public AmazonS3 getClientForS3(){
        if (flag==false){
            client = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(getAwsCredentials())).withRegion(Regions.US_EAST_1).build();
            flag=true;
        }
        return client;
    }

}
