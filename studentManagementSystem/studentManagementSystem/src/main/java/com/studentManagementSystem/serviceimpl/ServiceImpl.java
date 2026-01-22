package com.studentManagementSystem.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentManagementSystem.entity.Student;
import com.studentManagementSystem.service.StudentService;

@Service
public class ServiceImpl  implements StudentService{

	@Autowired
	com.studentManagementSystem.Repositery.StudentRepository StudentRepository;
	
	@Override
	public List<Student> getAllStudents() {
		
		List<Student> list = StudentRepository.findAll();
		return list;
	}
	
	  @Override
	    public void saveStudent(Student student) {
	        StudentRepository.save(student);
	    }

	    @Override
	    public Student getStudentById(int id) {
	        return StudentRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
	    }

	    @Override
	    public void updateStudent(Student student) {
	        StudentRepository.save(student);
	    }

	    @Override
	    public void deleteStudentById(int id) {
	        StudentRepository.deleteById(id);
	    }
	

}
