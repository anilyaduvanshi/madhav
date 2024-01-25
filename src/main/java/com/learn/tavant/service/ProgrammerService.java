package com.learn.tavant.service;

import com.learn.tavant.dao.ProgrammerRepo;
import com.learn.tavant.model.entity.ProgrammerDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProgrammerService {

    @Autowired
    ProgrammerRepo programmerRepo;

    public void saveProgrammer(ProgrammerDetails details){
        programmerRepo.save(details);
    }

    public List<ProgrammerDetails> getProgrammer(){
        return programmerRepo.findAll();
    }


}
