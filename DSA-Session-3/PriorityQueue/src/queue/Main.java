package queue;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		PriorityQueueArray priorityQueueObject;
		int capacity,element,priority;
		while(true) {
		System.out.println("Enter capacity of queue");
		capacity = input.nextInt();
		priorityQueueObject = new PriorityQueueArray(capacity);
		System.out.println("Enter element  of queue");
		element = input.nextInt();
		System.out.println("Enter priority of element");
		priority = input.nextInt();
		priorityQueueObject.enqueue(element, priority);
	}

}
}
