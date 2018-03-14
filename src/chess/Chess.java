package chess;

import objects.*;
import board.*;

public class Chess {
	public static void main (String args[]) {
		Board.welcome();
		
		Piece[][] board = Board.buildBoard();	
		Board.printBoard(board);
		
		board[0][1].move(board, 2, 2);
		Board.printBoard(board);
		
		//board[1][2].move(board, 3, 2);
		//Board.printBoard(board);
		
		//board[6][1].move(board, 4, 1);
		//Board.printBoard(board);
		
		//board[3][2].move(board, 4, 1);
		//Board.printBoard(board);
		
		//board[4][1].move(board, 5, 1);
		//Board.printBoard(board);
		
		//board[6][2].move(board, 5, 1);
		//Board.printBoard(board);
		
		//board[4][1].move(board, 3, 1);
		//Board.printBoard(board);
		
	}


}
