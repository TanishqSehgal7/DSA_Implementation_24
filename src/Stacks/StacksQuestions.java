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
	
	
	public static boolean balancedParenthesis(String str) {
		
		Stack<Character> stack = new Stack<Character>();
		
		for(char ch: str.toCharArray()) {
			
			if(ch == '{' || ch == '[' || ch ==  '(') {
				stack.push(ch);
			} else {
				if(!stack.isEmpty()) {
					if((ch == '}' && stack.peek() == '{') || 
						(ch == ']' && stack.peek() == '[') || 
						(ch == ')' && stack.peek() == '(')) {
						
						stack.pop();
					}
				}
			}
		}
		
		if(stack.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		String str = "Tanishq";
		System.out.println("Reversed String: " + reverStringUsingStack(str));
		
		String parenthesis = "[()]{}{()}";
//		String parenthesis = "[(}]";
		System.out.println(balancedParenthesis(parenthesis));
	}
}
