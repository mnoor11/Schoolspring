package com.example.school.controller;

import com.example.school.service.TeacherService;
import com.example.school.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1")
public class TeacherController {

    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("teacher")
    public ResponseEntity getTeacher(){
        return ResponseEntity.status(200).body(teacherService.getTeachers());
    }

    @PostMapping("teacher")
    public ResponseEntity addTeacher(@RequestBody @Valid Teacher teacher, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError());
        }
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(201).body("teacher added");
    }

    @PutMapping("teacher/{index}")
    public ResponseEntity updateTeacher(@RequestBody @Valid Teacher teacher, @PathVariable Integer index){
        boolean isTeacherUpdate = teacherService.updateAuthor(index, teacher);
        if(!isTeacherUpdate){
            return ResponseEntity.status(400).body("The index is out array");
        } else {
            return ResponseEntity.status(200).body("teacher updated");
        }
    }

    @DeleteMapping("teacher/{index}")
    public ResponseEntity deleteTeacher(@PathVariable Integer index){
        boolean isTeacherDelete = teacherService.deleteTeacher(index);
        if(!isTeacherDelete){
            return ResponseEntity.status(400).body("Index is out array");
        } else {
            return  ResponseEntity.status(200).body("Author deleted");
        }
    }
}
