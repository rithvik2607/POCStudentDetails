package com.rithvik.MongoDBProject.repo;

import com.rithvik.MongoDBProject.entity.AcademicDetailsEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcademicDetailsRepo extends MongoRepository<AcademicDetailsEntity, String> {

}
