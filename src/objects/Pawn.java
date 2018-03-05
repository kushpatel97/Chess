package objects;
import board.*;

public class Pawn extends Piece {
	// int x
	// int y
	// boolean firstmove = false;
	// boolean team;
	// boolean alive = true;
	
	public Pawn(int x, int y, boolean team) {
		this.x = x;
		this.y = y;
		
		this.team = team;
	}

	@Override
	public void move(Piece[][] board, int x, int y) {
		// TODO Auto-generated method stub
		
		// WHITE PAWN
		if (this.team == true) {
			if (!(Board.isEmpty(board, x, y)) && board[x][y].team == false && (x - this.x == 1) && (y - this.y == 1)) {
				System.out.println("AYE AYE CAPTAIN");
				board[x][y].update(board, x, y);
				return;
			}
			
			if (this.firstmove) { // can move 2 spaces forward
				if ((Board.isEmpty(board, x, y)) && (x - this.x == 1 || x - this.x == 2) && (y - this.y == 0)) {
					// Move the Piece
					System.out.println("VALID MOVE");
					board[this.x][this.y].update(board, x, y);
				} else {
					int bx = this.x - x;
					int by = this.y - y;
					System.out.println("X: " + bx);
					System.out.println("Y: " + by);
					System.out.println("Error. Not a valid move.");
				}
			} else {
				if ((Board.isEmpty(board, x, y)) && (x - this.x == 1) && (y - this.y == 0)) {
					// Move the Piece
					System.out.println("SUCCESSFUL MOVE!");
					board[this.x][this.y].update(board, x, y);
				} else {
					int bx = this.x - x;
					int by = this.y - y;
					System.out.println("X: " + bx);
					System.out.println("Y: " + by);
					System.out.println("Error. Not a valid move.");
				}
			}
		// BLACK PAWN
		} else if (this.team == false) {
			//black pieces
			if (this.firstmove) { // can move 2 spaces forward
				if ((Board.isEmpty(board, x, y)) && (this.x - x == 1 || this.x - x == 2) && (y - this.y == 0)) {
					// Move the Piece
					System.out.println("VALID MOVE");
					board[this.x][this.y].update(board, x, y);
				} else {
					int bx = this.x - x;
					int by = this.y - y;
					System.out.println("X: " + bx);
					System.out.println("Y: " + by);
					System.out.println("Error. Not a valid move.");
				}
			} else {
				if ((Board.isEmpty(board, x, y)) && (this.x - x == 1) && (this.y - y == 0)) {
					// Move the Piece
					System.out.println("SUCCESSFUL MOVE!");
					board[this.x][this.y].update(board, x, y);
				} else {
					int bx = this.x - x;
					int by = this.y - y;
					System.out.println("X: " + bx);
					System.out.println("Y: " + by);
					System.out.println("Error. Not a valid move.");
				}
			}
		}
		
	}
	
	
}
