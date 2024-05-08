package com.example.amex.core;

import java.util.List;
import java.util.Optional;

public interface StudentService {

	StudentEntity addStudent(StudentEntity student);
	
	Optional<StudentEntity> findStudentById(Long id);
	
	List<StudentEntity> findStudentByClassName(String className );
	
	List<StudentEntity> findStudentByName(String name);
	
	
	StudentEntity updateStudent(Long id, StudentEntity student);
}
