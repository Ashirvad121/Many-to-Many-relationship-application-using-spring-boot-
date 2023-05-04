package com.masai.service;

import java.util.List;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.model.Course;
import com.masai.model.Student;
import com.masai.repo.CourseDao;
@Service
public class CourseServiceImpl implements CourseService{
	
	CourseDao crepo;
	
	@Autowired
	public CourseServiceImpl(CourseDao crepo) {
		System.out.print("in courseservice");
		this.crepo=crepo;
	}
	
	@Override
	public Course registerNewCourse(Course course) {
		Set<Student> students= course.getStudents();
		
		for(Student student : students) {
			student.getCourses().add(course);
		}
		return crepo.save(course);
	}

}
