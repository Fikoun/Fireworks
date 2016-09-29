package game;

import java.awt.Color;
import java.util.Random;

public class Spark 
{
	
	private Random r = new Random();
	
	public Color color;
	public float x;
	public float y;
	
	private float Vx = 0;
	private float Vy = 0;
	private float speed;
	
	public Spark(int x, int y)
	{
		this.x = x;
		this.y = y;
		this.color = Color.YELLOW;
		
		speed = 10; 
		
		Vx = speed * (r.nextFloat()-0.5f);
		Vy = speed * (r.nextFloat()-0.5f);
		
		
	}
	
	public void update()
	{
		x += Vx;
		y += Vy;
		
		
		
		if(Vy >= 0)
			Vy -= 0.05f;
		else if (Vy < 0)
			Vy += 0.05f;

		if(Vx >= 0)
			Vx -= 0.05f;
		else if (Vx < 0)
			Vx += 0.05f;
	}
	

}
