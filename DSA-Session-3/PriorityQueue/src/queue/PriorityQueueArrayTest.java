package queue;

import static org.junit.Assert.*;

import org.junit.Test;

public class PriorityQueueArrayTest {

	@Test
	public void testEnqueue() throws Exception {
		PriorityQueueArray priorityQueueObject = new PriorityQueueArray(5);
		priorityQueueObject.enqueue(20, 4);
		priorityQueueObject.enqueue(25, 2);
		priorityQueueObject.enqueue(30, 1);
		assertEquals(2, priorityQueueObject.rear);
		priorityQueueObject.enqueue(40, 3);
		priorityQueueObject.enqueue(50, 1);
		assertEquals(4, priorityQueueObject.rear);
	}

	@Test
	public void testDequeue1() throws Exception {
		PriorityQueueArray priorityQueueObject = new PriorityQueueArray(5);
		priorityQueueObject.enqueue(20, 4);
		priorityQueueObject.enqueue(25, 2);
		priorityQueueObject.enqueue(30, 1);
		assertEquals(30, priorityQueueObject.dequeue());
	}

	@Test
	public void testDequeue2() throws Exception {
		PriorityQueueArray priorityQueueObject = new PriorityQueueArray(5);
		priorityQueueObject.enqueue(100, 1);
		priorityQueueObject.enqueue(25, 2);
		priorityQueueObject.enqueue(30, 1);
		assertEquals(100, priorityQueueObject.dequeue());
		assertEquals(30, priorityQueueObject.dequeue());
	}
}
