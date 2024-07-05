package LinkedList.CircularLinkedList;

public class CircularLL {

	static Node head = null;
	static Node tail = null;
	
	public static class Node {
		
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	public static void insertAtEnd(int data) {
		
		Node newNode = new Node(data);
		
		if(tail == null && head == null) {
			tail = newNode;
			head = newNode;
			tail.next = head;
			return;
		} else {
			tail.next = newNode;
			tail = newNode;
			tail.next = head;
		}
	}
	
	public static void insertAtHead(int data) {
		
		Node newNode = new Node(data);
		
		if(tail == null || head == null) {
			head = newNode;
			tail = newNode;
			tail.next = head;
			return;
		} else {
			newNode.next = head;
			tail.next = newNode;
			head = newNode;
		}
	}
	
	public static int getLength() {
		
		int length = 0;
		Node current = head;
		do {
			current = current.next;
			length++;
		} while(current!=head);
		
		return length;
	}
	
	public static void insertAtKthPos(int data, int pos) {
		Node newNode = new Node(data);
		
		if(head == null || pos == 1) {
			insertAtHead(data);
			return;
		}
		
		int length = getLength();
		if(pos > length) {
			insertAtEnd(data);
			return;
		}
		
		Node current = head;
		int count = 1;
		while(count < pos-1) {
			current = current.next;
			count++;
		}
		Node nextOfCurrent = current.next;
		current.next = newNode;
		newNode.next = nextOfCurrent;
	}
	
	public static void deleteAtKthPos(int pos) {
		if(head == null && tail == null) {
			System.out.println("Cannot Delete! List is Empty.");
		} else {
			int len = getLength();
			if(pos == 1) {
				deleteAtHead();
			}
			if(pos > len) {
				deleteAtEnd();
			}
			int count = 1;
			Node current = head;
			while(count < pos-1) {
				current = current.next;
				count++;
			}
			Node nextOfNodeToDelete = current.next.next;
			current.next = nextOfNodeToDelete;
			return;
		}
	}
	
	public static void deleteAtHead() {
		
		if(head == null && tail == null) {
			System.out.println("List is Empty! Cannot delete");
		} else {
			head = tail.next.next;
			tail.next = head;
			return;
		}
	}
	
	public static void deleteAtEnd() {
		
		if(head == null && tail == null) {
			System.out.println("Cannot Delete! List is Empty");
		} else {
			Node current = head;
			while(current.next!=tail) {
				current = current.next;
			}
			tail = current;
			tail.next = head;
			return;
		}
	}
	
	public static void reverseCLL() {
		Node current = head;
		Node previous = null;
		Node nextNode = null;
		
		do {
			nextNode = current.next;
			current.next = previous;
			previous = current;
			current = nextNode;
		} while(current != head);
		nextNode.next = previous;
		head = previous;
	}
	
	public static void printLL() {
		Node current = head;
		do {
			System.out.print(current.data + " => ");
			current = current.next;
		} while(current!=head);
	}
	
	public static void main(String[] args) {
		
		insertAtEnd(50);
		insertAtEnd(40);
		insertAtEnd(30);
		insertAtEnd(20);
		insertAtEnd(10);
		printLL();
		System.out.println("\n");
		
		insertAtHead(10);
		insertAtHead(20);
		insertAtHead(30);
		insertAtHead(40);
		printLL();
		System.out.println("\n");

		deleteAtHead();
		printLL();
		System.out.println("\n");
		
		insertAtKthPos(5,4);
		printLL();
		System.out.println("\n");
		
		deleteAtEnd();
		printLL();
		System.out.println("\n");
		
		deleteAtKthPos(3);
		printLL();
		System.out.println("\n");
		
		reverseCLL();
		printLL();
		System.out.println("\n");

	}
}
