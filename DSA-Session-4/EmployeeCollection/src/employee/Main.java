package employee;

import java.util.*;

public class Main {

	public static void main(String[] args) {
			try {
			Scanner input = new Scanner(System.in);
			Employee employeeObject;
			EmployeeList employeeListObject = new EmployeeList();
			;
			int choiceId, choice;
			String choiceName, choiceAddress;
			while (true) {
				System.out.println("Enter 1 for Add employee");
				System.out.println("Enter 2 for sort employee in natural order");
				System.out.println("Enter 3 for sort employees by name");
				System.out.println("Enter 4 for display employees list");
				System.out.println("Enter 5 for Exit");
				choice = input.nextInt();
				switch (choice) {
				case 1:
					System.out.println("Enter employee Id");
					choiceId = input.nextInt();
					input.nextLine();
					System.out.println("Enter employee Name");
					choiceName = input.nextLine();
					System.out.println("Enter employee Address");
					choiceAddress = input.nextLine();
					employeeObject = new Employee(choiceName, choiceAddress, choiceId);
					employeeListObject.getUniqueEmployeeList(choiceId, employeeObject);
					employeeListObject.getEmployeeList();
					System.out.println("added");
					break;
				case 2:
					employeeListObject.getNaturalSortedEmployeeList();
					employeeListObject.display();
					System.out.println("sorted ....");
					break;
				case 3:
					employeeListObject.getNameSortedEmployeeList();
					employeeListObject.display();
					System.out.println("sorted ....");
					break;
				case 4:
					employeeListObject.display();
					break;
				case 5:
					System.out.println("program exited....");
					System.exit(0);
				}
			}
		} catch (Exception e) {
			System.out.println("Invalid entry");
			main(args);
		}
	}
}
