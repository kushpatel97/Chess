package objects;

public class Piece {
	// Location
	int x;
	int y;
	boolean moved = false; // true - moved at least once | false - moved 0 times, for Pawns + Castle
	boolean team; // true - white    false - black
	
	// White or Black
	public void setTeam(boolean team) {
		this.team = team;
	}
	
	public boolean isTeam() {
		return team;
	}
	
	
	// Set Location
	public void put(int x, int y) {
		this.x = x;
		this.y = y;
		moved = true;
	}
	
	// Constructor
	public Piece(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
}
