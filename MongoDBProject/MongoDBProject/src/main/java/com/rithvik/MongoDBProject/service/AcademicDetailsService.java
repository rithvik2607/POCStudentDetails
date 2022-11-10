package com.rithvik.MongoDBProject.service;

import com.rithvik.MongoDBProject.entity.AcademicDetailsEntity;
import com.rithvik.MongoDBProject.entity.ReqAcademicDetailsEntity;
import com.rithvik.MongoDBProject.repo.AcademicDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AcademicDetailsService {

  @Autowired
  AcademicDetailsRepo academicDetailsRepo;

  public AcademicDetailsEntity saveAcademicDetails(ReqAcademicDetailsEntity reqAcademicDetailsEntity) {
    AcademicDetailsEntity academicDetailsEntity = new AcademicDetailsEntity();
    academicDetailsEntity.setMidTermMarks(reqAcademicDetailsEntity.getMidTermMarks());
    academicDetailsEntity.setEndTermMarks(reqAcademicDetailsEntity.getEndTermMarks());
    academicDetailsRepo.save(academicDetailsEntity);
    return academicDetailsEntity;
  }

}
