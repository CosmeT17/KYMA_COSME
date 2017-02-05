package Enemies;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import Game.main.*;

public class ParticleEffect{
	
	private Game game;
	private Handler handler;
	private Random r = new Random();
	private int counter;
	private Color color;
	
	public ParticleEffect(Game g, Handler handler){
		counter = 0;
		this.game = game; 
		this.handler = handler;
	}	
	
	public void render(Graphics g){
		while (counter == 0){
			int limit = r.nextInt(15) + 5;
			for (int i = 0; i < limit; i++)
			{
				color = new Color(r.nextInt(251), r.nextInt(251), r.nextInt(251));
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 20),r.nextInt(Game.HEIGHT - 42),ID.Enemy, color, handler));
			}
			counter = 1;
		}
	}
	
	
}