package de.lette.faces;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("tictactoe")
@SessionScoped
public class TicTacToeHandler implements Serializable {

	private char player = 'X';
	private char[] field;
	
	public TicTacToeHandler() {
		restart();
	}
	
	public void turn(int index) {
		
		if(field[index] == ' ')
		{
			field[index] = player;
			switchPlayer();
		}
	}
	
	public void restart()
	{
		field = new char[]{' ', ' ',' ',' ',' ',' ',' ',' ',' '};
	}
	
	private void switchPlayer()
	{
		player = player == 'X' ? 'O' : 'X';
	}
	
	public char[] getField() {
		return field;
	}
	
	public String getMessage()
	{
		return player + " ist dran";
	}
}
