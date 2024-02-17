package com.student.stddetails.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.student.stddetails.model.Student;
import com.student.stddetails.repository.StudentRepository;
import com.student.stddetails.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	
	private StudentRepository studentRepository;
	
	
	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}



	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}



	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}



	@Override
	public  Student getStudentById(long id) {
		
		Optional<Student> student = studentRepository.findById(id);
		
		if(student.isPresent()) {
			return student.get();
		
		}
		throw new RuntimeException("ResourceNotFound for " + id);
		
		
		
		
	}



	@Override
	public Student updateStudent(Student student, long id) {
		
		Student existingStudent = studentRepository.findById(id).orElseThrow( () -> new RuntimeException("ResourseNotFound for" + id ));
		
		//update
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setCourse(student.getCourse());
		
		//save update
		studentRepository.save(existingStudent);
		
		return existingStudent;
	}



	@Override
	public void deleteStudent(long id) {
		
		studentRepository.findById(id).orElseThrow( () -> new RuntimeException("ResourseNotFound for" + id ));
		
		studentRepository.deleteById(id);
		
	}



}
