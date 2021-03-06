package queue;

/**
 * this program is create a priority queue
 * @author Manoj Sharma
 * Dated 2  august 2019
 */
public class PriorityQueueArray implements PriorityQueueInterface {
	int priorQueue[][];
	int front;
	int rear;
	int capacity;
	int counter;
	public PriorityQueueArray(int capacity) {
		priorQueue = new int[2][capacity];
		front = -1;
		rear = -1;
		this.capacity = capacity;
	}
/**
 * This method checks whether queue is full or not
 * @return true if queue is full otherwise returns false
 */
	public boolean isFull() {
		if (front == rear + 1 || (front == 0 && rear == capacity - 1)) {
			return true;
		} else {
			return false;
		}
	}
/**
 * This method checks whether queue is empty or not
 * @return true if queue is empty otherwise returns false
 */
	
	public boolean isEmpty() {
		if (counter == capacity)
			return true;
		else
			return false;
	}
/**
 * This method adds the element in the queue according to the order of priority as entered by user
 * @param element is the integer value to be added
 * @param priority is the element's priority in between 1<=priority<=capacity
 */
	public void enqueue (int element, int priority) throws Exception {
		if (isFull()) {
			throw new Exception("Queue is Full");

		} else if (priority > capacity || priority <= 0) {
			throw new Exception("Priority is not valid");

		} else {
			if (front == -1 && rear == -1) {
				front = 0;
				rear = 0;
			} else {
				rear++;
			}
			priorQueue[0][rear] = element;
			priorQueue[1][rear] = priority;
		}
	}
/**
 * This method deletes the element in queue according to the priorities
 * @return the integer element dequeued 
 * @throws Exception 
 */
	public int dequeue() throws Exception {
		int data = 0;
		if (!isEmpty()) {
			outer: for (int j = 1; j <= capacity; j++) {
				for (int i = front; i <= rear; i++) {
					if (j == priorQueue[1][i]) {
						data = priorQueue[0][i];
						priorQueue[1][i] = -1;
						priorQueue[0][i] = -1;
						counter++;
						break outer;
					}
				}
			}
		} else {
			throw new Exception("Empty Queue");

		}
		return data;
	}

	public void display() {
		for (int i = front; i <= rear; i++) {
			System.out.println("value- " + priorQueue[0][i] + " priority- " + priorQueue[1][i]);
		}
	}
}
