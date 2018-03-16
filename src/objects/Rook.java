package objects;

import board.Board;

public class Rook extends Piece {
	public Rook(int x, int y, boolean team) {
		this.x = x;
		this.y = y;
		
		this.team = team;
	}
	
	private boolean lineCheck(Piece[][] board, int oldx, int oldy, int x, int y, int dir) {
		// 5 (east) 6 (west) 7 (north) 8 (south)
		if (dir == 5) {
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
			System.out.println("Code Input Error: Dir not set properly.");
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
	
	
	
	
//	@Override
//	public void move(Piece[][] board, int x, int y) {
//		// TODO Auto-generated method stub
//		int oldx = this.x;
//		int oldy = this.y;
//		
//		boolean dir; // true - positive | false - negative (up, right)
//		
//		if (((oldx - x == 0) && (oldy - y != 0)) || ((oldx - x != 0) && (oldy - y == 0))) { // moves in one direction
//			if (oldx - x == 0) { // moving horizontally
//				System.out.println("HORIZONTAL");
//				if (oldy - y < 0) dir = true;
//				else dir = false;
//				
//				if (dir) { // GOING RIGHT
//					// check condition
//					 for (int i = oldy+1; i < y; i++) {
//						 if (!Board.isEmpty(board, x, i)) {
//							 System.out.println("MOVE DOES NOT WORKbbb");
//							 return;
//						 }
//					 }
//					 if (!Board.isEmpty(board, x, y)) {
//						 if (board[oldx][oldy].isOppositeTeam(board[x][y])) {
//							 // kill
//							 board[oldx][oldy].kill(board, this.x, this.y, x, y);
//						 } else {
//							 // spot is filled w teammate
//							 System.out.println("MOVE DOES NOT WORKzzz");
//							 return;
//						 }
//					 } else {
//						 // update location
//						 board[oldx][oldy].update(board, x, y);
//					 }
//					 
//				} else { // GOING LEFT
//					// check condition
//					for (int i = oldy-1; i > y; i--) {
//						 if (!Board.isEmpty(board, x, i)) {
//							 System.out.println("MOVE DOES NOT WORK");
//							 return;
//						 }
//					}
//					if (!Board.isEmpty(board, x, y)) {
//						 if (board[oldx][oldy].isOppositeTeam(board[x][y])) {
//							 // kill
//							 board[oldx][oldy].kill(board, this.x, this.y, x, y);
//						 } else {
//							 // spot is filled w teammate
//							 System.out.println("MOVE DOES NOT WORKzzz");
//							 return;
//						 }
//					 } else {
//						 // update location
//						 board[oldx][oldy].update(board, x, y);
//					 }
//				}
//				
//				
//			} else { // moving vertically
//				System.out.println("VERTICAL");
//				if (oldx - x > 0) dir = true;
//				else dir = false;
//				
//				if (dir) { // GOING UP
//					// check condition
//					for (int i = oldx-1; i > x; i--) {
//						 if (!Board.isEmpty(board, i, y)) {
//							 System.out.println("MOVE DOES NOT WORKaaaa");
//							 return;
//						 }
//					}
//					if (!Board.isEmpty(board, x, y)) {
//						 if (board[oldx][oldy].isOppositeTeam(board[x][y])) {
//							 // kill
//							 board[oldx][oldy].kill(board, this.x, this.y, x, y);
//						 } else {
//							 // spot is filled w teammate
//							 System.out.println("MOVE DOES NOT WORKzzz");
//							 return;
//						 }
//					 } else {
//						 // update location
//						 board[oldx][oldy].update(board, x, y);
//					 }
//				} else { // GOING DOWN
//					// check condition
//					for (int i = oldx+1; i < x; i++) {
//						 if (!Board.isEmpty(board, i, y)) {
//							 System.out.println("MOVE DOES NOT WORKhhhh");
//							 return;
//						 }
//					}
//					if (!Board.isEmpty(board, x, y)) {
//						 if (board[oldx][oldy].isOppositeTeam(board[x][y])) {
//							 // kill
//							 board[oldx][oldy].kill(board, this.x, this.y, x, y);
//						 } else {
//							 // spot is filled w teammate
//							 System.out.println("MOVE DOES NOT WORKzzz");
//							 return;
//						 }
//					 } else {
//						 // update location
//						 board[oldx][oldy].update(board, x, y);
//					 }
//				}
//				
//				
//			}
//			
//			
//			
//		}
//		
//	}
//
