package circularqueue;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner input = new Scanner(System.in);
			int size, choice, value;
			System.out.println("Enter the size of queue");
			size = input.nextInt();
			if (size <= 0) {
				System.out.println("Size can't be negative or null");
				throw new Exception();
			}
			CircularQueue queue = new CircularQueue(size);
			while (true) {
				System.out.println("Press 1 To add items in queue");
				System.out.println("Press 2 To delete item form queue");
				System.out.println("Press 3 To display queue items");
				System.out.println("Press 4 exit");
				choice = input.nextInt();
				if (choice < 1 || choice > 4) {
					throw new Exception();
				}
				switch (choice) {
				case 1:
					System.out.println("enter elements to be add in queue");
					value = input.nextInt();
					queue.addItem(value);
					break;
				case 2:
					if (queue.isEmpty()) {
						System.out.println("Can't delete queue is empty");
						break;
					} else {
						System.out.println("Deleted item is "
								+ queue.deleteItem());
					}
					break;
				case 3:
					System.out.println("queue is  ");
					queue.display();
					break;
				case 4:
					System.out.println("program exit....");
					System.exit(0);

				}
			}
		} catch (Exception e) {
			System.out.println("Invalid input....");
			main(args);
		}
	}
}
