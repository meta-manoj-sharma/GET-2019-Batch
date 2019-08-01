package circularqueue;

// interface for queue
public interface Queue {
	public void addItem(int data);

	public int deleteItem();

	public boolean isEmpty();

	public boolean isFull();
}
