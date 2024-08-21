package BinarySearchTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import BinaryTrees.BinaryTree.Node;

public class BinarySearchTree {
	
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
	
	public static Node takeInput(Node root) {
		
		System.out.println("Enter the data:");
		int data = scn.nextInt();
		
		while(data != -1) {
			root = insertIntoBST(root, data);
			data = scn.nextInt();
		}
		return root;
	}
	
	public static Node insertIntoBST(Node root, int data) {
		
		// base case -> when root is null
		if(root == null) {
			root = new Node(data);
			return root;
		}
		
		if(data > root.data) {
			root.right = insertIntoBST(root.right,data);
		} else if(data < root.data) {
			root.left = insertIntoBST(root.left,data);
		}
		
		return root;
	}
	
	public static Node searchInBST(Node root, int x) {
		
		/*
			recursive solution has o(height) complexity for most case but has o(n) complexity for skew tree
			we can have an iterative solution to have better complexity
		*/
		
		// base case
		if(root == null) {
			return null;
		}
		
		if(root.data == x) {
			return root;
		}
		
		if(x > root.data) {
			return searchInBST(root.right, x);
		} else {
			return searchInBST(root.left, x);
		}
 	}
	
	public static Node searchInBstEfficient(Node root, int x) {
		
		Node temp = root;
		
		while(temp!=null) {
			
			if(x>temp.data) {
				temp = temp.right;
			} else {
				temp = temp.left;
			}
			
			if(temp.data == x) {
				return temp;
			}
		}
		return null;
	}
	
	public static int findMinValueInBST(Node root) {
		
		Node temp = root;
		
		while(temp.left!=null) {
			temp = temp.left;
		}
		
		return temp.data;
	}
	
