package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.RPSController;

import javax.swing.SpringLayout;

import model.RPSNum;

public class RPSPanel extends JPanel
{
	
	private RPSController baseController;
	private SpringLayout baseLayout;
	private JButton rockButton;
	private JButton paperButton;
	private JButton scissorsButton;
	private JButton quitButton;
	private JButton multiPlayer;
	private JTextField p1Score;
	private JTextField tieScore;
	private JTextField p2Score;
	private JLabel outcome;
	
	private boolean p1Updated;
	private boolean p2Updated;
	
	public RPSPanel(RPSController baseController)
	{
		this.baseController = baseController;
		this.setFocusable(true);
		baseLayout = new SpringLayout();
		rockButton = new JButton("Rock");
		baseLayout.putConstraint(SpringLayout.WEST, rockButton, 100, SpringLayout.WEST, this);
		paperButton = new JButton("Paper");
		scissorsButton = new JButton("Scissors");
		baseLayout.putConstraint(SpringLayout.EAST, scissorsButton, -100, SpringLayout.EAST, this);
		p1Score = new JTextField("P1:");
		p1Score.setEditable(false);
		baseLayout.putConstraint(SpringLayout.EAST, p1Score, -296, SpringLayout.EAST, scissorsButton);
		baseLayout.putConstraint(SpringLayout.NORTH, p1Score, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, p1Score, 100, SpringLayout.WEST, this);
		tieScore = new JTextField("Tie:");
		tieScore.setEditable(false);
		baseLayout.putConstraint(SpringLayout.NORTH, tieScore, 0, SpringLayout.NORTH, p1Score);
		baseLayout.putConstraint(SpringLayout.WEST, tieScore, 258, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, tieScore, 0, SpringLayout.EAST, paperButton);
		p2Score = new JTextField("Bot:");
		p2Score.setEditable(false);
		baseLayout.putConstraint(SpringLayout.NORTH, p2Score, 0, SpringLayout.NORTH, p1Score);
		baseLayout.putConstraint(SpringLayout.WEST, p2Score, 46, SpringLayout.EAST, tieScore);
		baseLayout.putConstraint(SpringLayout.EAST, p2Score, 150, SpringLayout.EAST, tieScore);
		outcome = new JLabel();
		baseLayout.putConstraint(SpringLayout.NORTH, outcome, 51, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, outcome, -285, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, paperButton, 21, SpringLayout.SOUTH, outcome);
		
		p1Updated = false;
		p2Updated = false;
		
		setupPanel();
		setupLayout();
		setupListeners();
		changeRandomColor();
	}

	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.add(rockButton);
		this.add(paperButton);
		this.add(scissorsButton);
		this.add(p1Score);
		this.add(tieScore);
		this.add(p2Score);
		this.add(outcome);
	}

	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.EAST, paperButton, -252, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, rockButton, 0, SpringLayout.NORTH, paperButton);
		baseLayout.putConstraint(SpringLayout.NORTH, scissorsButton, 0, SpringLayout.NORTH, rockButton);
		
		
	}

	private void setupListeners()
	{
		rockButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent click)
			{
				baseController.updatePlay(RPSNum.Rock, 1);
			}
			
		});
		
		paperButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent click)
			{
				baseController.updatePlay(RPSNum.Paper, 1);
			}
			
		});
		
		scissorsButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent click)
			{
				baseController.updatePlay(RPSNum.Scissors, 1);
			}
			
		});
		
		this.addMouseMotionListener(new MouseMotionListener()
		{

			@Override
			public void mouseDragged(MouseEvent dragged)
			{
				changeRandomColor();
				
			}

			@Override
			public void mouseMoved(MouseEvent moved)
			{}
			
		});
		
		this.addKeyListener(new KeyListener()
		{

			@Override
			public void keyTyped(KeyEvent keyE)
			{
				char key = keyE.getKeyChar();
				switch(key)
				{
					case 'z':
						if(!p1Updated)
						{
							baseController.updatePlay(RPSNum.Rock, 1);
							p1Updated = true;
							
						}
						break;
					case 'x':
						if(!p1Updated)
						{
							baseController.updatePlay(RPSNum.Paper, 1);
							p1Updated = true;
						}
						break;
					case 'c':
						if(!p1Updated)
						{
							baseController.updatePlay(RPSNum.Scissors, 1);
							p1Updated = true;
						}
						break;
						
					case '1':
						if(!p2Updated)
						{
							baseController.updatePlay(RPSNum.Rock, 2);
							p2Updated = true;
						}
						break;
					case '2':
						if(!p2Updated)
						{
							baseController.updatePlay(RPSNum.Paper, 2);
							p2Updated = true;
						}
						break;
					case '3':
						if(!p2Updated)
						{
							baseController.updatePlay(RPSNum.Scissors, 2);
							p2Updated = true;
						}
						break;
					default:
						break;
						
				}
				
				if(p1Updated && p2Updated)
				{
					switch(baseController.getWinner(true))
					{
						case 0:
							outcome.setText("TIE!!!");
							break;
						case 1:
							outcome.setText("P1 Wins!!!");
							break;
						case 2:
							outcome.setText("P2 Wins!!!");
							break;
						default:
							outcome.setText("NOBODY WINS???");
								
					}
					p1Updated = false;
					p2Updated = false;
					
					updateScores(true);
					
				}
				
			}

			@Override
			public void keyPressed(KeyEvent e)
			{}

			@Override
			public void keyReleased(KeyEvent e)
			{}
			
		});
		
	}
	
	private void changeRandomColor()
	{
		int red, green, blue;
		red = (int) (Math.random() * 256);
		green = (int) (Math.random() * 256);
		blue = (int) (Math.random() * 256);
		
		this.setBackground(new Color(red, green, blue));
	}
	
	private void updateScores(boolean multiplayer)
	{
		int[] scoreBoard;
		scoreBoard = baseController.getScoreBoard(multiplayer);
		String p1 = "P1: " + Integer.toString(scoreBoard[0]);
		p1Score.setText(p1);
		String tie = "Ties: " + Integer.toString(scoreBoard[1]);
		tieScore.setText(tie);
		if(multiplayer)
		{
			String p2 = "P2: " + Integer.toString(scoreBoard[2]);
			p2Score.setText(p2);
		}
		else
		{
			String bot = "Bot: " + Integer.toString(scoreBoard[2]);
			p2Score.setText(bot);
		}
		
	}
	
	private void updateSelections()
	{
		
	}
	
}
