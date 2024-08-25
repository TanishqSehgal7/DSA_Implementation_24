package BinarySearchTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class MergeTwoBstApproach2 {

	
	static Node root1;
	static Node root2;
	static Node root3;
	static Node head1;
	static Node head2;
	
	static Scanner scn = new Scanner(System.in);
	
	public static class Node {
		
		Node left;
		Node right;
		
		int data;
		
		public Node(int data) {
			
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	public static Node takeInput(Node root) {
		
		System.out.println("Enter data:\n");
		int data = scn.nextInt();
		
		while(data!=-1) {
			root = insertIntoBST(root, data);
			data = scn.nextInt();
		}
		
		return root;
	}
	
	
	public static Node insertIntoBST(Node root, int data) {
		
		if(root == null) {
			root = new Node(data);
			return root;
		}
		
		if(data > root.data) {
			root.right = insertIntoBST(root.right, data);
		} else if(data < root.data) {
			root.left = insertIntoBST(root.left, data);
		}
		
		return root;
	}
	
	public static void levelOrderTraversal(Node root) {
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		queue.add(null);
		
		while(!queue.isEmpty()) {
			
			Node front = queue.poll();
			
			if(front == null) {
				
				System.out.println();
				
				if(!queue.isEmpty()) {
					queue.add(null);
				}
				
			} else {
				
				System.out.print(front.data + " ");
				
				if(front.left != null) {
					queue.add(front.left);
				} 
				
				if(front.right!=null) {
					queue.add(front.right);
				}
				
			}
		}
		
	}
	
	public static ArrayList<Node> saveInOrderToArrayList(Node root, ArrayList<Node> arr) {
		
		if(root == null) {
			return arr;
		}
		
		saveInOrderToArrayList(root.left, arr);
		arr.add(root);
		saveInOrderToArrayList(root.right, arr);
		
		return arr;
	}
	
	
	public static Node converBstInOrderToSortedLL(Node root, ArrayList<Node> arr) {
		
		arr = saveInOrderToArrayList(root, arr);
		
		for(int i = 0; i< arr.size()-1; i++) {
			
			// convert to singly LL
			arr.get(i).left = null;
			arr.get(i).right = arr.get(i+1);
		}
		
		arr.get(arr.size()-1).left = null;
		arr.get(arr.size()-1).right = null;
		
		return arr.get(0);
	}
	
	
	public static Node mergeTwoSortedLL(Node head1, Node head2) {
		
		Node head3 = null;
		Node temp3 = null;
		
		while(head1!=null && head2!=null) {
			
			if(head1.data < head2.data) {
				
				if(head3 == null) {
					head3 = head1;
					temp3 = head3;
				} else {
					temp3.right = head1;
					temp3 = temp3.right;
				}
				
				head1 = head1.right;
				
			} else if(head2.data < head1.data) {
				
				if(head3 == null) {
					head3 = head2;
					temp3 = head3;
				} else {
					temp3.right = head2;
					temp3 = temp3.right;
				}
				
				head2 = head2.right;
			}
		}
		
		while(head1!=null) {
			temp3.right = head1;
			head1 = head1.right;
			temp3 = temp3.right;
		}
		
		while(head2!=null) {
			temp3.right = head2;
			head2 = head2.right;
			temp3 = temp3.right;
		}
			
		return head3;
	}
	
	public static Node makeBstFromSortedLinkedList(Node start, Node end) {
        if (start == end) {
            return null;
        }

        Node slow = start;
        Node fast = start;

        // Find the middle node
        while (fast != end && fast.right != end) {
            slow = slow.right;
            fast = fast.right.right;
        }

        Node root = new Node(slow.data);

        root.left = makeBstFromSortedLinkedList(start, slow);
        root.right = makeBstFromSortedLinkedList(slow.right, end);

        return root;
    }
	
	
	public static void main(String[] args) {
		
		root1 = takeInput(root1);
		root2 = takeInput(root2);
		
		// 50 40 60 70 -1
		// 55 45 65 35 47 -1
		
		ArrayList<Node> ar1 = new ArrayList<Node>();
		ArrayList<Node> ar2 = new ArrayList<Node>();
		
		head1 = converBstInOrderToSortedLL(root1, ar1);
		head2 = converBstInOrderToSortedLL(root2, ar2);
		
		Node t1 = head1;
		Node t2 = head2;
		
		System.out.println("\nLinkedList1:\n");
		while(t1!=null) {
			System.out.print(t1.data + " ");
			t1 = t1.right;
		}
		
		System.out.println("\n\nLinkedList2:\n");
		while(t2!=null) {
			System.out.print(t2.data + " ");
			t2 = t2.right;
		}
		
		System.out.println();
		
		Node head3 = mergeTwoSortedLL(head1, head2);
		Node tail = head3;
		
		System.out.println("\nMerged Sorted LinkedList:\n");
		
		while(tail!=null) {
			System.out.print(tail.data + " ");
			tail = tail.right;
		}
		
		System.out.println("\n\nFinal BST is:\n");
		
		Node finalBst = makeBstFromSortedLinkedList(head3,null);
		
		levelOrderTraversal(finalBst);
		
	}
	
//	50 
//	45 65 
//	40 47 60 70 
//	35 55 
}
