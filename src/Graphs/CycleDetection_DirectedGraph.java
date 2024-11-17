package Graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CycleDetection_DirectedGraph {

	static Scanner scn = new Scanner(System.in);
	static HashMap<Integer, Set<Integer>> adjList = new HashMap<>();
	static HashMap<Integer, Boolean> visited = new HashMap<>();
	static HashMap<Integer, Boolean> dfsVisited = new HashMap<>();
	
	public static void prepareAdjList(int u, int v) {
		adjList.computeIfAbsent(u, k->new HashSet<>()).add(v);
	}
	
	public static String cycleDetectionUsingDFS(int numberOfNodes) {
		
		for(int node=1; node<=numberOfNodes; node++) {
			if(!visited.getOrDefault(node, false)) {
				boolean ans = detectCycleDirectedGraphDFS(node);
				if(ans) {
					return "Graph has a cycle.";
				}
			}
		}
		
		return "Graph does not have a cycle.";
	}
	
	
	public static boolean detectCycleDirectedGraphDFS(int node) {
		
		visited.replace(node, true);
		dfsVisited.replace(node, true);
		
		for(int neighbour: adjList.getOrDefault(node, new HashSet<>())) {
			
			if(!visited.getOrDefault(neighbour,false)) {
				boolean cycleDetected = detectCycleDirectedGraphDFS(neighbour);
				if(cycleDetected) {
					return true;
				}
			} else if(dfsVisited.getOrDefault(neighbour, false)) {
				return true;
			}
		}
		
		dfsVisited.replace(node, false);
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
		
		for(int i=1; i<numberOfNodes; i++) {
			visited.put(i, false);
			dfsVisited.put(i, false);
		}
		
		System.out.println(adjList);
		System.out.println(cycleDetectionUsingDFS(numberOfNodes));
		

	}
}

//8 9
//1 2
//2 3
//2 4
//3 7
//3 8
//8 7
//4 5
//5 6
//6 4
