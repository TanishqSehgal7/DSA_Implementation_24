package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class GraphWithAdjacencyList {
	
	static HashMap<Integer, List<Integer>> graph = new HashMap<>();
	static Scanner scn = new Scanner(System.in);
	
	public static void addEdge(int u, int v, boolean direction) {
		
		// Add edge from u to v
		graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
		
		// If undirected, add edge from v to u
		if (!direction) {
			graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
		}
	}
	
	public static void main(String[] args) {
		
		int numberOfNodes = 5;
		int numberofEdges = 6;
				
		for(int i = 0; i < numberofEdges; i++) {
			int u = scn.nextInt();
			int v = scn.nextInt();
			
			addEdge(u, v, false);
		}
		
		System.out.println(graph);
	}

}

// Input
/*    
0 1 
1 2
2 3
3 1
3 4
0 4
*/