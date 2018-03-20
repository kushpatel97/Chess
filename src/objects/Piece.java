package objects;
import board.*;

public abstract class Piece {
        // Location
        int x;
        int y;
        boolean firstmove = true; // true - has not moved | false - moved at least once, for Pawns + Castle
        boolean team; // true - white    false - black
		public boolean enpassant; // only for pawns

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
    		board[x][y].enpassant = board[this.x][this.y].enpassant;
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
    
    public static boolean isChecked(Piece[][] board, int x, int y) {
    		for (int i = x+1; i <= 7; i++) { // south (Rook + Queen)
    			if (!Board.isEmpty(board, i, y)) {
    	    			if ((board[i][y] instanceof Rook || board[i][y] instanceof Queen) && board[x][y].isOppositeTeam(board[i][y])) {
    	    				return true;
    	    			} else {
    	    				break;
    	    			}
    			}	
    		}
    		
    		for (int i = x-1; i >= 0; i--) { // north (Rook + Queen)
    			if (!Board.isEmpty(board, i, y)) {
    	    			if ((board[i][y] instanceof Rook || board[i][y] instanceof Queen) && board[x][y].isOppositeTeam(board[i][y])) {
    	    				return true;
    	    			} else {
    	    				break;
    	    			}
    			}	
    		}
    		
    		for (int i = y+1; i <= 7; i++) { // east (Rook + Queen)
    			if (!Board.isEmpty(board, x, i)) {
    	    			if ((board[x][i] instanceof Rook || board[x][i] instanceof Queen) && board[x][y].isOppositeTeam(board[x][i])) {
    	    				return true;
    	    			} else {
    	    				break;
    	    			}
    			}	
    		}
    		
    		for (int i = y-1; i >= 0; i--) { // west (Rook + Queen)
    			if (!Board.isEmpty(board, x, i)) {
    	    			if ((board[x][i] instanceof Rook || board[x][i] instanceof Queen) && board[x][y].isOppositeTeam(board[x][i])) {
    	    				return true;
    	    			} else {
    	    				break;
    	    			}
    			}	
    		}
    		
    		for (int i = y+1, j = x-1; i <= 7 || j >= 0; i++, j--) { // northeast (Bishop + Queen)
    			if (!Board.isEmpty(board, i, j)) { 
    	    			if ((board[i][j] instanceof Bishop || board[i][j] instanceof Queen) && board[x][y].isOppositeTeam(board[i][j])) {
    	    				return true;
    	    			} else {
    	    				break;
    	    			}
    			}	
    		}
    		
    		for (int i = y-1, j = x-1; i >= 0 || j >= 0; i--, j--) { // northwest (Bishop + Queen)
    			if (!Board.isEmpty(board, i, j)) {
    	    			if ((board[i][j] instanceof Bishop || board[i][j] instanceof Queen) && board[x][y].isOppositeTeam(board[i][j])) {
    	    				return true;
    	    			} else {
    	    				break;
    	    			}
    			}	
    		}
    		
    		for (int i = y+1, j = x+1; i <= 7 || j <= 7; i++, j++) { // southeast (Bishop + Queen)
    			if (!Board.isEmpty(board, i, j)) { 
    	    			if ((board[i][j] instanceof Bishop || board[i][j] instanceof Queen) && board[x][y].isOppositeTeam(board[i][j])) {
    	    				return true;
    	    			} else {
    	    				break;
    	    			}
    			}	
    		}
    		
    		for (int i = y-1, j = x+1; i >= 0 || j <= 7; i--, j++) { // southwest (Bishop + Queen)
    			if (!Board.isEmpty(board, i, j)) {
    	    			if ((board[i][j] instanceof Bishop || board[i][j] instanceof Queen) && board[x][y].isOppositeTeam(board[i][j])) {
    	    				return true;
    	    			} else {
    	    				break;
    	    			}
    			}	
    		}
    		
    		if (board[x][y].team) { // white piece, checking for black Pawn
    			if ((board[x-1][y-1] instanceof Pawn && board[x][y].isOppositeTeam(board[x-1][y-1]) || (board[x-1][y+1] instanceof Pawn && board[x][y].isOppositeTeam(board[x-1][y+1])))) { 
    				return true;
    			}
    		} else { // black piece, checking for white Pawn
    			if ((board[x+1][y-1] instanceof Pawn && board[x][y].isOppositeTeam(board[x+1][y-1]) || (board[x+1][y+1] instanceof Pawn && board[x][y].isOppositeTeam(board[x+1][y+1])))) { 
    				return true;
    			}
    		}
    		
    		// Knight
    		if (!Board.isEmpty(board, x+2, y+1) && board[x+2][y+1] instanceof Knight && board[x][y].isOppositeTeam(board[x+2][y+1])) return true;
    		if (!Board.isEmpty(board, x+2, y-1) && board[x+2][y-1] instanceof Knight && board[x][y].isOppositeTeam(board[x+2][y-1])) return true;
    		if (!Board.isEmpty(board, x-2, y+1) && board[x-2][y+1] instanceof Knight && board[x][y].isOppositeTeam(board[x-2][y+1])) return true;
    		if (!Board.isEmpty(board, x-2, y-1) && board[x-2][y-1] instanceof Knight && board[x][y].isOppositeTeam(board[x-2][y-1])) return true;
    		
    		if (!Board.isEmpty(board, x+1, y+2) && board[x+1][y+2] instanceof Knight && board[x][y].isOppositeTeam(board[x+1][y+2])) return true;
    		if (!Board.isEmpty(board, x+1, y-2) && board[x+1][y-2] instanceof Knight && board[x][y].isOppositeTeam(board[x+1][y-2])) return true;
    		if (!Board.isEmpty(board, x-1, y+2) && board[x-1][y+2] instanceof Knight && board[x][y].isOppositeTeam(board[x-1][y+2])) return true;
    		if (!Board.isEmpty(board, x-1, y-2) && board[x-1][y-2] instanceof Knight && board[x][y].isOppositeTeam(board[x-1][y-2])) return true;
    		
    		// King
    		if (!Board.isEmpty(board, x+1, y) && board[x+1][y] instanceof King && board[x][y].isOppositeTeam(board[x+1][y])) return true;
    		if (!Board.isEmpty(board, x-1, y) && board[x-1][y] instanceof King && board[x][y].isOppositeTeam(board[x-1][y])) return true;
    		if (!Board.isEmpty(board, x, y+1) && board[x][y+1] instanceof King && board[x][y].isOppositeTeam(board[x][y+1])) return true;
    		if (!Board.isEmpty(board, x, y-1) && board[x][y-1] instanceof King && board[x][y].isOppositeTeam(board[x][y-1])) return true;
    		
    		if (!Board.isEmpty(board, x+1, y+1) && board[x+1][y+1] instanceof King && board[x][y].isOppositeTeam(board[x+1][y+1])) return true;
    		if (!Board.isEmpty(board, x-1, y+1) && board[x-1][y+1] instanceof King && board[x][y].isOppositeTeam(board[x-1][y+1])) return true;
    		if (!Board.isEmpty(board, x+1, y-1) && board[x+1][y-1] instanceof King && board[x][y].isOppositeTeam(board[x+1][y-1])) return true;
    		if (!Board.isEmpty(board, x-1, y-1) && board[x-1][y-1] instanceof King && board[x][y].isOppositeTeam(board[x-1][y-1])) return true;
    		
    		return false;
    }
    
   // Helper for move method
   public abstract boolean isPathClear(Piece[][] board, int x, int y);

}
