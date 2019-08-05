package dictionary;

import java.util.*;

import org.json.simple.JSONObject;

public class DictionaryImp implements Dictionary {
	BSTNode head;

	/**
	 * method for add key and value in BST 
	 */
	
	@Override
	public boolean add(String key, String value) throws Exception {
		if(key.length()==0 || value.length() ==0 ||key==null||value==null){
			throw new NullPointerException("Invalid key and value");
		}
		if(head == null){
			head = new BSTNode(key,value);
		}else{
			addRec(key,value,head);
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
	private boolean addRec(String key,String value,BSTNode node){
		//go left if key less than current node key
		if (key.compareTo(node.getKey()) <= -1){
			if(node.getLeft() != null){
				//if left is present call recursive
				addRec(key, value, node.getLeft());
			}
			else{
				//add value to left 
				node.setLeft(new BSTNode(key,value));
				node.getLeft().setParent(node);
			}
		}
		//go right if key is greater than current node key
		else if(key.compareTo(node.getKey()) >= 1){
			if(node.getRight() != null){
				//if right is present call recursive
	            addRec(key, value, node.getRight());
			}
			else{
				//add value to right
				node.setRight(new BSTNode(key,value));
				node.getRight().setParent(node);
			}
		}
		else{
			node = new BSTNode(key,value);
		}
		return true;
	}
	
	
	
	/**
	 * method to traverse tree
	 * @param root
	 * @param list
	 * @return
	 */
	private List<Value> inorderRec(BSTNode root,List<Value> list) { 
		if (root != null) { 
			inorderRec(root.left,list);
	        list.add(new Value(root.getKey(),root.getValue()));
	        inorderRec(root.right,list); 
	    }
	    return list;
	} 
	
	/**
	 * method to find a value with key
	 * @param key
	 */
	@Override
	public String getValue(String key) {
		if(head != null){
			return getValueRec(key,head);
		}
		return null;
	}
	
	/**
	 * recursive method to find a value form tree
	 * @param key
	 * @param node
	 * @return
	 */
	private String getValueRec(String key,BSTNode node){
		if(node == null){
			return null;
		}
		else if(key.compareTo(node.getKey()) == 0){
			return node.getValue();
		}
		else if(key.compareTo(node.getKey()) <= -1){
			return getValueRec(key, node.getLeft());
		}
		else if(key.compareTo(node.getKey()) >= 1){
			return getValueRec(key, node.getRight());
		}
		else
			return null;
	}

	/*
	 * method to find all values from tree
	 */
	@Override
	public List<Value> getAll() {
		List<Value> valueList = new ArrayList<Value>();
		if(head != null){
			valueList = inorderRec(head,valueList);
		}
		return valueList;
	}

	/**
	 * method to find value of key between keys
	 * @param key1
	 * @param key2
	 */
	@Override
	public List<Value> getBetween(String key1 ,String key2) {
		List<Value> list = getAll();
		List<Value> finalList = new ArrayList<Value>();
		for(Value v : list){
			if(v.getKey().compareTo(key1) >= 1 && v.getKey().compareTo(key2) <= -1){
				finalList.add(v);
			}
		}
		return finalList;
	}

	@Override
	public boolean delete(String key) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
}
