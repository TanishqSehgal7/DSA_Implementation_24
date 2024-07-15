package LinkedList.SinglyLinkedList;

import LinkedList.SinglyLinkedList.SinglyLL.Node;

public class PalindromeLL {
	
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
	
	public static Node reverseSinglyLL(Node headNode) {
		Node prev = null;
		Node nextNode = null;
		Node current = headNode;
		
		while(current!=null) {
			nextNode = current.next;
			current.next = prev;
			prev = current;
			current = nextNode;
		}
		headNode = prev;
		return headNode;
	}
	
	
	public static boolean isLLPalindrome() {
		
		if(head.next == null) {
			return true;
		}
		
		// find middleNode
		Node fast = head;
		Node slow = head;
		
		while(fast.next!=null && fast.next.next!=null) {
			slow = slow.next;
			fast = fast.next;
		}
		
		slow = reverseSinglyLL(slow);
		Node dummyHead = head;
		while(slow!=null && (slow.data==dummyHead.data)) {
			dummyHead = dummyHead.next;
			slow = slow.next;
		}
		
		if(slow == null) {
			return true;
		}
		
		return false;
	}

	public static void main(String[] args) {
		
		insertAtHead(5);
		insertAtHead(10);
		insertAtHead(20);
		insertAtHead(20);
		insertAtHead(10);
		insertAtHead(5);
		
		printSLL();
		
		System.out.println(isLLPalindrome());

	}

}
