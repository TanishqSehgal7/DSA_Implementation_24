package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class BridgesInGrapg_TarjansAlgo {
	
	static HashMap<Integer, Set<Integer>> adjList = new HashMap<>();
	static HashMap<Integer,Boolean> visited = new HashMap<>();
	static Scanner scn = new Scanner(System.in);
	static List<String> ans = new ArrayList<>();
	static int time = 0;
	
	public static void prepareAdjacencyList(int u, int v) {	
		adjList.computeIfAbsent(u, k -> new HashSet<>()).add(v);
		adjList.computeIfAbsent(v, k-> new HashSet<>()).add(u);
	}
	
	public static List<String> findBridges(int u, int discovery[], int low[], int parent[], boolean visited[]) {
		
		// update discovery and low with incremented time
		discovery[u] = low[u] = ++time;
		
		visited[u] = true;
		
		// process neighbors of u
		
		for(int neighbor: adjList.getOrDefault(u, new HashSet<>())) {
			
			// node is not visited
			if(!visited[neighbor]) {
				
				parent[neighbor] = u;
				visited[neighbor] = true;
				
				// make dfs call
				findBridges(neighbor, discovery, low, parent, visited);
				
				low[u] = Math.min(low[u], low[neighbor]);
				
				// check if u, neighbor is a bridge
				if(low[neighbor] > discovery[u]) {
					ans.add(u + " - " + neighbor);
				}
				
			} else if(neighbor != parent[u]) { 
				// back edge scenario and the node is visited
				low[u] = Math.min(low[u], discovery[neighbor]);
			}
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
				findBridges(i, dicovery, low, parent, visited);
			}
		}
		
		System.out.println(ans);
	}

}
