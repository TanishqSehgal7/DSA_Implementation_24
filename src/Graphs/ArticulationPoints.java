package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ArticulationPoints {

	static HashMap<Integer, Set<Integer>> adjList = new HashMap<>();
	static HashMap<Integer,Boolean> visited = new HashMap<>();
	static Scanner scn = new Scanner(System.in);
	static List<Integer> ans = new ArrayList<>();
	static int time = 0;
	
	public static void prepareAdjacencyList(int u, int v) {	
		adjList.computeIfAbsent(u, k -> new HashSet<>()).add(v);
		adjList.computeIfAbsent(v, k-> new HashSet<>()).add(u);
	}
	
	public static List<Integer> findArticulationPoints(int u, int discovery[], int low[], int parent[], boolean visited[]) {
		
		discovery[u] = low[u] = ++time;
		visited[u] = true;
		
		int childCount = 0;
		
		for(int neighbor: adjList.getOrDefault(u, new HashSet<>())) {
			
			if(!visited[neighbor]) {
				
				childCount++;
				parent[neighbor] = u;
				visited[neighbor] = true;
				
				findArticulationPoints(neighbor, discovery, low, parent, visited);
				
				low[u] = Math.min(low[u], low[neighbor]);
				
				// check condition for articulation point for a non rooted node
				if(parent[u]!=-1 && low[neighbor] >= discovery[u]) {
					ans.add(u);
				}
				
			} else if(neighbor != parent[u]) { // back edge
				low[u] = Math.min(low[u], discovery[neighbor]);
			}
		}
		
		if(parent[u] == -1 && childCount > 1) { // rooted node
			ans.add(u);
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		
		System.out.println("Enter the number of nodes");
		int numberOfNodes = scn.nextInt();
		
		System.out.println("Enter the number of edges");
		int numberOfEdges = scn.nextInt();
		
		for(int i=0; i < numberOfEdges; i++) {
			int u = scn.nextInt();
			int v = scn.nextInt();
			prepareAdjacencyList(u, v);
		}	
		
		int dicovery[] = new int[numberOfNodes];
		int low[] = new int[numberOfNodes];
		int parent[] = new int[numberOfNodes];
		boolean visited[] = new boolean[numberOfNodes];
		
		Arrays.fill(visited, false);
		Arrays.fill(parent, -1);
		Arrays.fill(low, -1);
		Arrays.fill(dicovery, -1);
		
		for(int i=0; i<numberOfNodes; i++) {
			if(!visited[i]) {
				ans = findArticulationPoints(i, dicovery, low, parent, visited);
			}
		}
		
		System.out.println(ans);
	}
}
