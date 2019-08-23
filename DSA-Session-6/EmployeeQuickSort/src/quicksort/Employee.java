package quicksort;

public class Employee {
	private int employeeId;
	private String employeeName;
	private int employeeSalary;
	private int employeeAge;

	public Employee(int employeeId, String name, int salary, int age) 
	{
	public Employee(int employeeId, String name, int salary, int age) {
		this.employeeId = employeeId;
		this.employeeName = name;
		this.employeeSalary = salary;
		this.employeeAge = age;
	}

	// Getters
	public int getEmployeeId() 
	{
		return employeeId;
	}

	public String getEmployeeName() 
	{
		return employeeName;
	}

	public int getEmployeeSalary()
	{
		return employeeSalary;
	}

	public int getEmployeeAge() 
	{
	public int getEmployeeId() {
		return employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public int getEmployeeSalary() {
		return employeeSalary;
	}

	public int getEmployeeAge() {
		return employeeAge;
	}
}
