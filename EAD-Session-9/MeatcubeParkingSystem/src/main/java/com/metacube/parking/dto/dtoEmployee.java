package com.metacube.parking.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class dtoEmployee {
	
	@NotBlank(message="{fullName.NotBlank}")
	@Pattern(regexp="[a-zA-Z]+" , message="{fullName.OnlyAlphabates}")
	@Size(min=2, max=30, message="{fullName.Size}")
	private String fullName ;
	
	private String gender ;
	
	@NotBlank(message="{email.NotBlank}")
	@Email(message="{email.ValidEmail}")
	private String email ;
	
	@NotBlank(message="{contactNumber.NotBlank}")
	@Pattern(regexp="[0-9]+" , message="{contactNumber.OnlyNumber}")
	@Size(min=8, max=10, message="{contactNumber.Size}")
	private String contactNumber ;
	
	private String organization  ;
	/**
	 * 
	 * @param fullName
	 * @param gender
	 * @param email
	 * @param contactNumber
	 * @param organization
	 */
	public dtoEmployee(String fullName , String gender , String email , String contactNumber , String organization) {
		this.contactNumber = contactNumber;
		this.email = email ;
		this.fullName = fullName;
		this.gender = gender;
		this.organization = organization;
	}
	/**
	 * 
	 */
	public dtoEmployee() {
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

	public String toString() {
		return "Employee [fullName=" + this.fullName + ", gender=" + this.gender + ", email=" + this.email +", contactNumber=" + this.contactNumber + ", organization=" + this.organization + "]";
	}
}