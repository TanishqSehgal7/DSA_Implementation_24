package LinkedList.SinglyLinkedList;

public class SinglyLL {
	
	static Node head = null;
	
	public static class Node {
		int data;
		Node next;
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	public static void insertAtHead(int data) {
		Node newNode = new Node(data);
		if(head == null) {
			head = newNode;
			return;
		}
		newNode.next = head;
		head = newNode;
	}
	
	public static void printSLL() {
		Node temp = head;
		while(temp!=null) {
			System.out.print(temp.data + " -> ");
			temp = temp.next;
		}
		if(temp == null) {
			System.out.print("NULL");
		}
	}
	
	public static void insertAtEnd(int data) {
		Node newNode = new Node(data);
		Node temp = head;
		if(head == null) {
			head = newNode;
			return;
		}
		while(temp.next!=null) {
			temp = temp.next;
		}
		if(temp.next == null) {
			temp.next = newNode;
			newNode.next = null;
		}
	}
	
	public static int getLLSize() {
		int length = 0;
		Node temp = head;
		while(temp!=null) {
			temp = temp.next;
			length++;
		}
		return length;
	}
	
	public static void insertAtKthPos(int data, int pos) {
		if(head == null || pos == 1) {
			insertAtHead(data);
		}
		if(pos >= getLLSize()) {
			insertAtEnd(data);
		}
		int count = 1;
		Node temp = head;
		Node newNode = new Node(data);
		while(count < pos-1) {
			temp = temp.next;
			count++;
		}
		Node next = null;
		if(count == pos-1) {
			next = temp.next;
			temp.next = newNode;
			newNode.next = next;
		}
	}
	
	public static void deleteAtHead() {
		if(head == null) {
			System.out.println("List is Empty! Cannot delete.");
			return;
		}
		Node temp = head.next;
		head.next = null;
		head = temp;
	}
	
	public static void deleteAtEnd() {
		Node temp = head;
		if(head == null) {
			System.out.println("List is Empty! Cannot delete.");
			return;
		}
		while(temp.next.next!=null) {
			temp = temp.next;
		}
		if(temp.next.next == null) {
			temp.next = null;
		}
	}
	
	public static void deleteAtKthPos(int pos) {
		
		int len = getLLSize();
		
		if(head == null) {
			System.out.println("List is Empty! Cannot delete.");
			return;
		}
		
		if(pos == 1) {
			deleteAtHead();
			return;
		} 
		else if(head == null) {
			System.out.println("Can't Delete From Empty List!");
			return;
		}
		else if(pos>len) {
			deleteAtEnd();
			return;
		}
		
		Node temp = head;
		int count = 1;
		Node nextOfNodeToDelete = null;
		while(count<pos-1) {
			temp = temp.next;
			count++;
		}
		nextOfNodeToDelete = temp.next.next;
		temp.next = nextOfNodeToDelete;
	}
	
	public static void reverseSinglyLL() {
		Node prev = null;
		Node nextNode = null;
		Node current = head;
		
		while(current!=null) {
			nextNode = current.next;
			current.next = prev;
			prev = current;
			current = nextNode;
		}
		head = prev;
	}

	public static void main(String[] args) {
		
		insertAtHead(10);
		insertAtHead(20);
		insertAtHead(30);
		printSLL();
		
		insertAtEnd(5);
		System.out.println("\n");
		printSLL();
		
		insertAtKthPos(25,2);
		System.out.println("\n");
		printSLL();
		
		insertAtKthPos(15,4);
		System.out.println("\n");
		printSLL();
		
		reverseSinglyLL();
		System.out.println("\n\nReversed Singly LL is:");
		printSLL();
		
		deleteAtHead();
		System.out.println("\n");
		printSLL();
		
		deleteAtEnd();
		System.out.println("\n");
		printSLL();
		
		deleteAtKthPos(3);
		System.out.println("\n");
		printSLL();
	}

}
