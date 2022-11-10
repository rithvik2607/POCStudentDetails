package com.rithvik.MongoDBProject.service;

import com.rithvik.MongoDBProject.entity.PersonalDetailsEntity;
import com.rithvik.MongoDBProject.entity.ReqPersonalDetailsEntity;
import com.rithvik.MongoDBProject.repo.PersonalDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonalDetailsService {

  @Autowired
  PersonalDetailsRepo personalDetailsRepo;

  public PersonalDetailsEntity savePersonalDetails(ReqPersonalDetailsEntity reqPersonalDetailsEntity) {
    PersonalDetailsEntity personalDetailsEntity = new PersonalDetailsEntity();
    personalDetailsEntity.setStudAddress(reqPersonalDetailsEntity.getStudAddress());
    personalDetailsEntity.setParentName(reqPersonalDetailsEntity.getParentName());
    personalDetailsEntity.setParentPhNo(reqPersonalDetailsEntity.getParentPhNo());
    personalDetailsEntity.setBloodGroup(reqPersonalDetailsEntity.getBloodGroup());
    personalDetailsEntity.setEmergencyContactNumber(reqPersonalDetailsEntity.getEmergencyContactNumber());
    personalDetailsRepo.save(personalDetailsEntity);
    return personalDetailsEntity;
  }
}
