package queen;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		try {
			int noOfQueen, row = 0; // row is initial step for process
			NQueen object = new NQueen();
			Scanner input = new Scanner(System.in);
			System.out.println("enter no. of queens");
			noOfQueen = input.nextInt();
			if (noOfQueen >= 0) {
				int array[][] = new int[noOfQueen][noOfQueen];
				if (object.findPlaces(array, row, noOfQueen)) {
					System.out.println("TRUE");
				} else {
					System.out.print("No solution is there");
				}
			} else {
				System.out.println("Number of queen should be non negative");
			}
		} catch (Exception e) {
			System.out.println("Invalid Input....");
			main(args);
		}
	}
}