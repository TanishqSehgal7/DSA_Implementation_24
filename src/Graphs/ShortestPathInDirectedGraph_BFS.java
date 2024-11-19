package Graphs;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class ShortestPathInDirectedGraph_BFS {

	
	static Scanner scn = new Scanner(System.in);
	static HashMap<Integer, Set<Integer>> adjList = new HashMap<>();
	static HashMap<Integer, Boolean> visited = new HashMap<>();
	static HashMap<Integer, Integer> parent = new HashMap<>();
	static Queue<Integer> queue = new LinkedList<>();
	
	
	public static void prepareAdjList(int u, int v) {
		adjList.computeIfAbsent(u, k->new HashSet<>()).add(v);
		adjList.computeIfAbsent(v, k->new HashSet<>()).add(u);
	}
	
	
	public static LinkedList<Integer> findShortestRoute(int numberOfNodes, int src, int dest) {
		
		visited.replace(src, true);
		queue.add(src);
		
		while(!queue.isEmpty()) {
			
			int front = queue.poll();
			
			for(int neighbour: adjList.getOrDefault(front, new HashSet<>())) {
				
				if(!visited.getOrDefault(neighbour,false)) {
					visited.replace(neighbour, true);
					parent.replace(neighbour, front);
					queue.add(neighbour);
				}
			}
		}
		
		// prepare shortest path by backtracking from destination node
		LinkedList<Integer> shortestRoute = new LinkedList<>();
		
		int currentNode = dest;
		shortestRoute.add(currentNode);
		int shortestPathSize = 0;
		while(currentNode!=src) {
			System.out.println("Current Node: " + currentNode);
			currentNode = parent.get(currentNode);
			shortestRoute.add(currentNode);
			shortestPathSize++;
		}
		
		System.out.println("Length of Shortest Path = " + shortestPathSize);
		Collections.reverse(shortestRoute);
		
		return shortestRoute;
	}
	
	
	public static void main(String[] args) {
	
		int numberOfNodes = scn.nextInt();
		int numberOfEdges = scn.nextInt();
		
		for(int i=0; i<numberOfEdges; i++) {
			
			int u = scn.nextInt();
			int v = scn.nextInt();
			
			prepareAdjList(u,v);
		}
		
		for(int i=1; i<=numberOfNodes; i++) {
			visited.put(i, false);
			parent.put(i, -1);
		}
		
		LinkedList<Integer> shortestRoute = findShortestRoute(numberOfNodes, 1, 8);
		System.out.println("Parent: " + parent);
		System.out.println(shortestRoute);
	}
}

//8 9
//1 2
//2 5
//5 8
//1 3
//3 8
//1 4
//4 6
//6 7
//7 8
