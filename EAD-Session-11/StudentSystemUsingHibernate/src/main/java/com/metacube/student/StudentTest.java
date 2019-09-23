package com.metacube.student;

import static org.junit.Assert.*;

import org.junit.Test;

import com.metacube.student.dao.StudentDao;
import com.metacube.student.model.Student;
import com.metacube.student.service.StudentService;

public class StudentTest {
	@Test
	public void testAddStudent() {
		StudentDao daoObject = new StudentDao();
		Student student = new Student();
		student.setId(3);
		student.setAge(18);
		student.setClassName(10);
		student.setEmail("man12@gmail.com");
		student.setFatherName("jagdish");
		student.setFirstName("manoj");
		student.setLastName("sharma");
		assertEquals(true, daoObject.addStudent(student));
	}

	@Test
	public void testAddStudentNegative() {
		Student student = new Student();
		StudentDao daoObject = new StudentDao();
		assertEquals(false, daoObject.addStudent(student));
	}
}
