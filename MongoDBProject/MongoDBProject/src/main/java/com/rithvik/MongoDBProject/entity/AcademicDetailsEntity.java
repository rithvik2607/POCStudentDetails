package com.rithvik.MongoDBProject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("academicdetailsentity")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AcademicDetailsEntity {

  @Id
  private String acadDetailsId;

  private Double midTermMarks;

  private Double endTermMarks;

  private String studentId;

}
