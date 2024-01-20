package com.learn.tavant.controller;


import com.learn.tavant.model.ResponseModel;
import com.learn.tavant.service.S3BucketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class S3Bucket {

    @Autowired
    S3BucketService bucketService;

    @GetMapping(path = "/tavant/create-s3-bucket")
    public ResponseEntity<ResponseModel> createBucket(@RequestParam String bucketName){
        return new ResponseEntity<>(new ResponseModel(bucketService.createS3Bucket(bucketName)), HttpStatus.OK);
    }

    @GetMapping(path = "/tavant/delete-s3-bucket")
    public ResponseEntity<ResponseModel> deleteBucket(@RequestParam String bucketName){
        return new ResponseEntity<>(new ResponseModel(bucketService.deleteS3Bucket(bucketName)), HttpStatus.OK);
    }

    @PostMapping(path = "/tavant/put-s3-object")
    public ResponseEntity<ResponseModel> putObjectInS3(@RequestParam String objectContent, @RequestParam String bucketName){
        return new ResponseEntity<>(new ResponseModel(bucketService.putObjectsInBucket(objectContent, bucketName)), HttpStatus.OK);
    }

    @PostMapping(path = "/tavant/get-s3-object")
    public ResponseEntity<ResponseModel> getObjectFromS3(@RequestParam String bucketName, @RequestParam String objectKey){
        return new ResponseEntity<>(new ResponseModel(bucketService.putObjectsInBucket(bucketName, objectKey)), HttpStatus.OK);
    }

}
