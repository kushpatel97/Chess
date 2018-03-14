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

        public boolean isTeam() {
                return team;
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
    }

    // Move Piece
    public abstract void move(Piece[][] board, int x, int y);

}
