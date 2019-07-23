package integerset;

import java.util.*;

public class Main {
	/**
	 * @return entered array as input
	 * @throws Exception is length is null
	 */
	private static int[] getInput() throws Exception {
		Scanner input = new Scanner(System.in);
		int length = 0, i;
		System.out.println("enter length of Set");
		length = input.nextInt();
		if (length == 0) {
			throw new Exception(); // for checking length null
		}
		int[] set = new int[length];
		System.out.println("enter elements of Set");
		for (i = 0; i < length; i++) {
			set[i] = input.nextInt();
		}
		return set;
	}

	public static void main(String[] args) {
		try {
			IntSet object = new IntSet(getInput());
			while (true) {
				int choice, member, i;
				Scanner input = new Scanner(System.in);
				System.out.println("Enter your choice for...");
				System.out.println("press 1 To check member of set");
				System.out.println("press 2 To get the size of set");
				System.out.println("press 3 To check subset of set");
				System.out.println("press 4 To get complement of the set");
				System.out.println("press 5 To get union of two sets");
				System.out.println("press 6 Exit");
				choice = input.nextInt();
				switch (choice) {
				case 1:
					System.out.println("Enter member to be check in set");
					member = input.nextInt();
					if (object.isMember(member)) {
						System.out.println(member + " is member of set");
					} else
						System.out.println(member + " is not a member of set");
					break;
				case 2:
					object.size();
					break;
				case 3:
					System.out.println("enter data for set S");
					IntSet s = new IntSet(getInput());
					if (object.isSubSet(s)) {
						System.out.println("S is a subset of set");
					} else
						System.out.println("S is not a subset of set");
					break;
				case 4:
					int[] complement = new int[1000 - object.size()];
					System.out.println("complemnt of set is");
					complement = object.getComplement(); // calling complement set function and store in complement array
					for (i = 0; i < complement.length; i++) {
						System.out.print(complement[i] + " ");
					}
					break;
				case 5:
					System.out.println("enter data for second set...");
					IntSet object2 = new IntSet(getInput());
					System.out.println("union of sets is ");
					int[] union = new int[object.size() + object2.size()]; // array to store union of two sets
					union = object.union(object, object2);// calling union of function
					for (i = 0; i < union.length; i++) {
						System.out.print(union[i] + " ");
					}
					break;
				case 6:
					System.exit(0);
				}
			}
		} catch (Exception e) {
			System.out.println("Invalid input");
			main(args);
		}
	}
}
