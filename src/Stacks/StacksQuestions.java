package Stacks;

import java.util.ArrayList;
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
	
	public static Stack<Integer> deleteMiddleFromStack(Stack<Integer> stack, int count, int size) {
		
		// base case 
		if(count == size/2) {
			stack.pop();
			return stack;
		}
		
		int num = stack.peek();
		stack.pop();
		
		stack = deleteMiddleFromStack(stack, count+1, size);
		stack.push(num);
		
		return stack;
	}
	
	public static Stack<Integer> pushAtBottom(Stack<Integer> stack, int x) {
		
		if(stack.isEmpty()) {
			stack.push(x);
			return stack;
		}
		
		int num = stack.peek();
		stack.pop();
		stack = pushAtBottom(stack, x);
		stack.push(num);
		
		return stack;
	}
	
	public static Stack<Integer> reverseStack(Stack<Integer> stack) {
		
		int num = stack.peek();
		stack.pop();
		
		if(stack.isEmpty()) {
			stack.push(num);
			return stack;
		}
		 
		stack = reverseStack(stack);
		
		if(!stack.isEmpty()) {
			pushAtBottom(stack, num);
			return stack;
		}
		
		return stack;
	}
	
	public static Stack<Integer> sortStack(Stack<Integer> stack) {
	
		int num = stack.peek();
		stack.pop();
		
		// base case
		if(stack.isEmpty()) {
			stack.push(num);
			return stack;
		}
		
		stack = sortStack(stack);
		stack = sortedStackInsert(stack, num);
		return stack;
	}
	
	public static Stack<Integer> sortedStackInsert(Stack<Integer> stack, int x) {
		
		if(stack.isEmpty() || (!stack.isEmpty() && stack.peek()<x)) {
			stack.push(x);
			return stack;
		}
		
		int num = stack.peek();
		stack.pop();
		
		sortedStackInsert(stack, x);
		stack.push(num);
		return stack;
	}
	
	public static boolean redundantBrackets(Stack<Character> stack, String exp) {
		
		for(int i=0;i<exp.length();i++) {
			
			char ch = exp.charAt(i);
			boolean isRedundant = true;
			
			if(ch == '(' || ch == '+' || ch == '-' || ch == '*' || ch == '/') {
				stack.push(ch);
			} else {
				
				if(ch == ')') {
					char top = stack.peek();
					while(stack.peek()!='(') {
						if(top == '+' || top == '-' || top == '*' || top == '/' ) {
							isRedundant = false;
						}
						stack.pop();
					}
					
					stack.pop();
					
					if(isRedundant) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	
	public static int minCostToMakeStringValid(Stack<Character> stack, String str) {
		
		if(str.length()%2!=0) {
			return -1;
		}
		
		for(int i=0;i<str.length();i++) {

			char ch = str.charAt(i);

			// if ch is an open brace then push it to stack
			if(ch == '{') {
				stack.push(ch);
			} else {
				// if ch is a closed brace
				
				if(!stack.isEmpty() && stack.peek() == '{') {
					stack.pop();
				} else {
					stack.push(ch);
				}
			}
		}
		
		int openBraceCount = 0;
		int closedBraceCount = 0;
		
		while(!stack.isEmpty()) {
			if(stack.peek() == '{') {
				openBraceCount++;
			} else {
				closedBraceCount++;
			}
			stack.pop();
		}
		
		int answer = (openBraceCount+1)/2 + (closedBraceCount+1)/2;
		return answer;
	}
	
//	public static int[] nextSmallerElement(Stack<Integer> stack, int arr[]) {
//		
//		int[] result = new int[arr.length];
//		stack.push(-1);
//		for(int i=arr.length-1; i>=0;i--) {
//			
//			int element = arr[i];
//			
//			if(!stack.isEmpty() && stack.peek()<element) {
//				result[i] = stack.peek();
//				stack.push(element);
//			} else if(!stack.isEmpty() && stack.peek()>element) {
//				while(stack.peek()>element) {
//					stack.pop();
//				}
//				if(stack.peek()<element) {
//					result[i] = stack.peek();
//					stack.push(element);
//				}
//			}
//		}
//		return result;
//	}
	
	
	public static int[] nextSmallerElement(Stack<Integer> stack, int arr[]) {
		
		int[] result = new int[arr.length];
		stack.push(-1);
		
		for(int i=arr.length-1;i>=0;i--) {
			
			int element = arr[i];
			
			while(stack.peek()>element) {
				stack.pop();
			}
			
			if(!stack.isEmpty() && stack.peek()<element) {
				result[i] = stack.peek();
				stack.push(element);
			}
		}
		
		return result;
	}
	
//	public static int[] nextSmallerElement(Stack<Integer> stack, int arr[]) {
//		
//		int[] result = new int[arr.length];
//		stack.push(-1);
//		
//		for(int i=arr.length-1;i>=0;i--) {
//			
//			int element = arr[i];
//			
//			while(stack.peek()>element) {
//				stack.pop();
//			}
//			
//			result[i] = stack.peek();
//			stack.push(element);
//		}
//		
//		return result;
//	}
	
 	
	public static void main(String[] args) {
		String str = "Tanishq";
		System.out.println("Reversed String: " + reverStringUsingStack(str));
		
		String parenthesis = "[()]{}{()}";
//		String parenthesis = "[(}]";
		System.out.println(balancedParenthesis(parenthesis));
		
		Stack<Integer> st = new Stack<Integer>();
		st.push(10);
		st.push(20);
		st.push(30);
		st.push(40);
		st.push(50);
		
		System.out.println(st);
		st =deleteMiddleFromStack(st, 0, st.size());
		System.out.println(st);
		
		int x = 30;
		System.out.println(pushAtBottom(st,x));
		
		System.out.println("Top: " + st.peek());
		
		System.out.println(reverseStack(st));
		
		System.out.println(sortStack(st));
		
		Stack<Character> expressionstack = new Stack<Character>();
		String exp = "(a+b)";
		System.out.println(redundantBrackets(expressionstack,exp));
		
		Stack<Character> s = new Stack<Character>();
		String bracesExp = "}}}{{{";
		System.out.println(minCostToMakeStringValid(s,bracesExp));
		
		Stack<Integer> nextSmElement = new Stack<Integer>();
		int[] arr = {2,1,4,3};
		
		int[] result = nextSmallerElement(nextSmElement,arr);
//		nextSmallerElement(nextSmElement,arr);
		
		for(int i=0;i<result.length;i++) {
			System.out.print(result[i] + " ");
		}
		
	}
}
