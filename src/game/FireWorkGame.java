package game;

import game.frames.ControlFrame;
import game.frames.FireWorkFrame;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Line2D;
import java.io.EOFException;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class FireWorkGame implements Runnable
{

	private Thread thread = new Thread(this);
	private FireWorkFrame frame;
	private boolean running = false;
	public final double  lockRate = 1.0 / 60.0;
	private boolean fLocked = true;
	private ArrayList<FireWork> fworks; 
	private ControlFrame cFrame;
	private boolean sumsEquals = true;
	private int fps = 0;
		
	private JPanel panel = new JPanel(){
		private static final long serialVersionUID = 6871752793965585458L;
		@Override
		public void paintComponent(Graphics g){
			
			g.setColor(new Color(0,0,0));
			g.fillRect(0, 0, frame.getWidth(), frame.getHeight());
			
			render(g);
		}
	};
	
	public FireWorkGame()
	{
		cFrame = new ControlFrame();
		cFrame.setVisible(true);
		cFrame.setResizable(false);
		frame = new FireWorkFrame();
		
		frame.add(panel);
		frame.addMouseListener(new MouseListener()
		{
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
			}

			@Override
			public void mousePressed(MouseEvent e) 
			{
				checkControl();
				if(sumsEquals && sum != 0)
				{
					float[] effects = new float[11];
					
					
					for(int i = 0; i < 9; i++)
					{
						effects[i] = Integer.parseInt(((JSpinner)cFrame.p.getComponent(i+10)).getValue().toString());
					}
						
					effects[9] = Integer.parseInt(((JSpinner)cFrame.p.getComponent(21)).getValue().toString());
					
					if(((JCheckBox)cFrame.p.getComponent(20)).isSelected())
						effects[10] = 1;
					else
						effects[10] = 0;
										
					fworks.add(new FireWork(e.getX(),e.getY(),sum,effects));
				}
			
				
			}
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
			
		});
		
		fworks = new ArrayList<FireWork>();
		for(int i = 10; i < 19; i++)
		{
			((JSpinner)cFrame.p.getComponent(i)).addChangeListener(new ChangeListener(){

				@Override
				public void stateChanged(ChangeEvent e) {
					checkControl();
				}
				
			});
		}
		
		((JSpinner)cFrame.p.getComponent(21)).addChangeListener(new ChangeListener(){

			@Override
			public void stateChanged(ChangeEvent e) {
				checkControl();
			}
			
		});
		thread.start();
	}
	
	
	
	
	
	
	
	
	
	
	///////////////////////////////////////////////////////////
	@Override
	public void run()
	{
		running = true;

		double fTime = 0, lTime = System.nanoTime() / 1000000000.0, pTime = 0, upTime = 0, frameTime = 0;
		int frames = 0;
		while(running)
		{
			boolean lock = false;
			
			fTime = System.nanoTime() / 1000000000.0;
			pTime = fTime - lTime;
			lTime = fTime;
			
			upTime += pTime;
			frameTime += pTime;
			
			while(upTime >= lockRate)
			{
				update();
				upTime -= lockRate;
				lock = true;
			
				
				if(frameTime >= 1)
				{
					frameTime = 0;
					fps = frames;
					frames=0;
				}	
			}
			
			if(lock)
			{
				panel.repaint();
				frames++;
			}else
			{
				try{Thread.sleep(1);}catch(InterruptedException e){e.printStackTrace();}
			}
			
		}
		
	}
	///////////////////////////////////////////////////////////
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void stop(){
		running = false;
	}
	
	
	int sum = 0;
	public void checkControl()
	{
		if(Integer.parseInt((((JSpinner)cFrame.p.getComponent(21)).getValue().toString())) < 0)
		{
			((JSpinner)cFrame.p.getComponent(21)).setValue(0);
		}
		if(Integer.parseInt((((JSpinner)cFrame.p.getComponent(21)).getValue().toString())) > 50)
		{
			((JSpinner)cFrame.p.getComponent(21)).setValue(50);
		}
		for(int i = 10; i < 19; i++)
		{
				if(Integer.parseInt((((JSpinner)cFrame.p.getComponent(i)).getValue().toString())) < 0)
				{
					((JSpinner)cFrame.p.getComponent(i)).setValue(0);
				}
		}
		sum = 0;
		for(int i = 10; i < 19; i++)
		{
				
			sum += Integer.parseInt((((JSpinner)cFrame.p.getComponent(i)).getValue().toString()));
				
		}
		((JLabel)cFrame.p.getComponent(9)).setText("SoučetLátek- "+sum);;
		if(sum > 100)
			sumsEquals = false;
		else
			sumsEquals = true;
		
		
		
	}
	
	
	
//								UPDATE
	
	public void update()
	{	
		for(int i = 0; i < fworks.size(); i++)
		{
				if(fworks.get(i).lTime > 80)
					fworks.remove(i);
				else
					fworks.get(i).update();
		}
	}

	
	

	
	
	
//								RENDER	
	
	public void render(Graphics g)
	{		
		
		Graphics2D g2 = (Graphics2D) g;
		g.setFont(new Font("TimesRoman", Font.BOLD, 40)); 
		g.setColor(Color.RED);
		if(!sumsEquals)
			g.drawString("SoučetLátek se musí být menší než 100", 80, 400);
		
		for(int i = 0; i < fworks.size(); i++)
		{
			if(fworks.get(i).exploded)
			{
				for(int e = 0; e < fworks.get(i).p.length; e++)
				{
					if(fworks.get(i).effects[10] != 0)
					{
						
						try{
							for(int r = 1; r < fworks.get(i).p[e].smoke.cords.size(); r++)
							{
								int x = fworks.get(i).p[e].smoke.cords.get(r).x;
								int y = fworks.get(i).p[e].smoke.cords.get(r).y;
								
								float lt = (float)fworks.get(i).lTime-80;
								int c = (int) (Math.abs(lt)*1.5f);
								if(c>255)
									c=255;
								g.setColor(new Color(c,c,c));
								g2.setStroke(new BasicStroke(3));
				                g2.draw(new Line2D.Float(x, y, fworks.get(i).p[e].smoke.cords.get(r-1).x, fworks.get(i).p[e].smoke.cords.get(r-1).y));	
							}
						}catch(Exception exept){
							
						}
					}
					if(fworks.get(i).p[e] != null)
					{
						int x = (int)fworks.get(i).p[e].x;
						int y = (int)fworks.get(i).p[e].y;
						Color c = fworks.get(i).p[e].color;
							
						g.setColor(c);
						g.fillRect(x, y, 2, 2);
					}
					
				}
				g2.setStroke(new BasicStroke(2));
				for(int e = 0; e < fworks.get(i).sp.size(); e++)
				{
					
					int x = (int)fworks.get(i).sp.get(e).x;
					int y = (int)fworks.get(i).sp.get(e).y;
					
					float lt = (float)fworks.get(i).lTime-80;
					int c = (int) (Math.abs(lt)*3.1875f);
					if(c>255)
						c=255;
					g.setColor(new Color(c,c,0));
					g.drawLine(x, y, fworks.get(i).x, fworks.get(i).y);
					
				}
			}else{
				g.setColor(Color.RED);
				g.fillRect(fworks.get(i).x, fworks.get(i).y, 2, 2);
				
				g.setColor(Color.YELLOW);
				g.fillRect(fworks.get(i).x, fworks.get(i).y+2, 2, 2);
			}
		}
	
		g.setFont(new Font("Verdana", Font.BOLD, 10)); 
		g.setColor(Color.WHITE);
		g.drawString(fps+"-FPS", 1075, 770);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
