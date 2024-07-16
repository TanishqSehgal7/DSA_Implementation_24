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
	
	public static void deleteAtHead() {
		
		if(head == null) {
			System.out.println("Cannot Delete! List is Empty");
			return;
		} else if(head.next == null) {
			head = null;
			return;
		} else {
			head = head.next;
		}
	}
	
	public static void deleteAtEnd() {
		Node temp = head;
		if(head == null) {
			System.out.println("Cannot Delete! List is Empty");
			return;
		} else if(head.next == null) {
			head = null;
			return;
		} else {
			while(temp.next.next!=null) {
				temp = temp.next;
			}
			temp.next = null;
			return;
		}
	}
	
	public static void deleteAtKthPos(int pos) {
		
		if(head == null) {
			System.out.println("Cannot Delete! List is Empty.");
			return;
		}
		if(head.next == null || pos == 1) {
			deleteAtHead(); 
		}
		
		int length = getLength();
		
		if(pos > length) {
			deleteAtEnd();
		}
		
		int count = 1;
		Node temp = head;
		while(count < pos-1) {
			temp = temp.next;
			count++;
		}
		
		if(count == pos-1) {
			Node nextOfNodeToDelete = temp.next.next;
			temp.next = nextOfNodeToDelete;
			return;
		}
	}
	
	public static void reverseDLL() {
		
		Node previousOfCurr = null;
		Node nextOfCurr = null;
		Node current = head;
		
		while(current!=null) {
			nextOfCurr = current.next;
			previousOfCurr = current.prev;
			current.next = previousOfCurr;
			current.prev = nextOfCurr;
			current = current.prev;
		}
		head = previousOfCurr.prev;
	}
	
	public static void reverseDLL2() {
	    Node previousOfCurr = null;
	    Node nextOfCurr = null;
	    Node current = head;
	    
	    while (current != null) {
	        nextOfCurr = current.next;  // Save next node
	        current.next = current.prev; // Swap next and prev
	        current.prev = nextOfCurr;   // Swap next and prev
	        previousOfCurr = current;    // Update previousOfCurr to current
	        current = nextOfCurr;        // Move to next node (was previously current.next)
	    }
	    
	    if (previousOfCurr != null) {
	        head = previousOfCurr; // Update head to the new front of the list
	    }
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
	
	public static void swapFirstAndLast() {
		
		if(head == null || head.next == null) {
			return;
		}
		
		int temp = head.data;
		head.data = tail.data;
		tail.data = temp;
	}
	
	public static void main(String[] args) {
		
		insertAtHead(10);
		insertAtHead(20);
		insertAtHead(30);
		insertAtHead(40);
		insertAtHead(50);
		printLL();
				
//		insertAtEnd(50);
//		insertAtEnd(40);
//		insertAtEnd(30);
//		insertAtEnd(20);
//		insertAtEnd(10);
//		printLL();
		
//		System.out.println("\n");
//		insertAtKthPosition(60,6);
//		printLL();
//		
//		System.out.println("\n");
//		insertAtKthPosition(5,11);
//		printLL();
//		
//		System.out.println("\n");
//		System.out.println("Length:" + getLength());
//		
//		System.out.println("\n");
//		insertAtKthPosition(5,13);
//		
//		System.out.println("Length:" + getLength());
//		printLL();
//		
//		deleteAtHead();
//		System.out.println("\n");
//		printLL();
//		
//		deleteAtHead();
//		System.out.println("\n");
//		printLL();
//		
//		deleteAtEnd();
//		System.out.println("\n");
//		printLL();
//		
//		deleteAtEnd();
//		System.out.println("\n");
//		printLL();
//		
//		deleteAtKthPos(10);
//		System.out.println("\n");
//		printLL();
//		
//		deleteAtKthPos(5);
//		System.out.println("\n");
//		printLL();
		
		reverseDLL();
		System.out.println("\n");
		printLL();
		
		reverseDLL2();
		System.out.println("\n");
		printLL();
		
		swapFirstAndLast();
		System.out.println("\n\nAfter swapping first and last node...\n");
		printLL();
		
	}
}
