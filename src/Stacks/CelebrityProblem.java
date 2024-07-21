package Stacks;

import java.util.Stack;

public class CelebrityProblem {
	
	public static boolean knows(int arr[][], int a, int b) {
		
		if(arr[a][b] == 1)
			return true;
		else
			return false;
	}

	public static int findCelebrity(int [][]arr, int n) {
		
		Stack<Integer> stack = new Stack<Integer>();
		
		// push all indexes to stack
		for(int i = 0; i<arr.length; i++) {
			stack.push(i);
		}
		
		// pop 2 elements, discard one on the basis of who knows who and push the other back in stack
		while(stack.size()>1) {
			
			int a = stack.peek();
			stack.pop();
			
			int b = stack.peek();
			stack.pop();
			
			if(knows(arr,a,b)) {
				stack.push(b);
			} else if(knows(arr,b,a)) {
				stack.push(a);
			}			
		}
		// now we have the candidate celebrity, so we check the corresponding row and col
		// check row to make sure that celebrity knows no one
		// check col to make sure that everyone knows celebrity

		int candidate = stack.peek();
		int zeroCount = 0;
		int oneCount = 0;
				
		for(int i=0;i<n;i++) {
			if(i!=candidate) {
				if(arr[candidate][i] == 0) {
					zeroCount++;
				} 
				if(arr[i][candidate] == 1) {
					oneCount++;
				}
			}
		}
		
		if(zeroCount == n-1 && oneCount == n-1) {
			return candidate;
		}
		
		return -1;
	}
	
	
	public static void main(String[] args) {
		
		
		int[][] arr = {{0,1,0},{0,0,0},{0,1,0}};
		int n = arr.length;		
		System.out.println("Celebrity in the room is: " + findCelebrity(arr,n));
	}

}
