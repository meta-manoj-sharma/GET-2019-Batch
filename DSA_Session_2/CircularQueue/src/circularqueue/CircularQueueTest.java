package circularqueue;

import static org.junit.Assert.*;

import org.junit.Test;

public class CircularQueueTest {

	@Test
	public void deleteItemMethodPositiveCasesTest() throws Exception {
		Queue queue = new CircularQueue(10);
		queue.addItem(1);
		queue.addItem(2);
		queue.addItem(3);
		queue.addItem(4);
		queue.addItem(5);
		queue.addItem(6);
		queue.addItem(7);
		queue.addItem(8);
		queue.addItem(9);
		queue.addItem(10);

		assertEquals(1, queue.deleteItem());
		assertEquals(2, queue.deleteItem());
		assertEquals(3, queue.deleteItem());
		assertEquals(4, queue.deleteItem());
		assertEquals(5, queue.deleteItem());
		assertEquals(6, queue.deleteItem());
		assertEquals(7, queue.deleteItem());
		assertEquals(8, queue.deleteItem());
		assertEquals(9, queue.deleteItem());
		assertEquals(10, queue.deleteItem());
	}

	@Test
	public void isEmptyMethodPositiveCasesTest() {
		Queue queue = new CircularQueue(0);
		assertTrue(queue.isEmpty());
	}

	@Test(expected = Exception.class)
	public void deleteItemMethodNegativeCasesTest() throws Exception {

		Queue queue = new CircularQueue(0);
		assertEquals(-1, queue.deleteItem());
	}

	@Test
	public void isFullMethodNegativeCasesTest() throws Exception {

		Queue queue = new CircularQueue(0);
		assertFalse(queue.isFull());
	}
}
