package infixevaluation;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		InfixEvaluation infixObject = new InfixEvaluation();
		int check;
		String expression;
		try {
			while (true) {
				System.out.println("enter expression to be evaluate");
				expression = input.nextLine();
				System.out.println("value = " + infixObject.evaluateInfix(expression));
				System.out.println("enter 0 to exit ");
				check = input.nextInt();
				if (check == 0) {
					System.out.println("Program exit ");
					System.exit(0);
				}
			}
		} catch (Exception e) {
			System.out.println("Invalid expression");
			main(args);
		}
	}
}
