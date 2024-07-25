package Queue;

public class QueueLinkedListImplementation {
	
	static Node front = null;
	static Node rear = null;
	static int size;
	static int frnt;
	static int rr;
	
	public static class Node {
		
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	public QueueLinkedListImplementation(int size) {
		this.front = null;
		this.rear = null;
		this.size = size;
		this.frnt = 0;
		this.rr = 0;
	}
	
	public static boolean isEmpty() {
		return (frnt == 0 && rr == 0 && front == null && rear == null);
	}
	
	public static boolean isFull() {
		return (rr == size);
	}
	
	public static void enQueue(int data) {
		
		Node newNode = new Node(data);
		
		if(isFull()) {
			return;
		}
		else if(isEmpty()) {
			front = newNode;
			rear = newNode;
		} else {
			rear.next = newNode;
			rear = newNode;
			rr++;
		}
	}
	
	public static void deQueue() {
		
		if(isEmpty()) {
			return;
		} else {
			front = front.next;
			frnt++;
			
			if(front == rear && frnt == rr) {
				frnt = 0;
				rr = 0;
				return;
			}
		}
	}
	
	public static void printQueue() {
		
		Node current = front;
		while(current!=null) {
			if(current.next==null) {
				System.out.print(current.data);
			} else {
				System.out.print(current.data + " <- ");
			}
			current = current.next;
		}
		
		System.out.println("\n");
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		QueueLinkedListImplementation queue = new QueueLinkedListImplementation(5);
		
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
