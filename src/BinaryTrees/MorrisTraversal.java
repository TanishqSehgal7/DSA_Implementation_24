package BinaryTrees;

import java.util.ArrayList;
import java.util.Scanner;

import BinaryTrees.BinaryTree.Node;

public class MorrisTraversal {
	
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
	
	public static Node buildTree(Node root) {
	
		System.out.println("Enter data:\n");
		int data = scn.nextInt();
		
		root = new Node(data);
		
		// base case if data == -1
		if(data == -1) {
			return null;
		}
		
		System.out.println("Enter data for inserting in left of " + root.data);
		root.left = buildTree(root.left);
		
		System.out.println("Enter data for inserting in right of " + root.data);
		root.right = buildTree(root.right);
		
		return root; 
	}
	
	public static Node findPredecessor(Node node) {
		
		// move once towards left and then keep moving towards right till node.right becomes null
		
		Node predecessor = node.left;
		
		while(predecessor.right!=null && predecessor.right!=node) {
			predecessor = predecessor.right;
		}
		
		return predecessor;
	}
	
	
	public static void morrisTraversal(Node root) {
		
		Node current = root;
		Node predecessor = null;
	
		while(current!=null) {
			
			// check if left of current is null, print the node and send current to left
			if(current.left == null) {

				System.out.print(current.data + " ");
				current = current.right;
	
			} else { // in this case left exists, so we find predecessor
				
				predecessor = findPredecessor(current);
				// check if predecessor.right is null? if yes then point predecessor.right = current and move current to its left
				
				if(predecessor.right == null) { 
					
					// this step is for making temporary link to parent of predecessor
					
					predecessor.right = current;
					current = current.left;
				
				} else { 
					
					// print the current node and remove the temporary link here and move current to right
					
					predecessor.right = null;
					System.out.print(current.data + " ");
					current = current.right;
				
				}
			}
		}
	}
	
	
	public static Node flattenABinaryTree(Node root) {
		
		Node current = root;
		Node prev = null;
		
		while(current!=null) {
			
			// check if left part exists
			if(root.left!=null) {
				
				prev = current.left;
				
				while(prev.right!=null) { // find the predecessor node
					prev = prev.right; 
				}
				
				prev.right = current.right; // attach predecessor.right = current.right
				current.right = current.left;
				current.left = null;
			}
			current = current.right; // move further to new value of current
		}
		
		return root;
	}
	
	
	public static void printTree(Node root) {
		
		if(root == null) {
			return;
		}
		
		System.out.print(root.data + " ");
		printTree(root.left);
		printTree(root.right);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		root = buildTree(root);
		// 1 2 4 -1 7 -1 -1 5 -1 -1 3 -1 6 -1 -1
		// 1 2 3 -1 -1 4 -1 -1 5 -1 6 -1 -1
		
		morrisTraversal(root);
		
		root = flattenABinaryTree(root);
		
		System.out.println("\n\nFlattened Binary Tree\n");
		printTree(root);
	}
}
