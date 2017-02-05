package Game.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import Enemies.GameObject;

public class Player extends GameObject{

	Random r = new Random();
	Handler handler;
	public static int HPLOSS = -2;
	public Player(float x, float y, ID id, Handler handler){
		super(x, y, id);
		this.handler = handler;
	}
	
	public Rectangle getBounds(){
		return new Rectangle((int)x, (int)y, 40, 40);
	}
	
	public void tick(){
		x += velX;
		y += velY;
		
		x = Game.clamp(x, 0, Game.WIDTH - 46);
		y = Game.clamp(y, 0, Game.HEIGHT - 68);
		
		vel[0] = velX;
		vel[1] = velY;
		
		collision();
	}
	
	private void collision(){
		for(int i = 0; i < handler.object.size(); i++){
			
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getID() == ID.Enemy){ //tempObject is now BasicEnemy
				if(getBounds().intersects(tempObject.getBounds())){
					 //Collision Code
					HUD.HEALTH += HPLOSS;
				}
			}
		}
	}
	
	public void render(Graphics g){
		g.setColor(Color.white);          /*if(id == ID.Player)*/ 
		g.fillRect((int)x, (int)y, 40, 40);
	}

	@Override
	public void hide(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect((int)x, (int)y, 40, 40);
		
		velX = 0;
		velY = 0;
	}
	
	public void restoreVel(){
		velX = vel[0];
		velY = vel[1];
	}
}
