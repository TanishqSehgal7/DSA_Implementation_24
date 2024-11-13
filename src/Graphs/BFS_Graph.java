package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class BFS_Graph {
	
	static HashMap<Integer, Set<Integer>> adjList = new HashMap<>();
	static HashMap<Integer,Boolean> visited = new HashMap<>();
	static Scanner scn = new Scanner(System.in);
	
	public static void prepareAdjacencyList(int u, int v) {	
		adjList.computeIfAbsent(u, k -> new HashSet<>()).add(v);
		adjList.computeIfAbsent(v, k-> new HashSet<>()).add(u);
	}
	
	public static List<Integer> BFS(int nodes) {
		
		List<Integer> ans = new ArrayList<>();
		
		for(int node=0; node<nodes; node++) {
			if(!visited.get(node)) {
				bfs(ans, node);
			}
		}		
		return ans;
	}
	
	public static void bfs(List<Integer> ans, int node) {
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(node);
		
		visited.put(node, true);
		
		while(!queue.isEmpty()) {
			
			// get front node from queue
			int frontNode = queue.poll();
			
			// add frontNode to ans
			ans.add(frontNode);
			
			// traverse all neighbours of frontNode
			for(int neighbour: adjList.getOrDefault(frontNode, new HashSet<>())) {
				if(!visited.getOrDefault(neighbour, false)) {
					queue.add(neighbour);
					visited.put(neighbour, true);
				}
			}
		}
	}

	public static void main(String[] args) {
		
		int nodes = 4;
		
		for(int i=0; i<nodes; i++) {
			visited.put(i, false);	
		}
		
		for(int i=0; i<nodes; i++) {
			int u = scn.nextInt();
			int v = scn.nextInt();
			prepareAdjacencyList(u, v);
		}
		System.out.println(adjList);
		
		List<Integer> bfsTraversal = BFS(nodes);
		
		System.out.println("BFS Traversal of Graph: " + bfsTraversal);
	}
	
//	0 3
//	3 1
//	1 4
//	1 2
	
}