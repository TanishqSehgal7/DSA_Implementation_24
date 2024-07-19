package Stacks;

import java.util.Scanner;
import java.util.Stack;

public class StackArrayImplementation {
	
	static int arr[];
	static int size;
	static int top;
	
	public static Scanner scn = new Scanner(System.in);
	
	public StackArrayImplementation(int size) {
		this.size = size;
		this.arr = new int[size];
		this.top = -1;
	}
	
	public static boolean isFull() {
		return top>=size-1;
	}
	
	public static boolean isEmpty() {
		return top==-1;
	}
	
	public static void push(int data) {
		
		try {
			if(!isFull()) {
				arr[++top] = data;
			}
		} catch (Exception e) {
			System.out.println("Stack Overflow! " + e.getMessage());
		}
	}
	
	
	public static int pop() {
		
		try {
			if(!isEmpty()) {
				arr[top] = -1;
				top-=1;
				return arr[top];
			}
		} catch (Exception e) {
			System.out.println("Stack Underflow! " + e.getMessage());
		}
		return -1;
	}
	
	public static int peek() {
		if(isEmpty()) {
			return -1;
		} else {
			return arr[top];
		}
	}
	
	public static void printStack() {
		if(isEmpty()) {
			System.out.println("Empty Stack!");
		} else {
			for(int i=top;i>=0;i--) {
				System.out.println(arr[i]);
			}
		}
	}
	
	public static void main(String[] args) {
		
		
		System.out.println("Enter the size of Stack:\n");
		size = scn.nextInt();
		
		StackArrayImplementation stack = new StackArrayImplementation(size);
		
		stack.push(10);
		stack.push(20);
		
		System.out.println("Stack is:");
		printStack();
		System.out.println("\n");
		
		stack.pop();
		System.out.println("\n");
		
		stack.push(20);
		stack.push(30);
		stack.push(40);
		
		System.out.println("Stack is:");
		printStack();
		System.out.println("\n");
		
		System.out.println("Top of Stack is:\n " + stack.peek());
		
		stack.push(50);
		System.out.println("Stack is:");
		printStack();
		System.out.println("\n");
		
		stack.push(60); // gives index out of bound error
		
		
//		stack.pop();
//		stack.pop();
//		stack.pop();
//		stack.pop();
//		stack.pop();
//		stack.pop();
//		printStack();
//		System.out.println("\n");
		
	}

}
