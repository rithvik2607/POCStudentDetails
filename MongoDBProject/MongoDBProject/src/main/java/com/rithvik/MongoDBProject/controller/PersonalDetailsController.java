package com.rithvik.MongoDBProject.controller;

import com.rithvik.MongoDBProject.entity.PersonalDetailsEntity;
import com.rithvik.MongoDBProject.entity.ReqPersonalDetailsEntity;
import com.rithvik.MongoDBProject.service.PersonalDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonalDetailsController {

  @Autowired
  PersonalDetailsService personalDetailsService;

  public PersonalDetailsEntity storePersonalDetails(ReqPersonalDetailsEntity reqPersonalDetailsEntity) {
    PersonalDetailsEntity personalDetailsEntity = personalDetailsService.savePersonalDetails(reqPersonalDetailsEntity);
    return personalDetailsEntity;
  }
}
