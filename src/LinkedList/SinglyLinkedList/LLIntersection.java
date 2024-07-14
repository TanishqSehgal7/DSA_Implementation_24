package LinkedList.SinglyLinkedList;

public class LLIntersection {

	static Node headA = null;
	static Node headB = null;
	static Node commonListHead = null;
	
	public static class Node {
		
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	public static Node insertAtHead(Node headNode, int data) {
		
		Node newNode = new Node(data);
		
		if(headNode == null) {
			headNode = newNode;
			return headNode;
		} else {
			newNode.next = headNode;
			headNode = newNode;
			return headNode;
		}
	}
	
	public static void printLL(Node headNode) {
		
		if(headNode == null) {
			System.out.println("Empty List!");
		} else {
			Node current = headNode;
			
			while(current!=null) {
				if(current.next!=null) {
					System.out.print(current.data + "->");
				} else {
					System.out.print(current.data);
				}
				current = current.next;
			}
		}
	}
	
	public static Node findIntersectionInLL() {
		
		Node a = headA;
		Node b = headB;
		
		while(a!=b) {
			if(a == null) {
				a = headB;
			} else if(b == null) {
				b = headA;
			} else {
				a = a.next;
				b = b.next;
			}
		}
		if(a==b && a!=null && b!=null) {
			return a;
		} else {
			return null;
		}
	}
	
	public static Node findIntersectionInLL2() {
		
		Node a = headA;
		Node b = headB;
		
		while(a!=b) {
			a = a == null ? headB : a.next;
			b = b == null ? headA : b.next;
		}
		
		if(a!=null && b!=null && a == b) {
			return a;
		} else {
			return null;
		}
	}
	
	public static void main(String[] args) {
		
		commonListHead = insertAtHead(commonListHead,60);
		commonListHead = insertAtHead(commonListHead,50);
		commonListHead = insertAtHead(commonListHead,30);
	
		headA = insertAtHead(headA,20);
		headB = insertAtHead(headB,40);
		
		if(headA!=null && headB!=null) {
			headA.next = commonListHead;
			headB.next = commonListHead;
		}
		
		headA = insertAtHead(headA,10);
		
		printLL(headA);
		System.out.println("\n");
		printLL(headB);
		
		System.out.println("\n");
		System.out.println(findIntersectionInLL().data);
		
		System.out.println(findIntersectionInLL2().data);
	}

}
