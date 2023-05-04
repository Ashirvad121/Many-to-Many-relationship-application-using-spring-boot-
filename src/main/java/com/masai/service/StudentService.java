package com.masai.service;

import java.util.List;

import com.masai.model.Student;

public interface StudentService {
	public Student registerStudent(Student student, String courseName);
	public List<Student> findStudentByCourseName(String courseName);
}
