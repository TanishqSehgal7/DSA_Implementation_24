package Graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Map.Entry;
import java.util.PriorityQueue;


public class KruskalsAlgo {

	static Scanner scn = new Scanner(System.in);
	static List<Edge> edges = new ArrayList<>();
	static List<Edge> mst = new ArrayList<>();
	
	public static class Edge implements Comparable<Edge> {
		int u;
		int v;
		int weight;

		public Edge(int u, int v, int weight) {
			this.u = u;
			this.v = v;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge other) {
			// TODO Auto-generated method stub
			return Integer.compare(this.weight, other.weight);
		}
	}
	
	public static class DisjointSetUnion {
		
		static int parent[];
		static int rank[];
		
		public DisjointSetUnion(int size) {
			this.parent = new int[size];
			this.rank = new int[size];
			
			for(int i=0; i<size; i++) {
				parent[i] = i;
				rank[i] = 0;
			}
		}
		
		public static int findParentForPathComparession(int node) {
			
			// recursive call till we find the top most parent
			
			if(parent[node] != node) {
				parent[node] = findParentForPathComparession(parent[node]);
			}
			return parent[node];
		}
		
		public static boolean union(int u, int v) {
			int rootU = findParentForPathComparession(u);
			int rootV = findParentForPathComparession(v);
			
			if(rootU == rootV) {
				return false;
			}
			
			if(rank[rootU] < rank[rootV]) {
				parent[rootU] = rootV;
			} else if(rank[rootU] > rank[rootV]) {
				parent[rootV] = rootU;
			} else {
				parent[rootV] = parent[rootU];
				rank[rootU]++;
			}
			
			return true;
		}
	}
	
	public static void KruskalsAlgorithm(int numberOfNodes) {
		
		Collections.sort(edges);
		DisjointSetUnion dsu = new DisjointSetUnion(numberOfNodes);
		int mstCost = 0;
		
		for(Edge edge: edges) {
			
			if(DisjointSetUnion.union(edge.u, edge.v)) {
				mst.add(edge);
				mstCost+= edge.weight;
			}
		}
		
		for(Edge edge: mst) {
			System.out.println("Edge " + edge.u + "->" + edge.v + " has weight " + edge.weight);
		}
		System.out.println("Minimum Cost of Spanning Tree is: " + mstCost);
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
			edges.add(new Edge(u,v,wt));
		}
		
		KruskalsAlgorithm(numberOfEdges);
	}

}
