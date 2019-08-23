package quicksort;

import java.util.List;
import java.util.*;

public class LinkedListOperation {
	Node headNode;// For storing head position

	/**
	 * This method helps in inserting any new nodes to the list
	 * @param list is the linked list containing head
	 * @param data is the employee object to be inserted in list
	 * @return the linked list with its head position
	 */
	public LinkedListOperation addEmployee(LinkedListOperation list, Employee data) {
		Node newNode = new Node(data);
		try {
			if (data == null) {
				throw new Exception("Invalid");
			}
		} catch (Exception e) {
			System.out.println("Invalid entry !! Try Again");
		}
		if (list.headNode == null) {
			list.headNode = newNode;
		} else {
			Node pointer = list.headNode;
			while (pointer.nextLink != null) {
				pointer = pointer.nextLink;
			}
			pointer.nextLink = newNode;
		}
		return list;
	}

	/**
	 * This method prints the given linked list
	 * @param list is the linked list to be printed
	 */
	public void printEmployeeList(LinkedListOperation list) {
		Node pointer = list.headNode;
		while (pointer != null) {
			System.out.println("ID " + pointer.employeeObject.getEmployeeId()
					+ "  Name - " + pointer.employeeObject.getEmployeeName()
					+ "  Salary - " + pointer.employeeObject.getEmployeeSalary()
					+ "  Age - " + pointer.employeeObject.getEmployeeAge());
			pointer = pointer.nextLink;
		}
	}

	/**
	 * This method performs the quick sort considering last node as end node
	 * @param head is the starting node's reference
	 * @return head reference of sorted List
	 */
	public Node quickSort(Node headNode) {
		if (headNode == null || headNode.nextLink == null)
			return headNode;
		Node pivot = findEnd(headNode);// pointing pivot
		// At this state nodes from leftHalf to pivot(end) <= pivot and nodes
		// from pivot.next(end.next) to end are > pivot
		Node leftHalf = partition(headNode, pivot);	// dividing right half
		Node rightHalf = pivot.nextLink;
		pivot.nextLink = null;
		dividePivot(leftHalf);// cut pivot temporarily
		Node sortedLeft = quickSort(leftHalf);
		addLast(sortedLeft, pivot);// add pivot again
		pivot.nextLink = quickSort(rightHalf);
		return sortedLeft;
	}

	/**
	 * This method adds pivot to last
	 * @param sortedLeft is the left side reference
	 * @param pivot is the reference of pivot node
	 */
	private void addLast(Node sortedLeft, Node pivot) {
		Node temporary = sortedLeft;
		while (temporary.nextLink != null) {
			temporary = temporary.nextLink;
		}
		temporary.nextLink = pivot;
	}

	/**
	 * Cuts pivot into half nodes  
	 * @param leftHalf
	 */
	private void dividePivot(Node leftHalf) {
		if (leftHalf == null || leftHalf.nextLink == null)
			return;
		Node temporary = leftHalf;
		Node previous = null;
		while (temporary.nextLink != null) {
			previous = temporary;
			temporary = temporary.nextLink;
		}
		previous.nextLink = null;
	}
/**
 * This method finds the end of the list when its head is passed
 * @param head is the head of Linked list
 * @return the reference of end node
 */
	private Node findEnd(Node head) {
		Node temporary = head;
		while (temporary.nextLink != null)
			temporary = temporary.nextLink;
		return temporary;
	}

	/**
	 * It assumes end as pivot. It starts traversing from head and adds every
	 * node which is > end(i.e. pivot) added at last
	 * @param head is node of starting reference
	 * @param end is end end reference
	 * @return the Node reference of the pivot correct position
	 */
	private Node partition(Node head, Node end) {
		Node actualHead = head;
		Node newEnd = end;
		Node previous = null;
		if (head == end) {
			return head;
		}
		// end node is pivot
		while (head != end) {
			// all the nodes should be left of pivot which are less than pivot
			if (head.employeeObject.getEmployeeSalary() > end.employeeObject.getEmployeeSalary()) {
				previous = head;
				head = head.nextLink;
			}
			else if ((head.employeeObject.getEmployeeSalary() == end.employeeObject.getEmployeeSalary()) && (head.employeeObject.getEmployeeAge() < end.employeeObject.getEmployeeAge())) {
				previous = head;
				head = head.nextLink;
			}
			// all the nodes should be right of pivot
			else {
				// remove head node and add at end
				if (previous != null) {
					previous.nextLink = head.nextLink;
				} else {
					actualHead = head.nextLink;
				}
				// adding at end
				Node tmp = head;
				head = head.nextLink;
				tmp.nextLink = null;
				newEnd.nextLink = tmp;
				newEnd = newEnd.nextLink;

			}
		}
		return actualHead;
	}

	/**
	 * This method returns the result after the complete evaluation
	 * @param list is the linked list
	 * @return the result containing array list of the object
	 */
	public List<Employee> resultList(LinkedListOperation list) {
		List<Employee> result = new ArrayList<Employee>();
		Node pointer = list.headNode;
		while (pointer != null) {
			result.add(pointer.employeeObject);
			pointer = pointer.nextLink;
		}
		return result;
	}
}
