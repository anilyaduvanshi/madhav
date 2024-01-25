package com.learn.tavant.controller;


import com.learn.tavant.model.entity.ProgrammerDetails;
import com.learn.tavant.model.common.ResponseModel;
import com.learn.tavant.service.ProgrammerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProgrammerController {

    @Autowired
    ProgrammerService programmerService;

    @PostMapping(path = "/tavant/save-programmer")
    public ResponseEntity<ResponseModel> saveNestedModel(@RequestBody @Valid ProgrammerDetails details){
        programmerService.saveProgrammer(details);
        return new ResponseEntity<>(new ResponseModel(null), HttpStatus.OK);
    }

    @PostMapping(path = "/tavant/get-programmer")
    public ResponseEntity<ResponseModel> getNestedModel(){
        ResponseModel responseModel = new ResponseModel(programmerService.getProgrammer());
        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }

}
