package objects;
import board.*;

public abstract class Piece {
        // Location
        int x;
        int y;
        boolean firstmove = true; // true - has not moved | false - moved at least once, for Pawns + Castle
        boolean team; // true - white    false - black

        // White or Black
        public void setTeam(boolean team) {
                this.team = team;
        }

        public boolean getTeam() {
                return team;
        }
        
        public boolean isOppositeTeam(Piece x) {
        		boolean team = this.team;
        		boolean team2 = x.team;
        		if (team == team2) {
        			return false;
        		}
        		return true;
        }


    // Update Location + Delete Past Spot
    public void update(Piece[][] board, int x, int y) {
    		board[x][y] = board[this.x][this.y];
        board[this.x][this.y] = null;
        board[x][y].x = x;
        board[x][y].y = y;
        this.firstmove = false;
    }
    
    // For Killing Other Pieces
    public void kill(Piece[][] board, int thisx, int thisy, int x, int y) {
    		board[x][y] = board[thisx][thisy];
		board[thisx][thisy] = null;
		board[x][y].x = x;
		board[x][y].y = y;
		board[x][y].firstmove = false;
    }

    
    public abstract boolean isPathClear(Piece[][] board, int x, int y);
    
    // Move Piece
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
