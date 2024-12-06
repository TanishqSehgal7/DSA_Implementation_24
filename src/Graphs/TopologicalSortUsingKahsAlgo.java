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
	static HashMap<Integer, Set<Integer>> adjList = new HashMap<>();
	static HashMap<Integer, Integer> inDegree = new HashMap<>();
	static Queue<Integer> queue = new LinkedList<>();
	
	public static void prepareAdjList(int u, int v) {
		adjList.computeIfAbsent(u, k->new HashSet<>()).add(v);
	}
	
	public static List<Integer> topologicalSortKahnsAlgo(int numberOfNodes) {
		
		List<Integer> ans = new ArrayList<>();
		
		// Step 1: find indegree
		for(int node = 1; node<=numberOfNodes; node++) {
			for(int neighbour: adjList.getOrDefault(node, new HashSet<>())) {
				int indegree = inDegree.getOrDefault(neighbour,0) + 1;
				inDegree.put(neighbour, indegree);
			}
		}
		
		// Step 2: insert all elements with indegree 0 in the queue
		for(Map.Entry<Integer, Integer> entry: inDegree.entrySet()) {
			if(entry.getValue() == 0) {
				queue.add(entry.getKey());
			}
		}
		
		// Step 3: apply BFS
		
		while(!queue.isEmpty()) {
			
			int front = queue.poll();
			ans.add(front);
			
			for(int neighbour: adjList.getOrDefault(front, new HashSet<>())) {
				int reducedInDegree = inDegree.getOrDefault(neighbour, 1) - 1;
				inDegree.put(neighbour, reducedInDegree);
				
				if(inDegree.getOrDefault(neighbour, 1) == 0) {
					queue.add(neighbour);
				}
			}
		}
		return ans;
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
