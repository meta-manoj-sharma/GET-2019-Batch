package employee;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class EmployeeListTest {

	@Test
	public void testSortById() {
		List<Employee> employeeList;
		EmployeeList employeeListObject = new EmployeeList();
		Employee object = new Employee("Jugal", "Udaipur", 1);
		employeeListObject.getUniqueEmployeeList(1, object);
		employeeListObject.getEmployeeList();
		Employee object1 = new Employee("Aman", "Kanpur", 3);
		employeeListObject.getUniqueEmployeeList(3, object1);
		employeeListObject.getEmployeeList();
		Employee object2 = new Employee("manoj", "Jaipur", 2);
		employeeListObject.getUniqueEmployeeList(2, object2);
		employeeListObject.getEmployeeList();
		employeeList = employeeListObject.getNaturalSortedEmployeeList();
		assertEquals("Jugal", employeeList.get(0).getEmployeeName());
		assertEquals("manoj", employeeList.get(1).getEmployeeName());
	}

	@Test
	public void testSortByName1() {
		List<Employee> employeeList;
		EmployeeList employeeListObject = new EmployeeList();
		Employee object = new Employee("Jugal", "Udaipur", 1);
		employeeListObject.getUniqueEmployeeList(1, object);
		employeeListObject.getEmployeeList();
		Employee object1 = new Employee("Aman", "Kanpur", 3);
		employeeListObject.getUniqueEmployeeList(3, object1);
		employeeListObject.getEmployeeList();
		Employee object2 = new Employee("manoj", "Jaipur", 2);
		employeeListObject.getUniqueEmployeeList(2, object2);
		employeeListObject.getEmployeeList();
		employeeList = employeeListObject.getNameSortedEmployeeList();
		assertEquals("Aman", employeeList.get(0).getEmployeeName());
		assertEquals("Jugal", employeeList.get(1).getEmployeeName());
	}
}
