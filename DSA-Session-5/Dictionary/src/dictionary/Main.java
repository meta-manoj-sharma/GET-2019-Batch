package dictionary;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		try {
			while (true) {
				String key = "";
				String value = "";
				Scanner input = new Scanner(System.in);
				System.out.println("Enter the choice for String operation ");
				System.out.println("Enter 1 for add key value pair in dictionary  ");
				System.out.println("Enter 2 for delete key value pair in dictionary ");
				System.out.println("Enter 3 to get the value corresponding to a specified key, ");
				System.out.println("Enter 4 to get sorted list of key value pairs ");
				System.out.println("Enter 5 to get sorted list of key value pairs for all the keys >=K1 and <=K2 ");
				System.out.println("Enter 6 for Exit ");
				List<Value> valueList = new ArrayList<Value>();
				int choice = input.nextInt();
				input.nextLine(); // to ignoring enter value
				switch (choice) {
				case 1:
					System.out.println("Enter the key for dictionary");
					key = input.nextLine();
					System.out.println("Enter the second String");
					value = input.nextLine();
					
					break;
					
				}
			}
		} catch (Exception e) {
			System.out.println("Invalid entry...");
			main(args);
		}
	}

}
