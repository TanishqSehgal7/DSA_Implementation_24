package BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BinaryTree {
	
	static Scanner scn = new Scanner(System.in);
	static Node root;
	
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
	
	public static Node buildTree(Node root) {
		
		System.out.println("Enter data:\n");
		int data = scn.nextInt();
		
		root = new Node(data);
		
		// base case if data == -1
		if(data == -1) {
			return null;
		}
		
		System.out.println("Enter data for inserting in left:\n");
		root.left = buildTree(root.left);
		System.out.println("Enter data for inserting in right:\n");
		root.right = buildTree(root.right);
		
		return root; 
	}
	
	
	public static void levelOrderTraversal(Node root) {
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			Node temp = queue.peek();
			System.out.print(temp.data + " ");
			queue.remove();
			
			if(temp.left!=null) {
				queue.add(temp.left);
			}
			
			if(temp.right!=null) {
				queue.add(temp.right);
			}
		}
	}
	
	
	public static void levelOrderTrasversalWithSeparator(Node root) {
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		queue.add(null);
		
		while(!queue.isEmpty()) {
			
			Node temp = queue.peek();
			queue.remove();
			
			// temp == null represents that a particular level has been printed
			if(temp == null) {
				System.out.println();
				
				// add separator if the queue is still not empty
				if(!queue.isEmpty()) {
					queue.add(null);
				}
				
			} else {
				
				System.out.print(" " + temp.data);
				
				// check for left node
				if(temp.left!=null) {
					queue.add(temp.left);
				} 
				if(temp.right!=null) {
					queue.add(temp.right);
				}
			}
		}
	}
	
	public static void reverLevelOrderTraversal(Node root) {
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		queue.add(null);
		
		Stack<Node> stack = new Stack<Node>();
		
		while(!queue.isEmpty()) {
			
			Node temp = queue.peek();
			queue.remove();
			stack.push(temp);
			
			if(temp == null) {
				
				if(!queue.isEmpty()) {
					queue.add(null);
				}
				
			} else {
				
				if(temp.left!=null) {
					queue.add(temp.left);
				}
				
				if(temp.right!=null) {
					queue.add(temp.right);
				}
			}
		}
		
		while(!stack.isEmpty()) {
			Node temp = stack.peek();
			stack.pop();
			if(temp == null) {
				System.out.println();
			} else  {
				System.out.print(" " + temp.data + " ");
			}
		}
	}
	
	public static void inOrderTraversal(Node root) {
		
		// LNR
		
		if(root == null) {
			return;
		}
		
		inOrderTraversal(root.left);
		
		System.out.print(root.data + " ");
		
		inOrderTraversal(root.right);
		
	}
	
	public static void preOrderTraversal(Node root) {
		
		// NLR
		
		if(root == null) {
			return;
		}
		
		System.out.print(root.data + " ");
		
		preOrderTraversal(root.left);
		
		preOrderTraversal(root.right);
		
	}
	
	public static void postOrderTraversal(Node root) {
		
		// LRN
		
		if(root == null) {
			return;
		}
		
		postOrderTraversal(root.left);
		
		postOrderTraversal(root.right);
		
		System.out.print(root.data + " ");
		
	}
	
	
	public static Node buildTreeFromLevelOrder(Node root) {
		
		
		Queue<Node> queue = new LinkedList<Node>();
		System.out.println("Enter data for root:\n");
		int rootData = scn.nextInt();
		root = new Node(rootData);
		queue.add(root);
		
		while(!queue.isEmpty()) {
			
			Node temp = queue.peek();
			queue.remove();
			
			System.out.println("Enter data for left of " + temp.data);
			int leftData = scn.nextInt();
			
			if(leftData!=-1) {
				temp.left = new Node(leftData);
				queue.add(temp.left);
			}
			
			System.out.println("Enter data for right of " + temp.data);
			int rightData = scn.nextInt();
			
			if(rightData!=-1) {
				temp.right = new Node(rightData);
				queue.add(temp.right);
			}
		}
		
		return root;
	}
	
	
	public static void main(String[] args) {
		
//		root = buildTree(root);  
//		System.out.println("\nLevel Order Traversal Without Separator:\n");

		levelOrderTraversal(root);
		// 10 20 30 40 50 60 70 -1 -1 -1 -1 -1 -1 -1 -1 
		root = buildTreeFromLevelOrder(root);
		
		System.out.println("\nLevel Order Traversal With Separator:\n");
		levelOrderTrasversalWithSeparator(root);
		
		System.out.println("\n");
		
//		System.out.println("\nReverse Level Order Traversal:\n");
//		reverLevelOrderTraversal(root);
		
//		System.out.println("\nInOrder Traversal:\n");
//		inOrderTraversal(root);
//		System.out.println("\n");
		
//		System.out.println("\nPreOrder Traversal:\n");
//		preOrderTraversal(root);
//		System.out.println("\n");
		
//		System.out.println("\nPostOrder Traversal:\n");
//		postOrderTraversal(root);
//		System.out.println("\n");
	}
}
