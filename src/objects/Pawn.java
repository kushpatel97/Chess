package objects;
import board.*;

public class Pawn extends Piece {
	// int x
	// int y
	// boolean firstmove = false;
	// boolean team;
	// boolean alive = true;
	
	public static boolean promotion = false;
	
	public Pawn(int x, int y, boolean team) {
		this.x = x;
		this.y = y;
		
		this.team = team;
	}
	
	@Override
	public boolean isPathClear(Piece[][] board, int x, int y) {
		// Black Pawn 
		if (this.team == false) {
			// diagonal kill
			if (!(Board.isEmpty(board, x, y)) && board[x][y].team == true && (x - this.x == 1) && (Math.abs(y - this.y) == 1)) return true;
			// move 2 spaces forward
			if (this.firstmove && Board.isEmpty(board, x, y) && Board.isEmpty(board, x-1, y) && (x - this.x == 1 || x - this.x == 2) && (y - this.y == 0)) return true;
			// move 1 space forward
			if ((Board.isEmpty(board, x, y)) && (x - this.x == 1) && (y - this.y == 0)) return true;
		} 
		// White Pawn
		else {
			// diagonal kill
			if (!(Board.isEmpty(board, x, y)) && board[x][y].team == false && (this.x - x == 1) && (Math.abs(y - this.y) == 1)) return true;
			// move 2 spaces forward
			if (this.firstmove && Board.isEmpty(board, x+1, y) && Board.isEmpty(board, x, y) && (this.x - x == 1 || this.x - x == 2) && (y - this.y == 0)) return true;
			// move 1 space forwrad
			if ((Board.isEmpty(board, x, y)) && (this.x - x == 1) && (this.y - y == 0)) return true;
		}
		
		return false;
	}
	
	/*@Override
	public boolean move(Piece[][] board, int x, int y) {
		// TODO Auto-generated method stub
		int oldx = this.x;
		int oldy = this.y;
		
		if (isPathClear(board, x, y)) {
			// Move 
			if (Board.isEmpty(board, x, y)) {
				board[oldx][oldy].update(board, x, y);
				return true;
			}
			
			// Kill
			if (board[oldx][oldy].isOppositeTeam(board[x][y])) {
				board[oldx][oldy].kill(board, this.x, this.y, x, y);
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}*/
	
	/*	@Override
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
		
	}*/
	
	
}
