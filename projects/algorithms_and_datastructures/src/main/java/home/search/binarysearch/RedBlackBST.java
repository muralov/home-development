package home.search.binarysearch;

public class RedBlackBST<Key extends Comparable<Key>, Value> {
	
	private Node root;
	
	enum Color {RED, BLACK};
	
	public class Node {
		Key  key; // key
		Value value; // associated data
		Node left, right; //subtrees
		int N; //# of all child nodes in this subtree
		Color color; //color of link from parent to this node
		public Node(Key key, Value value, int n, Color color) {
			this.key = key;
			this.value = value;
			N = n;
			this.color = color;
		}
	}
	
	private boolean isRed(Node x) {
		if(x==null) return false;
		return x.color == Color.RED;
	}
	
	private Node rotateLeft(Node h) {
		Node x = h.right;
		h.right = x.left;
		x.left = h;
		x.color = h.color;
		h.color = Color.RED;
		x.N = h.N;
		h.N = 1 + size(h.left) + size(h.right);
		return x;
	}
	
	private Node rotateRight(Node h) {
		Node x = h.left;
		h.left = x.right;
		x.right = h;
		x.color = h.color;
		h.color = Color.RED;
		x.N = h.N;
		h.N = 1 + size(h.left) + size(h.right);
		return x;
	}
	
	private void flipColors(Node h) {
		h.color = Color.RED;
		h.left.color = Color.BLACK;
		h.right.color = Color.BLACK;
	}
	
	public void put(Key key, Value val) {
		// Search for key. Update value if
		// found; grow table if new.
		root = put(root, key, val);
		root.color = Color.BLACK;
	}
	private Node put(Node h, Key key, Value val) {
		if (h == null) // Do standard insert, with red link to parent.
			return new Node(key, val, 1, Color.RED);
		int cmp = key.compareTo(h.key);
		if (cmp < 0) h.left = put(h.left, key, val);
		else if (cmp > 0) h.right = put(h.right, key, val);
		else h.value = val;
		//The necessary operations for RedBlackBST
		if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
		if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
		if (isRed(h.left) && isRed(h.right)) flipColors(h);
		//updating the size
		h.N = size(h.left) + size(h.right) + 1;
		return h;
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

}
