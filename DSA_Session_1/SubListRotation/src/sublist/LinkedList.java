package sublist;
/**
 * this program for rotating a sub part of a linked list
 * @author Manoj Sharma
 * Dated 29 july 2019
 */
import java.util.*;

public class LinkedList {
	Node headNode;

	public LinkedList insert(LinkedList list, int data) {
		Node newNode = new Node(data);
		newNode.next = null;

		if (list.headNode == null) {
			list.headNode = newNode;
		} else {
			Node last = list.headNode;
			while (last.next != null) {
				last = last.next;
			}
			last.next = newNode;
		}
		return list;
	}

	/**
	 * @param start
	 * @param end
	 * @return
	 */
	public void rotateSubList(int start, int end, int rotateIndex) {
		Node currentNode = headNode;
		int nodeCount = 1;
		int opeartionCount = 0;
		validate(start, end, rotateIndex);
		Node startCurrent = null;
		Node startLast = null;
		Node endCurrent = null;
		Node endLast = null;
		int currentStart = start;
		int currentEnd = end;
		while (true) {
			if (opeartionCount >= rotateIndex || currentStart == currentEnd) {
				currentNode = headNode;
				break;
			}
			if (nodeCount == currentStart) {
				startCurrent = currentNode;
				currentNode = currentNode.next;
				nodeCount++;
			}

			else if (nodeCount < currentStart) {
				startLast = currentNode;
				currentNode = currentNode.next;
				nodeCount++;
			}
			// rotating sublist for lower limit is equal1
			else if (nodeCount == currentEnd && currentStart == 1) {
				endCurrent = currentNode;
				endLast.next = endCurrent.next;
				headNode = endCurrent;
				endCurrent.next = startCurrent;
				currentNode = headNode;
				nodeCount = 1;
				opeartionCount++;

			}
			// rotating sublist for lower limit and higher limit to be adjacent
			else if (nodeCount == currentEnd
					&& (currentEnd - currentStart) == 1) {
				endCurrent = currentNode;
				startCurrent.next = endCurrent.next;
				startLast.next = endCurrent;
				endCurrent.next = startCurrent;
				currentNode = headNode;
				nodeCount = 1;
				opeartionCount++;

			}
			// rotating sublist
			else if (nodeCount == currentEnd) {
				endCurrent = currentNode;
				endLast.next = endCurrent.next;
				startLast.next = endCurrent;
				endCurrent.next = startCurrent;
				currentNode = headNode;
				nodeCount = 1;
				opeartionCount++;

			}

			else {
				endLast = currentNode;
				currentNode = currentNode.next;
				nodeCount++;
			}
		}
	}

	/**
	 * 
	 * @param start
	 * @param end
	 * @param rotateIndex
	 */
	private void validate(int start, int end, int rotateIndex) {

		if (start <= 0) {
			throw new AssertionError("Start Index Must Be Positive Number");
		}
		if (end >= size()) {
			throw new AssertionError("end Index Must Be Less Then Size");
		}
		if (end < start) {
			throw new AssertionError("end index can't be less then start index");
		}
	}

	/**
	 * @return size of Linked List
	 */
	public int size() {
		int size = 0;
		Node current = headNode;
		while (current != null) {

			size++;
			current = current.next;
		}
		return size;
	}

	public void display(LinkedList list) {
		Node currentNode = list.headNode;
		while (currentNode != null) {
			System.out.print(currentNode.data + " ");
			currentNode = currentNode.next;
		}
	}

	/**
	 * This method checks whether there is a loop in a linked list or not
	 * @param list is the linked list in which loop is to be found
	 * @return true when there exists a loop in a linked list otherwise returns false
	 */
	public boolean detectLoopInList(Node headNode, LinkedList list) {
		Set<Node> referenceSet = new HashSet<Node>();
		Node traverse = list.headNode;
		while (traverse != null) {
			if (referenceSet.contains(traverse)) {// Checking whether the node's
													// reference is already
													// present or not
				return true;
			}
			referenceSet.add(traverse);// Otherwise add into the set
			traverse = traverse.next;

		}
		return false;
	}

	/**
	 * @return convert list to Array()
	 */
	public int[] toArray() {
		int size = this.size();
		int resultArray[] = new int[size];
		int index = 0;
		Node current = headNode;
		while (current != null) {
			resultArray[index++] = current.data;
			current = current.next;
		}
		return resultArray;
	}
}
