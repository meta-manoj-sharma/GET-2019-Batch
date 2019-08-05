package stringoperation;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String inputString;
		int flag;
		StringOperation objectString = new StringOperation();
		try {
			while (true) {
				System.out.println("enter string");
				inputString = input.nextLine();
				System.out.println("Number of unique character = "
						+ objectString.uniqueChar(inputString));
				System.out.println("Press 0 to exit or any number to continue");
				flag = input.nextInt();
				input.nextLine();
				if (flag == 0) {
					System.out.println("Program exit....");
					System.exit(0);
				}
			}
		} catch (Exception e) {
			System.out.println("Invalid input");
		}
	}
}