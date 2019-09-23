package com.metacube.student;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.ui.Model;

import com.metacube.student.controller.HomeController;
import com.metacube.student.model.Student;

public class StudentSystemTest {
	Student student = new Student();
	HomeController controller = new HomeController();

	@Test
	public void formPostTest() {
		Student student = new Student();
		HomeController controller = new HomeController();
		assertEquals("detail", controller.formPost(student));
	}

	@Test
	public void showStudentTest() {
		Student student = new Student();
		HomeController controller = new HomeController();
		assertEquals("showStudent", controller.showStudent());
	}

	@Test
	public void formPostTestNegative() {
		Student student = new Student();
		HomeController controller = new HomeController();
		assertNotEquals("details", controller.formPost(student));
	}

	@Test
	public void showStudentTestNegative() {
		Student student = new Student();
		HomeController controller = new HomeController();
		assertNotEquals("Student", controller.showStudent());
	}
}
