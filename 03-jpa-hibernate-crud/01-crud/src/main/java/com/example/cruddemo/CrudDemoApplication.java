package com.example.cruddemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.cruddemo.dao.StudentDAO;
import com.example.cruddemo.entity.Student;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println(studentDAO.deleteAll());

	}

	private void deleteStudent(StudentDAO studentDAO) {
		Student theStudent = studentDAO.findById(3);

		System.out.println(theStudent);
		studentDAO.delete(3);
		Student theStudent2 = studentDAO.findById(3);

		System.out.println(theStudent2);
	}

	private void updateStudent(StudentDAO studentDAO) {
		Student theStudent = studentDAO.findById(1);

		System.out.println(theStudent);
		theStudent.setFirstName("Titochka");
		studentDAO.update(theStudent);
		System.out.println(theStudent);

	}

	private void findStudentsByLastName(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findByLastName("Maltanczyk");

		for (Student i : students){
			System.out.println(i);
		}
	}

	private void findAllStudents(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findAll();

		for (Student i : students){
			System.out.println(i);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student...");
		Student student1 = new Student("Tito", "Maltanczyk", "titos@gmail.com");

		System.out.println("Saving the student...");
		studentDAO.save(student1);

		System.out.println("Added student id: " + student1.getId());
		System.out.println("Founded student: "+studentDAO.findById(student1.getId()));
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("Creating new student...");
		Student student1 = new Student("Tito", "Goodboy", "titos2@gmail.com");
		Student student2 = new Student("Tony", "Parker", "tp9@gmail.com");
		Student student3 = new Student("Alex", "Megos", "carrot@gmail.com");

		System.out.println("Saving the student...");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);

		System.out.println("Added student id: " + student1.getId());
		System.out.println("Added student id: " + student2.getId());
		System.out.println("Added student id: " + student3.getId());

	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student...");
		Student student1 = new Student("Tito", "Maltanczyk", "titos@gmail.com");

		System.out.println("Saving the student...");
		studentDAO.save(student1);

		System.out.println("Added student id: " + student1.getId());

	}


}