	public static int findMaxValueInBST(Node root) {
		
		Node temp = root;
		
		while(temp.right!=null) {
			temp = temp.right;
		}
		
		return temp.data;
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
	
	public static void inOrderTraversal(Node root) {
		
		// LNR
		
		if(root == null) {
			return;
		}
		
		inOrderTraversal(root.left);
		
		System.out.print(root.data + " ");
		
		inOrderTraversal(root.right);
		
	}
	
	public static void preOrderTraversal(Node root) {
		
		// NLR
		
		if(root == null) {
			return;
		}
		
		System.out.print(root.data + " ");
		
		preOrderTraversal(root.left);
		
		preOrderTraversal(root.right);
		
	}
	
	public static void postOrderTraversal(Node root) {
		
		// LRN
		
		if(root == null) {
			return;
		}
		
		postOrderTraversal(root.left);
		
		postOrderTraversal(root.right);
		
		System.out.print(root.data + " ");
		
	}
	
	
	public static Node findInOrderSuccessor(Node root, int x) {
		
		// base case
		if(root == null) {
			return null;
		}
		
		Node successor = null;
		Node temp = root;
		
		while(temp!=null) {
			
			System.out.println("Temp is: " + temp.data);
			
			if(x < temp.data) {
				successor = temp;
				temp = temp.left;
			} else {
				temp = temp.right;
			}
		}
		
		if(successor!=null) {
			return successor;
		} else {
			return null;
		}
	}
	
	
	public static Node findInOrderPredecessor(Node root, int x) {
		
		if(root == null) {
			return null;
		}
		
		Node predecessor = null;
		Node temp = root;
		
		while(temp!=null) {
			
			if(x > temp.data) {
				predecessor = temp;
				temp = temp.right;
			} else {
				temp = temp.left;
			}
		}
		
		if(predecessor!=null) {
			return predecessor;
		} else {
			return null;
		}
	}
	
	
	public static Node deleteFromBST(Node root, int x) {
		
		// base case 1 -> root is null
		if(root == null) {
			return root;
		}
		 
		// base case 2 -> root.dat == x
		if(root.data == x) { // implement delete node logic here
			
			// 0 child
			if(root.left == null && root.right == null) {
				root = null;
				return null;
			}
			
			
			if(root.left != null && root.right == null) { // left child only
				
				Node temp = root.left;
				root = null;
				return temp;
				
			} else if(root.right!=null && root.left == null) { // right child only
				
				Node temp = root.right;
				root = null;
				return temp;
				
			} else if(root.right!=null && root.left!=null) {
				
//				Node predecessor = findInOrderPredecessor(root,root.data);
				Node successor = findInOrderSuccessor(root, root.data);
				
				// Copy the successor's data to the root
	            root.data = successor.data;
	            
	            // Delete the successor node from the right subtree
	            root.right = deleteFromBST(root.right, successor.data);
			}
			
			// both left and right child
		} else if(root.data > x) { // traverse in left part in this case
		
			root.left = deleteFromBST(root.left, x);
			
		} else { // traverse in right part in this case
			
			root.right = deleteFromBST(root.right, x);

		}
		return root;
	}
	
	
	public static boolean isBSTValid(Node root, int min, int max) {
		
		// base case
		if(root == null) {
			return true;
		}
		
		if(root.data >=min && root.data<=max) {
			
			boolean leftCall = isBSTValid(root.left, min, root.data);
			boolean rightCall = isBSTValid(root.right, root.data, max);
			return leftCall && rightCall;
		} else {
			return false;
		}
	}
	
	public static int findKthSmallestElement(Node root, int k, int[] cnt) {
		
		// base case 1
		if(root == null) {
			return -1;
		} 
		
		int left = findKthSmallestElement(root.left, k,cnt);
		
		if(left!=-1) {
			return left;
		}
		
		cnt[0]++;
		if(root!=null && cnt[0] == k-1) {
			return root.data;
		}
		
		return findKthSmallestElement(root.right, k, cnt);
	}
	
	
	public static void findSuccessorPredecesor(Node root, int x) {
		
		
		Node temp = root;
		int successor = -1;
		int predecessor = -1;
		
		// find the key and keep saving values of successor and predecessor
		
		while(temp.data!=x) {
			
			if(x > temp.data) {
				successor = temp.data;
				temp = temp.right;
			} else {
				predecessor = temp.data;
				temp = temp.left;
			}			
		}
		
		// after exitting, the above loop temp.data == x and key is found
		
		Node leftTree = temp.left;
		
		// gives predecessor -> maximum value smaller than x
		while(leftTree!=null) {
			predecessor = leftTree.data;
			leftTree = leftTree.right;
		}
		
		System.out.println("Predecessor is: " + predecessor);
		
		
		Node rightTree = temp.right;
		
		// gives successor -> minimum value greater than x
		while(rightTree!=null) {
			successor = rightTree.data;
			rightTree = rightTree.left;
		}
		
		System.out.println("Successor is: " + successor);
		
	}
	
	
	// iterative solution for constant space
	public static Node LCA(Node root, Node a, Node b) {
		
		while(root!=null) {
			
			if(root.data > a.data && root.data > b.data) {
				root = root.left;
			} else if(root.data < a.data && root.data < b.data) {
				root = root.right;
			} else {
				return root;
			}
		}
		return null;
	}
	
	
	public static Node LCA_Recursive(Node root, Node a, Node b) {
		
		// base case
		if(root == null) {
			return root;
		}
		
		if(root.data > a.data && root.data > b.data) { // traverse to left part
			return LCA_Recursive(root.left, a, b);
		}
		
		if(root.data < a.data && root.data < b.data) {
			return LCA_Recursive(root.right, a, b);
		}
		
		return root;
	}
	
	
	public static ArrayList<Integer> twoSumInBST(Node root, ArrayList<Integer> arr) {
		
		
		if(root == null ) {
			return arr;
		}
		
		twoSumInBST(root.left, arr);
		
		arr.add(root.data);

		twoSumInBST(root.right, arr);
		
		return arr;
	}
	
	public static boolean isTwoSumValid(Node root, ArrayList<Integer> arr, int target) {
		
		arr = twoSumInBST(root, arr);
		
		int i = 0; int j = arr.size()-1;
		
		int sum = 0;
		
		while(i<j) {
			
			sum = arr.get(i) + arr.get(j);
			if(sum == target) {
				System.out.println("\n\nSum = Target for -> "+ arr.get(i) + " and " + arr.get(j));
				return true;
			} else if(sum < target) {
				i++;
			} else if(sum > target) {
				j--;
			}
		}
		
		return false;
	}
	
	
	public static ArrayList<Node> savedBstToArrInOrder(Node root, ArrayList<Node> arr) {
		
		
		if(root == null) {
			return arr;
		}
		
		savedBstToArrInOrder(root.left, arr);
		
		arr.add(root);
		
		savedBstToArrInOrder(root.right, arr);
		
		return arr;
	}
	
	public static Node bstToLinkedList(Node root, ArrayList<Node> arr) {
		
		arr = savedBstToArrInOrder(root, arr);
		
		for(int i=0;i<arr.size()-1;i++) {
			
			arr.get(i).left = null;
			arr.get(i).right = arr.get(i+1);
		}
		
		arr.get(arr.size()-1).left = null;
		arr.get(arr.size()-1).right = null;
		
		return arr.get(0);
	}
	
	public static void main(String args[]) {
		
		// 21 10 50 5 15 40 60 55 70 -1
		// 100 50 110 25 70 120 60 115 -1
		// 100 200 110 25 70 120 60 115 -1
		// 5 4 8 2 6 10 3 7 -1
		// 50 30 60 20 40 70 80 -1
		
		root = takeInput(root);
		levelOrderTraversal(root);
		
		System.out.println("\n\nInOrder:\n");
		inOrderTraversal(root);
		
		System.out.println("\n\nPreOrder:\n");
		preOrderTraversal(root);
		
		System.out.println("\n\nPostOrder:\n");
		postOrderTraversal(root);
		
		System.out.println("\n"+searchInBST(root,80));
		System.out.println("\n" + searchInBstEfficient(root,80));
		
		System.out.println("\nMin Value: " + findMinValueInBST(root));
		System.out.println("\nMax Value: " + findMaxValueInBST(root));
		
		int x = 50;
		System.out.println("\nIn Order successor of " + x + " is: " + findInOrderSuccessor(root,x).data);
		System.out.println("\nIn Order predecessor of " + x + " is: " + findInOrderPredecessor(root,x).data);
		
		root = deleteFromBST(root,x);
		levelOrderTraversal(root);
		
		System.out.println(isBSTValid(root,Integer.MIN_VALUE, Integer.MAX_VALUE));
		int [] cnt = {0};
		int kthSmallestInBST = findKthSmallestElement(root,3,cnt);
		System.out.println("\nKth Smallest Element in BST is: " + kthSmallestInBST);
		
		System.out.println("\n");
		
		findSuccessorPredecesor(root,40);
		
		Node a = searchInBstEfficient(root, 60);
		Node b = searchInBstEfficient(root, 20);
		
		System.out.println("\nLCA Iterative: " + LCA(root,a,b).data);
		
		System.out.println("\nLCA Recursive: " + LCA_Recursive(root,a,b).data);
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		System.out.println(isTwoSumValid(root, arr, 20));
		
		ArrayList<Node> nodeList = new ArrayList<Node>();
		Node head  = bstToLinkedList(root, nodeList);
		
		System.out.println("\n");
		
		while(head!=null) {
			System.out.print(head.data + " ");
			head = head.right;
		}
	}
	
}