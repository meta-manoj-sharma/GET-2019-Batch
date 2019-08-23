package quicksort;

import java.util.*;

public class Main {
	public static void main(String args[])
	{
	
		try {
			LinkedListOperation employeeList; 
			Employee employeeObject;
			Scanner input = new Scanner(System.in);
			String employeeName;
			int employeeAge, noOfEmployee, flag, employeeId, employeeSalary;
			while (true) 
			{
				System.out.println("enter no. of employee");
				noOfEmployee = input.nextInt();
				employeeList = new LinkedListOperation();
				if (noOfEmployee > 0) 
				{
					while (noOfEmployee != 0) 
					{
			while (true) {
				System.out.println("enter no. of employee");
				noOfEmployee = input.nextInt();
				employeeList = new LinkedListOperation();
				if (noOfEmployee > 0) {

					while (noOfEmployee != 0) {
						input.nextLine();
						System.out.println("enter Name of employee");
						employeeName = input.nextLine();
						if(employeeName.charAt(0)==' ')
						{
							throw new Exception();
						}
						System.out.println("enter Id of employee");
						employeeId = input.nextInt();
						System.out.println("enter Age. of employee");
						employeeAge = input.nextInt();
						if(employeeAge >= 18)
						{
						if(employeeAge >= 18){
						System.out.println("enter Salary of employee");
						employeeSalary = input.nextInt();
						employeeObject = new Employee(employeeId, employeeName, employeeSalary, employeeAge);
						employeeList = employeeList.addEmployee(employeeList, employeeObject);
						noOfEmployee--;
						}
						else
						{
						else{
							System.out.println("Employee age should be 18 or greater than 18...");
							System.out.println("Enter data again");
						}
					}
					System.out.println("Entered list is.....");
					employeeList.printEmployeeList(employeeList);
					employeeList.headNode = employeeList.quickSort(employeeList.headNode);
					System.out.println(" ");
					System.out.println("List after sorting.....");
					employeeList.printEmployeeList(employeeList);
					System.out.println("Press 0 to exit or any number to continue");
					flag = input.nextInt();
					input.nextLine();
					if (flag == 0) 
					{
						System.out.println("Program exit....");
						System.exit(0);
					}
				} 
				else
					System.out.println("Employees number can't be null or negative");
			}
		} 
		catch (Exception e) 
		{
					if (flag == 0) {
						System.out.println("Program exit....");
						System.exit(0);
					}
				} else
					System.out.println("Employees number can't be null or negative");
			}
		} catch (Exception e) {
			System.out.println("Invalid data....  program restart");
			main(args);
		}
	}
}
