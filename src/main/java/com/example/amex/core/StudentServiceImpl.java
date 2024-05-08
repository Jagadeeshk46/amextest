package com.example.amex.core;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{

	
	@Autowired
	StudentRepository studentRepository;

	@Override
	public StudentEntity addStudent(StudentEntity student) {
		 
		return studentRepository.save(student);
	}

	@Override
	public Optional<StudentEntity> findStudentById(Long id) {
		return studentRepository.findById(id);
	}

	@Override
	public List<StudentEntity> findStudentByClassName(String className) {
		return studentRepository.findStudentByStudentClass(className);
	}

	@Override
	public List<StudentEntity> findStudentByName(String name) {
		return studentRepository.findStudentByName(name);
	}

	@Override
	public StudentEntity updateStudent(Long id, StudentEntity studentDetails) {
		Optional<StudentEntity> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            StudentEntity student = optionalStudent.get();
            student.setName(studentDetails.getName());
            student.setDateOfBirth(studentDetails.getDateOfBirth());
            student.setJoiningDate(studentDetails.getJoiningDate());
            student.setStudentClass(studentDetails.getStudentClass());
            return studentRepository.save(student);
        } else {
            throw new IllegalArgumentException("Student not found with id: " + id);
        }
	}
	
	
	 
	
	
	

}
