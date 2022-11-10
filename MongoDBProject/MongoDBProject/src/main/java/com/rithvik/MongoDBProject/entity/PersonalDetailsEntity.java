package com.rithvik.MongoDBProject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document("personaldetailsentity")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PersonalDetailsEntity {

  @Id
  private String persDetailsId;

  private String studAddress;

  private String parentPhNo;

  private String parentName;

  private String bloodGroup;

  private String emergencyContactNumber;

  private String studentId;

}
