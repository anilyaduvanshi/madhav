package com.learn.tavant.dao;

import com.learn.tavant.model.entity.ProgrammerDetails;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProgrammerRepo extends JpaRepository<ProgrammerDetails, Long> {
}
