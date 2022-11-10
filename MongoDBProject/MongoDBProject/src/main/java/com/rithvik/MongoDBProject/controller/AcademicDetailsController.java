package com.rithvik.MongoDBProject.controller;

import com.rithvik.MongoDBProject.entity.AcademicDetailsEntity;
import com.rithvik.MongoDBProject.entity.ReqAcademicDetailsEntity;
import com.rithvik.MongoDBProject.service.AcademicDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AcademicDetailsController {

  @Autowired
  AcademicDetailsService academicDetailsService;

  public AcademicDetailsEntity storeAcademicDetails(ReqAcademicDetailsEntity reqAcademicDetailsEntity) {
    AcademicDetailsEntity academicDetailsEntity = academicDetailsService.saveAcademicDetails(reqAcademicDetailsEntity);
    return academicDetailsEntity;
  }
}
