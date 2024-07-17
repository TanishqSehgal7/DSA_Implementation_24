package Stacks;

import java.util.Scanner;

public class StackUsingLinkedList {

	static Node head;
	static int size;
	static int top;
	
	public static Scanner scn = new Scanner(System.in);
	
	static class Node {
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	public StackUsingLinkedList(int size) {
		this.size = size;
		this.head = null;
		this.top = -1;
	}
	
	public static boolean isEmpty() {
		return head == null && top==-1;
	}
	
	public static boolean isFull() {
		return top>=size-1;
	}
	
	public static void push(int data) {
		
		Node newNode = new Node(data);
		if(isEmpty()) {
			++top;
			head = newNode;
			return;
		} else if(!isFull()) {
			++top;
			newNode.next = head;
			head = newNode;
			return;
		} else if(isFull()) {
			System.out.println("Stack Overflow!");
			return;
		}
	}
	
	public static void pop() {
		try {
			if(!isEmpty()) {
				head = head.next;
				--top;
			}
		} catch (Exception e) {
			System.out.println("Stack Underflow! " + e.getMessage());
		}
	}
	
	public static int peek() {
		return head.data;
	}
	
	public static void printStack() {
		
		if(isEmpty()) {
			System.out.println("Stack is Empty!");
		} else {
			Node current = head;
			while(current!=null) {
				System.out.println(current.data);
				current = current.next;
			}
		}
 	}

	public static void main(String[] args) {

		System.out.println("Enter size of Stack");
		size = scn.nextInt();
		
		StackUsingLinkedList stack = new StackUsingLinkedList(size);
		
		stack.push(10);
		stack.push(20);
		
		System.out.println("Stack is:");
		printStack();
		System.out.println("\n");
		System.out.println("\nTop is: " + top);
		
		stack.pop();
		System.out.println("\n");
		
		stack.push(20);
		stack.push(30);
		stack.push(40);
		
		System.out.println("Stack is:");
		printStack();
		System.out.println("\n");
		System.out.println("\nTop is: " + top);
		
		System.out.println("Top of Stack is:\n " + stack.peek());
		
		stack.push(50);
		System.out.println("Stack is:");
		printStack();
		System.out.println("\n");
		System.out.println("\nTop is: " + top);
		
		stack.push(60); // gives index out of bound error
	}

}
