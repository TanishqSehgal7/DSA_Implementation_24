package Recursion;

import java.util.ArrayList;
import java.util.List;

public class SudokuSolver {

	public static boolean sudokuSolver(int [][] board) {
		
		int n = board[0].length;
		
		for(int row = 0; row<n; row++) {
			for(int col = 0; col < n; col++) {
				
				if(board[row][col] == 0) {
					
					for(int val = 0; val <=9; val++) {
						if(isSafe(row, col, board, val)) {
							board[row][col] = 1;
						}
						
						// recursive call
						boolean isSolutionPossibleFurther = sudokuSolver(board);
						
						if(isSolutionPossibleFurther) {
							return true;
						} else {
							// backtrack
							board[row][col] = 0;
						}
					}
				}
				
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean isSafe(int row, int col, int[][] board, int val) {
		
		for(int i = 0; i<board[0].length; i++) {
			
			if(board[row][i] == val) { // check if column contains value
				return false;
			} else if(board[i][col] == val) { // check if row contains value
				return false;
			} else if(board[3*(row/3) + i/3][(3*(col/3) + i%3)] == val) {
				return false;
			}
		}
		return true;
	}
	
	
	
	public static void main(String[] args) {
		
		
		int[][] board = 
			   {{5,3,0,0,7,0,0,0,0},
				{6,0,0,1,9,5,0,0,0},
				{0,9,8,0,0,0,0,6,0},
				{8,0,0,0,6,0,0,0,3},
				{4,0,0,8,0,3,0,0,1},
				{7,0,0,0,2,0,0,0,6},
				{0,6,0,0,0,0,2,8,0},
				{0,0,0,4,1,9,0,0,5},
				{0,0,0,0,8,0,0,7,9}};
		
		System.out.println(sudokuSolver(board));
		
		for(int row = 0; row<board.length; row++) {
			for(int col = 0; col < board[0].length; col++) {
				System.out.print(board[row][col] + " ");
			}	
			System.out.println();
		}

	}

}
