package Trees;

import java.util.Scanner;

import Trees.CountOfLeafNodes.Node;

public class CheckBinaryTreeBalancedEfficient {
	
	static Scanner scn = new Scanner(System.in);
	static Node root;
	
	public static class MyResultContainer {
		
		private static boolean isBalanced;
		private static int height;
		
		public MyResultContainer() {
			this.isBalanced = false;
			this.height = 0;
		}

		public static boolean isBalanced() {
			return isBalanced;
		}

		public static void setBalanced(boolean isBalanced) {
			MyResultContainer.isBalanced = isBalanced;
		}

		public static int getHeight() {
			return height;
		}

		public static void setHeight(int height) {
			MyResultContainer.height = height;
		}
	}
	
	
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
	
	
	public static MyResultContainer isBalanced(Node root) {
		
		// base case
		if(root == null) {
			MyResultContainer mrc = new MyResultContainer();
			mrc.setBalanced(true);
			mrc.setHeight(0);
			return mrc;
		}
		
		MyResultContainer left = isBalanced(root.left);
		MyResultContainer right = isBalanced(root.right);
		
		boolean leftSideBalanced = left.isBalanced();
		boolean rightSideBalanced = right.isBalanced();
		
		int leftHeight = left.getHeight();
		int rightHeight = right.getHeight();
		
		boolean diff = Math.abs(leftHeight - rightHeight) <=1;
		
		MyResultContainer ans = new MyResultContainer();
		
		ans.setHeight(Math.max(leftHeight, rightHeight)+1);
		
		if(leftSideBalanced && rightSideBalanced && diff) {
			ans.setBalanced(true);
		} else {
			ans.setBalanced(false);
		}
		
		return ans;
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		root = buildTree(root);
		
		// 1 2 4 -1 -1 5 6 -1 -1 -1 3 -1 -1
		
		System.out.println("Is Tree Balanced? " + isBalanced(root).isBalanced());
	}

}
