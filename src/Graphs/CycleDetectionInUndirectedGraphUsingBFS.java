package Graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class CycleDetectionInUndirectedGraphUsingBFS {

	static Scanner scn = new Scanner(System.in);
	static HashMap<Integer, Set<Integer>> adjList = new HashMap<>();
	static HashMap<Integer, Boolean> visited = new HashMap<>();
	static HashMap<Integer, Integer> parentMap = new HashMap<>();
	
	public static void prepareAdjList(int u, int v) {
		adjList.computeIfAbsent(u, k->new HashSet<>()).add(v);
		adjList.computeIfAbsent(v, k->new HashSet<>()).add(u);
	}
	
	public static String cycleDetectionUsingBFS(int numberOfEdges, int numberOfNodes) {
		
		for(int i = 0; i<numberOfNodes; i++) {
			if(!visited.getOrDefault(i, false)) {
				boolean containsCycle = hasCycleBFS(i);
				if(containsCycle) {
					return "This is a cyclic graph.";
				}
			}
		}
		
		return "This is an Acyclic graph.";
	}
	
	public static boolean hasCycleBFS(int node) {
		
		visited.put(node, true);
		parentMap.put(node, -1);
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(node);
		
		while(!queue.isEmpty()) {
			
			int front = queue.poll();
			
			for(int neighbor: adjList.getOrDefault(front, new HashSet<>())) {
				
				if(!visited.getOrDefault(neighbor, false)) {
					queue.add(neighbor);
					visited.replace(neighbor, true);
					parentMap.put(neighbor, front);
				} else if(neighbor != parentMap.get(front)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	public static String cycleDetectionUsingDFS(int numberOfEdges, int numberOfNodes) {
		
		
		for(int i=0; i<=numberOfNodes; i++) {
			
			if(!visited.getOrDefault(i, false)) {
				boolean containsCycle = hasCycleDFS(i);
				if(containsCycle) {
					return "This is a cyclic graph";
				}
			}
		}
		
		return "This is an Acyclic graph.";
	}
	
	public static boolean hasCycleDFS(int node) {
		
		visited.put(node, true);
		
		for(int neighbor: adjList.getOrDefault(node, new HashSet<>())) {
			
			if(!visited.getOrDefault(neighbor, false)) {
				
				parentMap.put(neighbor, node);
				boolean containsCycle = hasCycleDFS(neighbor);
				
				if(containsCycle) {
					return true;
				}
				
			} else if(neighbor != parentMap.get(node)) {
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
			parentMap.put(i, -1);
		}
		
//		System.out.println(cycleDetectionUsingBFS(numberOfEdges, numberOfNodes));
		System.out.println(cycleDetectionUsingDFS(numberOfEdges, numberOfNodes));

//		System.out.println("Visited Map: " + visited);
//		System.out.println("Parent Map: " + parentMap);
//		System.out.println("Adj List: " + adjList);
	}
}

//9 8
//1 2
//2 3
//4 5
//5 7
//5 6
//7 8
//6 8
//8 9

//9 7
//1 2
//2 3
//4 5
//5 6
//5 7
//7 8
//8 9

