package stack_dynamic;

import linked_list.LinkedList;
import linked_list.Node;

public class Stack {
	
	private LinkedList stack;
	
	public Stack() {
		stack = new LinkedList();
	}

	public void push(int data) {
		stack.insertLast(stack.getHead(), data);
	}
	
	public void pop() {
		stack.removeLast();
	}
	
	public Node peek() {
		return stack.getNode(stack.getHead(), length() - 1);
	}
	
	public int length() {
		return stack.getLength();
	}
	
	public void print(Node top) {
		if (top != null) {
			print(top.getNext());
			System.out.println(top);			
		}
	}
	
	public LinkedList getStack() {
		return stack;
	}

	public void setStack(LinkedList stack) {
		this.stack = stack;
	}
	
	public static void main(String[] args) {
		
		Stack stack = new Stack();
		
		stack.push(69);
		stack.push(5);
		stack.push(7);
		stack.push(1);
		stack.push(-5);
		
		stack.pop();
		
		System.out.println("Top: " + stack.peek());
		System.out.println("Tamanho: " + stack.length());
		stack.print(stack.stack.getHead());
	}
}
