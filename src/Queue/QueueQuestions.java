package Queue;

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

	public static void main(String[] args) {
		
		Queue<Integer> queue1 = new LinkedList<Integer>();
		Queue<Integer> queue2 = new LinkedList<Integer>();
		
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
		System.out.println("\n");
		System.out.println(queue2);
		
	}

}
