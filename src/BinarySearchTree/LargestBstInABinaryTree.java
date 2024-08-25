package BinarySearchTree;

import java.util.Scanner;

public class LargestBstInABinaryTree {
	
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
	
	public static class Info {
		
		int max;
		int min;
		boolean isBST;
		int size;
		
		public Info(int max, int min, boolean isBST, int size) {
			this.max = max;
			this.min = min;
			this.isBST = isBST;
			this.size = size;
		}
	}
	
	
	
	public static int sizeOfLargestBstInABinaryTree(Node root) {
        int[] maxSize = new int[1];
        maxSize[0] = 0;
        solve(root, maxSize);
        return maxSize[0];
    }

    public static Info solve(Node root, int[] maxSize) {
        
    	if(root == null) {
            return new Info(Integer.MIN_VALUE, Integer.MAX_VALUE, true, 0);
        }

        Info leftcall = solve(root.left, maxSize);
        Info rightcall = solve(root.right, maxSize);

        Info currentNodeInfo = new Info(0, 0, false, 0);

        currentNodeInfo.size = leftcall.size + rightcall.size + 1;

        currentNodeInfo.max = Math.max(root.data, rightcall.max);
        currentNodeInfo.min = Math.min(root.data, leftcall.min);

        if(leftcall.isBST && rightcall.isBST && root.data > leftcall.max && root.data < rightcall.min) {
            currentNodeInfo.isBST = true;
        } else {
            currentNodeInfo.isBST = false;
        }

        if(currentNodeInfo.isBST) {
        	maxSize[0] = Math.max(maxSize[0], currentNodeInfo.size);
        }

        return currentNodeInfo;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		root = buildTree(root);
		// 5 2 1 -1 -1 3 -1 -1 4 -1 -1
		
		System.out.println(sizeOfLargestBstInABinaryTree(root));
	}

}
