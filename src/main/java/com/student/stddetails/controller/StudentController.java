package com.student.stddetails.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.stddetails.model.Student;
import com.student.stddetails.service.StudentService;


@RestController
@RequestMapping("/api/stdnts")
public class StudentController {
	
	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	// build create student REST API
	@PostMapping
	public ResponseEntity<Student> saveStudent(@RequestBody Student student){
		
		return new ResponseEntity<Student>(studentService.saveStudent(student), HttpStatus.CREATED);
	}

	//get all students
	@GetMapping
	public List<Student> getAllStudents(){
		return studentService.getAllStudents();
	}
	
	//build get student by id
	@GetMapping("{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") long id){
		return new ResponseEntity<Student>(studentService.getStudentById(id),HttpStatus.OK);
	}
	
	//update student
	@PutMapping("{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable("id") long id  , @RequestBody Student student){
		
		return new ResponseEntity<Student>(studentService.updateStudent(student, id), HttpStatus.OK);
		
	}
	
	//delete student
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable("id") long id){
		studentService.deleteStudent(id);
		return new ResponseEntity<String>("Student deleted successfully", HttpStatus.OK);
	}
	
	
	/*
	 * @GetMapping("{id}") public Student getStubyid(@PathVariable Long id) { return
	 * StudentService.getStudentById(id); }
	 */
}
