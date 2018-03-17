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
	public boolean move(Piece[][] board, int x, int y) {
		// TODO Auto-generated method stub
		
		// BLACK PAWN
		if (this.team == false) {
			if (!(Board.isEmpty(board, x, y)) && board[x][y].team == true && (x - this.x == 1) && (Math.abs(y - this.y) == 1)) {
				board[x][y].kill(board, this.x, this.y, x, y);
				return true;
			}
			
			if (this.firstmove) { // can move 2 spaces forward
				if ((Board.isEmpty(board, x, y)) && (x - this.x == 1 || x - this.x == 2) && (y - this.y == 0)) {
					// Move the Piece
					board[this.x][this.y].update(board, x, y);
					return true;
				} else {
					return false;
				}
			} else {
				if ((Board.isEmpty(board, x, y)) && (x - this.x == 1) && (y - this.y == 0)) {
					// Move the Piece
					board[this.x][this.y].update(board, x, y);
					return true;
				} else {
					return false;
				}
			}
		// WHITE PAWN
		} else if (this.team == true) {
			if (!(Board.isEmpty(board, x, y)) && board[x][y].team == false && (this.x - x == 1) && (Math.abs(y - this.y) == 1)) {
				board[x][y].kill(board, this.x, this.y, x, y);
				return true;
			}	
			if (this.firstmove) { // can move 2 spaces forward
				if ((Board.isEmpty(board, x, y)) && (this.x - x == 1 || this.x - x == 2) && (y - this.y == 0)) {
					// Move the Piece
					board[this.x][this.y].update(board, x, y);
					return true;
				} else {
					return false;
				}
			} else {
				if ((Board.isEmpty(board, x, y)) && (this.x - x == 1) && (this.y - y == 0)) {
					// Move the Piece
					board[this.x][this.y].update(board, x, y);
					return true;
				} else {
					return false;
				}
			}
		}
		
		return false;
		
	}
	
	
}
