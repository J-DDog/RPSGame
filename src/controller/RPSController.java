package controller;

import model.RPSNum;
import model.RockPaperScissors;
import view.RPSFrame;

public class RPSController
{
	private RockPaperScissors rps;
	private RPSFrame baseFrame;
	
	public RPSController()
	{
		rps = new RockPaperScissors();
		baseFrame = new RPSFrame(this);
	}
	
	public void start()
	{
		
	}
	
	public void updatePlay(RPSNum choice, int player)
	{
		rps.playerScores(choice, player);
	}
	
	public int getWinner(boolean multiplayer)
	{
		return rps.getWinner(multiplayer);
	}
	
	public int[] getScoreBoard(boolean multiplayer)
	{
		return rps.getScoreBoard(multiplayer);
	}
}
