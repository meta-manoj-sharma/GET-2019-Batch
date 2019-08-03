package employee;

import java.util.*;
/**
 * class to get sorted list of employee according to name
 */
public class NameSorted implements Comparator<Employee> {
	public int compare(Employee object1, Employee object2) {
		return object1.getEmployeeName().compareTo(object2.getEmployeeName());
	}
}
