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
	
	
	public static int circularTour(int[] petrol, int[] distance, int n) {
		
		int deficit = 0;
		int balance = 0;
		int start = 0;
		
		for(int i=0;i<n;i++) {
			balance += petrol[i] - distance[i];
			if(balance < 0) {
				deficit+=balance;
				start = i+1;
				balance = 0;
			}
		}
		
		if(deficit + balance >= 0) {
			return start;
		} else {
			return -1;
		}
	}
	
	public static Queue<Integer> interLeaveQueueApproach(Queue<Integer> queue) {
		
		Queue<Integer> helper = new LinkedList<Integer>();
		
		int count = 0;
		int size = queue.size();
		while(count<(size/2)) {
			int val = queue.peek();
			queue.remove();
			helper.add(val);
			++count;
		}
				
		while(!helper.isEmpty()) {
			int val = helper.peek();
			helper.remove();
			queue.add(val);
			val = queue.peek();
			queue.remove();
			queue.add(val);
		}
		return queue;
	}
	
	public static Queue<Integer> interLeaveStackApproach(Queue<Integer> queue) {
		
		
		Stack<Integer> stack = new Stack<Integer>();
		
		int size = queue.size();
		int count = 0;
		
		while(count<=size/2) {
			int val = queue.peek();
			queue.remove();
			stack.push(val);
			count++;
		}
		
		while(!stack.isEmpty()) {
			int val = stack.peek();
			stack.pop();
			queue.add(val);
		}
		
		count = 0;
		while(count<=size/2) {
			int val = queue.peek();
			queue.remove();
			queue.add(val);
			count++;
		}
		
		count = 0;
		while(count<=size/2) {
			int val = queue.peek();
			queue.remove();
			stack.push(val);
			count++;
		}
		
		Queue<Integer> helper = new LinkedList<Integer>();
		while(!stack.isEmpty() && !queue.isEmpty()) {
			int val = stack.peek();
			stack.pop();
			helper.add(val);
			val = queue.peek();
			queue.remove();
			helper.add(val);
		}
		
		return helper;
	}
	

	public static void main(String[] args) {
		
		Queue<Integer> queue1 = new LinkedList<Integer>();
		Queue<Integer> queue2 = new LinkedList<Integer>();
		Queue<Integer> queue3 = new LinkedList<Integer>();
		Queue<Integer> queue4 = new LinkedList<Integer>();
		
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
		
		queue3.add(11);
		queue3.add(12);
		queue3.add(13);
		queue3.add(14);
		queue3.add(15);
		queue3.add(16);
		queue3.add(17);
		queue3.add(18);
		
		queue4.add(11);
		queue4.add(12);
		queue4.add(13);
		queue4.add(14);
		queue4.add(15);
		queue4.add(16);
		queue4.add(17);
		queue4.add(18);
		
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
		
		int[] petrol = {4,6,7,4};
		int[] distance = {6,5,3,5};
		System.out.println(circularTour(petrol, distance, petrol.length));
		
		System.out.println(interLeaveQueueApproach(queue3));
		System.out.println(interLeaveStackApproach(queue3));
	}

}
