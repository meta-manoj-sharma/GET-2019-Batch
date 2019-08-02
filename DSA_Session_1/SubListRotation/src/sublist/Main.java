package sublist;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		try {

			Scanner input = new Scanner(System.in);
			int size, choice, row, start, end, noOfRotation;
			while (true) {
				LinkedList list = new LinkedList();
				System.out.println("Enter size of linked list");
				size = input.nextInt();
				if (size <= 0) {
					System.out.println("linked list size can't be null or negative");
				} else {
					System.out.println("Enter data into linked list");
					for (row = 0; row < size; row++) {
						choice = input.nextInt();
						list.insert(list, choice);
					}
					System.out.println("Entered linked list is....");
					list.display(list);
					System.out.println(" ");
					System.out.println("Enter lower limit of sub list");
					start = input.nextInt();
					System.out.println("Enter highest limit of sub list");
					end = input.nextInt();
					System.out.println("Enter position by which sub list to be rotate");
					noOfRotation = input.nextInt();
					System.out.println("Rotated liked list is...");
					list.rotateSubList(start, end, noOfRotation);
					list.display(list);
					System.out.println(" ");
					/* Create loop for testing */
					list.headNode.next.next = list.headNode;
					if (list.detectLoopInList(list.headNode, list)) {
						System.out.println("Loop is present in linked list");
					} else {
						System.out.println("Loop is not present in linked list");
					}
					System.out.println("Press 1 to exit and press any key to continue");
					choice = input.nextInt();
					if (choice == 1) {
						System.out.println("Program exit.......");
						System.exit(0);
					}
				}
			}
		}

		catch (Exception e) {
			System.out.println("Invalid Input.... program restart");
			main(args);
		}
	}
}
