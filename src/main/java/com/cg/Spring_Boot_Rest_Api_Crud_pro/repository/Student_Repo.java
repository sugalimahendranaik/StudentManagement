package com.cg.Spring_Boot_Rest_Api_Crud_pro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.Spring_Boot_Rest_Api_Crud_pro.entity.Student;

@Repository
public interface Student_Repo extends JpaRepository<Student, Integer> {

}
