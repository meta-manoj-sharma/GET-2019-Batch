package dictionary;

import java.util.*;

import org.json.simple.JSONObject;

public class DictionaryImp implements Dictionary {
	BSTNode headNode;
	/*
	 * parameterized constructor
	 * @input json object
   	 */
	
	public DictionaryImp(JSONObject jsonObject) throws Exception {
		this.headNode = null;
		this.input(jsonObject);
	}
	
	//default constructor
	public DictionaryImp() {
	}

	/*
	 * method for add key and value from json object
	 * @param jsonObject
	 */
	private boolean input(JSONObject jsonObject) throws Exception{
		
		for(Object obj : jsonObject.keySet()){
			String key = (String)obj;
			String value = (String) jsonObject.get(key);
			this.add(key, value);
		}
		return true;
	}



	/**
	 * method for add key and value in BST
	 */

	@Override
	public boolean add(String key, String value) throws Exception {
		if (key.length() == 0 || value.length() == 0 || key == null || value == null) {
			throw new NullPointerException("Invalid key and value");
		}
		if (headNode == null) {
			headNode = new BSTNode(key, value);
		} else {
			addRecursion(key, value, headNode);
		}
		return false;
	}

	/**
	 * Recursive function for adding key and value in BST
	 * @param key
	 * @param value
	 * @param node
	 * @return
	 */
	private boolean addRecursion(String key, String value, BSTNode node) {
		// go left if key less than current node key
		if (key.compareTo(node.getKey()) <= -1) {
			if (node.getLeftChild() != null) {
				// if left is present call recursive
				addRecursion(key, value, node.getLeftChild());
			} else {
				// add value to left
				node.setLeftChild(new BSTNode(key, value));
				node.getLeftChild().setParentNode(node);
			}
		}
		// go right if key is greater than current node key
		else if (key.compareTo(node.getKey()) >= 1) {
			if (node.getRightChild() != null) {
				// if right is present call recursive
				addRecursion(key, value, node.getRightChild());
			} else {
				// add value to right
				node.setRightChild(new BSTNode(key, value));
				node.getRightChild().setParentNode(node);
			}
		} else {
			node = new BSTNode(key, value);
		}
		return true;
	}

	/**
	 * method for delete a key and value form BST 0
	 * @param key
	 */
	@Override
	public boolean delete(String key) throws Exception {

		if (key.length() == 0 || key == null) {
			throw new NullPointerException("Invalid key and value");
		}

		if (headNode != null) {
			return deleteRecursion(key, headNode);
		}
		return false;
	}

	/**
	 * recursive function for deleting a key form BST
	 * @param key
	 * @param node
	 * @return
	 */
	private boolean deleteRecursion(String key, BSTNode node) {
		// go left if key less than current node key
		if (key.compareTo(node.getKey()) <= -1) {
			if (node.getLeftChild() != null) {
				// if left is present call recursive
				return deleteRecursion(key, node.getLeftChild());
			}
		}
		// go right if key is greater than current node key
		else if (key.compareTo(node.getKey()) >= 1) {
			if (node.getRightChild() != null) {
				// if right is present call recursive
				return deleteRecursion(key, node.getRightChild());
			}
		}
		// if key is equal to node key
		else if (key.compareTo(node.getKey()) == 0) {
			// check if it is a leaf node
			if (node.getLeftChild() == null && node.getRightChild() == null) {
				if (node.getParentNode() == null) {
					headNode = null;
				}
				// set parent child null if it is leaf node
				else if (node.getParentNode().getLeftChild() == node) {
					node.getParentNode().setLeftChild(null);
				} else {
					node.getParentNode().setRightChild(null);
				}
			}
			// if left node is null
			else if (node.getLeftChild() == null && node.getRightChild() != null) {
				if (node.getParentNode() == null) {
					BSTNode newNode = findMinimum(node.getRightChild());
					node.setKey(newNode.getKey());
					node.setValue(newNode.getValue());
					return deleteRecursion(newNode.getKey(), newNode);
				}
				// if self is left than set parent left else set parent right
				else if (node.getParentNode().getLeftChild() == node) {
					node.getParentNode().setLeftChild(node.getRightChild());
				} else {
					node.getParentNode().setRightChild(node.getRightChild());
				}
			}
			// if right is null
			else if (node.getRightChild() == null && node.getLeftChild() != null) {
				// if self is right set parent right else set parent left
				if (node.getParentNode().getRightChild() == node) {
					node.getParentNode().setRightChild(node.getLeftChild());
				} else {
					node.getParentNode().setLeftChild(node.getLeftChild());
				}
			}

			else {
				BSTNode newNode = findMinimum(node.getRightChild());
				node.setKey(newNode.getKey());
				node.setValue(newNode.getValue());
				return deleteRecursion(newNode.getKey(), newNode);
			}
		}

		return true;

	}

	/**
	 * method to find minimum value from tree
	 * @param currentNode
	 * @return
	 */
	private BSTNode findMinimum(BSTNode currentNode) {
		while (currentNode.getLeftChild() != null) {
			currentNode = currentNode.getLeftChild();
		}
		return currentNode;

	}

	/**
	 * method to traverse tree
	 * @param root
	 * @param list
	 * @return
	 */
	private List<Value> inorderRecursion(BSTNode root, List<Value> list) {
		if (root != null) {
			inorderRecursion(root.leftChild, list);
			list.add(new Value(root.getKey(), root.getValue()));
			inorderRecursion(root.rightChild, list);
		}
		return list;
	}

	/**
	 * method to find a value with key 
	 * @param key
	 */
	@Override
	public String getValue(String key) {
		if (headNode != null) {
			return getValueRecursion(key, headNode);
		}
		return null;
	}

	/**
	 * recursive method to find a value form tree
	 * @param key
	 * @param node
	 * @return
	 */
	private String getValueRecursion(String key, BSTNode node) {
		if (node == null) {
			return null;
		} else if (key.compareTo(node.getKey()) == 0) {
			return node.getValue();
		} else if (key.compareTo(node.getKey()) <= -1) {
			return getValueRecursion(key, node.getLeftChild());
		} else if (key.compareTo(node.getKey()) >= 1) {
			return getValueRecursion(key, node.getRightChild());
		} else
			return null;
	}

	/*
	 * method to find all values from tree
	 */
	@Override
	public List<Value> getAll() {
		List<Value> valueList = new ArrayList<Value>();
		if (headNode != null) {
			valueList = inorderRecursion(headNode, valueList);
		}
		return valueList;
	}

	/**
	 * method to find value of key between keys 
	 * @param key1
	 * @param key2
	 */
	@Override
	public List<Value> getBetween(String key1, String key2) {
		List<Value> list = getAll();
		List<Value> finalList = new ArrayList<Value>();
		for (Value v : list) {
			if (v.getKey().compareTo(key1) >= 0 && v.getKey().compareTo(key2) <= -1) {
				finalList.add(v);
			}
		}
		return finalList;
	}
public void display(List<Value> valueList) {
	for(int i = 0; i < valueList.size(); i++) {
	System.out.println("Key-"+valueList.get(i).getKey()+" value-"+valueList.get(i).getValue());	
	}
}
}
