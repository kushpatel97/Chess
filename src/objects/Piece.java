package objects;
import board.*;

public abstract class Piece {
        // Location
        int x;
        int y;
        boolean firstmove = true; // true - has not moved | false - moved at least once, for Pawns + Castle
        boolean team; // true - white    false - black
        boolean alive = true; // true - piece still alive    false - piece killed

        // White or Black
        public void setTeam(boolean team) {
                this.team = team;
        }

        public boolean isTeam() {
                return team;
        }

	
    // Alive or Dead
    public void kill() {
            this.alive = false;
    }

    // Update Location + Delete Past Spot
    public void update(Piece[][] board, int x, int y) {
            board[x][y] = board[this.x][this.y];
            board[this.x][this.y] = null;
            this.x = x;
            this.y = y;
            this.firstmove = false;
    }

    // Move Piece
    public abstract void move(Piece[][] board, int x, int y);

    // Helper for Move
    //public abstract boolean canmove(int x, int y);

}
