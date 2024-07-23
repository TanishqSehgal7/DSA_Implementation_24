package Queue;

public class QueueArrayImplementation {

	static int front = 0;
	static int rear = 0;
	static int[] arr;
	static int size;
	
	public QueueArrayImplementation(int size) {
		this.front = 0;
		this.rear = 0;
		this.size = size;
		this.arr = new int[size];
	}
	
	public static void enQueue(int data) {
		
		if(rear==size) {
			return;
		} else {
			arr[rear] = data;
			rear++;
		}
	}
	
	public static void deQueue() {
		
		if(front == rear) {
			System.out.println("Queue is Empty!");
			return;
		} else {
			arr[front] = -1;
			front++;
			if(front == rear) {
				front = 0;
				rear = 0;
			}
		}
	}
	
	public static void printQueue() {
		for(int i = front; i<=rear-1;i++) {
			System.out.println(arr[i] + " ");
		}
		System.out.println("\n");
	}
	
	
	public static void main(String[] args) {
		
		QueueArrayImplementation queue = new QueueArrayImplementation(5);
		
		queue.enQueue(10);
		queue.enQueue(20);
		queue.enQueue(30);
		queue.enQueue(40);
		queue.enQueue(50);
		printQueue();
		
		queue.deQueue();
		queue.deQueue();
		printQueue();

	}

}
