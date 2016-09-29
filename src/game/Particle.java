package game;

import java.awt.Color;
import java.util.Random;

public class Particle 
{ 
	public static float alfa = 0;
	public static int countP = 0;
	
	private Random r = new Random();
	
	public Color color;
	public float x;
	public float y;
	
	private float Vx = 0;
	private float Vy = 0;
	private float speed;
	public Smoke smoke = null;
	
	public Particle(int x, int y, Color color,boolean smoke)
	{
		this.x = x;
		this.y = y;
		this.color = color;
		
		speed = r.nextInt(5)+15; 
		
		
		Vx =  -speed * (float)(Math.cos(alfa));
		Vy =  -speed * (float)(Math.sin(alfa));
		
		
		
		alfa += Math.PI/(countP-1);
		
		if(smoke)
			this.smoke = new Smoke();
		
		
	}
	
	public void update()
	{
		x += Vx;
		y += Vy;
		Vy += 0.5f;
		
		if(Vx > 0)
			Vx -= 0.03f;
		else if (Vx < 0)
			Vx += 0.03f;
		
	}
	

}
