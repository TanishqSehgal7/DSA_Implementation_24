package Recursion;

import java.util.ArrayList;
import java.util.List;

public class NQueenProblem {

	
	public static List<List<Integer>> nQueens(int n) {
		
		List<List<Integer>> board = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
	        List<Integer> row = new ArrayList<>();
	        for (int j = 0; j < n; j++) {
	            row.add(0);
	        }
	        board.add(row);
	    }
		
		
		List<List<Integer>> ans = new ArrayList<>();
		
		solve(0,ans,board,n);
		
		return ans;
	}
	
	
	public static void solve(int column, List<List<Integer>> ans, List<List<Integer>> board, int N) {
		
		if(column == N) {
			addSolution(board,ans, N);
			return;
		}
		
		for(int row=0; row<N; row++) {
			if(isSafe(row, column, board, N)) {
				board.get(row).set(column, 1);
				solve(column + 1, ans, board, N);
				// backtrack
				board.get(row).set(column, 0);
			}
		}
	}
	
	public static boolean isSafe(int row, int column, List<List<Integer>> board, int N) {
		
		int x = row;
		int y = column;
		
		// check for same row (to the left)
		while(y >= 0) {
			if(board.get(x).get(y) == 1) {
				return false;
			}
			
			y--;
		}
		
		// check for upper left diagonal 
		x = row; 
		y = column;
		while(x>=0 && y>=0) {
			if(board.get(x).get(y) == 1) {
				return false;
			}
			
			y--;
			x--;
		}
		
		// check for bottom left diagonal
		x = row; 
		y = column;
		while(x<N && y>=0) {
			if(board.get(x).get(y) == 1) {
				return false;
			}
			
			y--;
			x++;
		}
		
		return true;
	}
	
	
	public static void addSolution(List<List<Integer>> board, List<List<Integer>> ans, int N) {
		
		List<Integer> temp = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				temp.add(board.get(i).get(j));
			}
		}
		
		ans.add(temp);
	}
	
	
	public static void main(String[] args) {
		
		System.out.println(nQueens(4));
	}

}
