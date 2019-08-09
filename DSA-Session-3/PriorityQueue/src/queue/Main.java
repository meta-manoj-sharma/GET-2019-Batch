package queue;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		try{
		Scanner input = new Scanner(System.in);
		PriorityQueueArray priorityQueueObject;
		int capacity, element, priority, index, choice;
		System.out.println("Enter capacity of queue");
		capacity = input.nextInt();
		priorityQueueObject = new PriorityQueueArray(capacity);
		while (true) {
		System.out.println("Enter 1 for add elements in queue");
		System.out.println("Enter 2 get element from queue");
		System.out.println("Enter 3 display queue");
		System.out.println("Enter 4 for Exit");
		choice = input.nextInt();
		switch (choice) {
		case 1:
			for(index = 0; index < capacity; index++){
			System.out.println("Enter element  of queue");
			element = input.nextInt();
			System.out.println("Enter priority of element");
			priority = input.nextInt();
			priorityQueueObject.enqueue(element, priority);
			}
			break;
		case 2:
			System.out.println("deleted element is" + priorityQueueObject.dequeue());
			break;
		case 3:
			priorityQueueObject.display();
			break;
		case 4:
			System.out.println("program exited....");
			System.exit(0);
			default :
			System.out.println("enter valid choice...");
				}
			}
		} catch (Exception e) {
			System.out.println(e);
			main(args);
		}
	}
}
