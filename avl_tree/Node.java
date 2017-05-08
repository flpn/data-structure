package avl_tree;

public class Node {

	private int data;
	private int balance;
	private int height;
	private Node parent;
	private Node left;
	private Node right;
	
	public Node(int data) {
		this.data = data;
	}
	
	public Node(int data, Node parent) {
		this.data = data;
		this.parent = parent;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}
}
