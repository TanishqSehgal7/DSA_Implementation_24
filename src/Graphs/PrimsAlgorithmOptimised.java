package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PrimsAlgorithmOptimised {
	
	static Scanner scn = new Scanner(System.in);
	static HashMap<Integer, List<Pair>> adjList = new HashMap<>();
	static ArrayList<Integer> parent = new ArrayList<>();
	static ArrayList<Boolean> mst = new ArrayList<>();
	
	public static class Pair implements Comparable<Pair> {
		int node;
		int weight;
		
		public Pair(int node, int weight) {
			this.node = node;
			this.weight = weight;
		}

		@Override
		public int compareTo(Pair other) {
			// TODO Auto-generated method stub
			return Integer.compare(this.weight, other.weight);
		}
	}
	
	public static void prepareAdjList(int u, int v, int weight) {
        Pair nodeWithWeight1 = new Pair(v, weight);
        Pair nodeWithWeight2 = new Pair(u, weight);
        adjList.computeIfAbsent(u, k -> new ArrayList<>()).add(nodeWithWeight1);
        adjList.computeIfAbsent(v, k -> new ArrayList<>()).add(nodeWithWeight2);
    }
	
	public static ArrayList<Integer> primsAlgo(int source, ArrayList<Integer> parent, ArrayList<Boolean> mst) {
		
		// make a priority queue and add (source,0) initially
		PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(source, 0));
        
        int minCostOfMST = 0;
		
        while(!pq.isEmpty()) {
        	
        	Pair front = pq.poll();
        	
        	int frontNode = front.node;
        	int frontWeight = front.weight;
        	
        	// process edges
        	
        	if(mst.get(frontNode)) {
        		continue;
        	}
        	
        	minCostOfMST += frontWeight;
        	mst.set(frontNode, true);
        	
        	// process edges
        	
        	for (Pair edge : adjList.getOrDefault(frontNode, new ArrayList<>())) {
        	    int edgeNode = edge.node;
        	    int edgeWeight = edge.weight;

        	    if (!mst.get(edgeNode)) { // Only consider unvisited nodes
        	        pq.add(new Pair(edgeNode, edgeWeight));
        	        
        	        // Update parent only when visiting a node for the first time
        	        if (parent.get(edgeNode) == -1) { 
        	            parent.set(edgeNode, frontNode);
        	        }
        	    }
        	}
        	
        }
        
        System.out.println("Minimum Cost of MST is: " + minCostOfMST);
		
        return parent;
	}
	
	public static void main(String[] args) {
		
		
		System.out.println("Enter the number of nodes");
		int numberOfNodes = scn.nextInt();
		System.out.println("Enter the number of edges");
		int numberOfEdges = scn.nextInt();
		
		for (int i = 0; i < numberOfEdges; i++) {

            int u = scn.nextInt();
            int v = scn.nextInt();
            int wt = scn.nextInt();
            prepareAdjList(u, v, wt);
        }
		
		for(int i=0; i<numberOfNodes; i++) {
			parent.add(i, -1);
			mst.add(i, false);
		}
		
		parent = primsAlgo(0, parent, mst);
		System.out.println("\n");
		
		for(int i=0; i<parent.size(); i++) {
			System.out.println("Parent of " + i + " is: " + parent.get(i));
		}
	}
}
