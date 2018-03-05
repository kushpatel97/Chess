package objects;

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

	@Override
	public void move(Piece[][] board, int x, int y) {
		// TODO Auto-generated method stub
		
	}

	public static Piece Queen(int x, int y, boolean b) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
