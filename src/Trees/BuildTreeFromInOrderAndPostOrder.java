package Trees;

import java.util.HashMap;


public class BuildTreeFromInOrderAndPostOrder {

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
	
	
	public static Node solve(int[] inOrder, int[] postOrder, int[] postOrderIndex, int inOrderStart, int inOrderEnd, int size, HashMap<Integer, Integer> map) {
		
		// base case
		if((postOrderIndex[0] < 0) || inOrderStart > inOrderEnd) {
			return null;
		}
		
		// get element from preOrder Index
		int element = postOrder[postOrderIndex[0]--];
		
		// create a node
		Node node = new Node(element);
		
		// find position of element from inOrder Array
		int positionOfRootFromInOrder = map.get(element);
		
		// right call
		node.right = solve(inOrder, postOrder, postOrderIndex, positionOfRootFromInOrder+1, inOrderEnd, size, map);
		
		// left call
		node.left = solve(inOrder, postOrder, postOrderIndex, inOrderStart, positionOfRootFromInOrder-1, size, map);
		
		return node;
	}
	
	
	public static Node buildTree(int[] inOrder, int[] postOrder, int size) {
		
		int[] postOrderIndex = {size-1};
		referenceMap = createMapping(inOrder, referenceMap, size);
		
//		solve(inOrder, postOrder, postOrderIndex, inOrderStart, inOrderEnd, size, map);
		Node ans = solve(inOrder, postOrder, postOrderIndex, 0, size-1, size, referenceMap);
		return ans;
	}
	
	public static void printTree(Node root) {
		
		if(root == null) {
			return;
		}
		
		printTree(root.left);
		printTree(root.right);
		System.out.print(root.data + " ");
	}
	
	public static void main(String[] args) {
		
		int[] inOrder = {4,8,2,5,1,6,3,7};
		int[] postOrder = {8,4,5,2,6,7,3,1};
		
		root = buildTree(inOrder,postOrder,inOrder.length);
		printTree(root);
	}

}
