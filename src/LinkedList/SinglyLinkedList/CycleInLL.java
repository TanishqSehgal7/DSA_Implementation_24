package LinkedList.SinglyLinkedList;

public class CycleInLL {

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
	
	public static void insertAtHead(int data) {
		Node newNode = new Node(data);
		if(head == null) {
			head = newNode;
			tail = newNode;
			return;
		}
		newNode.next = head;
		head = newNode;
	}
	
	public static void makeIntersectionPoint(int d) {
		
		if(head == null) {
			return;
		} else {
			Node current = head;
			while(current.data!=d) {
				current = current.next;
			}
			
			if(current.data == d) {
				tail.next = current;
			}
		}
	}
	
	public static boolean doesCycleExist() {
		
		Node slow = head;
		Node fast = head;
		
		while(fast!=null && fast.next.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
			
			if(slow == fast) {
				return true;
			}
		}
		
		return false;
	}
	
	public static Node findCyclePoint() {
		
		Node slow = head;
		Node fast = head;
		
		while(fast!=null && fast.next.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
			
			if(slow == fast) {
				slow = head;
				break;
			}
		}
		
		while(slow!=fast) {
			slow = slow.next;
			fast = fast.next;
			if(slow == fast) {
				return slow;
			}
 		}
		return null;
	}
	
	
	
	public static void printLL() {
		Node current = head;
		do {
			System.out.print(current.data + " ");
			current = current.next;
		} while(current!=tail.next);
		
	}
	
	public static void main(String[] args) {
		
		insertAtHead(60);
		insertAtHead(50);
		insertAtHead(40);
		insertAtHead(30);
		insertAtHead(20);
		insertAtHead(10);
		printLL();
		
		System.out.println("\n");
		makeIntersectionPoint(30);
		printLL();
		
		System.out.println("Tail.next = " + tail.next.data);
		
		if(doesCycleExist()) {
			System.out.println("List contains a Cycle");
		} else {
			System.out.println("List does not contain a cycle");
		}
		System.out.println("Point at which cycle starts: " + findCyclePoint().data);
	}
	
	

}
