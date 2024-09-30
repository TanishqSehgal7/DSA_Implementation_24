package Recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RatInAMaze {
	
	public static List<String> findPath(int M[][], int N) {
		
		List<String> ans = new ArrayList<>(); // list of all the paths
		
		// starting point
		int srcx=0;
		int srcy=0;
		
		// if src index value initially is 0, so rat cannot enter maze
		if(M[0][0] == 0) {
			return ans; // return empty list in this case
		}
		
		
		// by default array is initialized with 0 in java
		boolean visited[][] = new boolean[N][N];
		
		String path = "";
		
		solve(M,N,srcx,srcy,ans,visited,path);
		
		Collections.sort(ans); // sort list lexicographically
		//or
//		ans.sort(Comparator.naturalOrder());
		
		return ans;
	}
	
	
	public static void solve(int M[][], int N, int x, int y, List<String> ans, boolean visited[][], String path) {
		
		// base case -> destination is reached
		if(x == N-1 && y == N-1) {
			ans.add(path);
			return;
		}
		
		visited[x][y] = true; // mark visited place as true
		
		// we have 4 choices to move - D L R U
		
		// down
		int newX = x+1;
		int newY = y;
		if(isSafe(newX, newY, N, visited, M)) {
			path+='D';
			solve(M,N,newX,newY,ans,visited,path);
			path = path.substring(0, path.length()-1); // remove last added direction for backtracking
		}
		
		// left
		newX = x;
		newY = y-1;
		if(isSafe(newX, newY, N, visited, M)) {
			path+='L';
			solve(M,N,newX,newY,ans,visited,path);
			path = path.substring(0, path.length()-1); // remove last added direction for backtracking
		}
		
		// right
		newX = x;
		newY = y+1;
		if(isSafe(newX, newY, N, visited, M)) {
			path+='R';
			solve(M,N,newX,newY,ans,visited,path);
			path = path.substring(0, path.length()-1); // remove last added direction for backtracking
		}
		
		// up
		newX = x-1;
		newY = y;
		if(isSafe(newX, newY, N, visited, M)) {
			path+='U';
			solve(M,N,newX,newY,ans,visited,path);
			path = path.substring(0, path.length()-1); // remove last added direction for backtracking
		}
		
		
		visited[x][y] = false; // backtrack the visited place and mark false for making a new solution
		
	}
	
	
	public static boolean isSafe(int x, int y, int N, boolean visited[][], int M[][]) {
		
		if((x>=0 && x<N) && (y>=0 && y<N) && visited[x][y] == false && M[x][y] == 1) {
			// safe to move
			return true;
		} else {
			return false;
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int N =  4;
		
		int M [][] = {{1,0,0,0}, {1,1,0,1}, {1,1,0,0}, {0,1,1,1}};
		
		System.out.println(findPath(M,N));
		
	}

}
