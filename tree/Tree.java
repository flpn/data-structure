package tree;

public class Tree {

	private Node root;


	public void preOrder(Node root) {
		if (root != null) {
			System.out.println(root.getData());
			preOrder(root.getLeft());
			preOrder(root.getRight());			
		}
	}

	public void inOrder(Node root) {
		if (root != null) {			
			preOrder(root.getLeft());
			System.out.println(root.getData());
			preOrder(root.getRight());
		}
	}

	public void postOrder(Node root) {
		if (root != null) {
			preOrder(root.getLeft());
			preOrder(root.getRight());
			System.out.println(root.getData());
		}
	}

	public Node insert(Node root, int value) {
		if (this.root == null) {
			this.root = new Node(value);
		}
		else {
			if (root == null) {
				root = new Node(value);
			}
			else if (value > root.getData()) {
				root.setRight(insert(root.getRight(), value));
			}
			else if (value < root.getData()) {
				root.setLeft(insert(root.getLeft(), value));
			}
		}

		return root;
	}

	public void remove(int value) {
		Node currentNode = root;
		Node parent = root;
		boolean isLeftChild = false;

		while(currentNode.getData() != value) {
			parent = currentNode;

			if (currentNode.getData() > value) {
				isLeftChild = true;
				currentNode = currentNode.getLeft();
			}
			else {
				isLeftChild = false;
				currentNode = currentNode.getRight();
			}
		}

		if (isLeaf(currentNode)) {
			deleteLeaf(currentNode, parent, isLeftChild);
		}
		else if (hasNotRightChild(currentNode)) {
			deleteParentWithLeftChild(currentNode, parent, isLeftChild);
		}
		else if (hasNotLeftChild(currentNode)) {
			deleteParentWithRightChild(currentNode, parent, isLeftChild);
		}
		else if (hasTwoChild(currentNode)) {
			deleteParentWithTwoChild(currentNode, parent, isLeftChild);
		}
	}

	private void deleteLeaf(Node current, Node parent, boolean isLeftChild) {
		if (current == root) {
			root = null;
		}

		if (isLeftChild) {
			parent.setLeft(null);
		}
		else {
			parent.setRight(null);
		}
	}

	private void deleteParentWithLeftChild(Node current, Node parent, boolean isLeftChild) {
		if (current == root) {
			root = current.getLeft();
		}
		else if (isLeftChild) {
			parent.setLeft(current.getLeft());
		}
		else {
			parent.setRight(current.getLeft());
		}
	}

	private void deleteParentWithRightChild(Node current, Node parent, boolean isLeftChild) {
		if (current == root) {
			root = current.getRight();
		}
		else if (isLeftChild) {
			parent.setLeft(current.getRight());
		}
		else {
			parent.setRight(current.getRight());
		}
	}

	private void deleteParentWithTwoChild(Node current, Node parent, boolean isLeftChild) {
		Node successor = getSubstitute(current);

		if (current == root) {
			root = successor;
		}
		else if (isLeftChild) {
			parent.setLeft(successor);
		}
		else {
			parent.setRight(successor);
		}

		successor.setLeft(current.getLeft());
	}

	private boolean isLeaf(Node current) {
		return current.getLeft() == null && current.getRight() == null;
	}

	private boolean hasNotRightChild(Node current) {
		return current.getRight() == null;
	}

	private boolean hasNotLeftChild(Node current) {
		return current.getLeft() == null;
	}

	private boolean hasTwoChild(Node current) {
		return current.getLeft() != null && current.getRight() != null;
	}

	private Node getSubstitute(Node deletedNode) {
		Node currentNode = deletedNode.getRight();
		Node substitute = null;
		Node substituteParent = null;

		while(currentNode != null) {
			substituteParent = substitute;
			substitute = currentNode;
			currentNode = currentNode.getLeft();
		}

		updateSubstituteRightChild(substitute, deletedNode, substituteParent);

		return substitute;
	}

	private void updateSubstituteRightChild(Node substitute, Node deletedNode, Node substituteParent) {
		if (substitute != deletedNode.getRight()) {
			substituteParent.setLeft(substitute.getRight());
			substitute.setRight(deletedNode.getRight());
		}
	}

	public Node getRoot() {
		return root;
	}
	
	public void setRoot(Node root) {
		this.root = root;
	}
}