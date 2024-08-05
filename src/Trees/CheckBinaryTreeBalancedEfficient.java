package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import Trees.CountOfLeafNodes.Node;

public class CheckBinaryTreeBalancedEfficient {
	
	static Scanner scn = new Scanner(System.in);
	static Node root;
	
	static int leftHeight;
	static int rightHeight;
	
	public static class MyResultContainer {
		
		private static boolean isBalanced;
		private static int height;
		
		public MyResultContainer(boolean isBalanced, int height) {
			this.isBalanced = isBalanced;
			this.height = height;
		}
		
		MyResultContainer() {
            // Default constructor
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
				
				System.out.print(temp.data + " ");
				
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
	
	
	public static MyResultContainer isBalanced(Node root) {
		
		// base case
		if(root == null) {
			MyResultContainer mrc = new MyResultContainer();
			mrc.isBalanced = true;
			mrc.height = 0;
			return mrc;
		}
		
		MyResultContainer left = isBalanced(root.left);
		MyResultContainer right = isBalanced(root.right);
		
		boolean leftSideBalanced = left.isBalanced;
		boolean rightSideBalanced = right.isBalanced;
		
		leftHeight = left.height;
		rightHeight = right.height;
		
		MyResultContainer ans = new MyResultContainer();
		
		ans.height = (Math.max(leftHeight, rightHeight)+1);
				
		boolean diff = Math.abs(leftHeight - rightHeight) <= 1;
		 
		if(leftSideBalanced && rightSideBalanced && diff) {
			ans.isBalanced = true;
		} else {
			ans.isBalanced = false;
		}
		
		return ans;
	}
	
	public static MyResultContainer isBalanced2(Node root) {
	    if (root == null) {
	        return new MyResultContainer(true, 0);
	    }

	    MyResultContainer left = isBalanced(root.left);
	    MyResultContainer right = isBalanced(root.right);

//	    MyResultContainer result = new MyResultContainer(true,0);
	    boolean isBalanced = left.isBalanced && right.isBalanced && Math.abs(left.height - right.height) <= 1;
        int height = Math.max(left.height, right.height) + 1;
        
	    return new MyResultContainer(isBalanced, height);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		root = buildTree(root);
		
		// 1 2 4 -1 -1 5 6 -1 -1 -1 3 -1 -1
		
		levelOrderTrasversalWithSeparator(root);
		
		System.out.println("Is Tree Balanced? " + isBalanced(root).isBalanced);
	}

}
