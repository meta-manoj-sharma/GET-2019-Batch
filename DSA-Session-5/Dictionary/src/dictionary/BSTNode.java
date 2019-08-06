package dictionary;

public class BSTNode {
	private String key;
	private String value;
	BSTNode leftChild,rightChild,parentNode;
	
	//constructor 
	public BSTNode(String key, String value) {
		super();
		this.key = key;
		this.value = value;
		this.leftChild = null;
		this.rightChild = null;
		this.parentNode = null;
	}

	//getter method for key
	public String getKey() {
		return key;
	}

	//setter method for key
	public void setKey(String key) {
		this.key = key;
	}

	//getter method for value
	public String getValue() {
		return value;
	}

	//setter method for value
	public void setValue(String value) {
		this.value = value;
	}

	//getter method for left child
	public BSTNode getLeftChild() {
		return leftChild;
	}

	//setter method for left child
	public void setLeftChild(BSTNode left) {
		this.leftChild = left;
	}

	//getter method right child
	public BSTNode getRightChild() {
		return rightChild;
	}

	//setter method for right
	public void setRightChild(BSTNode right) {
		this.rightChild = right;
	}

	//getter method for parent
	public BSTNode getParentNode() {
		return parentNode;
	}

	//setter method for parent
	public void setParentNode(BSTNode parent) {
		this.parentNode = parent;
	}	
}
