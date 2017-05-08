package avl_tree;

public class AVLTree {

	private Node root;

	public boolean insert(int data) {
		if (root == null) {
			root = new Node(data);
		}
		else {
			Node current = root;
			Node parent;

			while (true) {
				if (current.getData() == data) {
					return false;
				}

				parent = current;

				boolean goToTheLeft = current.getData() > data;

				if (goToTheLeft) {
					current = current.getLeft();
				}
				else {
					current = current.getRight();
				}

				if (current == null) {
					if (goToTheLeft) {
						parent.setLeft(new Node(data, parent));
					}
					else {
						parent.setRight(new Node(data, parent));
					}

					rebalance(parent);
					break;
				}
			}
		}

		return true;
	}

	public void delete(int data) {
		if (root == null) {
			return;
		}

		Node node = root;
		Node child = root;

		while (child != null) {
			node = child;

			if (data >= node.getData()) {
				child = node.getRight();
			}
			else {
				child = node.getLeft();
			}

			if (data == node.getData()) {
				delete(node);
				return;
			}
		}
	}

	private void delete(Node node) {
		if (node.getLeft() == null && node.getRight() == null) {
			if (node.getParent() == null) {
				root = null;
			}
			else {
				Node parent = node.getParent();

				if (parent.getLeft() == node) {
					parent.setLeft(null);
				}
				else {
					parent.setRight(null);
				}

				rebalance(parent);
			}

			return;
		}

		if (node.getLeft() != null) {
			Node child = node.getLeft();

			while (child.getRight() != null) {
				child = child.getRight();
			}

			node.setData(child.getData());
			delete(child);
		}
		else {
			Node child = node.getRight();

			while(child.getLeft() != null) {
				child = child.getLeft();
			}

			node.setData(child.getData());
			delete(child);
		}
	}

	public void preOrder() {
		preOrder(root);
	}

	private void preOrder(Node root) {
		if (root != null) {
			System.out.printf("%s ", root.getData());
			preOrder(root.getLeft());
			preOrder(root.getRight());
		}
	}

	public void inOrder() {
		inOrder(root);
	}

	private void inOrder(Node root) {
		if (root != null) {
			preOrder(root.getLeft());
			System.out.printf("%s ", root.getData());
			preOrder(root.getRight());
		}
	}

	public void postOrder() {
		postOrder(root);
	}

	private void postOrder(Node root) {
		if (root != null) {
			preOrder(root.getLeft());
			preOrder(root.getRight());
			System.out.printf("%s ", root.getData());
		}
	}

	public void printBalance(Node node) {
		if (node != null) {
			printBalance(node.getLeft());
			System.out.printf("%s ", node.getBalance());
			printBalance(node.getRight());
		}
	}

	private void rebalance(Node node) {
		setBalance(node);

		if (node.getBalance() == -2) {
			if (height(node.getLeft().getLeft()) >= height(node.getLeft().getRight())) {
				node = rotateRight(node);
			}
			else {
				node = rotateLeftThenRight(node);
			}
		}
		else if(node.getBalance() == 2) {
			if (height(node.getRight().getRight()) >= height(node.getRight().getLeft())) {
				node = rotateLeft(node);
			}
			else {
				node = rotateRightThenLeft(node);
			}
		}

		if (node.getParent() != null) {
			rebalance(node.getParent());
		}
		else {
			root = node;
		}
	}

	private void setBalance(Node... nodes) {
		for(Node node : nodes) {
			reHeight(node);
			node.setBalance(height(node.getRight()) - height(node.getLeft()));
		}
	}

	private void reHeight(Node node) {
		if (node != null) {
			int height = 1 + Math.max(height(node.getRight()), height(node.getLeft()));
			node.setHeight(height);
		}
	}

	private int height(Node node) {
		if (node == null) {
			return -1;
		}

		return node.getHeight();
	}

	private Node rotateRight(Node node) {
		Node b = node.getLeft();

		b.setParent(node.getParent());
		node.setLeft(b.getRight());

		if (node.getLeft() != null) {
			node.getLeft().setParent(node);
		}

		b.setRight(node);
		node.setParent(b);

		if (b.getParent() != null) {
			if (b.getParent().getRight() == node) {
				b.getParent().setRight(b);
			}
			else {
				b.getParent().setLeft(b);
			}
		}

		setBalance(node, b);

		return b;
	}

	private Node rotateLeft(Node node) {
		Node b = node.getRight();

		b.setParent(node.getParent());
		node.setRight(b.getLeft());

		if (node.getRight() != null) {
			node.getRight().setParent(node);
		}

		b.setLeft(node);
		node.setParent(b);

		if (b.getParent() != null) {
			if (b.getParent().getRight() == node) {
				b.getParent().setRight(b);
			}
			else {
				b.getParent().setLeft(b);
			}
		}

		setBalance(node, b);

		return b;
	}

	private Node rotateLeftThenRight(Node node) {
		node.setLeft(rotateLeft(node.getLeft()));

		return rotateRight(node);
	}

	private Node rotateRightThenLeft(Node node) {
		node.setRight(rotateRight(node.getRight()));

		return rotateLeft(node);
	}
}