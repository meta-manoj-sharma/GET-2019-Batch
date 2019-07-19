package calculation;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		try {
			while (true) {
				System.out.println("enter first number ");
				int num1 = input.nextInt();
				System.out.println("enter second number ");
				int num2 = input.nextInt();
				HcfAndLcm object = new HcfAndLcm();
				System.out.println("hcf "
						+ object.highestCommonFactor(num1, num2));
				System.out.println("lcm "
						+ object.leastCommonMultiple(num1, num2));
			}
		} catch (Exception e) {
			System.out.println("please enter valid number");
			main(args);
		}
	}
}
