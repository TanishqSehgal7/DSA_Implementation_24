package BinarySearchTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class MergeTwoBst {

	static Node root1;
	static Node root2;
	static Node root3;
	
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
	
	public static Node takeInput(Node root) {
		
		System.out.println("Enter data:\n");
		int data = scn.nextInt();
		
		while(data!=-1) {
			root = insertIntoBST(root, data);
			data = scn.nextInt();
		}
		
		return root;
	}
	
	
	public static Node insertIntoBST(Node root, int data) {
		
		if(root == null) {
			root = new Node(data);
			return root;
		}
		
		if(data > root.data) {
			root.right = insertIntoBST(root.right, data);
		} else if(data < root.data) {
			root.left = insertIntoBST(root.left, data);
		}
		
		return root;
	}
	
	public static void levelOrderTraversal(Node root) {
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		queue.add(null);
		
		while(!queue.isEmpty()) {
			
			Node front = queue.poll();
			
			if(front == null) {
				
				System.out.println();
				
				if(!queue.isEmpty()) {
					queue.add(null);
				}
				
			} else {
				
				System.out.print(front.data + " ");
				
				if(front.left != null) {
					queue.add(front.left);
				} 
				
				if(front.right!=null) {
					queue.add(front.right);
				}
				
			}
		}
		
	}
	
	
	public static ArrayList<Integer> saveInOrderToArrayList(Node root, ArrayList<Integer> arr) {
		
		if(root == null) {
			return arr;
		}
		
		saveInOrderToArrayList(root.left, arr);
		arr.add(root.data);
		saveInOrderToArrayList(root.right, arr);
		
		return arr;
	}
	
	
	public static ArrayList<Integer> mergeTwoSortedArrayForBst(Node root1, Node root2) {
		
		int i = 0;
		int j = 0;
		
		ArrayList<Integer> ar1 = new ArrayList<Integer>();
		ArrayList<Integer> ar2 = new ArrayList<Integer>();
		
		ar1 = saveInOrderToArrayList (root1, ar1);
		ar2 = saveInOrderToArrayList(root2, ar2);
		
		ArrayList<Integer> ar3 = new ArrayList<Integer>();
		
		while(i < ar1.size() && j < ar2.size()) {
			
			if(ar1.get(i) < ar2.get(j)) {
				ar3.add(ar1.get(i));
				i++;
			} else if(ar2.get(j) < ar1.get(i)) {
				ar3.add(ar2.get(j));
				j++;
			}
		}
		
		while (i < ar1.size()) {
		    ar3.add(ar1.get(i));
		    i++;
		}

		while (j < ar2.size()) {
		    ar3.add(ar2.get(j));
		    j++;
		}
		
		return ar3;
	}
	
	public static Node makeBstFromArrayList(ArrayList<Integer> arr, int st, int end) {

		if(st > end) {
			return null;
		}
				
		int mid = (st + end)/2;
		Node root = new Node(arr.get(mid));
		
		root.left = makeBstFromArrayList(arr, st, mid-1);
		root.right = makeBstFromArrayList(arr, mid+1, end);
		
		return root;
	}
	
	
	public static void main(String[] args) {

		root1 = takeInput(root1);
		root2 = takeInput(root2);
		
		// 50 40 60 70 -1
		// 55 45 65 35 47 -1
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list = mergeTwoSortedArrayForBst(root1, root2);
		
		root3 = makeBstFromArrayList(list, 0, list.size()-1);
		
		levelOrderTraversal(root3);
	}
	

//	50 
//	40 60 
//	35 45 55 65 
//	47 70 

}
