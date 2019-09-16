package com.metacube.parking.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Vehicle {
	
	@NotBlank(message="{vehicleName.NotBlank}")
	@Size(min=2, max=10, message="{vehicleName.Size}")
	private String vehicleName;
	
	private String email;
	
	private String vehicleType;
	
	@NotBlank(message="{vehicleNumber.NotBlank}")
	@Size(min=2, max=12, message="{vehicleNumber.Size}")
	private String vehicleNumber;
	
	@NotBlank(message="{employeeId.NotBlank}")
	@Size(min=2, max=9, message="{employeeId.Size}")
	private String employeeId;
	
	@Size(min=2, max=50, message="{vehicleDetails.Size}")
	private String vehicleDetails;
	
	/**
	 * 
	 * @param email
	 * @param vehicleName
	 * @param vehicleType
	 * @param vehicleNumber
	 * @param employeeId
	 * @param vehicleDetails
	 */
	public Vehicle(String email , String vehicleName,	String vehicleType,	String vehicleNumber,	String employeeId,	String vehicleDetails) {
		this.email = email;
		this.employeeId=employeeId;
		this.vehicleDetails=vehicleDetails;
		this.vehicleName=vehicleName;
		this.vehicleNumber=vehicleNumber;
		this.vehicleType=vehicleType;
	}
	public Vehicle() {
	}
	
	/**
	 * 
	 * @return email of String Type
	 */
	public String getEmail() {
		return this.email;
	}
	/**
	 * 
	 * @param email of String Type
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 
	 * @return vehicleName of String Type
	 */
	public String getVehicleName() {
		return this.vehicleName;
	}
	/**
	 * 
	 * @param vehicleName of String Type
	 */
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	/**
	 * 
	 * @return vehicleType of String Type
	 */
	public String getVehicleType() {
		return this.vehicleType;
	}
	/**
	 * 
	 * @param vehicleType of String Type
	 */
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	/**
	 * 
	 * @return vehicleNumber of String Type
	 */
	public String getvehicleNumber() {
		return this.vehicleNumber;
	}
	/**
	 * 
	 * @param vehicleNumber of String Type
	 */
	public void setvehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	/**
	 * 
	 * @return employeeId of String Type
	 */
	public String getEmployeeId() {
		return this.employeeId;
	}
	/**
	 * 
	 * @param employeeId of String Type
	 */
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	/**
	 * 
	 * @return vehicleDetails of String Type
	 */
	public String getVehicleDetails() {
		return this.vehicleDetails;
	}
	/**
	 * 
	 * @param vehicleDetails of String Type
	 */
	public void setVehicleDetails(String vehicleDetails) {
		this.vehicleDetails = vehicleDetails;
	}	
}
