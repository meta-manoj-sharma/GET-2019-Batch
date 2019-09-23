package com.metacube.student.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
/**
 * Assignment based on spring mvc 
 * @author Manoj Sharma
 * Dated 19 sept 2019
 */
public class Student {
	@NotBlank(message = "{firstNameError}")
	@Pattern(regexp = "[a-z A-Z]+", message = "{firstNameError.OnlyAlphabates}")
	private String firstName;
	@NotBlank(message = "{lastNameError}")
	@Pattern(regexp = "[a-z A-Z]+", message = "{lastNameError.OnlyAlphabates}")
	private String lastName;
	@NotBlank(message = "{fatherNameError}")
	@Pattern(regexp = "[a-z A-Z]+", message = "{fatherNameError.OnlyAlphabates}")
	private String fatherName;

	@NotBlank(message = "{emailBlank}")
	@Pattern(regexp="^[a-zA-Z0-9.!#$%&'*+=?^_`{|}~-]+@[a-z0-9.-]+\\.[a-z]{2,}$",message="{emailPattern}")
	private String email;

	@NotBlank(message = "{classBlank}")
	@Pattern(regexp = "\\d+", message = "{classNamePattern}")
	String className;

	@NotBlank(message = "{ageBlank}")
	@Pattern(regexp = "\\d+", message = "{agePattern}")
	String age;

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

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
}