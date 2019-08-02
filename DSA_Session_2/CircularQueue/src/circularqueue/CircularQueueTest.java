package circularqueue;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CircularQueueTest {
	private Queue queue;

	@Before
	public void createQueue() {
		queue = new CircularQueue(2);
	}

	@Test
	public void deleteItemTest1() throws Exception {
		queue.addItem(1);
		queue.addItem(2);
		assertEquals(1, queue.deleteItem());
		assertEquals(2, queue.deleteItem());
	}

	@Test
	public void deleteItemTest2() throws Exception {
		queue.addItem(3);
		queue.addItem(4);
		assertEquals(3, queue.deleteItem());
		assertEquals(4, queue.deleteItem());
	}

	@Test
	public void deleteItemTest3() throws Exception {
		queue.addItem(5);
		queue.addItem(6);
		assertEquals(5, queue.deleteItem());
		assertEquals(6, queue.deleteItem());
	}

	@Test
	public void deleteItemTest4() throws Exception {
		queue.addItem(7);
		queue.addItem(8);
		assertEquals(7, queue.deleteItem());
		assertEquals(8, queue.deleteItem());
	}

	@Test
	public void deleteItemTest5() throws Exception {
		queue.addItem(9);
		queue.addItem(10);
		assertEquals(9, queue.deleteItem());
		assertEquals(10, queue.deleteItem());
	}

	@Test
	public void isEmptyMethodPositiveCasesTest() {
		Queue queue = new CircularQueue(0);
		assertTrue(queue.isEmpty());
	}

	@Test
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
