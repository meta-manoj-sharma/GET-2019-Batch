package queen;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int noOfQueen, row = 0;  //row is initial step for process
		NQueen object = new NQueen();
		Scanner input = new Scanner(System.in);
		System.out.println("enter no. of queens");
		noOfQueen = input.nextInt();
		int array[][] = new int[noOfQueen][noOfQueen];
		if (object.findPlaces(array, row, noOfQueen)) {
			System.out.println("TRUE");
		}
		else {
			System.out.print("No solution is there");
		}
	}
}
