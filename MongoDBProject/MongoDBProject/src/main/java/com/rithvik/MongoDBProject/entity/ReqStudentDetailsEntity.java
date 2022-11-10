package com.rithvik.MongoDBProject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.Binary;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReqStudentDetailsEntity {

  private String name;

  private String grade;

  private Medium medium;

  private Gender gender;

  private List<ReqPersonalDetailsEntity> reqPersonalDetailsEntities;

  private ReqAcademicDetailsEntity reqAcademicDetailsEntity;

}
