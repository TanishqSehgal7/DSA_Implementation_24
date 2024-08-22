package BinarySearchTree;

import java.util.*;

public class NormalBstToBalanced {

	static Node root;
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
				System.out.println("");
				if(!queue.isEmpty()) {
					queue.add(null);
				}
			} else {
				
				System.out.print(front.data + " ");
				
				if(front.left!=null) {
					queue.add(front.left);
				} 
				
				if(front.right!=null) {
					queue.add(front.right);
				}
			}
		}
	}
	
	public static ArrayList<Integer> saveBstToArrWithInOrder(Node root, ArrayList<Integer> arr) {
		
		
		if(root == null) {
			return arr;
		}
		
		saveBstToArrWithInOrder(root.left, arr);
		
		arr.add(root.data);
		
		saveBstToArrWithInOrder(root.right,arr);
		
		return arr;
		
	}
	
	public static Node bstToBalancedBst(Node root) {
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr = saveBstToArrWithInOrder(root, arr);
		
		return inOrderToBalancedBST(0, arr.size()-1, arr);
	}
	
	public static Node inOrderToBalancedBST(int start, int end, ArrayList<Integer> arr) {
		
		// base case
		if(start > end) {
			return null;
		}
		
		// find mid
		int mid = (start+end)/2;
		
		// make new node with mid
		Node root = new Node(arr.get(mid));
		
		root.left = inOrderToBalancedBST(start, mid-1, arr);
		root.right = inOrderToBalancedBST(mid+1, end, arr);
		
		return root;
	}
	
	public static void main(String[] args) {
		
		
		// 50 30 60 20 40 70 80 -1
		
		root = takeInput(root);
		
		levelOrderTraversal(root);
		
		System.out.println("\n");
		
		root = bstToBalancedBst(root);
		
		levelOrderTraversal(root);
	}

}
