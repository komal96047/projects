package com.studentManagementSystem.service;

import java.util.List;
import com.studentManagementSystem.entity.Student;

public interface StudentService {
    List<Student> getAllStudents();
    void saveStudent(Student student);
    Student getStudentById(int id);
    void updateStudent(Student student);
    void deleteStudentById(int id);
}
