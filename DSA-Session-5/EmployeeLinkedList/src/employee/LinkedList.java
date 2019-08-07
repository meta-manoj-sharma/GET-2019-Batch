package employee;
/**
 * program to get employee list based on their salary
 * @author Manoj Sharma
 * Dated 3 august 2019 
 */
public class LinkedList {
	Node headNode;
/**
 * method to insert data into linked list
 * @param list linked list which contain employee data
 * @param data of employee
 * @return list of employee
 */
	public LinkedList insert(LinkedList list, Employee data) {
		Node newNode = new Node(data);
		newNode.nextLink = null;

		if (list.headNode == null) {
			list.headNode = newNode;
		} else {
			Node last = list.headNode;
			while (last.nextLink != null) {
				last = last.nextLink;
			}
			last.nextLink = newNode;
		}
		return list;
	}
/**
 * method to get list of employee sorted by salary
 * @param employeeList get list of employees
 * @return sorted list
 */
	public LinkedList sortBySalary(LinkedList employeeList) {

		Node currentNode = employeeList.headNode;
		Node nextNode = null;
		Employee swapFlag;
		while (currentNode != null) {
			nextNode = currentNode.nextLink;
			while (nextNode != null) {
				if (nextNode.employeeData.getEmployeeSalary() > currentNode.employeeData.getEmployeeSalary()) {
					swapFlag = currentNode.employeeData;
					currentNode.employeeData = nextNode.employeeData;
					nextNode.employeeData = swapFlag;
				}
				//for sorting on age basis when salary of two employees are equal 
				if (nextNode.employeeData.getEmployeeSalary() == currentNode.employeeData.getEmployeeSalary()) {
					if (nextNode.employeeData.getEmployeeAge() <= currentNode.employeeData.getEmployeeAge()) {
						swapFlag = currentNode.employeeData;
						currentNode.employeeData = nextNode.employeeData;
						nextNode.employeeData = swapFlag;
					}
				}
				nextNode = nextNode.nextLink;
			}
			currentNode = currentNode.nextLink;
		}
		return employeeList;
	}
}
