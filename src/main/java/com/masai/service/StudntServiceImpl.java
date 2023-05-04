package com.masai.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.model.Course;
import com.masai.model.Student;
import com.masai.repo.CourseDao;
import com.masai.repo.StudentRepo;

@Service
public class StudntServiceImpl implements StudentService{
	StudentRepo srepo;
	CourseDao cdao;
	
	@Autowired
	public StudntServiceImpl(StudentRepo srepo,CourseDao cdao) {
		this.srepo=srepo;
		this.cdao=cdao;
	}
	
	@Override
	public Student registerStudent(Student student,String courseName) {
		Course course= cdao.findStudentByCourse(courseName);
		if(course!=null) {
			student.getCourses().add(course);
			course.getStudents().add(student);
			return srepo.save(student);
		}
		return null;
	}

	@Override
	public List<Student> findStudentByCourseName(String courseName) {
		Set<Student> students=  cdao.findStudentsByCourseName(courseName);
		List<Student> list= new ArrayList(students);
		return list;
	}
	

}
