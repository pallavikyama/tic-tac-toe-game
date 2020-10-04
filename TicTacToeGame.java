package com.blz.tictactoe;

import java.util.Scanner;

public class TicTacToeGame {
	static char[] board = new char[10];
	static char playerLetter;
	static char computerLetter;
	static int playerMoveChoice;
	static int computerMoveChoice;
	static int toss;
	static int filledCellsCount;

	public static final int PLAYER_FIRST = 0;
	public static final int COMPUTER_FIRST = 1;

	static Scanner input = new Scanner(System.in);

	// CREATE EMPTY TIC_TAC_TOE BOARD
	private void createBoard() {
		for (int i = 1; i < board.length; i++) {
			board[i] = ' ';
		}
		filledCellsCount = 0;
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
		++filledCellsCount;
		showBoard();
		gameStatus(playerLetter);
	}

	// SET COMPUTER MOVE USING RANDOM
	private void setComputerMove() {
		boolean x = false;
		while (x == false) {
			computerMoveChoice = (int) Math.ceil(Math.random() * 10) % 9;
			if (board[computerMoveChoice] != ' ' || computerMoveChoice <= 0 || computerMoveChoice > board.length)
				x = false;
			else {
				x = true;
				board[computerMoveChoice] = computerLetter;
				System.out.println("Computer has set its move.");
				++filledCellsCount;
			}
		}
		showBoard();
		gameStatus(computerLetter);
	}

	// CHOOSE FIRST PLAYER USING RANDOM
	private void chooseFirstPlayer() {
		System.out.println("Now a toss is done to get the first player among user and computer.\n------TOSS-------");
		toss = (int) Math.floor(Math.random() * 10) % 2;
		if (toss == PLAYER_FIRST) {
			System.out.println("Player has to play first.");
			getUserMove();
		} else {
			System.out.println("Computer has to play first.");
			setComputerMove();
		}
	}

	// GAME STATUS- WINNER|TIE|NEXT TURN
	private void gameStatus(char checkWinner) {
		if ((board[1] == board[2] && board[2] == board[3] && board[3] == checkWinner)
				|| (board[1] == board[4] && board[4] == board[7] && board[7] == checkWinner)
				|| (board[1] == board[5] && board[5] == board[9] && board[9] == checkWinner)
				|| (board[2] == board[5] && board[5] == board[8] && board[8] == checkWinner)
				|| (board[3] == board[6] && board[6] == board[9] && board[9] == checkWinner)
				|| (board[3] == board[5] && board[5] == board[7] && board[7] == checkWinner)
				|| (board[4] == board[5] && board[5] == board[6] && board[6] == checkWinner)
				|| (board[7] == board[8] && board[8] == board[9] && board[9] == checkWinner)) {
			if (checkWinner == playerLetter)
				System.out.println("USER won the TIC-TAC-TOE Game!");
			else
				System.out.println("COMPUTER won the TIC-TAC-TOE Game!");
		} else if (filledCellsCount == 9)
			System.out.println("It's a TIE match.");
		else {
			System.out.println("Game continues.");
			if ((filledCellsCount % 2 == 0 && toss == PLAYER_FIRST)
					|| (filledCellsCount % 2 != 0 && toss == COMPUTER_FIRST))
				getUserMove();
			else if ((filledCellsCount % 2 == 0 && toss == COMPUTER_FIRST)
					|| (filledCellsCount % 2 != 0 && toss == PLAYER_FIRST))
				setComputerMove();
		}
	}

	public static void main(String[] args) {
		System.out.println("Welcome to TIC-TAC-TOE Game.");
		TicTacToeGame boardObj = new TicTacToeGame();
		boardObj.createBoard();
		boardObj.gameInputs();
		boardObj.chooseFirstPlayer();
		input.close();
	}
}