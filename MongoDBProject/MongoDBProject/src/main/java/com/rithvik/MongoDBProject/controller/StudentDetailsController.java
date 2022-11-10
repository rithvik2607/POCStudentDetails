package com.rithvik.MongoDBProject.controller;

import com.rithvik.MongoDBProject.entity.*;
import com.rithvik.MongoDBProject.service.StudentDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/students")
public class StudentDetailsController {

  @Autowired
  StudentDetailsService studentDetailsService;

  @Autowired
  PersonalDetailsController personalDetailsController;

  @Autowired
  AcademicDetailsController academicDetailsController;

  @PostMapping("/create")
  public ResponseEntity<String> createStudent(@RequestBody ReqStudentDetailsEntity reqStudentDetailsEntity) {
    AcademicDetailsEntity acads = academicDetailsController.storeAcademicDetails(reqStudentDetailsEntity.getReqAcademicDetailsEntity());
    List<PersonalDetailsEntity> persDetails = new ArrayList<>();
    for(ReqPersonalDetailsEntity reqPersDetails: reqStudentDetailsEntity.getReqPersonalDetailsEntities()) {
      persDetails.add(personalDetailsController.storePersonalDetails(reqPersDetails));
    }
    studentDetailsService.createStudent(reqStudentDetailsEntity, acads, persDetails);
    return new ResponseEntity<>("Student details saved successfully", HttpStatus.OK);
  }

  @GetMapping("/marksSearch/{score}")
  public ResponseEntity<List<String>> findByMarks(@PathVariable String score) {
    Double marks = Double.valueOf(score);
    List<String> result = studentDetailsService.findPassedStudents(marks);
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @GetMapping("/genderSearch/{gender}")
  public ResponseEntity<List<String>> findByGender(@PathVariable String gender) {
    String val = gender.toUpperCase();
    Gender desiredGender = Gender.valueOf(val);
    List<String> result = studentDetailsService.findStudentsOfGender(desiredGender);
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @PostMapping("/image/add")
  public String uploadPhoto(@RequestParam("name") String name, @RequestParam("image") MultipartFile file) {
    try {
      studentDetailsService.addPhoto(name, file);
    }
    catch(IOException e) {
      log.error(e.getMessage());
    }
    log.info("Image saved successfully");
    return "redirect:/image/" + name;
  }

  @GetMapping("/image/{name}")
  public ResponseEntity<String> getPhoto(@PathVariable String name, Model model) {
    Binary img = studentDetailsService.getPhoto(name);
    model.addAttribute("image", Base64.getEncoder().encodeToString(img.getData()));
    return new ResponseEntity<>("Successfully returned image", HttpStatus.OK);
  }
}
