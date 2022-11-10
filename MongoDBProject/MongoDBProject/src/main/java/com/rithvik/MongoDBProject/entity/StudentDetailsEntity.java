package com.rithvik.MongoDBProject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("studentdetails")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentDetailsEntity {

  @Id
  private String id;

  private String name;

  private String grade;

  private Medium medium;

  private Gender gender;

  private List<PersonalDetailsEntity> personalDetails;

  private AcademicDetailsEntity academicDetails;

  private Binary image;

}
