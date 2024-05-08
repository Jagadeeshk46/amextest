package com.example.amex.core;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity, Long>{

	
	List<StudentEntity> findStudentByStudentClass(String className);
	
	List<StudentEntity> findStudentByName(String name);
}
