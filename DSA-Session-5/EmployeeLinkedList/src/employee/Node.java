package employee;

public class Node {
	Employee employeeData;
	Node nextLink;

	Node(Employee employeeData) {
		this.employeeData = employeeData;
		this.nextLink = null;
	}
}
