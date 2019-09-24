package com.metacube.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.student.dao.StudentDao;
import com.metacube.student.model.Student;

@Service
@Transactional
public class StudentService {
	@Autowired
	StudentDao daoObject;

	public void addStudentService(Student student) {
		daoObject.addStudent(student);
	}

	public List getAllstudent() {
		return daoObject.getAll();
	}
}
