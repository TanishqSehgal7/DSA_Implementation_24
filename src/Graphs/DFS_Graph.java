package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class DFS_Graph {

	static Scanner scn = new Scanner(System.in);
	static HashMap<Integer, Set<Integer>> adjList = new HashMap<>();
	static HashMap<Integer, Boolean> visited = new HashMap<>();
	
	public static void prepareAdjList(int u, int v) {
		adjList.computeIfAbsent(u, k->new HashSet<>()).add(v);
		adjList.computeIfAbsent(v, k->new HashSet<>()).add(u);
	}
	
	
	public static List<Integer> DFS(int numberOfNodes) {
		
		List<Integer> dfsAns = new ArrayList<>();
		
		for(int i = 0; i<numberOfNodes; i++) {
			if(!visited.getOrDefault(i, false)) {
				dfs(dfsAns, i);
			}
		}
		
		return dfsAns;
	}
	
	
	public static void dfs(List<Integer> ans, int node) {
		
		visited.replace(node, true);
		ans.add(node);
		
		for(int neighbor: adjList.getOrDefault(node, new HashSet<>())) {
			
			if(!visited.get(neighbor)) {
				dfs(ans, neighbor);
			}
		}
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
		
		System.out.println(adjList);
		
		List<Integer> dfsTraversal = DFS(numberOfNodes);
		
		System.out.println(dfsTraversal);
	}

}

//6 6
//0 4
//1 4
//1 5
//3 5
//2 4
//2 3



