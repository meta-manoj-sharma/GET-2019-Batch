package employee;

import java.util.*;

public class Employee implements Comparable<Employee> {
	private String employeeName;
	private String employeeAddress;
	private int employeeId;
/*
 * constructor to get employee details
 */
	Employee(String employeeName, String employeeAddress, int employeeId) {
		this.employeeName = employeeName;
		this.employeeAddress = employeeAddress;
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return this.employeeName;
	}

	public String getEmployeeAddress() {
		return this.employeeAddress;
	}

	public int getEmployeeId() {
		return this.employeeId;
	}
// method to compare and sort employee list according employee id
	public int compareTo(Employee object) {
		return this.getEmployeeId() - object.getEmployeeId();
	}
}
