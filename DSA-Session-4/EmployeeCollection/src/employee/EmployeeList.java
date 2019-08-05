package employee;

import java.util.*;
/**
 * program to store information of employees
 * @author Manoj sharma
 * Dated 1 august 2019
 */
public class EmployeeList {
	public Map<Integer, Employee> uniqueEmployeeList = new HashMap<Integer, Employee>();
	public List employeeList = new ArrayList<Employee>();
/**
 * get unique employees map value and convert it into list
 * @return list of employees
 */
	public List<Employee> getEmployeeList() {
		employeeList.clear();
		Iterator employeeListIterator = uniqueEmployeeList.entrySet()
				.iterator();
		while (employeeListIterator.hasNext()) {
			Map.Entry listElement = (Map.Entry) employeeListIterator.next();
			employeeList.add(listElement.getValue());
		}
		return employeeList;
	}
/**
 * @param employeeId is enter by user to employee
 * @param empObject object of employee class
 * @return unique list of employees 
 */
	public Map<Integer, Employee> getUniqueEmployeeList(int employeeId,
			Employee empObject) {
		if (uniqueEmployeeList.containsKey(employeeId)) {
			System.out.println("!Warning...... employee already exist to this id ");
		} else {
			uniqueEmployeeList.put(employeeId, empObject);
		}
		return uniqueEmployeeList;
	}
/**
 * @return list of employees in natural sorted manner
 */
	public List<Employee> getNaturalSortedEmployeeList() {
		Collections.sort(employeeList);
		return employeeList;
	}
/**
 * @return list of employees in name sorted manner
 */
	public List<Employee> getNameSortedEmployeeList() {
		Collections.sort(employeeList, new NameSorted());
		return employeeList;
	}
/**
 * Display the list of employees
 */
	public void display() {
		System.out.println(" list is ");
		for (int i = 0; i < employeeList.size(); i++) {
			System.out.println(" EmpId- " +((Employee) employeeList.get(i)).getEmployeeId()
					+ "  Name- " + ((Employee) employeeList.get(i)).getEmployeeName()
					+ "   Address- " + ((Employee) employeeList.get(i)).getEmployeeAddress());
		}
	}
}
