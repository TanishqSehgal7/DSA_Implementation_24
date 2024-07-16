package LinkedList.DoublyLinkedList;

public class PalindromeDLL {
	
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
	
	public static int getLength() {
		Node temp = head;
		int length = 0;
		while(temp!=null) {
			temp = temp.next;
			length++;
		}
		return length;
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
	
	public static boolean isDLL_Palindrome() {
		
		Node fwd = head;
		Node bwd = tail;
		
		int len = getLength();
		
		for(int i=0;i<Math.floor(len/2);i++) {
			
			if(fwd.data!=bwd.data) {
				return false;
			}
			
			fwd = fwd.next;
			bwd = bwd.prev;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		insertAtHead(5);
		insertAtHead(10);
		insertAtHead(20);
		insertAtHead(20);
		insertAtHead(10);
		insertAtHead(5);
		printLL();
		
		System.out.println("\n");
		System.out.println(isDLL_Palindrome());
	}

}
