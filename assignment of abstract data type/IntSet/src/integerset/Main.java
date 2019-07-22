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
		System.out.println("enter length of array");
		length = input.nextInt();
		if (length == 0) {
			throw new Exception(); // for checking length null
		}
		int[] set = new int[length];
		System.out.println("enter elements of array");
		for (i = 0; i < length; i++) {
			set[i] = input.nextInt();
		}
		return set;
	}
	
	public static void main(String[] args) {
		try {
			while (true) {
				int choice, member, i;
				Scanner input = new Scanner(System.in);
				System.out.println("press 1 To check member of set");
				System.out.println("press 2 To get the size of set");
				System.out.println("press 3 To check subset of set");
				System.out.println("press 4 To get complement of the set");
				System.out.println("press 5 To get union of two sets");
				System.out.println("press 6 Exit");
				choice = input.nextInt();
				switch (choice) {
				case 1:
					IntSet object3 = new IntSet(getInput());
					System.out.println("enter member to be check");
					member = input.nextInt();
					if (object3.isMember(member)) {
						System.out.println(member + "is member of set");
					} else
						System.out.println(member + "is not a member of set");
					break;
				case 2:
					IntSet object4 = new IntSet(getInput());
					object4.size();
					break;
				case 3:
					IntSet object5 = new IntSet(getInput());
					System.out.println("enter data for subset s");
					IntSet s = new IntSet(getInput());
					if (object5.isSubSet(s)) {
						System.out.println("S is a subset of set");
					} else
						System.out.println("S is not a subset of set");
					break;
				case 4:
					IntSet object6 = new IntSet(getInput());
					int[] complement = new int[1000 - object6.size()];
					System.out.println("complemnt of set is");
					complement = object6.getComplement(); // calling complement set function and store in complement array
					for (i = 0; i < complement.length; i++) {
						System.out.print(complement[i] + " ");
					}
					break;
				case 5:
					System.out.println("enter data fo first set");
					IntSet object1 = new IntSet(getInput());
					System.out.println("enter data for second set");
					IntSet object2 = new IntSet(getInput());
					System.out.println("union of sets is ");
					int[] union = new int[object1.size() + object2.size()]; // array to store union of two sets
					union = IntSet.union(object1, object2);// calling union of function
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
