package Queue;

public class CircularQueue {
	
	static int arr[];
	static int size;
	static int front;
	static int rear;
	
	public CircularQueue(int size) {
		this.size = size;
		this.arr = new int[size];
		this.front = -1;
		this.rear = -1;
	}
	
	public static void enQueue(int data) {
		
		// if queue is full
		if((front == 0 && rear == size-1) || (rear == (front-1)%(size-1))) {
			return;
		} else if(front == -1) { // single element
			front = 0;
			rear = 0;
		} else if((rear == size-1) && (front!=0)) { // cyclic nature of queue
			rear = 0;
		} else { // normal case
			rear++;
		}
		
		arr[rear] = data;
		return;
	}
	
	public static void deQueue() {
		// is queue is empty
		arr[front] = -1;
		if(front == -1 && rear == -1) {
			return;
		} else if(front == rear) {
			front = -1;
		} else if(front==size-1) {
			front = 0;
		} else {
			front++;
		}
		return;
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
		// TODO Auto-generated method stub
		
		CircularQueue cq = new CircularQueue(5);
		cq.enQueue(10);
		cq.enQueue(20);
		cq.enQueue(30);
		cq.enQueue(40);
		cq.enQueue(50);

		printCircularQueue();
		cq.deQueue();
		printCircularQueue();
		cq.enQueue(60);
		printCircularQueue();
	}

}
