package chess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import objects.*;
import board.*;

public class Chess {
	public static void main (String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			System.out.print("Enter Move: ");
			String s = br.readLine().trim();
			if (checkInput(s)) {
				String state = s.substring(0, s.indexOf(' ')+1);
				String target = s.substring(s.indexOf(' ')+1);
				System.out.println("State: " + state);
				System.out.println("Target: " + target);
			}
			
			
			break;
		}
		
		// INITIALIZE
		Board.welcome();
		Piece[][] board = Board.buildBoard();	
		Board.printBoard(board);
		
		
		
	}

	public static boolean checkInput(String s) {
		if (s.length() != 5 || s.charAt(2) != ' ') {
			System.out.println("Invalid Input.");
			return false;
		}
		
		if (!Character.isLetter(s.charAt(0)) || !Character.isDigit(s.charAt(1)) || !Character.isLetter(s.charAt(3)) || !Character.isDigit(s.charAt(4))) {
			System.out.println("Invalid Input!");
			return false;
		}
		
		// make sure letters and numbers are within range
		if ((!(s.charAt(0) >= 'a' && s.charAt(0) <= 'h')) || (!(s.charAt(3) >= 'a' && s.charAt(3) <= 'h'))) {
			System.out.println("Invalid Input!");
			return false;
		}
		
		
		char a = 'a';
		if (a < 'b') {
			System.out.println("HELLO");
		}
		
		
		return true;
	}

}
