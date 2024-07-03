package LinkedList.CircularLinkedList;

public class CircularLL {

	static Node head = null;
	static Node tail = head;
	
	public static class Node {
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
		}
	}
	
	public static void insertAtHead(int data) {
		
		Node newNode = new Node(data);
		
		if(head == null) {
			head = tail = newNode;
			return;
		} else {
			newNode.next = head;
			head = newNode;
			tail.next = head;
			return;
		}
	}
	
	public static void insertionAtTail(int data) {
		
		Node temp = tail;
		Node newNode = new Node(data);
		
		if(head == null && tail == null) {
			head = tail = null;
			return;
		} else {
			tail.next = newNode;
			tail = newNode;
			tail.next = head;
			return;
		}
	}
	
	public static void printLL() {
		
		Node temp = tail;
		do {
			System.out.print(tail.data +  " -> ");
			tail = tail.next;
		} while(tail!=temp);
	}
	
	public static void main(String[] args) {
		
		insertAtHead(50);
		insertAtHead(40);
		insertAtHead(30);
		insertAtHead(20);
		insertAtHead(10);
		
		insertionAtTail(60);
		
		printLL();
	}

}
