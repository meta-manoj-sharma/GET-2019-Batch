package com.metacube.metacubeparking;

/**
 * The Class VehicleValidation.
 */
public class VehicleValidation {
	
	/** The error. */
	private String error = "";

	/**
	 * Validate.
	 * @param name the name
	 * @param type the type
	 * @param number the number
	 * @param employeeId the employee id
	 * @return error String type
	 */
	public String validate(String name, String type, int number, int employeeId) {
		if (name.trim().equals("")) {
			this.error = "Vehicle Name Cannnot be blank";
		} else if (number <= 0) {
			this.error = "Vehicle Number Cannnot be blank";
		} else if (type.equals("")) {
			this.error = "Vehicle Type Cannnot be blank";
		} else if (employeeId <= 0) {
			this.error = "Employee Id Cannnot be blank";
		}
		return this.error;
	}
}