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
	
	public int updatePlay(RPSNum choice)
	{
		return rps.playerScores(choice);
		
	}
	
}
