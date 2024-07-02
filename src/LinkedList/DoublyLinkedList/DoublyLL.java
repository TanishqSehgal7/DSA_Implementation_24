package LinkedList.DoublyLinkedList;

public class DoublyLL {
	
	static Node head = null;
	static Node tail = head;
	
	public static class Node {
		int data;
		Node next;
		Node prev;
		
		public Node(int data) {
			this.data = data;
			this.next = null;
			this.prev = null;
		}
	}
	
	public static void insertAtHead(int data) {

		Node newNode = new Node(data);
		if(head == null) {
			head = newNode;
			tail = head;
			return;
		} else {
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		}
	}
	
	public static void insertAtEnd(int data) {
		
		Node newNode = new Node(data);
		if(head == null) {
			head = newNode;
			tail = head;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
	}
	
	public static int getLength() {
		Node temp = head;
		int length = 0;
		while(temp!=null) {
			temp = temp.next;
			length++;
		}
		return length;
	}
	
	public static void insertAtKthPosition(int data, int pos) {
		Node newNode = new Node(data);
		
		if(pos == 1) {
			insertAtHead(data);
		}
		int len = getLength();
		if(pos > len) {
			insertAtEnd(data);
		}
		Node current = head;
		int count = 1;
		while(count < pos-1) {
			current = current.next;
			count++;
		}
		
		Node nextOfNodeAtPos = current.next;
		current.next = newNode;
		newNode.prev = current;
		newNode.next = nextOfNodeAtPos;
		nextOfNodeAtPos.prev = newNode;
	}
	
	public static void printLL() {
		
		Node temp = head;
		while(temp!=null) {
			if(temp.next == null) {
				System.out.print(temp.data);
			} else {
				System.out.print(temp.data + " <=> ");
			}
			temp = temp.next;
		}
	}
	
	public static void main(String[] args) {
		insertAtHead(10);
		insertAtHead(20);
		insertAtHead(30);
		insertAtHead(40);
		insertAtHead(50);
		printLL();
		System.out.println("\n");
		insertAtEnd(50);
		insertAtEnd(40);
		insertAtEnd(30);
		insertAtEnd(20);
		insertAtEnd(10);
		printLL();
		
		System.out.println("\n");
		insertAtKthPosition(60,6);
		printLL();
		
		System.out.println("\n");
		insertAtKthPosition(5,11);
		printLL();
		
		System.out.println("\n");
		System.out.println("Length:" + getLength());
		
		System.out.println("\n");
		insertAtKthPosition(5,13);
		
		System.out.println("Length:" + getLength());
		printLL();
	}
}
