package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Stack;

public class ShortestDistanceInDirectedAcyclicGraph {

	static Scanner scn = new Scanner(System.in);
	static HashMap<Integer, List<Pair>> adjList = new HashMap<>();
	static HashMap<Integer, Boolean> visited = new HashMap<>();
	static HashMap<Integer, Integer> distanceMap = new HashMap<>();
	static Stack<Integer> stack = new Stack<>();
	
	public static class Pair {
		int node;
		int weight;
		
		public Pair(int node, int weight) {
			this.node = node;
			this.weight = weight;
		}
	}
	
	public static void prepareAdjList(int u, int v, int weight) {
		Pair nodeWitWeight = new Pair(v,weight);
		adjList.computeIfAbsent(u, k-> new ArrayList<>()).add(nodeWitWeight);
	}
	
	// find topological sort
	public static void topologicalSort(int numberOfNodes) {
		
		for(int i=0; i<=numberOfNodes; i++) {
			if(!visited.getOrDefault(i,false)) {
				dfs(i);
			}
		}
	}
	
	public static void dfs(int node) {
		
		visited.put(node, true);
		
		for(Pair neighbor: adjList.getOrDefault(node, new ArrayList<>())) {
			if(!visited.getOrDefault(neighbor.node, false)) {
				dfs(neighbor.node);
			}
		}
		
		stack.add(node);
	}
	
	public static void shortestDistanceInDAG(int src) {
		
		distanceMap.put(src, 0);
		
		while(!stack.isEmpty()) {
			int top = stack.peek();
			stack.pop();
			
			if(distanceMap.getOrDefault(top, Integer.MAX_VALUE) != Integer.MAX_VALUE) {
				for(Pair pair: adjList.getOrDefault(top, new ArrayList<>())) {
					int newDist = distanceMap.get(top) + pair.weight;
					if(newDist < distanceMap.get(pair.node)) {
						distanceMap.put(pair.node, newDist);
					}
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		int numberOfNodes = scn.nextInt();
		int numberOfEdges = scn.nextInt();
		
		for(int i=0; i<numberOfEdges; i++) {
			
			int u = scn.nextInt();
			int v = scn.nextInt();
			int wt = scn.nextInt();
			
			prepareAdjList(u, v, wt);
		}
		
		for(int i=0; i<numberOfNodes; i++) {
			visited.put(i, false);
			distanceMap.put(i, Integer.MAX_VALUE);
		}
		
		for(Entry<Integer, List<Pair>> entry: adjList.entrySet()) {
			System.out.println("Printing values for key " + entry.getKey());
			for(Pair pair: entry.getValue()) {
				System.out.println(pair.node + " has weight " + pair.weight);
			}
		}
		topologicalSort(numberOfNodes);
		shortestDistanceInDAG(1);
		
		System.out.println(distanceMap);
	}
}

//6 9
//0 1 5
//0 2 3
//1 2 2
//1 3 6
//2 3 7
//2 4 4
//2 5 2
//3 4 -1
//4 5 -2
