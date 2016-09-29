package game;

import java.awt.Color;
import java.util.ArrayList;


public class FireWork 
{
	public boolean exploded = false;
	public int x;
	public int y = 800;
	public int finalY;
	private int size;
	public float[] effects = new float[11];
	private Color[] colors = new Color[]{new Color(255, 255, 255),new Color(204, 204, 204),
										 new Color(255, 255, 0),new Color(255, 204, 0),
										 new Color(255, 153, 0),new Color(255, 0, 0),
										 new Color(255, 0, 255),new Color(0, 0, 255),
										 new Color(0, 255, 0)};
	public int lTime = 0;
	
	public Particle[] p;
	public ArrayList<Spark> sp = new ArrayList<Spark>();
	int spL;
	public Smoke sm = new Smoke();
	
	
	public FireWork(int x, int y,int size,float[] effects)													
	{
		this.x = x;
		this.finalY = y;
		this.effects = effects;
		this.size = size;
		p = new Particle[size];
		
		spL = (int) effects[9];
	}
	
	public void explode()
	{
		exploded = true;
		p = new Particle[size];
		Particle.alfa = 0;
		Particle.countP = size;
		for(int i = 0; i < p.length;i++)
		{
			Color c = Color.WHITE;
					
			for(int cs = 0; cs < effects.length-2;cs++)
			{	
				if(!(effects[cs] <= 0)){
					c = colors[cs];
					
					effects[cs]--;
	
					break;
				}
			}
			
			
			if(effects[10]==0)		
				p[i] = new Particle(x,y,c,false);
			else{
				p[i] = new Particle(x,y,c,true);
				p[i].smoke.cords.add(new cords((int)p[i].x, (int)p[i].y));
			}
			
		}
		for(int i = 0; i < spL;i++)
		{
			sp.add(new Spark(x,y));
		}
		
	}
	
	public void update()
	{
		if(exploded)
		{
			for(int i = 0; i < p.length;i++)
			{
				p[i].update();
				if(effects[10] != 0)
					p[i].smoke.cords.add(new cords((int)p[i].x, (int)p[i].y));
			}
			int spL = sp.size();
			for(int i = 0; i < spL;i++)
			{
				sp.get(i).update();	
			}
			
			
			
			lTime++;
		}else{
		if(y <= finalY)
			explode();
			y-=9; 	
		
		}
	}
	
	

}
