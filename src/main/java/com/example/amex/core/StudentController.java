package com.example.amex.core;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@PostMapping("/add")
	public ResponseEntity<?> saveStudent(@RequestBody StudentEntity student) {
		 try {
	            return ResponseEntity.ok().body(studentService.addStudent(student));
	        } catch (Exception e) {
	        	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
	        }
	}
	
	@GetMapping("/searchStudent")
    public ResponseEntity<?> searchStudents(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String studentClass) {
        try {
            if (id != null) {
            	Optional<StudentEntity> student = studentService.findStudentById(id);
            	if(student.isPresent()) {
            		 return ResponseEntity.ok().body(List.of(student.get()));
            	} 
            	
            } else if (name != null) {
                return ResponseEntity.ok().body(studentService.findStudentByName(name));
            	
            } else if (studentClass != null) {
                return ResponseEntity.ok().body(studentService.findStudentByClassName(studentClass));
            }  
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
		 
    }

	@PutMapping("/updateStudent/{id}")
	public ResponseEntity<?> updateStudent(@PathVariable Long id, @RequestBody StudentEntity studentDetails) {
	    try {
	            return ResponseEntity.ok().body(studentService.updateStudent(id, studentDetails));
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
	    }
	}
	
	
	 
	
}
