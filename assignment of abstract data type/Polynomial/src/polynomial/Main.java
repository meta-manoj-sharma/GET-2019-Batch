package polynomial;

import java.util.*;

public class Main {
	/**
	 * @return polynomial in form of array which is input
	 * @throws Exception
	 */
	private static int[] getInput() throws Exception {
		Scanner input = new Scanner(System.in);
		int length = 0, i;
		System.out.println("enter length of array");
		length = input.nextInt();
		if (length == 0) { //checking length of array
			throw new Exception();
		}
		int[] set = new int[length];
		System.out.println("enter elements of polynomial in form of array");
		for (i = 0; i < length; i++) {
			set[i] = input.nextInt();
		}
		return set;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			while (true) {
				int choice, value, i;
				Scanner input = new Scanner(System.in);
				System.out.println("WELCOME");
				System.out.println("press 1 To evaluate polynomial");
				System.out.println("press 2 To get degree of polynomial");
				System.out.println("press 3 To add two polynomial");
				System.out.println("press 4 To multiply two polynomial");
				System.out.println("press 5 Exit");
				choice = input.nextInt();
				switch (choice) {
				case 1:
					Polynomial object5 = new Polynomial(getInput());
					System.out
							.println("enter value at which polynomial to be evaluate");
					value = input.nextInt();
					System.out.println("polynomial solution is "
							+ object5.evaluate(value));
					break;
				case 2:
					Polynomial object6 = new Polynomial(getInput());
					System.out.println("polynomial degree is "
							+ object6.degree());
					break;
				case 3:
					System.out.println("enter data fo first polynomial");
					Polynomial object1 = new Polynomial(getInput());
					System.out.println("enter data for second polynomial");
					Polynomial object2 = new Polynomial(getInput());
					System.out.println("addition of polynomial is ");
					Polynomial.display(object1.addPoly(object1, object1)); // to add two polynomial and display the result
					break;
				case 4:
					System.out.println("enter data fo first polynomial");
					Polynomial object3 = new Polynomial(getInput());
					System.out.println("enter data for second polynomial");
					Polynomial object4 = new Polynomial(getInput());
					System.out.println("multiplication of polynomial is ");
					Polynomial.display(object3.mulPoly(object3, object4));  // to multiply two polynomial and display their result
					break;
				case 5:
					System.exit(0);
				}
			}
		} catch (Exception e) {
			System.out.println("Invalid input");
			main(args);
		}
	}
}
