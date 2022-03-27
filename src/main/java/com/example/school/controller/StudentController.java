package com.example.school.controller;

import com.example.school.model.Student;
import com.example.school.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("student")
    public ResponseEntity getStudent(){
        return ResponseEntity.status(201).body(studentService.getStudents());
    }

    @PostMapping("student")
    public ResponseEntity addStudent(@RequestBody @Valid Student student, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError());
        }
        studentService.addStudent(student);
        return ResponseEntity.status(200).body("DONE add student");
    }

    @PutMapping("student/{index}")
    public ResponseEntity updateStudent(@RequestBody @Valid Student student, @PathVariable Integer index, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError());
        }
        studentService.updateStudent(index, student);
        return ResponseEntity.status(200).body("DONE UpdateStudent");
    }

    @DeleteMapping("student/{index}")
    public ResponseEntity deleteStudent(@PathVariable @Valid Integer index, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError());
        }
        studentService.deleteStudent(index);
        return ResponseEntity.status(200).body("DONE DELETE STUDENT!");
    }

}
