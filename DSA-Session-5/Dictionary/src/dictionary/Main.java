package dictionary;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class Main {

	public static void main(String[] args) {
		try {
			DictionaryImp dictionaryObj = new DictionaryImp();
			while (true) {
				String key = "";
				String value = "";
				Scanner input = new Scanner(System.in);
				System.out.println("Enter 1 for add key value pair in dictionary  ");
				System.out.println("Enter 2 for delete key value pair in dictionary ");
				System.out.println("Enter 3 to get the value corresponding to a specified key, ");
				System.out.println("Enter 4 to get sorted list of key value pairs ");
				System.out.println("Enter 5 to get sorted list of key value pairs for all the keys >=K1 and <=K2 ");
				System.out.println("Enter 6 for display ");
				System.out.println("Enter 7 for Exit ");
				List<Value> valueList = new ArrayList<Value>();
				int choice = input.nextInt();
				input.nextLine(); // to ignoring enter value
				switch (choice) {
				case 1:
					System.out.println("Enter the key for dictionary");
					key = input.nextLine();
					System.out.println("Enter the value for dictionary");
					value = input.nextLine();
					dictionaryObj.add(key, value);
					break;
				case 2:
					System.out.println("Enter the key to be delete");
					key = input.nextLine();
					dictionaryObj.delete(key);
					break;
				case 3:
					System.out.println("Enter the key to get value");
					key = input.nextLine();
					System.out.println("value- " +dictionaryObj.getValue(key));
					break;
				case 4:
					valueList = dictionaryObj.getAll();
					dictionaryObj.display(valueList);
					break;
				case 5:
					System.out.println("Enter the key 1 ");
					key = input.nextLine();
					System.out.println("Enter the key 2");
					value = input.nextLine();
					valueList = dictionaryObj.getBetween(key, value);
					dictionaryObj.display(valueList);
					break;
				case 6:
					valueList = dictionaryObj.getAll();
					dictionaryObj.display(valueList);
					break;
				case 7:
					System.out.println("program exited .....");
					System.exit(0);
					default:
						System.out.println("Enter valid choice....");
				}
			}
		} catch (Exception e) {
			System.out.println("Invalid entry...");
			main(args);
		}
	}
}
