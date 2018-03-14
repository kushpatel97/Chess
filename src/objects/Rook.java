package objects;

import board.Board;

public class Rook extends Piece {
	public Rook(int x, int y, boolean team) {
		this.x = x;
		this.y = y;
		
		this.team = team;
	}
	
	private boolean isPathClear(Piece[][] board, int x, int y) {
		return true;
	}
	
	@Override
	public void move(Piece[][] board, int x, int y) {
		// TODO Auto-generated method stub
		int oldx = this.x;
		int oldy = this.y;
		
		boolean dir; // true - positive | false - negative (up, right)
		
		if (((oldx - x == 0) && (oldy - y != 0)) || ((oldx - x != 0) && (oldy - y == 0))) { // moves in one direction
			if (oldx - x == 0) { // moving horizontally
				System.out.println("HORIZONTAL");
				if (oldy - y < 0) dir = true;
				else dir = false;
				
				if (dir) { // GOING RIGHT
					// check condition
					 for (int i = oldy+1; i < y; i++) {
						 if (!Board.isEmpty(board, x, i)) {
							 System.out.println("MOVE DOES NOT WORKbbb");
							 return;
						 }
					 }
					 if (!Board.isEmpty(board, x, y)) {
						 if (board[oldx][oldy].isOppositeTeam(board[x][y])) {
							 // kill
							 board[oldx][oldy].kill(board, this.x, this.y, x, y);
						 } else {
							 // spot is filled w teammate
							 System.out.println("MOVE DOES NOT WORKzzz");
							 return;
						 }
					 } else {
						 // update location
						 board[oldx][oldy].update(board, x, y);
					 }
					 
				} else { // GOING LEFT
					// check condition
					for (int i = oldy-1; i > y; i--) {
						 if (!Board.isEmpty(board, x, i)) {
							 System.out.println("MOVE DOES NOT WORK");
							 return;
						 }
					}
					if (!Board.isEmpty(board, x, y)) {
						 if (board[oldx][oldy].isOppositeTeam(board[x][y])) {
							 // kill
							 board[oldx][oldy].kill(board, this.x, this.y, x, y);
						 } else {
							 // spot is filled w teammate
							 System.out.println("MOVE DOES NOT WORKzzz");
							 return;
						 }
					 } else {
						 // update location
						 board[oldx][oldy].update(board, x, y);
					 }
				}
				
				
			} else { // moving vertically
				System.out.println("VERTICAL");
				if (oldx - x > 0) dir = true;
				else dir = false;
				
				if (dir) { // GOING UP
					// check condition
					for (int i = oldx-1; i > x; i--) {
						 if (!Board.isEmpty(board, i, y)) {
							 System.out.println("MOVE DOES NOT WORKaaaa");
							 return;
						 }
					}
					if (!Board.isEmpty(board, x, y)) {
						 if (board[oldx][oldy].isOppositeTeam(board[x][y])) {
							 // kill
							 board[oldx][oldy].kill(board, this.x, this.y, x, y);
						 } else {
							 // spot is filled w teammate
							 System.out.println("MOVE DOES NOT WORKzzz");
							 return;
						 }
					 } else {
						 // update location
						 board[oldx][oldy].update(board, x, y);
					 }
				} else { // GOING DOWN
					// check condition
					for (int i = oldx+1; i < x; i++) {
						 if (!Board.isEmpty(board, i, y)) {
							 System.out.println("MOVE DOES NOT WORKhhhh");
							 return;
						 }
					}
					if (!Board.isEmpty(board, x, y)) {
						 if (board[oldx][oldy].isOppositeTeam(board[x][y])) {
							 // kill
							 board[oldx][oldy].kill(board, this.x, this.y, x, y);
						 } else {
							 // spot is filled w teammate
							 System.out.println("MOVE DOES NOT WORKzzz");
							 return;
						 }
					 } else {
						 // update location
						 board[oldx][oldy].update(board, x, y);
					 }
				}
				
				
			}
			
			
			
		}
		
	}

}
