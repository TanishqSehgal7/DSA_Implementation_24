package Trees;

import java.util.HashMap;

public class BuildTreeUsingPreOrderAndInOrder {
	
	static Node root;
	static HashMap<Integer, Integer> referenceMap = new HashMap<Integer, Integer>();
	
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
	
	public static HashMap<Integer,Integer> createMapping(int[] inOrder, HashMap<Integer,Integer> map, int size) {
		
		for(int i=0;i<size;i++) {
			map.put(inOrder[i], i);
		}
		
		return map;
	}
	
	
	public static Node solve(int[] inOrder, int[] preOrder, int[] preOrderIndex, int inOrderStart, int inOrderEnd, int size, HashMap<Integer, Integer> map) {
		
		// base case
		if((preOrderIndex[0] > size-1) || inOrderStart > inOrderEnd) {
			return null;
		}
		
		// get element from preOrder Index
		int element = preOrder[preOrderIndex[0]++];
		
		// create a node
		Node node = new Node(element);
		
		// find position of element from inOrder Array
		int positionOfRootFromInOrder = map.get(element);
		
		// left call
		node.left = solve(inOrder, preOrder, preOrderIndex, inOrderStart, positionOfRootFromInOrder-1, size, map);
		node.right = solve(inOrder, preOrder, preOrderIndex, positionOfRootFromInOrder+1, inOrderEnd, size, map);
		
		return node;
	}

	
	public static Node buildTree(int[] inOrder, int[] preOrder, int size) {
		
		int[] preOrderIndex = {0};
		referenceMap = createMapping(inOrder, referenceMap, size);
		
//		solve(inOrder, preOrder, preOrderIndex, inOrderStart, inOrderEnd, size, map);
		Node ans = solve(inOrder, preOrder, preOrderIndex, 0, size-1, size, referenceMap);
		return ans;
	}
	
	public static void printTree(Node root) {
		
		if(root == null) {
			return;
		}
		
		printTree(root.left);
		System.out.print(root.data + " ");
		printTree(root.right);
	}
	
	
	public static void main(String[] args) {
		
		int[] inOrder = {3,1,4,0,5,2};
		int[] preOrder = {0,1,3,4,2,5};
		
		root = buildTree(inOrder,preOrder,inOrder.length);
		printTree(root);
	}

}
