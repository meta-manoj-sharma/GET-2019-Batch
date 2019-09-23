package com.metacube.student.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

/**
 * Assignment based on spring security database authentication
  * @author Manoj Sharma 
  * Dated 19 sept 2019
 */
@Entity
@Table(name = "StudentInfo")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	private Integer id;

	@Column(name = "firstName")
	@NotBlank(message = "{firstNameError}")
	@Size(min = 2, max = 50)
	@Pattern(regexp = "[a-z A-Z]+", message = "{firstNameError.OnlyAlphabates}")
	private String firstName;

	@Column(name = "lastName")
	@NotBlank(message = "{lastNameError}")
	@Size(min = 2, max = 50)
	@Pattern(regexp = "[a-z A-Z]+", message = "{lastNameError.OnlyAlphabates}")
	private String lastName;

	@Column(name = "fatherName")
	@NotBlank(message = "{fatherNameError}")
	@Size(min = 2, max = 50)
	@Pattern(regexp = "[a-z A-Z]+", message = "{fatherNameError.OnlyAlphabates}")
	private String fatherName;

	@Column(name = "email")
	@NotBlank(message = "{emailBlank}")
	@Pattern(regexp = "^[a-zA-Z0-9.!#$%&'*+=?^_`{|}~-]+@[a-z0-9.-]+\\.[a-z]{2,}$", message = "{emailPattern}")
	private String email;

	@Column(name = "className")
	@NotNull(message = "{classBlank}")
	@Range(min = 1, max = 12, message = "{classNamePattern}")
	private Integer className;

	@Column(name = "age")
	@NotNull(message = "{ageBlank}")
	@Range(min = 1, max = 100, message = "{agePattern}")
	private Integer age;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getClassName() {
		return className;
	}

	public void setClassName(Integer className) {
		this.className = className;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}