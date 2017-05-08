package qeue_static;

public class Queue {

	private int[] queue;
	private int next;
	
	public Queue(int size) {
		queue = new int[size];
	}
	
	public void add(int data) {
		if (!isFull()) {
			queue[next++] = data;
		}
	}
	
	public void remove() {
		if (!isEmpty()) {
			for (int i = 0; i < next - 1; i++) {
				queue[i] = queue[i + 1];
			}
			
			queue[--next] = 0;
		}
	}
	
	public int peek() {
		return queue[0];
	}
	
	public int length() {
		return next;
	}
	
	public void print() {
		for (int i = 0; i < next; i++) {
			System.out.print(queue[i] + " ");
		}
	}
	
	private boolean isEmpty() {
		return next == 0;
	}
	
	private boolean isFull() {
		return next >= queue.length;
	}
	
	public static void main(String[] args) {
		
		Queue queue = new Queue(10);
		
		queue.add(56);
		queue.add(6);
		queue.add(5);
		queue.add(23);
		queue.add(1);
		queue.add(2);
		queue.add(-5);
		queue.add(8);
		queue.add(9);
		queue.add(4);
		
		queue.remove();

		
		System.out.println("Primeiro: " + queue.peek());
		System.out.println("Tamanho: " + queue.length());
		queue.print();
	}
}
	
