package Enemies;

import java.awt.Graphics;
import java.awt.Rectangle;

import Game.main.ID;

public abstract class GameObject {

	protected float x;
	protected float y;
	
	protected float velX;
	protected float velY;
	
	protected float[] vel;
	
	public ID id;
	
	public GameObject(float x, float y, ID id){    //CONSTRUCTOR (MAKER)
		this.x = x;
		this.y = y;
		this.id = id;
		
		vel = new float[2];
		
		vel[0] = 0;
		vel[1] = 0;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract void hide(Graphics g);
	public abstract void restoreVel();
	public abstract Rectangle getBounds();
	
	public void setX(float x){                   //MUTATOR (SETTER)
		this.x = x;
	}
	
	public void setY(float y){                   //MUTATOR (SETTER)
		this.y = y;
	}
	
	public float getX(){                         //ACCESSOR (GETTER)   
		return x;
	}
	
	public float getY(){                         //ACCESSOR (GETTER)
		return y;
	}
	
	public void setID(ID id){                  //MUTATOR (SETTER)
		this.id = id;
	}
	
	public ID getID(){                         //ACCESSOR (GETTER)
		return id;
	}
	
	public void setVelX(float velX){             //MUTATOR (SETTER)
		this.velX = velX;
	}
	
	public void setVelY(int velY){             //MUTATOR (SETTER)
		this.velY = velY;
	}
	
	public float getVelX(){                      //ACCESSOR (GETTER)
		return velX;
	}
	
	public float getVelY(){                      //ACCESSOR (GETTER)
		return velY;
	}
	
	public void print(){
		if(id == ID.Enemy){
			System.out.println("Real Time: " + velX + ", " + velY);
			System.out.println("Stored: " + vel[0] + ", " + vel[1]);
		}
	}
}
