package Game.main;

import java.awt.Graphics;
import java.util.LinkedList;

import Enemies.GameObject;

public class Handler {

	public LinkedList<GameObject> object = new LinkedList<GameObject>();
	private static int countTimesDone = 1;
	private void restorVel(){
		for(int i = 0; i < object.size(); i++){
			GameObject tempObject = object.get(i);
			tempObject.restoreVel();
		}
	}
	
	public void tick(){
		for(int i = 0; i < object.size(); i++){
			GameObject tempObject = object.get(i);
			
			tempObject.tick();
		}
	}
	
	public void render(Graphics g){
		for(int i = 0; i < object.size(); i++){
			GameObject tempObject = object.get(i);
			
			tempObject.render(g);
		}
	}
	
	public void hide(Graphics g){
		for(int i = 0; i < object.size(); i++){
			GameObject tempObject = object.get(i);
			tempObject.hide(g);
		}
	}
	
	public void restore(Graphics g){
		restorVel();
	}
	
	public void addObject(GameObject object){
		this.object.add(object);
	}
	
	public void removeObject(GameObject object){
		this.object.remove(object);
	}
	
	public void clearEnemies(){
		for(int i = 0; i < object.size(); i++){
			GameObject tempObject = object.get(i);
			
			if(tempObject.id == ID.Player){
				object.clear();
				addObject(new Player(Game.WIDTH/2-30, Game.HEIGHT/2-30, ID.Player, this));
			}
		}
	}
	
	public void clear(){
		object.clear();
	}
}
