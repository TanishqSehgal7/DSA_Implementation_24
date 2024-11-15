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
			if(!visited.get(node)) {
				boolean containsCycle = hasCycleBFS(node);
				if(containsCycle) {
					return "Graph has a cycle.";
				} 
			}
		}
		
		return "Graph does not have a cycle.";
	}
	
	public static boolean hasCycleBFS(int node) {
		
		boolean isCyclicBFS = false;
		
		parentMap.put(node,-1);
		visited.replace(node, true);
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(node);
		
		while(!queue.isEmpty()) {
			
			int frontNode = queue.poll();
			
			for(int neighbour: adjList.getOrDefault(frontNode, new HashSet<>())) {
				
				if(visited.get(neighbour) && neighbour!=parentMap.get(frontNode)) {
					return true;
				} else if(!visited.get(neighbour)) {
					queue.add(neighbour);
					visited.replace(neighbour, true);
					parentMap.put(neighbour, frontNode);
				}
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
	}

}
