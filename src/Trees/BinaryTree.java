package Trees;

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
			
			if(temp == null) {
				
				stack.push(temp);
				
				if(!queue.isEmpty()) {
					queue.add(null);
				}
				
			} else {
				
				stack.push(temp);
				
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
			} else {
				System.out.print(" " + temp.data + " ");
			}
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		root = buildTree(root);  
		levelOrderTraversal(root);
		
		System.out.println("\n");
		
		levelOrderTrasversalWithSeparator(root);
		
		System.out.println("\n");
		
		reverLevelOrderTraversal(root);
	}

}
