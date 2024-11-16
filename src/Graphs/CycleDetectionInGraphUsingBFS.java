package Graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class CycleDetectionInGraphUsingBFS {

	static Scanner scn = new Scanner(System.in);
	static HashMap<Integer, Set<Integer>> adjList = new HashMap<>();
	static HashMap<Integer, Boolean> visited = new HashMap<>();
	static HashMap<Integer, Integer> parentMap = new HashMap<>();
	
	public static void prepareAdjList(int u, int v) {
		adjList.computeIfAbsent(u, k->new HashSet<>()).add(v);
		adjList.computeIfAbsent(v, k->new HashSet<>()).add(u);
	}
	
	static String cycleDetectionUsingBFS(int numberOfEdges, int numberOfNodes) {
		
		for(int node=0;node<numberOfNodes;node++) {
			if(!visited.getOrDefault(node,false)) {
				boolean containsCycle = hasCycleBFS(node);
				if(containsCycle) {
					return "Graph has a cycle.";
				} 
			}
		}
		
		return "Graph does not have a cycle.";
	}
	
	public static boolean hasCycleBFS(int node) {
				
		parentMap.put(node,-1);
		visited.replace(node, true);
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(node);
		
		while(!queue.isEmpty()) {
			
			int frontNode = queue.poll();
			System.out.println("\n");
			System.out.println("Front Node: " + frontNode);
			
			for(int neighbour: adjList.getOrDefault(frontNode, new HashSet<>())) {
				
				System.out.println("Neighbour: " + neighbour);
				System.out.println("Parent Map: " + parentMap);
				System.out.println("Visited Map: " + visited);
				
				if(visited.getOrDefault(neighbour,false) && neighbour!=parentMap.getOrDefault(frontNode,node)) {
					System.out.println("Cycle Detected!");
					return true;
				} else if(!visited.getOrDefault(neighbour,false)) {
					queue.add(neighbour);
					visited.replace(neighbour, true);
					parentMap.put(neighbour, frontNode);
				}
				
				System.out.println("Queue: "+ queue);
			}
		}
		return false;
	}
	
	static String cycleDetectionUsingDFS(int numberOfEdges, int numberOfNodes) {
		
		for(int node=0;node<numberOfNodes;node++) {
			if(!visited.getOrDefault(node,false)) {
				boolean containsCycle = hasCycleDFS(node, -1);
				System.out.println("Contains cycle DFS?" + containsCycle);
				if(containsCycle) {
					return "Graph has a cycle.";
				} 
			}
		}
		
		return "Graph does not have a cycle.";
	}
	
	public static boolean hasCycleDFS(int node, int parent) {
		
		visited.replace(node, true);
		
		System.out.println("Node DFS: " + node);
		System.out.println("Parent DFS: " + parent);
		System.out.println("Visited: " + visited);
		
		for(int neighbour: adjList.getOrDefault(node, new HashSet<>())) {
			if(!visited.getOrDefault(neighbour, false)) {
				System.out.println("Neighbour DFS:" + neighbour);
				boolean cycleDetected = hasCycleDFS(neighbour,node);
				if(cycleDetected) {
					return true;
				}
			} else if(neighbour != parent) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		
		int numberOfNodes = scn.nextInt();
		int numberOfEdges = scn.nextInt();
		
		for(int i=0; i<numberOfEdges; i++) {
			
			int u = scn.nextInt();
			int v = scn.nextInt();
			
			prepareAdjList(u,v);
		}
		
		for(int i=0; i<numberOfNodes; i++) {
			visited.put(i, false);
		}
		
		System.out.println(cycleDetectionUsingBFS(numberOfEdges, numberOfNodes));
//		System.out.println(cycleDetectionUsingDFS(numberOfEdges, numberOfNodes));

//		System.out.println("Visited Map: " + visited);
//		System.out.println("Parent Map: " + parentMap);
//		System.out.println("Adj List: " + adjList);
	}
}

//9 8
//1 2
//2 3
//4 5
//5 6
//5 7
//6 8
//7 8
//8 9

