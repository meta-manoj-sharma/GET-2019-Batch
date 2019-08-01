package infixevaluation;

public class StackImplementation implements MyStack {
	int topPointer = -1;
	private final int STACK_SIZE = 100;
	int[] stackArray = new int[STACK_SIZE];

	/**
	 * method to push element into stack
	 */
	@Override
	public boolean push(int element) throws Exception {
		if (topPointer == STACK_SIZE) {
			throw new Exception("Stack is full");
		}
		topPointer += 1;
		stackArray[topPointer] = element;
		return true;
	}

	/**
	 * method to pop element from stack
	 */
	@Override
	public int pop() throws Exception {
		int deleteItem = 0;
		if (topPointer == -1) {
			throw new Exception("stack is empty");
		}
		deleteItem = stackArray[topPointer];
		topPointer -= 1;
		return deleteItem;
	}

	/**
	 * method to get top element
	 */
	@Override
	public int peek() throws Exception {
		if (topPointer == -1) {
			throw new Exception("stack is empty");
		} else {
			return stackArray[topPointer];
		}
	}

	/**
	 * method to check if stack is empty
	 */
	@Override
	public boolean isEmpty() {
		if (topPointer == -1) {
			return true;
		}
		return false;
	}
}
