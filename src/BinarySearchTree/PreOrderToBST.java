package BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

import BinarySearchTree.BinarySearchTree.Node;

public class PreOrderToBST {
	
	
	static Node root;
	
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
	
	
	public static Node solve(int[] preOrder, int min, int max, int[] i) {
		
		
		// base case 1
		if(i[0] >= preOrder.length) {
			return null;
		}
		
		// base case 2
		if(preOrder[i[0]] < min || preOrder[i[0]] > max) {
			return null;
		}
		
		// make new Node
		Node root = new Node(preOrder[i[0]]);
		
		// increment index
		i[0]++;
		
		root.left = solve(preOrder, min, root.data, i);
		root.right = solve(preOrder, root.data, max, i);
		
		return root;
	}
	
	
	public static Node constructBST_FromPreOrder(int[] preOrder) {
		
		int[] i = new int[1];
		i[0] = 0;
		int min = Integer.MIN_VALUE;
		int max = Integer.MAX_VALUE;
		
		return solve(preOrder, min, max, i);
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] preOrder = {20, 10, 5, 15, 13, 35, 30, 42};
		
		Node newNode = constructBST_FromPreOrder(preOrder);
		
		levelOrderTraversal(newNode);
	}

}
