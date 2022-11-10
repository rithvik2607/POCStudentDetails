package com.rithvik.MongoDBProject.repo;

import com.rithvik.MongoDBProject.entity.PersonalDetailsEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalDetailsRepo extends MongoRepository<PersonalDetailsEntity, String> {

}
