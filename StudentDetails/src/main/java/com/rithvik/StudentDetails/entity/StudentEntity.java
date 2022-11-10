package com.rithvik.StudentDetails.entity;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentEntity {
    @Id
    private String rollNo;

    private String name;

    private String grade;

    private String medium;

    private PersonalDetailsEntity studDetails;

    private AcademicDetailsEntity studAcad;

    public StudentEntity(String rollNo, String name, String grade, String medium) {
        this.rollNo = rollNo;
        this.name = name;
        this.grade = grade;
        this.medium = medium;
    }
}
