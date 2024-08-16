package BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinarySearchTree {
	
	static Node root;
	
	static Scanner scn = new Scanner(System.in);
	
	public static class Node {
		
		int data;
		Node left;
		Node right;
		
		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	
	public static Node takeInput(Node root) {
		
		System.out.println("Enter the data:");
		int data = scn.nextInt();
		
		while(data != -1) {
			root = insertIntoBST(root, data);
			data = scn.nextInt();
		}
		return root;
	}
	
	public static Node insertIntoBST(Node root, int data) {
		
		// base case -> when root is null
		if(root == null) {
			root = new Node(data);
			return root;
		}
		
		if(data > root.data) {
			root.right = insertIntoBST(root.right,data);
		} else if(data < root.data) {
			root.left = insertIntoBST(root.left,data);
		}
		
		return root;
	}
	
	
	public static void levelOrderTraversal(Node root) {
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		queue.add(null);
		
		if(root == null) {
			return;
		}
		
		while(!queue.isEmpty()) {
			
			Node front = queue.poll();
			
			if(front == null) {
				System.out.println();
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
	
	public static void main(String args[]) {
		root = takeInput(root);
		levelOrderTraversal(root);
	}
	
}