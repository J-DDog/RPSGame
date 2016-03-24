package model;

public class RockPaperScissors
{
	private RPSNum botChoice;
	private RPSNum p1Choice;
	private RPSNum p2Choice;
	private int p1Wins;
	private int p2Wins;
	private int botWins;
	private int ties;
	
	
	public RockPaperScissors()
	{
		updateBotChoice();
	}
	
	public void playerScores(RPSNum choice, int i)
	{
		if(i == 1)
		{
			this.p1Choice = choice;
		}
		else
		{
			this.p2Choice = choice;
		}
	}
	
	public void updateBotChoice()
	{
		int rand = (int) (Math.random()*3);
		switch(rand)
		{
			case 0:
				botChoice = RPSNum.Rock;
				break;
			case 1:
				botChoice = RPSNum.Paper;
				break;
			case 2:
				botChoice = RPSNum.Scissors;
				break;
			default:
				break;
		}
	}
	
	public int getWinner(boolean multiplayer)
	{
		int winner = 0;
		if(multiplayer)
		{
			switch(p1Choice)
			{
				case Rock:
					switch(p2Choice)
					{
						case Paper:
							p2Wins++;
							winner = 2;
							break;
						case Rock:
							ties++;
							break;
						case Scissors:
							p1Wins++;
							winner = 1;
							break;
						default:
							break;
						
					}
					break;
				case Paper:
					switch(p2Choice)
					{
						case Paper:
							ties++;
							break;
						case Rock:
							p1Wins++;
							winner = 1;
							break;
						case Scissors:
							p2Wins++;
							winner = 2;
							break;
						default:
							break;
						
					}
					break;
				case Scissors:
					switch(p2Choice)
					{
						case Paper:
							p1Wins++;
							winner = 1;
							break;
						case Rock:
							p2Wins++;
							winner = 2;
							break;
						case Scissors:
							ties++;
							break;
						default:
							break;
						
					}
					break;
			}
		}
		else
		{
			switch(p1Choice)
			{
				case Rock:
					switch(botChoice)
					{
						case Paper:
							p2Wins++;
							winner = 2;
							break;
						case Rock:
							ties++;
							break;
						case Scissors:
							p1Wins++;
							winner = 1;
							break;
						default:
							break;
						
					}
					break;
				case Paper:
					switch(botChoice)
					{
						case Paper:
							ties++;
							break;
						case Rock:
							p1Wins++;
							winner = 1;
							break;
						case Scissors:
							p2Wins++;
							winner = 2;
							break;
						default:
							break;
						
					}
					break;
				case Scissors:
					switch(botChoice)
					{
						case Paper:
							p1Wins++;
							winner = 1;
							break;
						case Rock:
							p2Wins++;
							winner = 2;
							break;
						case Scissors:
							ties++;
							break;
						default:
							break;
						
					}
					break;
			}
		}
		return winner;
	}
	
	public RPSNum getBotChoice()
	{
		return botChoice;
	}
	
	public int[] getScoreBoard(boolean multiplayer)
	{
		int[] scoreBoard;
		scoreBoard = new int[3];
		scoreBoard[0] = p1Wins;
		scoreBoard[1] = ties;
		if(multiplayer)
		{
			scoreBoard[2] = p2Wins;
		}
		else
		{
			scoreBoard[2] = botWins;
		}
		return scoreBoard;
		
	}
	
}
