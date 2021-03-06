package employee;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			LinkedList employeeList; 
			Employee employeeObject;
			Scanner input = new Scanner(System.in);
			String employeeName;
			int employeeAge, noOfEmployee, flag;
			double employeeSalary;
			while (true) {
				System.out.println("enter no. of employee");
				noOfEmployee = input.nextInt();
				employeeList = new LinkedList();
				if (noOfEmployee > 0) {

					while (noOfEmployee != 0) {
						input.nextLine();
						System.out.println("enter Name of employee");
						employeeName = input.nextLine();
						if(employeeName.charAt(0)==' ')
						{
							throw new Exception();
						}
						System.out.println("enter Age. of employee");
						employeeAge = input.nextInt();
						System.out.println("enter Salary of employee");
						employeeSalary = input.nextDouble();
						employeeObject = new Employee(employeeName, employeeSalary, employeeAge);
						employeeList = employeeList.insert(employeeList, employeeObject);
						noOfEmployee--;
					}
					employeeList.sortBySalary(employeeList);
					Node currentNode = employeeList.headNode;
					while (currentNode != null) {
						System.out.println("Name- " + currentNode.employeeData.getEmployeeName() + "  Age- "	+ currentNode.employeeData.getEmployeeAge()
								                    + "  Salary- " + currentNode.employeeData.getEmployeeSalary());
						currentNode = currentNode.nextLink;
					}
					System.out.println("Press 0 to exit or any number to continue");
					flag = input.nextInt();
					input.nextLine();
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
