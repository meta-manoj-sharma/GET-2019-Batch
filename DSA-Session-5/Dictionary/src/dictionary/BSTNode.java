package dictionary;

public class BSTNode {
	private String key;
	private String value;
	BSTNode left,right,parent;
	
	//constructor 
	public BSTNode(String key, String value) {
		super();
		this.key = key;
		this.value = value;
		this.left = null;
		this.right = null;
		this.parent = null;
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
	public BSTNode getLeft() {
		return left;
	}

	//setter method for left child
	public void setLeft(BSTNode left) {
		this.left = left;
	}

	//getter method right child
	public BSTNode getRight() {
		return right;
	}

	//setter method for right
	public void setRight(BSTNode right) {
		this.right = right;
	}

	//getter method for parent
	public BSTNode getParent() {
		return parent;
	}

	//setter method for parent
	public void setParent(BSTNode parent) {
		this.parent = parent;
	}	
}
