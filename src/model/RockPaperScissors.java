package model;

public class RockPaperScissors
{
	private int p1Wins;
	private int p2Wins;
	private int botWins;
	private RPSNum botChoice;
	
	public RockPaperScissors()
	{
		
	}
	
	public int playerScores(RPSNum p1Choice)
	{
		int winner = 0;
		updateBotChoice();
		if(p1Choice != botChoice)
		{
			switch(botChoice)
			{
				case Rock:
					switch(p1Choice)
					{
						case Paper:
							winner = 1;
							break;
						case Scissors:
							winner = 2;
							break;
					}
					break;
				case Paper:
					switch(p1Choice)
					{
						case Scissors:
							winner = 1;
							break;
						case Rock:
							winner = 2;
							break;
					}
					break;
				case Scissors:
					switch(p1Choice)
					{
						case Rock:
							winner = 1;
							break;
						case Paper:
							winner = 2;
							break;
					}
					break;
					
			}
			
		}
		return winner;
	}
	
	public int playerScores(RPSNum p1Choice, RPSNum p2Choice)
	{
		int winner = 0;
		if(p1Choice != p2Choice)
		{
			switch(p2Choice)
			{
				case Rock:
					switch(p1Choice)
					{
						case Paper:
							winner = 1;
							break;
						case Scissors:
							winner = 2;
							break;
					}
					break;
				case Paper:
					switch(p1Choice)
					{
						case Scissors:
							winner = 1;
							break;
						case Rock:
							winner = 2;
							break;
					}
					break;
				case Scissors:
					switch(p1Choice)
					{
						case Rock:
							winner = 1;
							break;
						case Paper:
							winner = 2;
							break;
					}
					break;
					
			}
			
		}
		return winner;
	}
	
	public void updateBotChoice()
	{
		
	}
}
