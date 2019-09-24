package com.metacube.parking.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Employee {
	
	@NotBlank(message="{fullName.NotBlank}")
	@Pattern(regexp="[a-zA-Z]+" , message="{fullName.OnlyAlphabates}")
	@Size(min=2, max=30, message="{fullName.Size}")
	private String fullName ;
	
	private String gender ;
	
	@NotBlank(message="{email.NotBlank}")
	@Size(min=2, max=30, message="{email.Size}")
	@Email(message="{email.ValidEmail}")
	private String email ;
	
	@NotBlank(message="{password.NotBlank}")
	@Pattern(regexp="[0-9]+" , message="{password.ValidPassword}")
	@Size(min=2, max=30, message="{password.Size}")
	private String password ;
	
	private String confirmPassword ;
	
	@NotBlank(message="{contactNumber.NotBlank}")
	@Pattern(regexp="[0-9]+" , message="{contactNumber.OnlyNumber}")
	@Size(min=8, max=10, message="{contactNumber.Size}")
	private String contactNumber ;
	
	private String organization  ;
	
	private String profilePhtotoUrl;
	/**
	 * 
	 * @param profilePhtotoUrl
	 * @param fullName
	 * @param gender
	 * @param email
	 * @param password
	 * @param confirmPassword
	 * @param contactNumber
	 * @param organization
	 */
	public Employee(String profilePhtotoUrl , String fullName , String gender , String email , String password , String confirmPassword , String contactNumber , String organization) {
		this.contactNumber = contactNumber;
		this.email = email ;
		this.fullName = fullName;
		this.gender = gender;
		this.organization = organization;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.profilePhtotoUrl = profilePhtotoUrl;
	}
	public Employee() {
	}
	/**
	 * 
	 * @return
	 */
	public String getFullName() {
		return this.fullName;
	}
	/**
	 * 
	 * @param fullName
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	/**
	 * 
	 * @return
	 */
	public String getProfilePhtotoUrl() {
		return this.profilePhtotoUrl;
	}
	/**
	 * 
	 * @param profilePhtotoUrl
	 */
	public void setProfilePhtotoUrl(String profilePhtotoUrl) {
		this.profilePhtotoUrl = profilePhtotoUrl;
	}
	/**
	 * 
	 * @return
	 */
	public String getGender() {
		return this.gender;
	}
	/**
	 * 
	 * @param gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * 
	 * @return
	 */
	public String getEmail() {
		return this.email;
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
		return this.password;
	}
	/**
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 
	 * @return
	 */
	public String getConfirmPassword() {
		return this.confirmPassword;
	}
	/**
	 * 
	 * @param confirmPassword
	 */
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	/**
	 * 
	 * @return
	 */
	public String getContactNumber() {
		return this.contactNumber;
	}
	/**
	 * 
	 * @param contactNumber
	 */
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	/**
	 * 
	 * @return
	 */
	public String getOrganization() {
		return this.organization;
	}
	/**
	 * 
	 * @param organization
	 */
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	@Override
	public String toString() {
		return "Employee [fullName=" + this.fullName + ", gender=" + this.gender + ", email=" + this.email + ", password=" + this.password
				+ ", contactNumber=" + this.contactNumber + ", organization=" + this.organization + "]";
	}
}