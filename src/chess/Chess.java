package chess;

import objects.*;
import board.*;

public class Chess {
	public static void main (String args[]) {
		Board.welcome();
		
		Piece[][] b = Board.buildBoard();	
		Board.printBoard(b);
		
	}


}
