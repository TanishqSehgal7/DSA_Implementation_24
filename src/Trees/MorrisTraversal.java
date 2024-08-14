package Trees;

import java.util.Scanner;

import Trees.BinaryTree.Node;

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
		
		System.out.println("Enter data for inserting in left:\n");
		root.left = buildTree(root.left);
		System.out.println("Enter data for inserting in right:\n");
		root.right = buildTree(root.right);
		
		return root; 
	}
	
	public static Node findPredecessor(Node node) {
		
		// move once towards left and then keep moving towards right till node.right becomes null
		
		node = node.left;
		
		while(node.right!=null) {
			node = node.right;
		}
		
		return node;
	}
	
	
	public static void morrisTraversal(Node root) {
		
		Node current = root;
	
		while(current!=null) {
			
			// check if left of current is null, print the node and send current to left
			if(current.left == null && current.right!=null) {
				
				System.out.print(current.data + " ");
				current = current.right;
			
			} else { // in this case left exists, so we find predecessor
				
				Node predecessor = findPredecessor(current);
				// check if predecessor.right is null? if yes then point predecessor.right = current and move current to its left
				if(predecessor.right == null) { // this step is for making temporary link to parent of predecessor
					predecessor.right = current;
					current = current.left;
				} else { // print the current node and remove the temporary link here and move current to right
					predecessor.right = null;
					System.out.print(current.data + " ");
					current = current.right;
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		root = buildTree(root);
		// 1 2 4 -1 7 -1 -1 5 -1 -1 3 -1 6 -1 -1
		morrisTraversal(root);

	}

}
