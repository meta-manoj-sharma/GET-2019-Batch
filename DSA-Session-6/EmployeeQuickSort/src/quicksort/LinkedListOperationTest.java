package quicksort;
import java.util.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedListOperationTest {
	LinkedListOperation object=new LinkedListOperation();
	@Test
	public void testSortList1() {
		
			LinkedListOperation objectOfEmployeeList=new LinkedListOperation();
	
		Employee objectOfemployee1=new Employee(2,"Shamshir",10000,20);
		Employee objectOfemployee2=new Employee(1,"Vikrant",21600,23);
		Employee objectOfemployee3=new Employee(4,"Varun",22500,23);
		Employee objectOfemployee4=new Employee(5,"Surya",12000,23);
		Employee objectOfemployee5=new Employee(3,"Raju",500,24);
		object.addEmployee(objectOfEmployeeList, objectOfemployee1);
		object.addEmployee(objectOfEmployeeList, objectOfemployee2);
		object.addEmployee(objectOfEmployeeList,  objectOfemployee3);
		object.addEmployee(objectOfEmployeeList,  objectOfemployee4);
		object.addEmployee(objectOfEmployeeList,  objectOfemployee5);
		objectOfEmployeeList.headNode=objectOfEmployeeList.quickSort(objectOfEmployeeList.headNode);
		List<Employee> list1=new ArrayList<Employee>();
		list1=object.resultList(objectOfEmployeeList);
		String expected[]=new String[] {"Varun","Vikrant","Surya","Shamshir","Raju"};
		String actual[]=new String[5];
		for(int i=0;i<list1.size();i++)
		{
			actual[i]=list1.get(i).getEmployeeName();
		}
		assertArrayEquals(actual,expected);
	}
}
