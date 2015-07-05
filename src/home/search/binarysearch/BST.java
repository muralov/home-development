package home.search.binarysearch;

/**
 * This is the class searches an node based on binary search algorithm
 * @author mansur
 */
public class BST<Key extends Comparable<Key>, Value> {
	
	private Node root;
	
	public void put(Key key, Value value) {
		root = put(root, key, value);
	}
	
	private Node put(Node currentNode, Key key, Value value) {
		if(currentNode == null)
			currentNode = new Node(key, value, 1);
		
		int cmp = key.compareTo(currentNode.key);
		if(cmp < 0) 
			currentNode.left = put(currentNode.left, key, value); //less, traverse in left direction
		else if(cmp > 0) 
			currentNode.right = put(currentNode.right, key, value); //greater, traverse in right direction
		else 
			currentNode.value = value; //update the value if key already exists
		
		currentNode.N = size(currentNode.left) + size(currentNode.right) + 1; //updating the N
		
		return currentNode;
	}
	
	public Value get(Key key) {
		return get(key, root);
	}
	
	private Value get(Key key, Node currentNode) {
		if(currentNode == null) return null;
		
		int cmp = key.compareTo(currentNode.key);
		if(cmp == 0) 
			return currentNode.value; //update the value if key already exists
		else if(cmp < 0) 
			return get(key, currentNode.left); //less, traverse in left direction
		else 
			return get(key, currentNode.right); //greater, traverse in right direction
	}
	
	public int size() {
		return size(root);
	}
	
	private int size(Node x) {
		if(x==null) return 0;
		else return x.N;
	}
	
	private class Node {
		private Key key;
		private Value value;
		private Node left;
		private Node right;
		private int N; // # nodes in subtree rooted here

		public Node(Key key, Value value, int N) {
			this.key = key;
			this.value = value;
			this.N = N;
		}
	}

}
