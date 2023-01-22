package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;

@Service

public class StudentServiceImpl implements StudentService {
	private StudentRepository studentRepository;
	

	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}


	@Override
	public Student saveStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);
	}


	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}


	@Override
	public Student getStudentById(int id) {
		Optional<Student> student = studentRepository.findById(id);
		
		if(student.isPresent()) {
			return student.get();
		}else {
			throw new ResourceNotFoundException("Student", "Id", id);
		}
		
	}


	@Override
	public Student updateStudent(Student student, int id) {
		
		//check id is present in database or not
		Student idStudent = studentRepository.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("Student", "Id", id));
		idStudent.setFirstName(student.getFirstName());
		idStudent.setLastName(student.getLastName());
		idStudent.setphone(student.getPhone());
		
		studentRepository.save(idStudent);
		return idStudent;
	}

}
