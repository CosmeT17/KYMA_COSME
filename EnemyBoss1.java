package Enemies;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import Game.main.*;

public class EnemyBoss1 extends GameObject{
	
	private Handler handler;
	private Random r = new Random();
	
	private int timer = 175;
	private int timer2 = 30;
	
	public EnemyBoss1(float x, float y, ID id, Handler handler){
		super(x, y, id);
		
		this.handler = handler;

		velX = 0;
		velY = 1;
		
		vel[0] = velX;
		vel[1] = velY;
	}
	
	public Rectangle getBounds(){
		return new Rectangle((int)x, (int)y, 96, 96);
	}

	public void tick(){
		x += velX;
		y += velY;
		
		if(timer <= 0) velY = 0;
		else timer--;
		
		if(timer <= 0 )timer2--;
		
		if(timer2 <= 0){
			if(velX == 0) velX = -4;
			
			if(velX < 0) velX -= 0.006f;
			else if(velX > 0) velX += 0.006f;
			
			velX = Game.clamp(velX, -15, 15);
			
			int spawn = r.nextInt(7);
			if(spawn == 0) handler.addObject(new BasicBullet(x + 40, y + 115, ID.Enemy, Color.red, handler));
			}
			
		//if(y <= 0 || y >= Game.HEIGHT - 42) velY *= -1;
		if(x <= 0 || x >= Game.WIDTH - 102) velX *= -1;
		

		vel[0] = velX;
		vel[1] = velY;
	}

	public void render(Graphics g){
		g.setColor(Color.red);
		g.fillRect((int)x, (int)y, 96, 96);
		
		g.setColor(Color.white);
		g.drawRect((int)x, (int)y, 96, 96);
		
		g.setColor(Color.red);
		g.fillRect((int)x + 32, (int)y + 74, 30, 40);
		
		g.setColor(Color.white);
		g.drawRect((int)x + 32, (int)y + 74, 30, 40);
		
		g.setColor(Color.red);
		g.fillRect((int)x + 35, (int)y + 74, 25, 40);
	}

	public void hide(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect((int)x, (int)y, 96, 96);
		g.drawRect((int)x, (int)y, 96, 96);
		g.fillRect((int)x + 32, (int)y + 74, 30, 40);
		g.drawRect((int)x + 32, (int)y + 74, 30, 40);
		g.fillRect((int)x + 35, (int)y + 74, 25, 40);
		
		velX = 0;
		velY = 0;	
	}
	
	public void restoreVel(){
		velX = vel[0];
		velY = vel[1];
	}
	//handler.addObject(new EnemyBoss1(Game.WIDTH / 2 + 38, -155, ID.Enemy, handler));
}
