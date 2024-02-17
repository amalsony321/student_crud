package com.student.stddetails.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.stddetails.model.Student;


public interface StudentRepository extends JpaRepository<Student, Long> {

}
