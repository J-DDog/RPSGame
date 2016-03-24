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
		baseLayout = new SpringLayout();
		rockButton = new JButton("Rock");
		baseLayout.putConstraint(SpringLayout.WEST, rockButton, 100, SpringLayout.WEST, this);
		paperButton = new JButton("Paper");
		scissorsButton = new JButton("Scissors");
		baseLayout.putConstraint(SpringLayout.EAST, scissorsButton, -100, SpringLayout.EAST, this);
		p1Score = new JTextField("P1:");
		baseLayout.putConstraint(SpringLayout.EAST, p1Score, -296, SpringLayout.EAST, scissorsButton);
		baseLayout.putConstraint(SpringLayout.NORTH, p1Score, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, p1Score, 100, SpringLayout.WEST, this);
		tieScore = new JTextField("Tie:");
		baseLayout.putConstraint(SpringLayout.NORTH, tieScore, 0, SpringLayout.NORTH, p1Score);
		baseLayout.putConstraint(SpringLayout.WEST, tieScore, 258, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, tieScore, 0, SpringLayout.EAST, paperButton);
		p2Score = new JTextField("Bot:");
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
				int key = keyE.getKeyCode();
				
				switch(key)
				{
					case KeyEvent.VK_Z:
						baseController.updatePlay(RPSNum.Rock, 1);
						p1Updated = true;
						break;
					case KeyEvent.VK_X:
						baseController.updatePlay(RPSNum.Paper, 1);
						p1Updated = true;
						break;
					case KeyEvent.VK_C:
						baseController.updatePlay(RPSNum.Scissors, 1);
						p1Updated = true;
						break;
						
					case KeyEvent.VK_LEFT:
						baseController.updatePlay(RPSNum.Rock, 2);
						p2Updated = true;
						break;
					case KeyEvent.VK_DOWN:
						baseController.updatePlay(RPSNum.Paper, 2);
						p2Updated = true;
						break;
					case KeyEvent.VK_RIGHT:
						baseController.updatePlay(RPSNum.Scissors, 2);
						p2Updated = true;
						break;
					default:
						
						break;
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
	
	private void updateSelections()
	{
		
	}
	
}
