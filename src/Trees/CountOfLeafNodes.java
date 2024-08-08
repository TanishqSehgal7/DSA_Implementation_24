package Trees;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import Trees.BinaryTree.Node;

public class CountOfLeafNodes {
	
	static Scanner scn = new Scanner(System.in);
	static Node root1;
	static Node root2;
	static int count = 0;
	static int height = 0;
	static int width = 0;
	static int ans[];
	
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
		
		System.out.println("Enter data for inserting in left of: " + root.data);
		root.left = buildTree(root.left);
		System.out.println("Enter data for inserting in right: " + root.data);
		root.right = buildTree(root.right);
		
		return root; 
	}
	
	public static int countOfLeafNodes(Node root) {
		
		// LNR
		if(root == null) {
			return -1;
		}
		
		countOfLeafNodes(root.left);
		
		if(root.left == null && root.right == null) {
			count++;
		}
		
		countOfLeafNodes(root.right);
		
		return count;
		
	}
	
	
	public static int calculateTreeHeight(Node root) {
		
		if(root == null) {
			return 0;
		}
		
		int leftSubTreeHeight = calculateTreeHeight(root.left);
		int rightSubTreeHeight = calculateTreeHeight(root.right);
		
		int ans = Math.max(leftSubTreeHeight, rightSubTreeHeight) + 1;
		
		return ans;
		
	}
	
	public static int calculateTreeWidth(Node root) { // O(N^2) SOLUTION -> NOT EFFICIENT
		
		if(root == null) {
			return 0;
		}
				
		int leftSubTreeOnly = calculateTreeWidth(root.left);
		int rightSubTreeOnly = calculateTreeWidth(root.left);
		int leftAndRightBoth = calculateTreeHeight(root.left) + calculateTreeHeight(root.right) + 1;
		
		int ans = Math.max(leftAndRightBoth, Math.max(leftSubTreeOnly, rightSubTreeOnly));
		
		return ans;
	}
	
	
	public static int[] calculateTreeWidthEfficient(Node root) { 
		
		// O(N) approach
		
		if(root == null) {
			
			int baseCaseResult[] = new int[2];
			
			baseCaseResult[0] = 0; // store height at 0th index
			baseCaseResult[1] = 0; // store width height at 1st index
			
			return baseCaseResult;
		
		}
		
		int leftSubTreeCall[] = calculateTreeWidthEfficient(root.left);
		int rightSubTreeCall[] = calculateTreeWidthEfficient(root.right);
		
		int leftSubTreeHeight = leftSubTreeCall[0];
		int rightSubTreeHeight = rightSubTreeCall[0];
		int leftRightcombinationAns = leftSubTreeCall[0] +  rightSubTreeCall[0] + 1;
		
		int ans[] = new int[2]; 		
		
		ans[0] = Math.max(leftSubTreeCall[0], rightSubTreeCall[0]) + 1;
		ans[1] = Math.max(leftSubTreeHeight, Math.max(rightSubTreeHeight, leftRightcombinationAns));
		
		return ans;
		
	}
	
	
	public static boolean isBalanced(Node root) { // O(n^2) solution
		
		// base case
		if(root == null ) {
			return true;
		}
		
		boolean left = isBalanced(root.left);
		boolean right = isBalanced(root.right);
		
		boolean heightDiff = Math.abs(calculateTreeHeight(root.left) - calculateTreeHeight(root.right)) <=1;
		
		if(left && right && heightDiff) {
			return true;
		} else {
			return false;
		}

	}
	
	public static boolean isIdentical(Node root1, Node root2) {
		
		// base case
		if(root1 == null && root2 == null) {
			return true;
		}
		
		if(root1 == null  && root2 != null) {
			return false;
		}
		
		if(root1!=null && root2 == null) {
			return false;
		}
		
		boolean leftSideCheck = isIdentical(root1.left, root2.left);
		boolean rightSideCheck = isIdentical(root1.right,root2.right);
		
		boolean valueCheck = root1.data == root2.data;
		
		if(leftSideCheck && rightSideCheck && valueCheck) {
			return true;
		} else {
			return false;
		}

	}
	
	
	public static ArrayList<Object> isSumTree(Node root) {
		
		// base case
		ArrayList<Object> result = new ArrayList<Object>();
		if(root == null) {
			result.add(0,true);
			result.add(1,0);
			return result;
		}
		
		// base case 2
		if(root.left == null && root.right == null) {
			result.add(0,true);
			result.add(1,root.data);
			return result;
		}
		
		ArrayList<Object> leftSideCall = isSumTree(root.left);
		ArrayList<Object> rightSideCall = isSumTree(root.right);
		
		boolean isLeftSumTree = (boolean) leftSideCall.get(0);
		boolean isRightSumTree = (boolean) rightSideCall.get(0);
		
		int leftSumValue = (int) leftSideCall.get(1);
		int rightSumValue = (int) rightSideCall.get(1);
		
		boolean sumCondition = root.data == leftSumValue + rightSumValue;
				
		if(isLeftSumTree && isRightSumTree && sumCondition) {
			result.add(0, true);
			result.add(1, root.data + leftSumValue + rightSumValue);
		} else {
			result.add(0, false);
			result.add(1, root.data + leftSumValue + rightSumValue);
		}
		
		return result;
	}
	
