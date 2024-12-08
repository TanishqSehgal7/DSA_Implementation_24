package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Map.Entry;
import java.util.PriorityQueue;


public class DijkstrasAlgorithmForShortestDistances {

	
	static Scanner scn = new Scanner(System.in);
	static PriorityQueue<Pair> pq = new PriorityQueue<>();
	static HashMap<Integer, List<Pair>> adjList = new HashMap<>();
	static HashMap<Integer, Integer> distanceMap = new HashMap<>();
	
	public static class Pair implements Comparable<Pair> {
        int node;
        int weight;

        public Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Pair other) {
            return Integer.compare(this.weight, other.weight); // Sort by weight (distance)
        }
    }

    public static void prepareAdjList(int u, int v, int weight) {
        Pair nodeWithWeight1 = new Pair(v, weight);
        Pair nodeWithWeight2 = new Pair(u, weight);
        adjList.computeIfAbsent(u, k -> new ArrayList<>()).add(nodeWithWeight1);
        adjList.computeIfAbsent(v, k -> new ArrayList<>()).add(nodeWithWeight2);
    }

    public static void dijkstrasAlgoForShortestDistances(int source) {

    	// add source with distance 0 to distanceMap
        distanceMap.put(source, 0);
        pq.add(new Pair(source,0));
        
        while(!pq.isEmpty()) {
        	
        	Pair top = pq.poll();
        	
        	int topNode = top.node;
        	int topNodeWeight = top.weight;
        	
        	for(Pair neighbor: adjList.getOrDefault(topNode, new ArrayList<>())) {
        		
        		int newMinDistance = topNodeWeight + neighbor.weight;
        		
        		if(newMinDistance < distanceMap.getOrDefault(neighbor.node, Integer.MAX_VALUE)) {
        			distanceMap.put(neighbor.node, newMinDistance);
        			pq.add(new Pair(neighbor.node, newMinDistance));
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
			distanceMap.put(i, Integer.MAX_VALUE);
		}
		
		for(Entry<Integer, List<Pair>> entry: adjList.entrySet()) {
			System.out.println("Printing values for key " + entry.getKey());
			for(Pair pair: entry.getValue()) {
				System.out.println(pair.node + " has weight " + pair.weight);
			}
		}
		
		int source = 0;
        dijkstrasAlgoForShortestDistances(source);

        System.out.println("Shortest distances from source " + source + ":");
        for (Entry<Integer, Integer> entry : distanceMap.entrySet()) {
            System.out.println("Node " + entry.getKey() + " -> Distance: " + entry.getValue());
        }
	}
	
}


//4 5
//1 3 2
//1 2 9
//0 1 5
//0 2 8
//2 3 6
