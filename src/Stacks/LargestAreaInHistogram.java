package Stacks;

import java.util.Stack;

public class LargestAreaInHistogram {

	
	public static int[] nextSmallerElement(int[] heights) {
		
		
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(-1);
		int [] nextSmallerElementIdxes = new int[heights.length];
		
		for(int i=heights.length-1;i>=0;i--) {
			
			int element = heights[i];
			
			while(stack.peek()!=-1 && heights[stack.peek()]>element) {
				stack.pop();
			}
			nextSmallerElementIdxes[i] = stack.peek();
			stack.push(i);
		}
		
		return nextSmallerElementIdxes;
	}
	
	public static int[] prevSmallerElement(int[] heights) {
		
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(-1);
		int [] prevSmallerElementIdxes = new int[heights.length];
		
		for(int i=0;i<heights.length;i++) {
			
			int element = heights[i];
			
			while(stack.peek()!=-1 && heights[stack.peek()]>element) {
				stack.pop();
			}
			prevSmallerElementIdxes[i] = stack.peek();
			stack.push(i);
		}
		
		return prevSmallerElementIdxes;
		
	}
	
	public static int findLargestAreaInHist(int heights[]) {
		
		int [] nextSmaller = new int[heights.length];
		nextSmaller = nextSmallerElement(heights);
		
		int [] prevSmaller = new int[heights.length];
		prevSmaller = prevSmallerElement(heights);
		
		int area = Integer.MIN_VALUE;
		
		for(int i=0;i<heights.length;i++) {
			
			int l = heights[i];
			
			// case when all heights are equal
			if(nextSmaller[i] == -1) {
				nextSmaller[i] = heights.length;
			}
			
			int b = nextSmaller[i] - prevSmaller[i] - 1;
			
			int newArea = (l*b);
			area = Math.max(area, newArea);
		}	
		
		return area;
	}
	
	public static void main(String[] args) {
		
		int[] heights = {2,3,4,5,1};
		int largestArea = findLargestAreaInHist(heights);
		System.out.println("Largest Area in Histogram: " + largestArea);
	}
}
