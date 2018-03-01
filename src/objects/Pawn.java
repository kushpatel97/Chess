package objects;

public class Pawn extends Piece {
	// int x
	// int y
	// boolean firstmove = false;
	// boolean team;
	// boolean alive = true;
	
	public Pawn(int x, int y, boolean team) {
		this.x = x;
		this.y = y;
		
		this.team = team;
		firstmove = true;
	}

	@Override
	public void move(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	public static Piece Pawn(int x, int y, boolean b) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
