package objects;

import board.Board;

public class King extends Piece {

	public King(int x, int y, boolean team) {
		this.x = x;
		this.y = y;
		
		this.team = team;
	}
	
	private boolean isPathClear(Piece[][] board, int x, int y) {
		int oldx = this.x;
		int oldy = this.y;
		
		int deltax = Math.abs(x - oldx);
		int deltay = Math.abs(y - oldy);
		
		if ((deltax == deltay) || (deltax == 1 && deltay == 0) || (deltax == 0 && deltay == 1)) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public void move(Piece[][] board, int x, int y) {
		// TODO Auto-generated method stub
		int oldx = this.x;
		int oldy = this.y;
		
		if (isPathClear(board, x, y)) {
			// Move 
			if (Board.isEmpty(board, x, y)) {
				board[oldx][oldy].update(board, x, y);
				return;
			}
			
			// Kill
			if (board[oldx][oldy].isOppositeTeam(board[x][y])) {
				board[oldx][oldy].kill(board, this.x, this.y, x, y);
				return;
			} else {
				System.out.println("Invalid Move: same team blocking");
				return;
			}
		} else {
			System.out.println("Invalid Move");
			return;
		}
	}

}
