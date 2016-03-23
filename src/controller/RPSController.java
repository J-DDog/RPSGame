package controller;

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
	
	
}
