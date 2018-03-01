package objects;

public abstract class Piece {
	// Location
	int x;
	int y;
	boolean firstmove = false; // true - moved at least once | false - moved 0 times, for Pawns + Castle
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
	
	// Move Piece
	public abstract void move(int x, int y);
	
	// 
	
}
