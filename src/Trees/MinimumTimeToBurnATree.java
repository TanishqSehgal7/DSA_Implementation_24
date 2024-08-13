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
		
		return result;
		
	}
	
	
	public static int burnTree(Node root, HashMap<Node,Node> nodeToParent) {
		
		
		HashMap<Node, Boolean> visited = new HashMap<>();
		
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		visited.put(root, true);
		
		int ans = 0;
		
		while(!queue.isEmpty()) {
			
			boolean isSomethingAddedToQueue = false;
			int size = queue.size();
			
			for(int i = 0; i<size; i++) {
				
				// process neighbouring nodes
				Node front = queue.poll();
				
				if(front.left!=null && !visited.get(front.left)) {
					isSomethingAddedToQueue = true;
					queue.add(front.left);
					visited.put(front.left, true);
				}
				
				if(front.right!=null && !visited.get(front.right)) {
					isSomethingAddedToQueue = true;
					queue.add(front.right);
					visited.put(front.right, true);
				}
				
				if(nodeToParent.containsKey(front) && !visited.get(nodeToParent.get(front))) {
					isSomethingAddedToQueue = true;
					queue.add(nodeToParent.get(front));
					visited.put(nodeToParent.get(front),true);
				}
			}
			
			if(isSomethingAddedToQueue == true) {
				ans++;
			}
		}
		
		return ans;
	}
	
	
	public static int minimumTimeToBurnTree(Node root, int target) {
		
		/*
			Step1: Create nodeToParent mapping
			Step2: Find Target Node
			Step3: Burn the tree in min time
		*/
		
		HashMap<Node,Node> nodeToParent = new HashMap<>();
		Node targetNode = createParentMapping(root, target, nodeToParent);
		int minTime = burnTree(targetNode,nodeToParent);
		
		return minTime;
	}
	

	public static void main(String[] args) {
		
		root = buildTree(root);
		// 1 2 4 -1 -1 5 7 -1 -1 8 -1 -1 3 -1 6 -1 9 -1 10 -1 -1
		int target = 3;
		int minTime = minimumTimeToBurnTree(root,target);
		System.out.println("Min Time = " + minTime);
	}

}
