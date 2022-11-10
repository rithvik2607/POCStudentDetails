package com.rithvik.MongoDBProject.repo;

import com.rithvik.MongoDBProject.entity.StudentDetailsEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDetailsRepo extends MongoRepository<StudentDetailsEntity, String> {

  @Query("{name: ?0}")
  StudentDetailsEntity findItemByName(String name);
}
