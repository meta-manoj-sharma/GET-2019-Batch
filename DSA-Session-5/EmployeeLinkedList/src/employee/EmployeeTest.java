package employee;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class EmployeeTest {

	@Test
	public void testSortBySalary() {
		LinkedList employeeList = new LinkedList();
		Employee employeeObject = new Employee("A", 12000, 20);
		employeeList.insert(employeeList, employeeObject);
		Employee employeeObject1 = new Employee("B", 30000, 23);
		employeeList.insert(employeeList, employeeObject1);
		Employee employeeObject2 = new Employee("C", 6000, 26);
		employeeList.insert(employeeList, employeeObject2);
		employeeList.sortBySalary(employeeList);
		Node currentNode = employeeList.headNode;
		assertEquals("B", currentNode.data.getEmployeeName());
		currentNode = currentNode.next;
		assertEquals("A", currentNode.data.getEmployeeName());
		currentNode = currentNode.next;
		assertEquals("C", currentNode.data.getEmployeeName());
	}
// test case for equal salary condition then sort by age
	@Test
	public void testSortByAge() {
		LinkedList employeeList = new LinkedList();
		Employee employeeObject = new Employee("A", 12000, 23);
		employeeList.insert(employeeList, employeeObject);
		Employee employeeObject1 = new Employee("B", 12000, 20);
		employeeList.insert(employeeList, employeeObject1);
		Employee employeeObject2 = new Employee("C", 12000, 18);
		employeeList.insert(employeeList, employeeObject2);
		employeeList.sortBySalary(employeeList);
		Node currentNode = employeeList.headNode;
		assertEquals("C", currentNode.data.getEmployeeName());
		currentNode = currentNode.next;
		assertEquals("B", currentNode.data.getEmployeeName());
		currentNode = currentNode.next;
		assertEquals("A", currentNode.data.getEmployeeName());
	}

}
