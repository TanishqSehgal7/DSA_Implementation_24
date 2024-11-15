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
		
		List<Integer> ans = new ArrayList<>();
		
		for(int node=0; node<numberOfNodes; node++) {
			if(!visited.getOrDefault(node,false)) {
				dfs(ans, node);
			}
		}
		
		return ans;
	}
	
	
	public static void dfs(List<Integer> ans, int node) {
		
		ans.add(node);
		visited.replace(node, false, true);
		
		// for all nodes inside adjList call dfs recursively
		for(int neighbour: adjList.getOrDefault(node, new HashSet<>())) {
			if(!visited.getOrDefault(neighbour,false)) {
				dfs(ans, neighbour);
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

//7 6
//1 5
//1 4
//1 2
//2 7
//2 6
//2 3

//5 5
//0 2
//2 4
//4 3
//3 1
//1 2

