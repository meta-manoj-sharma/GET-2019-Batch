package employee;

public class Employee {
	private String employeeName;
	private double employeeSalary;
	private int employeeAge;
/*
 * constructor to get employee details
 */
	Employee(String employeeName, double employeeSalary, int employeeAge) {
		this.employeeName = employeeName;
		this.employeeSalary = employeeSalary;
		this.employeeAge = employeeAge;
	}

	public String getEmployeeName() {
		return this.employeeName;
	}

	public double getEmployeeSalary() {
		return this.employeeSalary;
	}
	public int getEmployeeAge() {
		return this.employeeAge;
	}
}
