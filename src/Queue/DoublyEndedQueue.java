package Queue;

public class DoublyEndedQueue {

	static int arr[];
	static int size;
	static int front;
	static int rear;
	
	public DoublyEndedQueue(int size) {
		this.size = size;
		this.arr = new int[size];
		this.front = -1;
		this.rear = -1;
	}
	
	
	public static void enQueueFront(int data) {
		
		// if queue is full
		if((front==0 && rear==size-1) || (rear == (front-1)%(size-1))) { // queue is full
			return;
		} else if(front == -1) { // enqueue first element
			front = 0;
			rear = 0;
		} else if(front == 0) { // cyclic nature
			front = size-1;
		} else {
			front--;
		}
		arr[front] = data;
		return;
	}
	
	public static void enQueueRear(int data) {
		
		if((front==0 && rear==size-1) || (rear == (front-1)%(size-1))) { // queue is full
			return;
		} else if(front == -1) { // enqueue first element
			front = 0;
			rear = 0;
		} else if(rear == size-1) { // cyclic nature
			rear = 0;
		} else {
			rear++;
		}
		arr[rear] = data;
	}
	
	public static void deQueueFront() {
		
		// check for empty queue
		arr[front] = -1;
		if(front == -1) {
			return;
		} else if(front == rear) { // single element
			front = -1;
			rear = -1;
		} else if(front == size-1) {
			front = 0;
		} else {
			front++;
		}
		return;
	}
	
	public static void deQueueRear() {
		
		arr[rear] = -1;
		// check for empty queue
		if(front == -1) {
			return; 
		} else if(front == rear) { // single element
			front = -1;
			rear = -1;
		} else if(rear == 0) { // cyclic nature
			rear = size-1;
		} else {
			rear--;
		}
	}
	
	public static void printCircularQueue() {
		for(int i=0;i<arr.length;i++) {
			if(arr[i]!=-1) {
				System.out.print(arr[i] + " ");
			}
		}
		System.out.println("\n");
	}
	
	
	public static void main(String[] args) {
		
		DoublyEndedQueue deq = new DoublyEndedQueue(5);
		
		deq.enQueueFront(10);
		deq.enQueueFront(20);
		deq.enQueueFront(30);
		printCircularQueue();
		deq.enQueueRear(40);
		deq.enQueueRear(50);
		printCircularQueue();
		deq.deQueueFront();
		printCircularQueue();
		deq.deQueueRear();
		printCircularQueue();
	}

}
