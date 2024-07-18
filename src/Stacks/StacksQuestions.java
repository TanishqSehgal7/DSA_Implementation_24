package Stacks;

import java.util.Stack;

public class StacksQuestions {
	
	public static String reverStringUsingStack(String str) {
		
		Stack<Object> stack = new Stack<Object>();
		String reversedString = "";
		
		for(char ch:str.toCharArray()) {
			stack.push(ch);
		}
		
		while(!stack.isEmpty()) {
			reversedString+= stack.pop();
		}
		return reversedString;
	}
	
	public static void main(String[] args) {
		String str = "Tanishq";
		System.out.println("Reversed String: " + reverStringUsingStack(str));
	}
}