//	public static ArrayList<Integer> zigZagTraversal(Node root) {
//		
//		Queue<Node> queue = new LinkedList<Node>();
//		ArrayList<Integer> result = new ArrayList<>();
//		
//		// base case
//		if(root == null) {
//			return result;
//		}
//		
//		queue.add(root);
//		
//		boolean leftToRight = true;
//		
//		while(!queue.isEmpty()) {
//			
//			int size = queue.size();
//			ArrayList<Integer> ans = new ArrayList<Integer>();
//			
//			for(int i=0;i<size;i++) {
//				
//				Node front = queue.peek();
//				queue.remove();
//				
//				int index = leftToRight ? i : size-i-1;
//				ans.add(index,front.data);
//				
//				if(front.left!=null) {
//					queue.add(front.left);
//				}
//				
//				if(front.right!=null) {
//					queue.add(front.right);
//				}
//			}
//			
//			leftToRight = !leftToRight;
//			
//			for(int i: ans) {
//				result.add(i);
//			}
//		}	
//		return result;
//	}
	
	public static ArrayList<Integer> zigZagTraversal(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            Deque<Integer> ans = new LinkedList<>();  // Use Deque for efficient operations at both ends

            for (int i = 0; i < size; i++) {
                Node front = queue.poll();

                if (leftToRight) {
                    ans.addLast(front.data);  // Append to the end
                } else {
                    ans.addFirst(front.data); // Append to the front
                }

                if (front.left != null) {
                    queue.add(front.left);
                }

                if (front.right != null) {
                    queue.add(front.right);
                }
            }

            leftToRight = !leftToRight;

            for (int num : ans) {
                result.add(num);
            }
        }

        return result;
    }
	
	
	public static void main(String[] args) {

		root1 = buildTree(root1);
		root2 = buildTree(root2);
		
		CountOfLeafNodes cntLn = new CountOfLeafNodes();
		cntLn.count = countOfLeafNodes(root1);
		System.out.println("Number of Leaf Nodes in Tree: " + cntLn.count);
		
		// 10 20 30 -1 -1 40 -1 -1 50 60 -1 -1 70 -1 -1
		// 10 20 30 -1 -1 40 -1 -1 50 -1 -1
		// 1 3 7 -1 -1 11 -1 -1 5 17 -1 -1 -1
		// 1 3 7 -1 -1 13 -1 -1 5 18 -1 -1 -1
		// 8 2 1 -1 -1 1 -1 -1 2 1 -1 -1 1 -1 -1
		
		cntLn.height = calculateTreeHeight(root1);
		System.out.println("Height of Tree is: " + cntLn.height);
		
		cntLn.width = calculateTreeWidth(root1);
		System.out.println("Width/Diameter of Tree is: " + cntLn.width);
		
		cntLn.ans = new int[2];
		cntLn.ans = calculateTreeWidthEfficient(root1);
		System.out.println("Height of Tree is: " + cntLn.ans[0]);
		
		System.out.println("Width of Tree is: " + cntLn.ans[1]);
		
		System.out.println("Is the given tree balanced? " + isBalanced(root1));
		
		System.out.println("Are Both Trees Identical? " + isIdentical(root1,root2));
		
		System.out.println("Is Sum Tree? " + isSumTree(root1));
		
		System.out.println("\nElements in ZigZag Traversal are:\n ");
		
		ArrayList<Integer> zigzagResult = zigZagTraversal(root1);
		for(int i:zigzagResult) {
			System.out.print(i + " ");
		}	
	}

}
