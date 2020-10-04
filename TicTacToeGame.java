package com.blz.tictactoe;

public class TicTacToeGame {
	static char[] board = new char[10];

	// CREATE EMPTY TIC_TAC_TOE BOARD
	private void createBoard() {
		for (int i = 1; i < board.length; i++) {
			board[i]=' ';
		}
		System.out.println("An empty board is created.");
	}

	public static void main(String[] args) {
		System.out.println("Welcome to TIC TAC TOE Game.");
		TicTacToeGame boardObj = new TicTacToeGame();
		boardObj.createBoard();
	}
}