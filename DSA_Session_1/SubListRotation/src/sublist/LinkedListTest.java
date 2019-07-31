package sublist;

import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedListTest {
	//positive test case
	@Test
	public void rotateSublist(){
		LinkedList list = new LinkedList();
		list.insert(list, 8);
		list.insert(list, 22);
		list.insert(list, 47);
		list.insert(list, 57);
		list.insert(list, 74);
		list.insert(list, 99);
		list.insert(list, 23);
		int expected[] = {8, 74, 22, 47, 57, 99, 23};
		list.rotateSubList(2, 5, 13);
		assertArrayEquals(expected, list.toArray());
	}
	// negative test case
	@Test(expected = AssertionError.class)
	public void rotate_Exception_InvalidStart(){
		LinkedList list = new LinkedList();
		list.insert(list, 8);
		list.insert(list, 5);
		list.insert(list, 22);
		list.rotateSubList(0, 4, 2);
	}
	
	@Test(expected = AssertionError.class)
	public void rotate_Exception_InvalidEnd(){
		LinkedList list = new LinkedList();
		list.insert(list, 8);
		list.insert(list, 5);
		list.insert(list, 22);
		list.rotateSubList(0, Integer.MAX_VALUE, 2);
	}

	@Test(expected = AssertionError.class)
	public void rotate(){
		LinkedList list = new LinkedList();
		list.insert(list, 8);
		list.insert(list, 5);
		list.insert(list, 22);
		list.rotateSubList(5, 2, 2);
	}
}
