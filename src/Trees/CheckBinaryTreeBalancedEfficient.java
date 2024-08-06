package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import Trees.CountOfLeafNodes.Node;

public class CheckBinaryTreeBalancedEfficient {
	
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
	
	
	public static Object[] isBalanced(Node root) {
		
		// base case
		if(root == null) {
			Object[] baseResult = new Object[2];
			baseResult[0] = true;
			baseResult[1] = 0;
			return baseResult;
		}
		
		Object[] left = isBalanced(root.left);
		Object[] right = isBalanced(root.right);
		
		boolean leftSideBalanced = (boolean) left[0];
		boolean rightSideBalanced = (boolean) right[0];
		
		int leftHeight = (int) left[1];
		int rightHeight = (int) right[1];
		
		Object[] ans = new Object[2];
		
		ans[0] = (Math.max(leftHeight, rightHeight)+1);
				
		boolean diff = Math.abs(leftHeight - rightHeight) <= 1;
		 
		if(leftSideBalanced && rightSideBalanced && diff) {
			ans[0] = true;
		} else {
			ans[0] = false;
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		root = buildTree(root);
		
		// 1 2 4 -1 -1 5 6 -1 -1 -1 3 -1 -1
		
		levelOrderTrasversalWithSeparator(root);
		
		System.out.println("Is Tree Balanced? " + isBalanced(root)[0]);
	}

}
