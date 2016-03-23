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
	private JTextField p1Field;
	private JTextField p2Field;
	private JLabel outcome;
	
	public RPSPanel(RPSController baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		rockButton = new JButton("Rock");
		baseLayout.putConstraint(SpringLayout.WEST, rockButton, 100, SpringLayout.WEST, this);
		paperButton = new JButton("Paper");
		scissorsButton = new JButton("Scissors");
		baseLayout.putConstraint(SpringLayout.EAST, scissorsButton, -100, SpringLayout.EAST, this);
		p1Field = new JTextField();
		baseLayout.putConstraint(SpringLayout.NORTH, p1Field, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, p1Field, 198, SpringLayout.WEST, this);
		p2Field = new JTextField();
		baseLayout.putConstraint(SpringLayout.EAST, p2Field, -189, SpringLayout.EAST, this);
		outcome = new JLabel("Vs");
		baseLayout.putConstraint(SpringLayout.WEST, p2Field, 6, SpringLayout.EAST, outcome);
		baseLayout.putConstraint(SpringLayout.NORTH, outcome, 16, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, p1Field, -6, SpringLayout.WEST, outcome);
		
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
		this.add(p1Field);
		this.add(p2Field);
		this.add(outcome);
	}

	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.EAST, paperButton, -252, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, rockButton, 0, SpringLayout.NORTH, paperButton);
		baseLayout.putConstraint(SpringLayout.NORTH, scissorsButton, 0, SpringLayout.NORTH, rockButton);
		baseLayout.putConstraint(SpringLayout.NORTH, p2Field, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, paperButton, 56, SpringLayout.SOUTH, outcome);
		baseLayout.putConstraint(SpringLayout.WEST, outcome, 300, SpringLayout.WEST, this);
		
		
	}

	private void setupListeners()
	{
		rockButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent click)
			{
				int winner = baseController.updatePlay(RPSNum.Rock);
				
				if(winner == 0)
				{
					outcome.setText("Tie");
				}
				else
				{
					if(winner == 1)
					{
						outcome.setText("P1");
					}
					else
					{
						outcome.setText("BOT!!!");
					}
				}
			}
			
		});
		
		paperButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent click)
			{
				int winner = baseController.updatePlay(RPSNum.Paper);
				
				if(winner == 0)
				{
					outcome.setText("Tie");
				}
				else
				{
					if(winner == 1)
					{
						outcome.setText("P1");
					}
					else
					{
						outcome.setText("BOT!!!");
					}
				}
			}
			
		});
		
		scissorsButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent click)
			{
				int winner = baseController.updatePlay(RPSNum.Scissors);
				
				if(winner == 0)
				{
					outcome.setText("Tie");
				}
				else
				{
					if(winner == 1)
					{
						outcome.setText("P1");
					}
					else
					{
						outcome.setText("BOT!!!");
					}
				}
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
				
				
				if(key == keyE.VK_Z)
				{
					int winner = baseController.updatePlay(RPSNum.Scissors);
					
					if(winner == 0)
					{
						outcome.setText("Tie");
					}
					else
					{
						if(winner == 1)
						{
							outcome.setText("P1");
						}
						else
						{
							outcome.setText("BOT!!!");
						}
					}
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
	
}
