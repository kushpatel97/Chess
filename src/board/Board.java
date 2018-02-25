package board;

import objects.Piece;

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
				board[x][y] = null;
			}
		}

		// PRINT BOARD
		int n = 1;
		for (int x = 0; x < 8; x++) {
			
			// BORDER: TOP (Letters)
			if (x == 0) {
				System.out.print("   ");
				char l = 'A';
				for (int bord = 0; bord < 8; bord++) {
					System.out.print("*" + l + "*");
					l = (char) (l + 1);
				}
				System.out.println();
			}
			// BORDER: TOP (Letters)
			
			for (int y = 0; y < 8; y++) {
				// BORDER: LEFT (Numbers)
				if (y == 0) {
					System.out.print("*" + n + "*");
					n++;
				}
				// BORDER: LEFT (Numbers)
				
				System.out.print("-" + y + "-");
			}
			System.out.println();
		}
		
		return board;
	}
	
	public boolean isEmpty(Piece[][] board, int x, int y) {
		if (board[x][y] == null) {
			return true;
		}
		
		return false;
	}
}
