package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class TopologicalSort {
	
	static Scanner scn = new Scanner(System.in);
	static HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();
	static HashMap<Integer, Boolean> visited = new HashMap<>();
	static Stack<Integer> stack = new Stack<>();
	static List<Integer> topologicalSort = new ArrayList<>();
	
	public static void prepareAdjList(int u, int v) {
		adjList.computeIfAbsent(u, k->new ArrayList<>()).add(v);
	}
	
	
	public static List<Integer> topologicalSort(int numberOfNodes) {
		
		for(int i=1; i<numberOfNodes; i++) {
			if(!visited.getOrDefault(i, false)) {
				dfsTopologicalSort(i);
			}
		}
		
		System.out.println(stack);
		
		while(!stack.isEmpty()) {
			int top = stack.pop();
			topologicalSort.add(top);
		}
		
		return topologicalSort;
	}
	
	
	public static void dfsTopologicalSort(int node) {
		
		visited.put(node, true);
		
		for(int neighbor: adjList.getOrDefault(node, new ArrayList<>())) {
			if(!visited.get(neighbor)) {
				dfsTopologicalSort(neighbor);
			}
			
		}
		
		System.out.println("Node " + node + " pushed to stack.");
		stack.add(node);
		
	}
	

	public static void main(String[] args) {
		
		int numberOfNodes = scn.nextInt();
		int numberOfEdges = scn.nextInt();
		
		for(int i=1; i<=numberOfNodes; i++) {
			visited.put(i, false);
		}
		
		for(int i=0; i<numberOfEdges; i++) {
			
			int u = scn.nextInt();
			int v = scn.nextInt();
			
			prepareAdjList(u,v);
		}
		
		System.out.println("Adjacency List: " + adjList);
		topologicalSort = topologicalSort(numberOfNodes);
		System.out.println("Topological Sort: " + topologicalSort);
	}

}
