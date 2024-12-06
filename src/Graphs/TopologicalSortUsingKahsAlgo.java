package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class TopologicalSortUsingKahsAlgo {

	static Scanner scn = new Scanner(System.in);
	static HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();
	static HashMap<Integer, Integer> inDegree = new HashMap<>();
	static Queue<Integer> queue = new LinkedList<>();
	
	public static void prepareAdjList(int u, int v) {
	
		adjList.computeIfAbsent(u, k->new ArrayList<>()).add(v);
	
	}
	
	
	public static List<Integer> topologicalSortKahnsAlgo(int numberOfNodes) {
		
		List<Integer> topologicalSort = new ArrayList<>();
		
		// find in-degree of all nodes
		
		for(int i=1; i<=numberOfNodes; i++) {
			for(int neighbor: adjList.getOrDefault(i, new ArrayList<>())) {
				int indegree = inDegree.getOrDefault(neighbor,0) + 1;
				inDegree.put(neighbor, indegree);
			}
		}
		
		// add nodes with in-degree 0 to the queue
		
		for(Map.Entry<Integer, Integer> entry: inDegree.entrySet()) {
			if(entry.getValue() == 0) {
				queue.add(entry.getKey());
			}
		}
		
		// apply BFS and store topological sort inside the list
		
		while(!queue.isEmpty()) {
			
			int front = queue.poll();
			topologicalSort.add(front);
			
			for(int neighbor: adjList.getOrDefault(front, new ArrayList<>())) {
				int indegree = inDegree.get(neighbor) - 1;
				inDegree.put(neighbor, indegree);
				
				if(inDegree.get(neighbor) == 0) {
					queue.add(neighbor);
				}
			}
		}
		
		return topologicalSort;
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
			inDegree.put(i, 0);
		}
		
		List<Integer> kahnsAlgoTopoSort = topologicalSortKahnsAlgo(numberOfNodes);
		System.out.println(kahnsAlgoTopoSort);
	}
}
