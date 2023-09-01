package com.schantz.springbootrestapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.schantz.springbootrestapi.bean.Student;


@RestController
public class StudentController {
	
	//http://localhost:8080/student
	@GetMapping("student")
	public Student getStudent() {
		Student student = new Student(1, "Douglas");
		return student;
	}
	
	//http://localhost:8080/students
	@GetMapping("students")
	public List<Student> getStudents(){
		List<Student> students = new ArrayList<>();
		students.add(new Student(1, "Douglas"));
		students.add(new Student(2, "Taina"));
		students.add(new Student(3, "Pedro"));
		students.add(new Student(4, "Maria"));
		return students;
		
	}
	
	//spring boot rest api with path variable
	@GetMapping("students/{id}/{name}")
	public Student studentPathVariable(@PathVariable("id") int studentId, @PathVariable("name") String name) {
		return new Student(studentId, name);
	}
	
	
}
