package com.rithvik.MongoDBProject.service;

import com.rithvik.MongoDBProject.entity.*;
import com.rithvik.MongoDBProject.repo.StudentDetailsRepo;
import lombok.extern.slf4j.Slf4j;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class StudentDetailsService {

  @Autowired
  StudentDetailsRepo studentDetailsRepo;

  public String createStudent(ReqStudentDetailsEntity reqStudentDetailsEntity, AcademicDetailsEntity acads, List<PersonalDetailsEntity> persDetails) {
    StudentDetailsEntity studentDetailsEntity = new StudentDetailsEntity();
    studentDetailsEntity.setName(reqStudentDetailsEntity.getName());
    studentDetailsEntity.setGrade(reqStudentDetailsEntity.getGrade());
    studentDetailsEntity.setMedium(reqStudentDetailsEntity.getMedium());
    studentDetailsEntity.setGender(reqStudentDetailsEntity.getGender());
    studentDetailsEntity.setAcademicDetails(acads);
    studentDetailsEntity.setPersonalDetails(persDetails);
    studentDetailsRepo.save(studentDetailsEntity);
    return "Student Details Saved into DB";
  }

  public List<String> findPassedStudents(Double marks) {
    List<String> names = new ArrayList<>();
    List<StudentDetailsEntity> students = studentDetailsRepo.findAll();
    for(StudentDetailsEntity stud: students) {
      if(stud.getAcademicDetails().getMidTermMarks() >= marks &&
              stud.getAcademicDetails().getEndTermMarks() >= marks) {
        names.add(stud.getName());
      }
    }
    return names;
  }

  public List<String> findStudentsOfGender(Gender gender) {
    List<String> names = new ArrayList<>();
    List<StudentDetailsEntity> students = studentDetailsRepo.findAll();
    for(StudentDetailsEntity stud: students) {
      if(stud.getGender() == gender) {
        names.add(stud.getName());
      }
    }
    return names;
  }


  public void addPhoto(String name, MultipartFile file) throws IOException {
    StudentDetailsEntity student = studentDetailsRepo.findItemByName(name);
    student.setImage(new Binary(BsonBinarySubType.BINARY, file.getBytes()));
    studentDetailsRepo.save(student);
  }

  public Binary getPhoto(String name) {
    StudentDetailsEntity student = studentDetailsRepo.findItemByName(name);
    Binary res = student.getImage();
    return res;
  }

}
