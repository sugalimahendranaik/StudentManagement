package com.cg.Spring_Boot_Rest_Api_Crud_pro.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.Spring_Boot_Rest_Api_Crud_pro.entity.Student;
import com.cg.Spring_Boot_Rest_Api_Crud_pro.repository.Student_Repo;

@Service
public class Student_Service {
	@Autowired
	Student_Repo repo;
	public Student saveStudent(Student s) {
		return repo.save(s);
	}
	
	public List<Student> getAllStudent(){
		List<Student> s = repo.findAll();
		return s;
	}
	
	public Student getStudentById(int id) {
		Student s = repo.findById(id).get();
		return s;
	}
	
	public Student updateStudent(Student s, int id) {
	    Student student = repo.findById(id).orElse(null);
	    if (student != null) {
	    	student.setName(s.getName());
	    	student.setBranch(s.getBranch());
	    	student.setMob_num(s.getMob_num());
	        return repo.save(student);
	    } else {
	        throw new RuntimeException("Student not found with ID: " + id);
	    }
	}
	
	public String deleteStudent(int id) {
	    repo.deleteById(id);
	    return "Deleted Successfully";
	}
}
