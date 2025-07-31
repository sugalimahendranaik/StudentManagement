package com.cg.Spring_Boot_Rest_Api_Crud_pro.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.cg.Spring_Boot_Rest_Api_Crud_pro.entity.Student;
import com.cg.Spring_Boot_Rest_Api_Crud_pro.service.Student_Service;

@RestController
public class Student_Controller {
	@Autowired
	Student_Service service;
	
	// 1.get all the Students 
	@GetMapping("/students")
	public List<Student> getAll(){
		return service.getAllStudent();
	}
	
	// 2.get student by id
	@GetMapping("/student/{id}")
	public Student getById(@PathVariable int id) {
		return service.getStudentById(id);
	}
	
	// 3.create student
	@PostMapping("/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createStudent(@RequestBody Student student) {
		service.saveStudent(student);
	}
	
	// 4.update student
	@PutMapping("/update/{id}")
	public Student update(@RequestBody Student student, @PathVariable int id) {
	    return service.updateStudent(student, id);
	}


	// 5.delete student
	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable int id) {
	    return service.deleteStudent(id);
	}
}
