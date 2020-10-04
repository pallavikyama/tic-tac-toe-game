package com.blz.tictactoe;

import java.util.Scanner;

public class TicTacToeGame {
	static char[] board = new char[10];
	static char playerLetter;
	static char computerLetter;

	static Scanner input = new Scanner(System.in);

	// CREATE EMPTY TIC_TAC_TOE BOARD
	private void createBoard() {
		for (int i = 1; i < board.length; i++) {
			board[i] = ' ';
		}
		System.out.println("An empty board is created.");
	}

	// CHOOSING INPUT
	private void gameInputs() {
		System.out.println("Choose a letter to play the game: 'X'(capital_case X) or 'O'(capital_case O).");
		boolean x = false;
		while (x == false) {
			playerLetter = input.next().charAt(0);
			if (playerLetter == 'X' || playerLetter == 'O')
				x = true;
			else {
				x = false;
				System.out.println("Wrong input. Please try again. Enter 'X' or 'O' only.");
			}
		}
		computerLetter = (playerLetter == 'X') ? 'O' : 'X';
		System.out.println("Player has choosed a " + playerLetter + " and computer got a " + computerLetter + ".");
	}

	// DISPLAY CURRENT BOARD
	private void showBoard() {
		System.out.println("-------------");
		for (int i = 1; i < board.length; i++) {
			System.out.print("| " + board[i] + " ");
			if (i % 3 == 0)
				System.out.println("|\n-------------");
		}
	}

	public static void main(String[] args) {
		System.out.println("Welcome to TIC TAC TOE Game.");
		TicTacToeGame boardObj = new TicTacToeGame();
		boardObj.createBoard();
		boardObj.gameInputs();
		System.out.println("Displaying board to choose a valid cell to play:");
		boardObj.showBoard();
		input.close();
	}
}