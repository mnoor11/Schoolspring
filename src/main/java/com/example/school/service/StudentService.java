package com.example.school.service;

import com.example.school.model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentService {
    private ArrayList<Student> students = new ArrayList<>();

    public ArrayList<Student> getStudents(){
        return students;
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public boolean updateStudent(Integer index, Student student){
        if(index >= students.size()){
            return false;
        }else {
            students.set(index, student);
            return true;
        }
    }

    public boolean deleteStudent(Integer index) {
        if (index >= students.size()) {
            return false;
        }
        students.remove(index);
        return true;
    }
}
