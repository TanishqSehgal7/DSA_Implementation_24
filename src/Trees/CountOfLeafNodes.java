package Trees;

import java.util.Scanner;

import Trees.BinaryTree.Node;

public class CountOfLeafNodes {
	
	static Scanner scn = new Scanner(System.in);
	static Node root;
	static int count = 0;
	static int height = 0;
	static int width = 0;
	static int ans[];
	
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
	
	
	public static int calculateTreeHeight(Node root) {
		
		if(root == null) {
			return 0;
		}
		
		int leftSubTreeHeight = calculateTreeHeight(root.left);
		int rightSubTreeHeight = calculateTreeHeight(root.right);
		
		int ans = Math.max(leftSubTreeHeight, rightSubTreeHeight) + 1;
		
		return ans;
		
	}
	
	public static int calculateTreeWidth(Node root) { // O(N^2) SOLUTION -> NOT EFFICIENT
		
		if(root == null) {
			return 0;
		}
				
		int leftSubTreeOnly = calculateTreeWidth(root.left);
		int rightSubTreeOnly = calculateTreeWidth(root.left);
		int leftAndRightBoth = calculateTreeHeight(root.left) + calculateTreeHeight(root.right) + 1;
		
		int ans = Math.max(leftAndRightBoth, Math.max(leftSubTreeOnly, rightSubTreeOnly));
		
		return ans;
	}
	
	
	public static int[] calculateTreeWidthEfficient(Node root) { // O(N) approach
		
		if(root == null) {
			int baseCaseResult[] = new int[2];
			baseCaseResult[0] = 0; // store height at 0th index
			baseCaseResult[1] = 0; // store width at 1st index
			return baseCaseResult;
		}
		
		int leftSubTreeCall[] = calculateTreeWidthEfficient(root.left);
		int rightSubTreeCall[] = calculateTreeWidthEfficient(root.right);
		
		int leftSubTreeAns = leftSubTreeCall[0];
		int rightSubTreeAns = rightSubTreeCall[0];
		int leftRightcombinationAns = leftSubTreeCall[1] +  rightSubTreeCall[1] + 1;
		
		int ans[] = new int[2]; 		
		ans[1] = Math.max(leftRightcombinationAns, Math.max(leftSubTreeAns, rightSubTreeAns));
		ans[0] = Math.max(leftSubTreeAns, rightSubTreeAns) +1;
		return ans;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		root = buildTree(root);
		
		CountOfLeafNodes cntLn = new CountOfLeafNodes();
		cntLn.count = countOfLeafNodes(root);
		System.out.println("Number of Leaf Nodes in Tree: " + cntLn.count);
		// 10 20 30 -1 -1 40 -1 -1 50 60 -1 -1 70 -1 -1
		// 10 20 30 -1 -1 40 -1 -1 50 -1 -1
		
		cntLn.height = calculateTreeHeight(root);
		System.out.println("Height of Tree is: " + cntLn.height);
		
		cntLn.width = calculateTreeWidth(root);
		System.out.println("Width/Diameter of Tree is: " + cntLn.width);
		
		cntLn.ans = new int[2];
		cntLn.ans = calculateTreeWidthEfficient(root);
		System.out.println("Width of Tree is: " + cntLn.ans[0]);
	}

}
