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

		List<Integer> bfsAns = new ArrayList<>();

		for(int i = 0; i<nodes; i++) {
			if(!visited.getOrDefault(i, false)) {
				bfs(bfsAns, i);
			}
		}

		return bfsAns;
	}

	public static void bfs(List<Integer> ans, int node) {

		Queue<Integer> queue = new LinkedList<>();
		
		visited.replace(node, true);
		queue.add(node);
		
		while(!queue.isEmpty()) {
			
			int front = queue.poll();
			
			ans.add(front);
			
			for(int neighbor: adjList.getOrDefault(front, new HashSet<>())) {
				if(!visited.getOrDefault(neighbor, false)) {
					queue.add(neighbor);
					visited.replace(neighbor, true);
				}
			}
		}
	}

	public static void main(String[] args) {

		int edges = scn.nextInt();
		int nodes = scn.nextInt();

		for(int i=0; i<nodes; i++) {
			visited.put(i, false);	
		}

		for(int i=0; i<edges; i++) {
			int u = scn.nextInt();
			int v = scn.nextInt();
			prepareAdjacencyList(u, v);
		}
		System.out.println(adjList);

		List<Integer> bfsTraversal = BFS(edges);

		System.out.println("BFS Traversal of Graph: " + bfsTraversal);
	}

//	4 5
//	0 3
//	1 3
//	1 4
//	1 2
//  Time Complexity - O(nodes+edges)

}