package chess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import objects.*;
import board.*;

public class Chess {
	public static void main (String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// INITIALIZE
		Board.welcome();
		Piece[][] board = Board.buildBoard();	
		Board.printBoard(board);
		
		boolean turn = true; // white = true, black = false
		
		while (true) { // ** condition needs to be whether or not the King is dead or game is over
			if (turn) { // White team
				System.out.println("White's move: ");
				String s = br.readLine().trim().toLowerCase();
				
				if (checkInput(s)) {
					int[] trans = Board.translate(s);
					// check if piece is white
					if (board[trans[0]][trans[1]].getTeam() == false) {
						System.out.println("Invalid Input: start state is of type wrong team");
						continue;
					}
					board[trans[0]][trans[1]].move(board, trans[2], trans[3]);
					Board.printBoard(board);
					turn = false;
				}
			} else { // Black team
				System.out.println("Black's move: ");
				String s = br.readLine().trim().toLowerCase();
				
				if (checkInput(s)) {
					int[] trans = Board.translate(s);
					// check if piece is black
					if (board[trans[0]][trans[1]].getTeam() == true) {
						System.out.println("Invalid Input: start state is of type wrong team");
						continue;
					}
					board[trans[0]][trans[1]].move(board, trans[2], trans[3]);
					Board.printBoard(board);
					turn = true;
				}
			}
		}
		
		
		
	}

	public static boolean checkInput(String s) {
		if (s.length() != 5 || s.charAt(2) != ' ') {
			System.out.println("Invalid Input: format incorrect");
			return false;
		}
		
		if (!Character.isLetter(s.charAt(0)) || !Character.isDigit(s.charAt(1)) || !Character.isLetter(s.charAt(3)) || !Character.isDigit(s.charAt(4))) {
			System.out.println("Invalid Input: format incorrect");
			return false;
		}
		
		// make sure letters and numbers are within range
		if ((!(s.charAt(0) >= 'a' && s.charAt(0) <= 'h')) || (!(s.charAt(3) >= 'a' && s.charAt(3) <= 'h'))) {
			System.out.println("Invalid Input: letters are out of range");
			return false;
		}
		
		if ((!(s.charAt(1) >= '1' && s.charAt(1) <= '8')) || (!(s.charAt(4) >= '1' && s.charAt(4) <= '8'))) {
			System.out.println("Invalid Input: numbers are out of range");
			return false;
		}
		
		// no duplicate entries
		if ((s.charAt(0) == s.charAt(3)) && (s.charAt(1) == s.charAt(4))) {
			System.out.println("Invalid Input: Target location cannot be the same as state location");
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
}
