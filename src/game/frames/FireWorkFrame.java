package game.frames;

import java.awt.Dimension;


import javax.swing.JFrame;

public class FireWorkFrame extends JFrame
{
	private static final long serialVersionUID = 1L;

	public FireWorkFrame()
	{
		this.setTitle("Ohňostroj");
		this.setVisible(true);
		this.setSize(new Dimension(1200, 800));
		this.setBounds(200, 200,1200, 800);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);	
	}

}
