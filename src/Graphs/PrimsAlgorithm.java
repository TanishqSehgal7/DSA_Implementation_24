package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;


public class PrimsAlgorithm {

	static Scanner scn = new Scanner(System.in); 
    static HashMap<Integer, List<Pair>> adjList = new HashMap<>();
    static int numberOfNodes;
    static int numberOfEdges;
    static int[] parent;
    static int[] key;
    static boolean[] mst;

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

    public static int[] primsAlgo(int key[], int parent[], boolean mst[]) {

        for (int count = 0; count < numberOfNodes; count++) {

            // Find the minimum key value among non-MST nodes
            int mini = Integer.MAX_VALUE;
            int u = 0;

            for (int i = 0; i < numberOfNodes; i++) {
                if (!mst[i] && key[i] < mini) {
                    mini = key[i];
                    u = i;
                }
            }

            System.out.println("Selected minimum node: " + u + " with key value: " + mini);

            // Mark the selected node as part of MST
            mst[u] = true;

            // Update key values for the neighbors
            for (Pair neighbour : adjList.getOrDefault(u, new ArrayList<>())) {

                int node = neighbour.node;
                int weight = neighbour.weight;

                if (!mst[node] && weight < key[node]) {
                    System.out.println("Updating node: " + node + " with parent: " + u + " and weight: " + weight);
                    parent[node] = u;
                    key[node] = weight;
                }
            }
        }
        return parent;
    }

    public static void main(String[] args) {
    	
    	System.out.println("Enter Number Of Nodes:\n");
    	numberOfNodes = scn.nextInt();
    	System.out.println("Enter Number of Edges:\n");
    	numberOfEdges = scn.nextInt();
    	
    	parent = new int[numberOfNodes];
    	key = new int[numberOfNodes];
    	mst = new boolean[numberOfNodes];

        for (int i = 0; i < numberOfNodes; i++) {
            parent[i] = -1;
            mst[i] = false;
            key[i] = Integer.MAX_VALUE;
        }

        System.out.println("Enter the value of source:");
        int source = scn.nextInt();
        key[source] = 0;

        for (int i = 0; i < numberOfEdges; i++) {

            int u = scn.nextInt();
            int v = scn.nextInt();
            int wt = scn.nextInt();
            prepareAdjList(u, v, wt);
        }
        

        for (Entry<Integer, List<Pair>> entry : adjList.entrySet()) {
            System.out.println("Printing values for key " + entry.getKey());
            for (Pair pair : entry.getValue()) {
                System.out.println(pair.node + " has weight " + pair.weight);
            }
        }

        parent = primsAlgo(key, parent, mst);

        System.out.println("Parent array:");
        for (int i = 0; i < parent.length; i++) {
            System.out.println(i + " has parent " + parent[i]);
        }
    }
}


//5 6
//0 1 2
//0 3 6
//1 3 8
//1 4 5
//1 2 3
//2 4 7

