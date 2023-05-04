package com.masai.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.masai.model.Student;

public interface StudentRepo extends JpaRepository<Student , Integer>{
	
	
}
