package Trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import Trees.BinaryTree.Node;


public class MinimumTimeToBurnATree {
	
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
	
	
	public static Node createParentMapping(Node root, int target, HashMap<Node,Node> nodeToParent) {
		
		Node result = null;
		
		Queue<Node> queue = new LinkedList<>();
		
		queue.add(root);
		nodeToParent.put(root, null);
		
		while(!queue.isEmpty()) {
			
			Node front = queue.poll();
			
			if(front.data == target) {
				result = front;
			}
			
			if(front.left!=null) {
				nodeToParent.put(front.left, front);
				queue.add(front.left);
			}
			
			if(front.right!=null) {
				nodeToParent.put(front.right, front);
				queue.add(front.right);
			}
		}
		
	}
	
	
	public static void burnTree(Node targetNode, HashMap<Node,Node> nodeToParent) {
		
		
	}
	
	
	public static int minimumTimeToBurnTree(Node root, int target) {
		
		/*
			Step1: Create nodeToParent mapping
			Step2: Find Target Node
			Step3: Burn the tree in min time
		*/
		
		int minTime = 0;
		HashMap<Node,Node> nodeToParent = new HashMap<>();
		Node targetNode = createParentMapping(root, target, nodeToParent);
		burnTree(targetNode,nodeToParent);
	}
	

	public static void main(String[] args) {
		
		

	}

}
