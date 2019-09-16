package com.metacube.parking.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class Login {
	
	@NotBlank(message="{email.NotBlank}")
	@Email(message="{email.ValidEmail}")
	private String email;
	
	private String password;
	/**
	 * 
	 * 
	 * @param email
	 * @param password
	 */
	public Login(String email , String password) {
		this.email = email;
		this.password = password;
	}
	public Login() {
		
	}
	/**
	 * 
	 * @return
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 
	 * @return
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Login [email=" + email + ", password=" + password + "]";
	}
}