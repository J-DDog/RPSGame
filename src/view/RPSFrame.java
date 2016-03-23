package view;

import javax.swing.JFrame;

import controller.RPSController;

public class RPSFrame extends JFrame
{
	private RPSController baseController;
	private RPSPanel basePanel;
	
	public RPSFrame(RPSController baseController)
	{
		this.baseController = baseController;
		basePanel = new RPSPanel(baseController);
		setupFrame();
	}
	
	public void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setSize(600, 600);
		this.setTitle("ROCK PAPER SCISSORS EXTREAM");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}
	
}
