package BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import BinaryTrees.BinaryTree.Node;

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
	
	public static boolean searchInBST(Node root, int x) {
		
		/*
			recursive solution has o(height) complexity for most case but has o(n) complexity for skew tree
			we can have an iterative solution to have constant complexity
		*/
		
		// base case
		if(root == null) {
			return false;
		}
		
		if(root.data == x) {
			return true;
		}
		
		if(x > root.data) {
			return searchInBST(root.right, x);
		} else {
			return searchInBST(root.left, x);
		}
 	}
	
	
	public static boolean searchInBstEfficient(Node root, int x) {
		
		Node temp = root;
		
		while(temp!=null) {
			
			if(x>temp.data) {
				temp = temp.right;
			} else {
				temp = temp.left;
			}
			
			if(temp.data == x) {
				return true;
			}
		}
		
		return false;
	}
	
	
	public static int findMinValueInBST(Node root) {
		
		Node temp = root;
		
		while(temp.left!=null) {
			temp = temp.left;
		}
		
		return temp.data;
	}
	
	public static int findMaxValueInBST(Node root) {
		
		Node temp = root;
		
		while(temp.right!=null) {
			temp = temp.right;
		}
		
		return temp.data;
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
	
	public static void main(String args[]) {
		
		root = takeInput(root);
		levelOrderTraversal(root);
		
		System.out.println("\n\nInOrder:\n");
		inOrderTraversal(root);
		
		System.out.println("\n\nPreOrder:\n");
		preOrderTraversal(root);
		
		System.out.println("\n\nPostOrder:\n");
		postOrderTraversal(root);
		
		System.out.println("\n"+searchInBST(root,70));
		System.out.println("\n" + searchInBstEfficient(root,70));
		System.out.println("\nMin Value: " + findMinValueInBST(root));
		System.out.println("\nMax Value: " + findMaxValueInBST(root));
	}
	
}