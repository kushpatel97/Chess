package objects;

import board.Board;

public class King extends Piece {
	
	static boolean castle = false;
	
	public King(int x, int y, boolean team) {
		this.x = x;
		this.y = y;
		
		this.team = team;
	}
	
	@Override
	public boolean isPathClear(Piece[][] board, int x, int y) {
		int oldx = this.x;
		int oldy = this.y;
		
		int deltax = Math.abs(x - oldx);
		int deltay = Math.abs(y - oldy);
		
		if ((deltax == deltay) || (deltax == 1 && deltay == 0) || (deltax == 0 && deltay == 1)) {
			return true;
		}
		
		Piece king = board[oldx][oldy];
		// Castling
		
		// **NOTICE: must put extra check conditions in here
		if ((king.getTeam() == true && oldx == 7 && oldy == 4 && x == 7 && y == 6 && king.firstmove && board[x][y+1].firstmove) || (king.getTeam() == false && oldx == 0 && oldy == 4 && x == 0 && y == 6 && king.firstmove && board[x][y+1].firstmove)) {
			if (Board.isEmpty(board, oldx, oldy+1) && Board.isEmpty(board, oldx, oldy+2)) {
				castle = true;
				return true;
			}
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
				if (castle) {
					if (board[x][y].getTeam()) board[7][7].update(board, 7, 5);
					if (!board[x][y].getTeam()) board[0][7].update(board, 0, 5);
				}
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

}
