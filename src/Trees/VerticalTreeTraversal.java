package Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import Trees.BinaryTree.Node;

import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

public class VerticalTreeTraversal {

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
	
	public static class Pair {
		
		int horizontalDistance;
		Node node;
		
		public Pair(Node node, int hd) {
			this.node = node;
			this.horizontalDistance = hd;
		}
	}
	
	public static Node buildTree(Node root) {
		
		System.out.println("Enter data:\n");
		int data = scn.nextInt();
		
		root = new Node(data);
		
		if(data == -1) {
			return null;
		}
		
		System.out.println("Enter Data to Left of " + root.data);
		root.left = buildTree(root.left);
		System.out.println("Enter Data to Right of " + root.data);
		root.right = buildTree(root.right);
		
		return root;
	}
	
	public static List<List<Integer>> verticalTraversal(Node root) {
		
//		HashMap<Integer, ArrayList<Integer>> result = new HashMap<Integer, ArrayList<Integer>>();
		// A treemap would be preferred since is orders the keys in natural ascending order and 
		// we need the horizontal distance in ascending order only from -ve to +ve in a sorted manner
		
		TreeMap<Integer,ArrayList<Integer>> result = new TreeMap<>();
		
		Queue<Pair> queue =  new LinkedList<Pair>();
		
		// push root at horizontal distance 0 in queue
		queue.add(new Pair(root,0));
		
		while(!queue.isEmpty()) {
			
			Pair temp = queue.poll(); // this contains horizontal distance and node
			Node tempNode = temp.node; // node obtained from temp
			int hd = temp.horizontalDistance; // horizontal distance obtained from temp
			
			// add root node to treemap corresponding to horizontalDistance = 0
			result.computeIfAbsent(hd, k -> new ArrayList<Integer>()).add(tempNode.data);
			
			if(tempNode.left!=null) {
				queue.add(new Pair(tempNode.left, hd-1));
			} 
			if(tempNode.right!=null) {
				queue.add(new Pair(tempNode.right,hd+1));
			}
		}
		
		// put all the lists stored in resulting treemap in a list of lists
		
		List<List<Integer>> res = new ArrayList<>();
		
		for(Map.Entry<Integer, ArrayList<Integer>> entry: result.entrySet()) {
			res.add(entry.getValue());
		}
		
		return res;
	}
	
	public static List<List<Integer>> topLevelView(Node root) {
		
//		HashMap<Integer, ArrayList<Integer>> result = new HashMap<Integer, ArrayList<Integer>>();
		// A treemap would be preferred since is orders the keys in natural ascending order and 
		// we need the horizontal distance in ascending order only from -ve to +ve in a sorted manner
		
		TreeMap<Integer,ArrayList<Integer>> result = new TreeMap<>();
		
		Queue<Pair> queue =  new LinkedList<Pair>();
		
		// push root at horizontal distance 0 in queue
		queue.add(new Pair(root,0));
		
		while(!queue.isEmpty()) {
			
			Pair temp = queue.poll(); // this contains horizontal distance and node
			Node tempNode = temp.node; // node obtained from temp
			int hd = temp.horizontalDistance; // horizontal distance obtained from temp
			
			// add root node to treemap corresponding to horizontalDistance = 0
			if(result.get(hd) == null) {
				result.computeIfAbsent(hd, k -> new ArrayList<Integer>()).add(tempNode.data);
			}
			
			if(tempNode.left!=null) {
				queue.add(new Pair(tempNode.left, hd-1));
			}
			
			if(tempNode.right!=null) {
				queue.add(new Pair(tempNode.right,hd+1));
			}
		}
		
		// put all the lists stored in resulting treemap in a list of lists
		
		List<List<Integer>> res = new ArrayList<>();
		
		for(Map.Entry<Integer, ArrayList<Integer>> entry: result.entrySet()) {
			res.add(entry.getValue());
		}
		
		return res;
	}
	
	
	public static List<List<Integer>> bottomView(Node root) {
		
//		HashMap<Integer, ArrayList<Integer>> result = new HashMap<Integer, ArrayList<Integer>>();
		// A treemap would be preferred since is orders the keys in natural ascending order and 
		// we need the horizontal distance in ascending order only from -ve to +ve in a sorted manner
		
		TreeMap<Integer,ArrayList<Integer>> result = new TreeMap<>();
		
		Queue<Pair> queue =  new LinkedList<Pair>();
		
		// push root at horizontal distance 0 in queue
		queue.add(new Pair(root,0));
		
		while(!queue.isEmpty()) {
			
			Pair temp = queue.poll(); // this contains horizontal distance and node
			Node tempNode = temp.node; // node obtained from temp
			int hd = temp.horizontalDistance; // horizontal distance obtained from temp
			
			// add root node to treemap corresponding to horizontalDistance = 0
			
			if(result.containsKey(hd)) {
				result.replace(hd, new ArrayList<Integer>()).add(tempNode.data);
			} else {
				result.computeIfAbsent(hd, k -> new ArrayList<Integer>()).add(tempNode.data);
			}
			
			if(tempNode.left!=null) {
				queue.add(new Pair(tempNode.left, hd-1));
			}
			
			if(tempNode.right!=null) {
				queue.add(new Pair(tempNode.right,hd+1));
			}
		}
		
		// put all the lists stored in resulting treemap in a list of lists
		
		List<List<Integer>> res = new ArrayList<>();
		
		for(Map.Entry<Integer, ArrayList<Integer>> entry: result.entrySet()) {
			res.add(entry.getValue());
		}
		
		return res;
	}
	
	public static void levelOrderTraversal(Node root) {
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			Node temp = queue.peek();
			System.out.print(temp.data + " ");
			queue.remove();
			
			if(temp.left!=null) {
				queue.add(temp.left);
			}
			
			if(temp.right!=null) {
				queue.add(temp.right);
			}
		}
	}
	
	public static void main(String[] args) {
		
		
		root = buildTree(root);
		
		levelOrderTraversal(root);
		
		System.out.println("\n\nNodes as per Vertical Order are:\n");
		
		// 1 2 4 -1 -1 5 -1 -1 3 6 -1 8 -1 -1 7 -1 9 -1 -1
		// 1 2 4 -1 -1 5 -1 -1 3 6 -1 -1 7 -1 -1
		
		List<List<Integer>> verticalOrder = verticalTraversal(root);
		List<List<Integer>> topLevelView = topLevelView(root);
		List<List<Integer>> bottomView = bottomView(root);
		
		for(List<Integer> nodelist : verticalOrder) {
			for(int i: nodelist) {
				System.out.print(i + " ");
			}
		}
		
		System.out.println("\n\nNodes as per Top View are:\n");
		
		for(List<Integer> nodelist : topLevelView) {
			for(int i: nodelist) {
				System.out.print(i + " ");
			}
		}
		
		System.out.println("\n\nNodes as per Top View are:\n");
		
		for(List<Integer> nodelist : bottomView) {
			for(int i: nodelist) {
				System.out.print(i + " ");
			}
		}
	}
}
