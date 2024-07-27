package Queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueQuestions {
	
	public static void reverseQueueUsingStack(Queue<Integer> queue) {
		
		Stack<Integer> stack  = new Stack<Integer>();
		
		while(!queue.isEmpty()) {
			int num = queue.peek();
			queue.remove();
			stack.push(num);
		}
		
		while(!stack.isEmpty()) {
			int num = stack.peek();
			stack.pop();
			queue.add(num);
		}
	} 
	
	
	public static void reverseQueueUsingRecursion(Queue<Integer> queue) {
		
		if(queue.isEmpty()) {
			return;
		}
		
		int num = queue.peek();
		queue.remove();
		reverseQueueUsingRecursion(queue);
		queue.add(num);
	}
	
	public static ArrayList<Integer> findFirstNegativeNumberInKsizedWindow(int arr[], int k) {
		
		Deque<Integer> deq = new ArrayDeque<Integer>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		// handle the first window of size k
		for(int i=0;i<k;i++) {
			if(arr[i]<0) {
				deq.addLast(i);
			}
		}
		
		if(!deq.isEmpty() && arr[deq.peek()]<0) {
			result.add(arr[deq.peek()]);
		} else {
			result.add(0);
		}
		
		// handle remaining elements in windows of k
		for(int i=k;i<arr.length;i++) {
			
			// for next element to enter in the window from the end, one has to exit from front
			if(!deq.isEmpty() && i - deq.peek()>=k) {
				deq.removeFirst();
			}
			
			// adding element to window
			if(arr[i]<0) {
				deq.addLast(i);
			}
			
			if(!deq.isEmpty() && arr[deq.peek()]<0) {
				result.add(arr[deq.peek()]);
			} else {
				result.add(0);
			}	
		}
		
		return result;
	}
	
	
	public static void reverseKElementsOfQueue(Queue<Integer> queue, int k) {
		
		int n = queue.size();
		
		// fetch first k elements of queue and push to stack
		Stack<Integer> stack = new Stack<Integer>();

		for(int i=0;i<k;i++) {
			int peek = queue.peek();
			queue.remove();
			stack.push(peek);
		}
		
		// push back reversed first k elements back to queue 
		while(!stack.isEmpty()) {
			queue.add(stack.peek());
			stack.pop();
		}
		
		for(int i=0;i<(n-k);i++) {
			int peek = queue.peek();
			queue.remove();
			queue.add(peek);
		}
	}
	
	public static String nonRepeatingCharInStream(String str) {
		
		HashMap<Character, Integer> map = new HashMap<Character,Integer>();
		Queue<Character> queue = new LinkedList<Character>();
		String ans = "";
		
		for(int i=0;i<str.length();i++) {
			
			if(map.containsKey(str.charAt(i))) {
				map.put(str.charAt(i), map.get(str.charAt(i))+1);
			} else {
				map.put(str.charAt(i), 1);
			}
			
			queue.add(str.charAt(i));
			
			while(!queue.isEmpty()) {
				if(map.get(queue.peek())>1) { // repeating element
					 queue.remove();
				} else { // non repeating element
					ans+=queue.peek();
					break;
				}
			}
			
			if(queue.isEmpty()) {
				ans+="#";
			}
		}
		return ans;
 	}
	

	public static void main(String[] args) {
		
		Queue<Integer> queue1 = new LinkedList<Integer>();
		Queue<Integer> queue2 = new LinkedList<Integer>();
		
		int[] arr = {-8,2,3,-6,10};
		
		queue1.add(10);
		queue1.add(20);
		queue1.add(30);
		queue1.add(40);
		queue1.add(50);
		
		queue2.add(60);
		queue2.add(70);
		queue2.add(80);
		queue2.add(90);
		queue2.add(100);
		
		reverseQueueUsingStack(queue1);
		System.out.println(queue1);
		
		reverseQueueUsingRecursion(queue2);
		System.out.println(queue2);
		
		ArrayList<Integer> firstNegativeElementList = new ArrayList<Integer>();
		firstNegativeElementList = findFirstNegativeNumberInKsizedWindow(arr,2);
		
		for(int element:firstNegativeElementList) {
			System.out.print(element + " ");
		}
		
		System.out.println("\n");
		
		reverseKElementsOfQueue(queue2,3);
		System.out.println(queue2);
		
		String str = "aabc";
		System.out.println(nonRepeatingCharInStream(str));
	}

}
