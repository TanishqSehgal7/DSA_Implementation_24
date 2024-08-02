package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

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
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		root = buildTree(root);  
		levelOrderTraversal(root);
	}

}
