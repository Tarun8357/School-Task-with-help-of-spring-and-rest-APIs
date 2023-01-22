package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Student;

public interface StudentService {
	
	Student saveStudent(Student student);
	List<Student> getAllStudents();
	Student getStudentById(int id );
	Student updateStudent(Student student,int id );

}
