package week3_assignment2;

import java.util.*;


class Queue {
	Stack<Integer> input = new Stack<>();
	Stack<Integer> output = new Stack<>();
	
	public Queue() {
		
	}
	
	void push(int val) {
		
		
		while(!input.empty()) {
			output.push(input.peek());
			input.pop();
		}
		
		input.push(val);
		
		while(!output.empty()) {
			input.push(output.peek());
			output.pop();
		}
		
	}
	
	void pop() {
		int top = input.peek();
		
		input.pop();
		
		System.out.println("we deleted this element"+top);
	}
	
	void peek() {
		System.out.println(input.peek());
	}
	
	void printStack() {
		while(!input.empty()) {
			System.out.println(input.peek());
			input.pop();
		}
	}
	
}
public class ImplementQueueUsingStack {

	public static void main(String[] args) {
		Queue queue = new Queue();
		queue.push(23);
		queue.push(37);
		queue.push(35);
		queue.push(34);
		queue.push(89);
		
		queue.pop();
		queue.peek();
	}

}