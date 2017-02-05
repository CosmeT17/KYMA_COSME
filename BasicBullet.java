package Enemies;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import Game.main.*;

public class BasicBullet extends GameObject{
	
	private Handler handler;
	private Random r = new Random();
	private Color color;
	
	public BasicBullet(float x, float y, ID id, Color color, Handler handler){
		super(x, y, id);
		
		this.handler = handler;
		this.color = color;
		
		velX = (r.nextInt(7 - -7) + -7);
		velY = 7;
		
		vel[0] = velX;
		vel[1] = velY;
	}
	
	public Rectangle getBounds(){
		return new Rectangle((int)x, (int)y, 16, 16);
	}

	public void tick(){
		x += velX;
		y += velY;
		
		if(y >= Game.HEIGHT + 16) handler.removeObject(this);
		handler.addObject(new Trail(x, y, ID.Trail, color, 16, 16, 0.06f, handler));
	}
	
	public void render(Graphics g){
		g.setColor(color);
		g.fillRect((int)x, (int)y, 16, 16);
	}

	public void hide(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect((int)x, (int)y, 16, 16);
		
		velX = 0;
		velY = 0;
	}
	
	public void restoreVel(){
		velX = vel[0];
		velY = vel[1];
	}
}
