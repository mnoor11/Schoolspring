package com.example.school.service;

import com.example.school.model.Teacher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TeacherService {
    private ArrayList<Teacher> teachers= new ArrayList<>();

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public boolean updateAuthor(Integer index, Teacher teacher) {
        if(index >= teachers.size()){
            return false;
        }
        teachers.set(index, teacher);
        return true;
    }

    public boolean deleteTeacher(Integer index) {
        if(index >= teachers.size()){
            return false;
        }
        teachers.remove(index);
        return true;
    }
}
