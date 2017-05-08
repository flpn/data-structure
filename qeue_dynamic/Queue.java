package qeue_dynamic;

import linked_list.LinkedList;
import linked_list.Node;

public class Queue {

	private LinkedList queue;
	
	public Queue() {
		queue = new LinkedList();
	}
	
	public void add(int data) {
		queue.insertLast(queue.getHead(), data);
	}
	
	public void remove() {
		queue.removeFirst();
	}
	
	public Node peek() {
		return queue.getHead();
	}

	public int length() {
		return queue.getLength();
	}
	
	public void print() {
		queue.print(queue.getHead());
	}
	
	public static void main(String[] args) {
		
		Queue queue = new Queue();
		
		queue.add(56);
		queue.add(1);
		queue.add(34);
		queue.add(5);
		queue.add(6);
		
		queue.remove();
		
		System.out.println("Primeiro: " + queue.peek());
		System.out.println("Tamanho: " + queue.length());
		queue.print();
	}
}
