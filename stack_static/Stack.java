package stack_static;

public class Stack {

	private int[] stack;
	private int top;
	
	public Stack(int size) {
		stack = new int[size];
		top = -1;
	}
	
	public void push(int data) {
		if (!isFull()) {
			stack[++top] = data;
		}
	}
	
	public void pop() {
		if (!isEmpty()) {
			stack[top--] = 0;
		}
	}
	
	public int peek() {
		return stack[top];
	}
	
	public int length() {
		return top + 1;
	}
	
	public void print() {
		for (int i = top; i >= 0; i--) {
			System.out.println(stack[i]);
		}
	}
	
	private boolean isFull() {
		return top == stack.length - 1;
	}
	
	private boolean isEmpty() {
		return top == -1;
	}
	
	public static void main(String[] args) {
		Stack stack = new Stack(10);
		
		stack.push(5);
		stack.push(3);
		stack.push(1);
		stack.push(4);
		stack.push(67);
		
		stack.pop();
		
		System.out.println("Top: " + stack.peek());
		System.out.println("Tamanho: " + stack.length());
		stack.print();
	}
}
