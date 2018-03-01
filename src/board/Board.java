package board;

import objects.*;

public class Board {
	
	public static void welcome() {
		System.out.println("===================================");
		System.out.println();
		System.out.println("WELCOME TO CHESS");
		System.out.println("By: Alex Louie + Kush Patel");
		System.out.println();
		System.out.println("===================================");
		System.out.println();
	}
	
	public static Piece[][] buildBoard() {
		Piece[][] board = new Piece[8][8];
		
		// Set Null
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				board[x][y] = new Pawn(x, y, true);
			}
		}
		
		return board;
	}
	
	public static void printBoard(Piece[][] board) {
		// PRINT BOARD
		int n = 8;
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				
				System.out.print("-" + y + "-");
				
				// BORDER: LEFT (Numbers)
				if (y == 7) {
					System.out.print(" " + n);
					n--;
				}
				// BORDER: LEFT (Numbers)
			}
			System.out.println();
			
			// BORDER: TOP (Letters)
			if (x == 7) {
				char l = 'a';
				for (int bord = 0; bord < 8; bord++) {
					System.out.print(" " + l + " ");
					l = (char) (l + 1);
				}
				System.out.println();
			}
			// BORDER: TOP (Letters)
		}
	}
	
	public boolean isEmpty(Piece[][] board, int x, int y) {
		if (board[x][y] == null) {
			return true;
		}
		
		return false;
	}
}
