package com.masai.repo;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.masai.model.Course;
import com.masai.model.Student;

public interface CourseDao extends JpaRepository<Course, Integer>{
	@Query("select c from Course as c where c.courseName=?1")
	public Course findStudentByCourse(String courseName);
	
	@Query("select c.students from Course as c where c.courseName=?1")
	public Set<Student> findStudentsByCourseName(String coursename);
}
