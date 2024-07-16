package Stacks;

import java.util.Scanner;

public class StackArrayImplementation {

	public static int top = -1;
	public static int size;
	public static int arr[];
	
	static Scanner scn = new Scanner(System.in);
	
	public StackArrayImplementation(int size) {
		this.size = size;
		this.arr = new int[size];
		this.top = -1;
	}
	
	public static int[] push(int arr[],int data) {
		
		if(top>size-1) {
			System.out.println("Stack Overflow!");
		} else {
			arr[++top] = data;
		}
		
		return arr;
	}
	
	public static int pop() {
		
		if(top==-1) {
			System.out.println("Stack Underflow!");
			return -1;
		} else {
			arr[top] = -1;
			return arr[top--];
		}
	}
	
	
	public static int peek() {
		if(top==-1) {
			return -1;
		} else {
			return arr[top];
		}
	}
	
	
	public static void printStack() {
		
		if(top==-1) {
			System.out.println("Stack is Empty");
		} else {
			for(int i = top; i>=0;i--) {
				System.out.println(arr[i]);
			}
		}
	}
	
	
	public static void main(String[] args) {
		
		System.out.println("Enter Size of Stack:\n");
		size = scn.nextInt();

		StackArrayImplementation stack = new StackArrayImplementation(size);
		
		for(int i=0;i<size;i++) {
			int element = scn.nextInt();
			stack.push(arr, element);
		}
		
		printStack();
		System.out.println("\n");
		
		stack.pop();
		printStack();	
		
		System.out.println("Top of Stack: " + stack.peek());
		

	}

}
