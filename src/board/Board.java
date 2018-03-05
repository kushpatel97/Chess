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
		
		// Set Init Null
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				board[x][y] = null;
			}
		}
		
		// White Pieces
		board[1][0] = new Pawn(1, 0, true);
		board[1][1] = new Pawn(1, 1, true);
		board[1][2] = new Pawn(1, 2, true);
		board[1][3] = new Pawn(1, 3, true);
		board[1][4] = new Pawn(1, 4, true);
		board[1][5] = new Pawn(1, 5, true);
		board[1][6] = new Pawn(1, 6, true);
		board[1][7] = new Pawn(1, 7, true);
		
		board[0][0] = new Rook(0, 0, true);
		board[0][1] = new Knight(0, 1, true);
		board[0][2] = new Bishop(0, 2, true);
		board[0][3] = new Queen(0, 3, true);
		board[0][4] = new King(0, 4, true);
		board[0][5] = new Bishop(0, 5, true);
		board[0][6] = new Knight(0, 6, true);
		board[0][7] = new Rook(0, 7, true);
		
		// Black Pieces
		board[6][0] = new Pawn(6, 0, false);
		board[6][1] = new Pawn(6, 1, false);
		board[6][2] = new Pawn(6, 2, false);
		board[6][3] = new Pawn(6, 3, false);
		board[6][4] = new Pawn(6, 4, false);
		board[6][5] = new Pawn(6, 5, false);
		board[6][6] = new Pawn(6, 6, false);
		board[6][7] = new Pawn(6, 7, false);
		
		board[7][0] = new Rook(7, 0, false);
		board[7][1] = new Knight(7, 1, false);
		board[7][2] = new Bishop(7, 2, false);
		board[7][3] = new Queen(7, 3, false);
		board[7][4] = new King(7, 4, false);
		board[7][5] = new Bishop(7, 5, false);
		board[7][6] = new Knight(7, 6, false);
		board[7][7] = new Rook(7, 7, false);
		
		return board;
	}
	
	public static void printBoard(Piece[][] board) {
		// PRINT BOARD
		int n = 8;
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				
				if (board[x][y] instanceof Pawn) {
					System.out.print("-P-");
				} 
				else if (board[x][y] instanceof Rook) {
					System.out.print("-R-");
				}
				else if (board[x][y] instanceof Knight) {
					System.out.print("-K-");
				}
				else if (board[x][y] instanceof Bishop) {
					System.out.print("-B-");
				}
				else if (board[x][y] instanceof Queen) {
					System.out.print("-Q-");
				}
				else if (board[x][y] instanceof King) {
					System.out.print("-T-");
				}
				else {
					System.out.print("-x-");
				}

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
	
	public static boolean isEmpty(Piece[][] board, int x, int y) {
		if (board[x][y] == null) {
			return true;
		}
		
		return false;
	}
}
