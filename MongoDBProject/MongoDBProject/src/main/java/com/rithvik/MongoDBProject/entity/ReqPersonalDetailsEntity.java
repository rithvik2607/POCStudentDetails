package com.rithvik.MongoDBProject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReqPersonalDetailsEntity {

  private String studAddress;

  private String parentPhNo;

  private String parentName;

  private String bloodGroup;

  private String emergencyContactNumber;

}
