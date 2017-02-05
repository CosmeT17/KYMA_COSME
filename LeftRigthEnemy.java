package Enemies;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import Game.main.*;

public class LeftRigthEnemy extends GameObject{
	
	private Handler handler;
	private Color color;
	
	public LeftRigthEnemy(float x, float y, ID id, Color color, Handler handler){
		super(x, y, id);
		
		this.handler = handler;
		this.color = color;
		
		velX = 7;
		
		vel[0] = velX;
		vel[1] = velY;
	}
	
	public Rectangle getBounds(){
		return new Rectangle((int)x, (int)y, 16, 16);
	}

	public void tick(){
		x += velX;
		
		if(x <= 0) velX *= -1;
		if(x >= Game.WIDTH - 22) velX *= -1;
		
		vel[0] = velX;
		vel[1] = velY;
		
		handler.addObject(new Trail(x, y, ID.Trail, color, 16, 16, 0.05f, handler));
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
	//BOTOM: handler.addObject(new LeftRigthEnemy(r.nextInt(Game.WIDTH - 22), Game.HEIGHT - 44, ID.Enemy, Color.orange, handler));
	//TOP:   handler.addObject(new LeftRigthEnemy(r.nextInt(Game.WIDTH - 22), 0, ID.Enemy, Color.orange, handler));
}
