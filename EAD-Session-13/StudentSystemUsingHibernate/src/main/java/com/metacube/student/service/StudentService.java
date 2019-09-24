package com.metacube.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.metacube.student.model.Student;
import com.metacube.student.repository.StudentRepository;

@Service
@Transactional
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;

	public boolean addStudent(Student student) {
		boolean value = false;
		try {
			studentRepository.save(student);
			value = true;
		} catch (Exception e) {
			e.getMessage();
		}
		return value;
	}

	public List<Student> getAllStudent() {
		return studentRepository.findAll();
	}

	public Student getByEmail(String email) {
		return studentRepository.findByEmail(email);
	}
}
