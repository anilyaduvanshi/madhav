package com.learn.tavant.service;
import com.amazonaws.SdkClientException;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.learn.tavant.config.S3BucketConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Objects;

@Service
public class S3BucketService {

    @Autowired
    S3BucketConfig s3Config;

    private long objectKey=1;

    public String createS3Bucket(String bucketName){
        if (s3Config.getClientForS3().doesBucketExist(bucketName)){
            return "bucket already exists";
        }else{
            try {
                s3Config.getClientForS3().createBucket(bucketName);
            } catch (SdkClientException e) {
                return e.getMessage();
            }
            return "bucket created";
        }
    }

    public String deleteS3Bucket(String bucketName){
        if (s3Config.getClientForS3().doesBucketExist(bucketName)){
            s3Config.getClientForS3().deleteBucket(bucketName);
            return "deleted successfully";
        }else{
            return "bucket does not exists";
        }
    }

    public String putObjectsInBucket(String objectContent, String bucketName){
        try {
//            InputStream inputStream = multipartFile.getInputStream();
//            ObjectMetadata objectMetadata = new ObjectMetadata();
            s3Config.getClientForS3().putObject(bucketName, "object" + Long.toString(objectKey++), objectContent);
        } catch (SdkClientException e) {
            return e.getMessage();
        }
        return "object saved";
    }


    public Object getObjectFromS3(String bucketName, String objectKey){
        return s3Config.getClientForS3().getObject(bucketName, objectKey);
    }

}

