package com.metacube.student.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.metadata.ClassMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.student.model.Student;

@Transactional
@Component
public class StudentDao {
	@Autowired
	HibernateTemplate template;

	@Autowired
	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	public boolean addStudent(Student student) {
		boolean value = false;
		try {
			template.save(Student);
			value = true;
		} catch (Exception e) {
			e.getMessage();
			System.out.println(e.getMessage());
		}
		return value;
	}

	/**
	 * Gets All the Students
	 * @return {List<Student>} list of students
	 */
	public List<Student> getAll() {
		return template.loadAll(Student.class);
	}
}
