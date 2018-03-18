package chess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import objects.*;
import board.*;

public class Chess {
	static boolean drawProposal = false; // for draw proposals
	
	public static void main (String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// INITIALIZE
		Board.welcome();
		Piece[][] board = Board.buildBoard();	
		Board.printBoard(board);
		
		boolean turn = true; // white = true, black = false
		
		while (true) { // ** condition needs to be whether or not the King is dead or game is over
			if (turn) { System.out.print("White's move: ");
			} else { System.out.print("Black's move: "); }
			
			String s = br.readLine().trim().toLowerCase();
			
			System.out.println(); // formatting space
			
			// draw response
			if (drawProposal) {
				if (s.equals("draw")) {
					endGame(turn, true);
				}
				drawProposal = false;
			}
			
			if (checkInput(s, turn)) {
				int[] trans = Board.translate(s);
				
				// if start state is NULL
				if (board[trans[0]][trans[1]] == null) {
					System.out.println("Illegal move, try again");
					System.out.println();
					continue;
				}
				
				// start state is wrong team
				if (board[trans[0]][trans[1]].getTeam() == !turn) {
					System.out.println("Illegal move, try again");
					System.out.println();
					continue;
				}
				
				// if move is not valid
				if (board[trans[0]][trans[1]].move(board, trans[2], trans[3])) {
					Board.printBoard(board);
					turn = !turn;
				} else {
					System.out.println("Illegal move, try again");
					System.out.println();
					continue;
				}
			} else {
				System.out.println("Illegal move, try again");
				System.out.println();
			}
		}
		
	}

	public static boolean checkInput(String s, boolean turn) {
		if (s.length() != 5 || s.charAt(2) != ' ') {
			if (s.length() >= 6) {
				// resign
				if (s.equals("resign")) {
					endGame(!turn, false);
				}
				
				// draw
				if (checkInput(s.substring(0, 5), turn)) {
					if (s.substring(6).equals("draw?")) {
						drawProposal = true;
						return true;
					}
				}
				
				
			}
			
			// System.out.println("Invalid Input: format incorrect");
			return false;
		}
		
		if (!Character.isLetter(s.charAt(0)) || !Character.isDigit(s.charAt(1)) || !Character.isLetter(s.charAt(3)) || !Character.isDigit(s.charAt(4))) {
			// System.out.println("Invalid Input: format incorrect");
			return false;
		}
		
		// make sure letters and numbers are within range
		if ((!(s.charAt(0) >= 'a' && s.charAt(0) <= 'h')) || (!(s.charAt(3) >= 'a' && s.charAt(3) <= 'h'))) {
			// System.out.println("Invalid Input: letters are out of range");
			return false;
		}
		
		if ((!(s.charAt(1) >= '1' && s.charAt(1) <= '8')) || (!(s.charAt(4) >= '1' && s.charAt(4) <= '8'))) {
			// System.out.println("Invalid Input: numbers are out of range");
			return false;
		}
		
		// no duplicate entries
		if ((s.charAt(0) == s.charAt(3)) && (s.charAt(1) == s.charAt(4))) {
			// System.out.println("Invalid Input: Target location cannot be the same as state location");
			return false;
		}
		
		return true;
	}

	public static boolean checkTurn(Piece[][] board, int[] arr, boolean turn) {
		boolean team = board[arr[0]][arr[1]].getTeam();
		
		if (turn == team) { // correct team
			turn = !turn;
			return true;
		}
		
		return false;
	}
	
	public static void endGame(boolean team, boolean draw) { // input is winner, draw is true if draw
		if (draw) System.out.println("draw");
		else if (team) System.out.println("White wins");
		else System.out.println("Black wins");
		
		System.exit(0);
	}
}
