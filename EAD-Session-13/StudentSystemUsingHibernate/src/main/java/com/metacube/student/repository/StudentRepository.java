package com.metacube.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metacube.student.model.Student;
/**
 * JPA  repository class for various database related operations
 */
public interface StudentRepository extends JpaRepository<Student, String> {

	// @Query("SELECT * FROM detail AS c WHERE c.email =email")
	Student findByEmail(String email);
}