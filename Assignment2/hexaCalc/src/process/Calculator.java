/**
 * get two hexadecimal number from user only positive number
 * ask user for different calculation methods
 * give result in hexadecimal number according to user choice
 */
package process;

import java.util.*;

public class Calculator {

	public static void main(String[] args) {
		try {
			String in1;
			String in2;
			String input1;
			String input2;
			int number1;
			int number2;
			int result;
			boolean res;
			String hexaDecimal = new String();
			Scanner scan = new Scanner(System.in);
			int flag = 1; // for repetition of loop to get always true condition
			do {
                System.out.println("Enter first hexadecimal no. ");
				in1 = scan.next();
				System.out.println("Enter second hexadecimal no. ");
				in2 = scan.next();
				input1 = in1.toUpperCase(); // to chnge hexadecimal number into uppercase letter only
				input2 = in2.toUpperCase();
                Function object = new Function();
				input1 = object.removeZeros(input1);
				input2 = object.removeZeros(input2);
				System.out.println("INput 1  " + input1);
                System.out.println("INput 2  " + input2);
				number1 = object.convertToDecimal(input1, 16);
				number2 = object.convertToDecimal(input2, 16);
				System.out.println("press 1 add ");
				System.out.println("press 2 subtract ");
				System.out.println("perss 3 multiply");
				System.out.println("press 4 divide ");
				System.out.println("press 5 compare");
				System.out.println("press 6 checking grater than and less than ");
				System.out.println("press 7 Exit");
				System.out.println("Enter your choice..... ");
				int choice = scan.nextInt();
				switch (choice) {
				case 1:
                    result = object.add(number1, number2); // calling addition methods to get additon of number
					hexaDecimal = object.convertFromDecimal(result);// converting to hexadecimal number
					System.out.println("additon is = " + hexaDecimal);
					break;
				case 2:
					result = object.subtract(number1, number2); // calling subtraction methods to get subtract of number
					hexaDecimal = object.convertFromDecimal(result);
					System.out.println("subtraction is = " + hexaDecimal);
					break;
				case 3:
					result = object.multiply(number1, number2);
					hexaDecimal = object.convertFromDecimal(result);
					System.out.println("multiplication is = " + hexaDecimal);
					break;
				case 4:
					result = object.divide(number1, number2);
					if (number2 == 0) {
						System.out.println("can't divide by 0");
						break;
					} else {
						hexaDecimal = object.convertFromDecimal(result);
						System.out.println("division is = " + hexaDecimal);
						break;
					}
				case 5:
					res = object.equalsTo(input1, input2); // for comparing == between two number
					if (res == true) {
						System.out.println("number1==number2");
						break;
					} else {
						System.out.println("number1!=number2");
						break;
					}
				case 6:
					boolean res1 = object.greaterThen(input1, input2);
					if (res1 == true) {
						System.out.println("number1>number2");
						break;
					} else {
						System.out.println("number1<number2");
						break;
					}
                 case 7:
					System.out.print("Thank you....");
					System.exit(0);
				}
			} while (flag == 1);

		} catch (Exception e) {
			System.out.print("Invalid entry....enter again");
			main(args);
		}
	}

}