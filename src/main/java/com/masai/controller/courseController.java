package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Course;
import com.masai.service.CourseService;

@RestController
@RequestMapping("course")
public class courseController {
	
	CourseService cservice;
	@Autowired
	public courseController(CourseService cs) {
		System.out.print("in courseservice");
		this.cservice=cs;
	}
	
	
	
	
	@PostMapping("/registerCourse")
	public ResponseEntity<Course> registerCourse(@RequestBody Course course){
		Course newCourse= cservice.registerNewCourse(course);
		return new ResponseEntity(newCourse,HttpStatus.CREATED);
	}
}
