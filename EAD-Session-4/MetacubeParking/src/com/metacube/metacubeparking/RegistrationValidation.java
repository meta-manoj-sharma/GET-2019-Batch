package com.metacube.metacubeparking;

/**
 * The Class RegistrationValidation.
 */
public class RegistrationValidation {
	
	/** The error. */
	private String error="";
	
	/**
	 * Validate.
	 * @param name the name
	 * @param password the password
	 * @param ConfirmPassword String type
	 * @param email the email
	 * @param contact the contact
	 * @return error String type
	 */
	public String validate(String name,String password, String ConfirmPassword, String email, String contact){
		if(name.trim().equals("")){
			this.error = "Name Cannnot Contain Only Spaces";
		}
		else if(!name.matches("[a-z A-z]+")){
			this.error = "Name Should Contain only Aplhabets";
		}
		else if(!email.matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$")){
			this.error = "Invalid Email Entered";
		}
		else if(!password.matches("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,15}$")){
			this.error = "Password should contain 8 - 15 characters having one Capital letter , one Small letter , one numeric digit and one Special Character excluding blank spac";
		}
		else if(!password.equals(ConfirmPassword)) {
			this.error = "Password and Confirm Password are not Same";
		}
		else if(contact.length()<8 ||contact.length()>11){
			this.error = "Contact Number should be between 8-10 digits";
		}
		else if(!contact.matches("[0-9]+")) {
			this.error = "Contact Number should Contain only Numeric Digits";
		}
		return this.error;
	}
}