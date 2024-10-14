package Recursion;

import java.util.ArrayList;
import java.util.List;

public class SudokuSolver {

	public static boolean sudokuSolver(int [][] board) {
		
		int n = board.length;

		// Find the first empty cell (marked as 0)
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < n; col++) {
				if (board[row][col] == 0) {
					
					// Try placing numbers 1 to 9
					for (int val = 1; val <= 9; val++) {
						if (isSafe(row, col, board, val)) {
							board[row][col] = val;  // Place the value

							// Recursively solve the rest of the board
							if (sudokuSolver(board)) {
								return true;  // If solved, return true
							}

							// Backtrack if placing val doesn't lead to a solution
							board[row][col] = 0;
						}
					}
					return false;  // If no valid number can be placed, backtrack
				}
			}
		}
		return true;  // If all cells are filled, the puzzle is solved
	}
	
	public static boolean isSafe(int row, int col, int[][] board, int val) {
		
		int n = board.length;

		// Check the row and column
		for (int i = 0; i < n; i++) {
			if (board[row][i] == val || board[i][col] == val) {
				return false;
			}
		}

		// Check the 3x3 sub-grid
		int subGridRow = 3 * (row / 3);
		int subGridCol = 3 * (col / 3);
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[subGridRow + i][subGridCol + j] == val) {
					return false;
				}
			}
		}

    	return true;  // Value is safe to place
	}
	
	
	public static void solveSudoku(int board [][]) {
		sudokuSolver(board);
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
		
		solveSudoku(board);
		
		for(int row = 0; row < board.length; row++) {
			for(int col = 0; col < board[0].length; col++) {
				System.out.print(board[row][col] + " ");
			}	
			System.out.println();
		}

	}

}
