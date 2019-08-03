package circularqueue;

/**
 * program to insert and delete from queue
 * @author Manoj Sharma
 * Dated 1 august 2019
 */
import java.util.*;

public class CircularQueue implements Queue {

	private int front, rear;
	private int size;
	private int[] array;

	CircularQueue(int size) {
		this.front = -1;
		this.rear = -1;
		this.size = size;
		array = new int[size];
	}

	/**
	 * add item into queue
	 * @param data to be add into queue
	 */
	@Override
	public void addItem(int data) {

		if (isFull()) {
			System.out.println(" Can't add queue is Full");
			return;
		}

		else if (front == -1) /* Insert First Element */
		{
			front = rear = 0;
			array[rear] = data;
		}

		else if (rear == size - 1 && front != 0) {
			rear = 0;
			array[rear] = data;
		}

		else {
			rear++;
			array[rear] = data;
		}
	}

	/**
	 * delete item from the front of queue
	 */
	@Override
	public int deleteItem() {
		if (!isEmpty()) {
			int data = array[front];
			array[front] = -1;
			if (front == rear) {
				front = -1;
				rear = -1;
			} else if (front == size - 1)
				front = 0;
			else
				front++;

			return data;
		}
		return -1;
	}

	/**
	 * to check queue to be empty or not
	 */
	@Override
	public boolean isEmpty() {
		if (front == -1) {
			return true;
		}
		return false;
	}

	/**
	 * to check queue is full or not
	 */
	@Override
	public boolean isFull() {
		if ((front == 0 && rear == size - 1) || (front == rear + 1)) {
			return true;
		}
		return false;
	}

	/**
	 * to display the queue
	 */
	public void display() {
		for (int i = 0; i < size; i++) {
			System.out.print(array[i] + " ");
		}
	}
}
