package queue;

public interface PriorityQueueInterface {
	public void enqueue(int element, int priority) throws Exception;

	public int dequeue() throws Exception;

	public boolean isEmpty();

	public boolean isFull();
}
