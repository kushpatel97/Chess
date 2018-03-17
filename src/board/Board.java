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
	}
	
	public static Piece[][] buildBoard() {
		Piece[][] board = new Piece[8][8];
		
		// Set Init Null
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				board[x][y] = null;
			}
		}
		
		// Black Pieces
		board[1][0] = new Pawn(1, 0, false);
		board[1][1] = new Pawn(1, 1, false);
		board[1][2] = new Pawn(1, 2, false);
		board[1][3] = new Pawn(1, 3, false);
		board[1][4] = new Pawn(1, 4, false);
		board[1][5] = new Pawn(1, 5, false);
		board[1][6] = new Pawn(1, 6, false);
		board[1][7] = new Pawn(1, 7, false);
		
		board[0][0] = new Rook(0, 0, false);
		board[0][1] = new Knight(0, 1, false);
		board[0][2] = new Bishop(0, 2, false);
		board[0][3] = new Queen(0, 3, false);
		board[0][4] = new King(0, 4, false);
		board[0][5] = new Bishop(0, 5, false);
		board[0][6] = new Knight(0, 6, false);
		board[0][7] = new Rook(0, 7, false);
		
		// White Pieces
		board[6][0] = new Pawn(6, 0, true);
		board[6][1] = new Pawn(6, 1, true);
		board[6][2] = new Pawn(6, 2, true);
		board[6][3] = new Pawn(6, 3, true);
		board[6][4] = new Pawn(6, 4, true);
		board[6][5] = new Pawn(6, 5, true);
		board[6][6] = new Pawn(6, 6, true);
		board[6][7] = new Pawn(6, 7, true);
		
		board[7][0] = new Rook(7, 0, true);
		board[7][1] = new Knight(7, 1, true);
		board[7][2] = new Bishop(7, 2, true);
		board[7][3] = new Queen(7, 3, true);
		board[7][4] = new King(7, 4, true);
		board[7][5] = new Bishop(7, 5, true);
		board[7][6] = new Knight(7, 6, true);
		board[7][7] = new Rook(7, 7, true);
		
		return board;
	}
	
	// Helper for printBoard
	private static void printName(Piece spot, char piece) {
		boolean team = spot.getTeam();
		if (team == true) { // white
			System.out.print("w" + piece + " ");
		} else { // black
			System.out.print("b" + piece + " ");
		}
	}
	
	// Checkered Pattern for printBoard
	private static void printChecker(int x, int y) {
		if (x % 2 == 0) {
			if (y % 2 == 0) {
				System.out.print("   ");
			}
			else {
				System.out.print("## ");
			}
		} else if (x % 2 == 1) {
			if (y % 2 == 0) {
				System.out.print("## ");
			} 
			else {
				System.out.print("   ");
			}
		}
		
	}
	
	public static void printBoard(Piece[][] board) {
		// PRINT BOARD
		int n = 8;
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				
				if (board[x][y] instanceof Pawn) {
					printName(board[x][y], 'P');
				} 
				else if (board[x][y] instanceof Rook) {
					printName(board[x][y], 'R');
				}
				else if (board[x][y] instanceof Knight) {
					printName(board[x][y], 'N');
				}
				else if (board[x][y] instanceof Bishop) {
					printName(board[x][y], 'B');
				}
				else if (board[x][y] instanceof Queen) {
					printName(board[x][y], 'Q');
				}
				else if (board[x][y] instanceof King) {
					printName(board[x][y], 'K');
				}
				else {
					printChecker(x, y);
				}

				// BORDER: RIGHT (Numbers)
				if (y == 7) {
					System.out.print(n);
					n--;
				}
				// BORDER: RIGHT (Numbers)
			}
			System.out.println();
			
			// BORDER: BOTTOM (Letters)
			if (x == 7) {
				char l = 'a';
				for (int bord = 0; bord < 8; bord++) {
					System.out.print(" " + l + " ");
					l = (char) (l + 1);
				}
				System.out.println();
			}
			// BORDER: BOTTOM (Letters)
		}
		System.out.println();
	}
	
	public static boolean isEmpty(Piece[][] board, int x, int y) {
		if (board[x][y] == null) {
			return true;
		}
		
		return false;
	}
	
	
	// Translates human input to board language - string must be inputted correctly
	public static int[] translate(String s) {
		int[] arr = new int[4];
		
		char a1 = (char) (s.charAt(0)-49);
		arr[1] = Character.getNumericValue(a1);
		arr[0] = 8 - Character.getNumericValue(s.charAt(1));
		char a3 = (char) (s.charAt(3)-49);
		arr[3] = Character.getNumericValue(a3);
		arr[2] = 8 - Character.getNumericValue(s.charAt(4));
		
		return arr;
	}
	
}


