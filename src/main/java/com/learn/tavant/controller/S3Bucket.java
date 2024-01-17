package com.learn.tavant.controller;


import com.learn.tavant.service.S3BucketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class S3Bucket {

    @Autowired
    S3BucketService bucketService;

    @GetMapping(path = "/tavant/create-s3-bucket")
    public String createBucket(@RequestParam String bucketName){
        return bucketService.createS3Bucket(bucketName);
    }

    @GetMapping(path = "/tavant/delete-s3-bucket")
    public String deleteBucket(@RequestParam String bucketName){
        return bucketService.deleteS3Bucket(bucketName);
    }

    @PostMapping(path = "/tavant/put-s3-object")
    public String putObjectInS3(@RequestParam String objectContent, @RequestParam String bucketName){
        return bucketService.putObjectsInBucket(objectContent, bucketName);
    }

    @PostMapping(path = "/tavant/get-s3-object")
    public Object getObjectFromS3(@RequestParam String bucketName, @RequestParam String objectKey){
        return bucketService.putObjectsInBucket(bucketName, objectKey);
    }

}
