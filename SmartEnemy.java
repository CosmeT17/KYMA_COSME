package Enemies;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import Game.main.*;

public class SmartEnemy extends GameObject{
	
	private Handler handler;
	private GameObject Player;
	private Color color;
	
	public SmartEnemy(float x, float y, ID id, Color color, Handler handler){
		super(x, y, id);
		this.handler = handler;
		this.color = color;
		
		for(int i = 0; i < handler.object.size(); i++){
			if(handler.object.get(i).getID() == ID.Player) Player = handler.object.get(i);
		}
	}
	
	public Rectangle getBounds(){
		return new Rectangle((int)x, (int)y, 16, 16);
	}

	public void tick(){
		x += velX;
		y += velY;
		
		float diffX = x - Player.getX();
		float diffY = y - Player.getY();
		float distance = (float)(Math.sqrt((diffX * diffX) + (diffY * diffY)));  //Pythagorean Theorem
		
		velX = (float)((-1.5/distance) * (diffX - 14));
		velY = (float)((-1.5/distance) * (diffY - 14));
		
		vel[0] = velX;
		vel[1] = velY;
		
		//if(y <= 0 || y >= Game.HEIGHT - 42) velY *= -1;
		//if(x <= 0 || x >= Game.WIDTH - 20) velX *= -1;
		
		handler.addObject(new Trail(x, y, ID.Trail, color, 16, 16, 0.07f, handler));
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
	//handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 20), r.nextInt(Game.HEIGHT - 42), ID.Enemy, Color.lightGray, handler));
}
