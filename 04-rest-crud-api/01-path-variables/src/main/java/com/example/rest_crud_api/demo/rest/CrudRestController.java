package com.example.rest_crud_api.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest_crud_api.demo.entity.Student;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class CrudRestController {

	private List<Student> students;

	@PostConstruct
	public void loadData(){
		students = new ArrayList<>();

		students.add(new Student("Tito", "Maltanczyk", 1));
		students.add(new Student("Titobasko", "Maltanczyk", 2));
		students.add(new Student("Tony", "Parker", 3));
	}

	@GetMapping("/students")
	public List<Student> getAllStudents(){
		return getStudents();
	}

	@GetMapping("/student/{studentId}")
	public Student getStudentById(@PathVariable Integer studentId){
		if (studentId >= students.size() || studentId < 0) {
			throw new StudentNotFoundException("Student id not fount - " + studentId);
		}
		return students.get(studentId);
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public List<Student> getStudents() {
		return students;
	}

	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {
		StudentErrorResponse studentErrorResponse = new StudentErrorResponse();

		studentErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		studentErrorResponse.setMessage(exc.getMessage());
		studentErrorResponse.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(studentErrorResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
		StudentErrorResponse studentErrorResponse = new StudentErrorResponse();

		studentErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		studentErrorResponse.setMessage(exc.getMessage());
		studentErrorResponse.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(studentErrorResponse, HttpStatus.BAD_REQUEST);
	}

}
