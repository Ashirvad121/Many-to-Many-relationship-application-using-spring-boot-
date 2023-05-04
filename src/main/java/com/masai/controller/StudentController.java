package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Course;
import com.masai.model.Student;
import com.masai.service.StudentService;

@RestController
public class StudentController {

	StudentService sservice;
	@Autowired
	public StudentController(StudentService sservice) {
		this.sservice=sservice;
	}
	
	@PostMapping("register/{coursename}")
	public ResponseEntity<Student> registerStudent(@PathVariable("coursename") String courseName,@RequestBody Student student) {
		Student studentRegister = sservice.registerStudent(student, courseName);
		return new ResponseEntity(studentRegister,HttpStatus.CREATED);
	}
	
	@GetMapping("getAllStudents/{course}")
	public ResponseEntity<List<Student>> findStudentsByCourseName(@PathVariable("course")String course){
		List<Student> list= sservice.findStudentByCourseName(course);
		return new ResponseEntity(list,HttpStatus.OK);
	}
}
