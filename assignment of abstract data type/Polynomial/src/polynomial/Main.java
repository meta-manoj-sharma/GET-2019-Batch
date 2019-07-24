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
		System.out.println("enter degree of polynomial");
		length = input.nextInt();
		if (length == 0) { //checking length of array
			throw new Exception();
		}
		int[] poly = new int[length];
		System.out.println("enter coeffiecient of polynomial in increasing order of degree");
		for (i = 0; i < length; i++) {
			poly[i] = input.nextInt();
		}
		return poly;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Polynomial object = new Polynomial(getInput());
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
					
					System.out.println("enter variable value");
					value = input.nextInt();
					System.out.println("polynomial solution is " + object.evaluate(value));
					break;
				case 2:
					System.out.println("polynomial degree is " + object.degree());
					break;
				case 3:
					System.out.println("enter data for second polynomial");
					Polynomial object1 = new Polynomial(getInput());
					System.out.println("addition of polynomial is ");
					object.display(object.addPoly(object, object1)); // to add two polynomial and display the result
					break;
				case 4:
					System.out.println("enter data for second polynomial");
					Polynomial object2 = new Polynomial(getInput());
					System.out.println("multiplication of polynomial is ");
					object.display(object.mulPoly(object, object2));  // to multiply two polynomial and display their result
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
