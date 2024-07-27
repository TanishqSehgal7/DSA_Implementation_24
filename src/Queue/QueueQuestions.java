package Queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
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
	}

}
