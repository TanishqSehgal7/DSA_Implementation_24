package Trees;

import java.util.Scanner;

import Trees.BinaryTree.Node;

public class CountOfLeafNodes {
	
	static Scanner scn = new Scanner(System.in);
	static Node root;
	static int count = 0;
	
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
	
	public static int countOfLeafNodes(Node root) {
		
		// LNR
		if(root == null) {
			return -1;
		}
		
		countOfLeafNodes(root.left);
		
		if(root.left == null && root.right == null) {
			count++;
		}
		
		countOfLeafNodes(root.right);
		
		return count;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		root = buildTree(root);
		
		CountOfLeafNodes cntLn = new CountOfLeafNodes();
		cntLn.count = countOfLeafNodes(root);
		System.out.println("Number of Leaf Nodes in Tree: " + cntLn.count);
		// 10 20 30 -1 -1 40 50 -1 -1 60 -1 -1
	}

}
