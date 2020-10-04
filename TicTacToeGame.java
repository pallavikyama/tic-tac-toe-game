package com.blz.tictactoe;

import java.util.Scanner;

public class TicTacToeGame {
	static char[] board = new char[10];
	static char playerLetter;
	static char computerLetter;
	static int playerMoveChoice;

	static Scanner input = new Scanner(System.in);

	// CREATE EMPTY TIC_TAC_TOE BOARD
	private void createBoard() {
		for (int i = 1; i < board.length; i++) {
			board[i] = ' ';
		}
		System.out.println("An empty board is created.");
		showBoard();
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
		System.out.println("Displaying board:\n-------------");
		for (int i = 1; i < board.length; i++) {
			System.out.print("| " + board[i] + " ");
			if (i % 3 == 0)
				System.out.println("|\n-------------");
		}
	}

	// CHECK IF USER MOVE INDEX IS VALID
	private void getUserMove() {
		boolean x = false;
		while (x == false) {
			System.out.println("Enter a valid cell index (choose a number from 1 to 9) to make a move.");
			playerMoveChoice = input.nextInt();
			if (playerMoveChoice <= 0 || playerMoveChoice >= board.length) {
				System.out.println("Try again. You gave an invalid cell index.");
				x = false;
			} else if (board[playerMoveChoice] == ' ') {
				System.out.println("This index is free for move.");
				x = true;
			} else {
				System.out.println("Try again. You choosed a filled cell.");
				x = false;
			}
		}
		setUserMove();
	}

	// SET USER MOVE AND DISPLAY
	private void setUserMove() {
		board[playerMoveChoice] = playerLetter;
		System.out.println("User move is set.");
		showBoard();
	}

	public static void main(String[] args) {
		System.out.println("Welcome to TIC TAC TOE Game.");
		TicTacToeGame boardObj = new TicTacToeGame();
		boardObj.createBoard();
		boardObj.gameInputs();
		boardObj.getUserMove();
		input.close();
	}
}