package com.schantz.springbootrestapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.schantz.springbootrestapi.bean.Student;


@RestController
public class StudentController {
	
	//http://localhost:8080/student
	@GetMapping("student")
	public ResponseEntity<Student> getStudent() {
		Student student = new Student(1, "Douglas");
		//return new ResponseEntity<>(student, HttpStatus.OK);
		return ResponseEntity.ok(student);
		
	}
	
	//http://localhost:8080/students
	@GetMapping("students")
	public  List<Student> getStudents(){
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
	
	//http://localhost:8080/students/query?id=1&name=douglas
	@GetMapping("students/query")
	public Student StudentRequestVariable(@RequestParam int id, @RequestParam String name) {
		return new Student(id, name);
	}
	
	//spring boot res api that handle http post request
	//@postpaming and @requestbody
	@PostMapping("students/create")
	@ResponseStatus(HttpStatus.CREATED)
	public Student createStudent(@RequestBody Student student) {
		System.out.println(student.getId());
		System.out.println(student.getName());
		return student;
	}
	
	//spring booot rest api that handles http put request
	@PutMapping("students/{id}/update")
	public Student updateStudent(@RequestBody Student student, @PathVariable("id") int studentId) {
		System.out.println(student.getName());
		return student;
	}
	
	//Spring Boot rest api tha handles http delete request
	@DeleteMapping("students/{id}/delete")
	public String deleteStudent(@PathVariable("id") int studentId) {
		return "Studente deleted sucessfull";
	}
	
	
	
	
	
	
	
	
	
}
