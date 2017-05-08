package linked_list;

public class LinkedList {
	
	private Node head;
	private int length;
	
	public void insertFirst(int data) {
		if (head == null)  {
			head = new Node(data);
		}
		else { 
			head = new Node(data, head);
		}
		
		length++;
	}
	
	public void insertLast(Node head, int data) {
		if(head == null) {
			insertFirst(data);
		}
		else if(head.getNext() == null) {
			head.setNext(new Node(data));
			length++;
		}
		else {
			insertLast(head.getNext(), data);
		}
	}
	
	public void insertAtPosition(int data, int position) {
		if (position == 0) {
			insertFirst(data);
		}
		else if (position == length) {
			insertLast(head, data);
		}
		else {
			Node previous = getNode(head, position - 1);
			Node next = getNode(head, position);
			
			Node newNode = new Node(data, next);
			previous.setNext(newNode);
			length++;
		}
	}
	
	public void removeFirst() {
		if(head != null) {
			head = head.getNext();
			length--;
		}
	}
	
	public void removeLast() { 
		if (length <= 1) {
			removeFirst();
		}
		else {
			getNode(head, length - 2).setNext(null);
			length--;
		}
	}
	
	public void removeAtPosition(int position) {
		if (position == 0) {
			removeFirst();
		}
		else if (position == length - 1) {
			removeLast();
		}
		else {
			Node previous = getNode(head, position - 1);
			Node next = getNode(head, position + 1);
			
			previous.setNext(next);
			length--;
		}
	}
	
	public void print(Node head) {
		if (head != null) {
			System.out.print(head + " ");
			print(head.getNext());			
		}
	}
	
	public void printReverse(Node head) {
		if (head != null) {
			printReverse(head.getNext());
			System.out.print(head + " ");			
		}
	}
	
	public Node getNode(Node head, int position) {
		if (position == 0) {
			return head;
		}
		else {
			return getNode(head.getNext(), --position);
		}
	}
	
	public Node getHead() {
		return head;
	}
	
	public void setHead(Node head) {
		this.head = head;
	}
	
	public int getLength() {
		return length;
	}
	
	public void setLength(int length) {
		this.length = length;
	}
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		
		list.insertFirst(10);
		list.insertFirst(36);
		
		list.insertLast(list.head, 9);
		list.insertLast(list.head, 12);

		list.insertAtPosition(11, 3);
		
//		list.removeFirst();
//		list.removeLast();
//		list.removeAtPosition(1);
 
		System.out.println(list.length);
		list.print(list.head);
	}
}
