package com.metacube.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class StudentSystemUsingHibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentSystemUsingHibernateApplication.class, args);
	}

}
