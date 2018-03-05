package chess;

import objects.*;
import board.*;

public class Chess {
	public static void main (String args[]) {
		Board.welcome();
		
		Piece[][] board = Board.buildBoard();	
		Board.printBoard(board);
		board[1][0].move(board, 2, 0);
		board[6][1].move(board, 4, 1);
		board[4][1].move(board, 3, 1);
		Board.printBoard(board);
		board[2][0].move(board, 3, 1);
		Board.printBoard(board);
	}


}
