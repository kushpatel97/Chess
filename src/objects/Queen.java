package objects;

import board.Board;

public class Queen extends Piece {
	// int x
	// int y
	// boolean firstmove = false;
	// boolean team;
	// boolean alive = true;
	
	public Queen(int x, int y, boolean team) {
		this.x = x;
		this.y = y;
		
		this.team = team;
		firstmove = true;
	}

	private boolean lineCheck(Piece[][] board, int oldx, int oldy, int x, int y, int dir) {
		// 1 (northeast) 2 (southeast) 3 (southwest) 4 (northwest) 5 (right) 6 (left) 7 (up) 8 (down)
				if (dir == 1) {
					while (oldx != (x+1) && oldy != (y-1)) {
						oldx--; 
						oldy++;
						if (!Board.isEmpty(board, oldx, oldy)) {
							return false;
						}
					}
				} else if (dir == 2) {
					while (oldx != (x-1) && oldy != (y-1)) {
						oldx++; 
						oldy++;
						if (!Board.isEmpty(board, oldx, oldy)) {
							return false;
						}
					}
				} else if (dir == 3) {
					while (oldx != (x-1) && oldy != (y+1)) {
						oldx++; 
						oldy--;
						if (!Board.isEmpty(board, oldx, oldy)) {
							return false;
						}
					}
				} else if (dir == 4) {
					while (oldx != (x+1) && oldy != (y+1)) {
						oldx--; 
						oldy--;
						if (!Board.isEmpty(board, oldx, oldy)) {
							return false;
						}
					}
				} else if (dir == 5) {
					while (oldy != (y-1)) {
						oldy++;
						if (!Board.isEmpty(board, oldx, oldy)) {
							return false;
						}
					}
				} else if (dir == 6) {
					while (oldy != (y+1)) {
						oldy--;
						if (!Board.isEmpty(board, oldx, oldy)) {
							return false;
						}
					}
				} else if (dir == 7) {
					while (oldx != (x+1)) {
						oldx--;
						if (!Board.isEmpty(board, oldx, oldy)) {
							return false;
						}
					}
				} else if (dir == 8) {
					while (oldx != (x-1)) {
						oldx++;
						if (!Board.isEmpty(board, oldx, oldy)) {
							return false;
						}
					}
				} else {
					return false;
				}
				
				return true;
	}
	
	private boolean isPathClear(Piece[][] board, int x, int y) {
		int oldx = this.x;
		int oldy = this.y;
		
		int deltax = Math.abs(x - oldx);
		int deltay = Math.abs(y - oldy);
		
		int dx = oldx - x;
		int dy = oldy - y;
		
		
		if (deltax == 0 && deltay != 0) { // horizontal
			if (dy < 0) { // moving right
				return lineCheck(board, oldx, oldy, x, y, 5);
			} else { // moving left
				return lineCheck(board, oldx, oldy, x, y, 6);
			}
		} else if (deltax != 0 && deltay == 0) { // vertical
			if (dx > 0) { // moving up
				return lineCheck(board, oldx, oldy, x, y, 7);
			} else { // moving down
				return lineCheck(board, oldx, oldy, x, y, 8);
			}
		} else if (deltax == deltay) { // diagonal
			if (dx > 0 && dy < 0) {
				return lineCheck(board, oldx, oldy, x, y, 1);
			} else if (dx < 0 && dy < 0) {
				return lineCheck(board, oldx, oldy, x, y, 2);
			} else if (dx < 0 && dy > 0) {
				return lineCheck(board, oldx, oldy, x, y, 3);
			} else if (dx > 0 && dy > 0) {
				return lineCheck(board, oldx, oldy, x, y, 4);
			}
		}
		
		return false;
	}
	
	@Override
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
	}
	
	
}
