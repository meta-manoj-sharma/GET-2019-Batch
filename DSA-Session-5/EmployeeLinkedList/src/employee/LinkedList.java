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
		newNode.next = null;

		if (list.headNode == null) {
			list.headNode = newNode;
		} else {
			Node last = list.headNode;
			while (last.next != null) {
				last = last.next;
			}
			last.next = newNode;
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
			nextNode = currentNode.next;
			while (nextNode != null) {
				if (nextNode.data.getEmployeeSalary() > currentNode.data.getEmployeeSalary()) {
					swapFlag = currentNode.data;
					currentNode.data = nextNode.data;
					nextNode.data = swapFlag;
				}
				//for sorting on age basis when salary of two employees are equal 
				if (nextNode.data.getEmployeeSalary() == currentNode.data.getEmployeeSalary()) {
					if (nextNode.data.getEmployeeAge() <= currentNode.data.getEmployeeAge()) {
						swapFlag = currentNode.data;
						currentNode.data = nextNode.data;
						nextNode.data = swapFlag;
					}
				}
				nextNode = nextNode.next;
			}
			currentNode = currentNode.next;
		}
		return employeeList;
	}
}
