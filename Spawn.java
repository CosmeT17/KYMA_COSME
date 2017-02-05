package Enemies;

import java.awt.Color;
import java.util.Random;

import Enemies.*;
import Game.main.Game;
import Game.main.HUD;
import Game.main.Handler;
import Game.main.ID;
public class Spawn {

	private Handler handler;
	private HUD hud;
	
	private int scoreKeep = 0;
	private Random r = new Random();
	
	private int looper;
	
	public Spawn(Handler handler, HUD hud){
		this.handler = handler;
		this.hud = hud;
	}
	
	public void tick(){
		scoreKeep++;
			
			if(scoreKeep == 500){
				hud.setWave(2);
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 20), r.nextInt(Game.HEIGHT - 46), ID.Enemy, Color.yellow, handler));                                  //BasicEnemy
			}
			
			if(scoreKeep == 1000){
				hud.setWave(3);
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 20), r.nextInt(Game.HEIGHT - 50), ID.Enemy, Color.magenta, handler));                                 //BasicEnemy
			}
			
			if(scoreKeep == 1500){
				hud.setWave(4);
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 20), r.nextInt(Game.HEIGHT - 55), ID.Enemy, Color.pink, handler));                                    //BasicEnemy
			}
			
			if(scoreKeep == 2000){
				hud.setWave(5);
				handler.addObject(new LeftRigthEnemy(r.nextInt(Game.WIDTH - 22), Game.HEIGHT - 44, ID.Enemy, Color.orange, handler));                                     //LeftRightEnemy (BOTTOM)
				handler.addObject(new LeftRigthEnemy(r.nextInt(Game.WIDTH - 22), 0, ID.Enemy, Color.orange, handler));                                                    //LeftRightEnemy (TOP)
			}
			
			if(scoreKeep == 2500){
				hud.setWave(6);
				handler.addObject(new UpDownEnemy(0, r.nextInt(Game.HEIGHT - 45), ID.Enemy, Color.orange, handler));                                                         //UpDownEnemy (LEFT)
				handler.addObject(new UpDownEnemy(Game.WIDTH - 22, r.nextInt(Game.HEIGHT - 45), ID.Enemy, Color.orange,  handler));                                          //UpDownEnemy (Right)
			}
			
			if(scoreKeep == 3000){
				hud.setWave(7); 
				handler.addObject(new VerticallyFastEnemy(r.nextInt(Game.WIDTH - 20), r.nextInt(Game.HEIGHT - 42), ID.Enemy, Color.cyan, handler));                  //VerticallyFastEnemy
			}
				
			if(scoreKeep == 3500){
				hud.setWave(8);  
				handler.addObject(new HorizontallyFastEnemy(r.nextInt(Game.WIDTH - 20), r.nextInt(Game.HEIGHT - 42), ID.Enemy, Color.green, handler));             //HorizontallyFastEnemy
			}
				
			if(scoreKeep == 4000){
				hud.setWave(9);   
				handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 20), r.nextInt(Game.HEIGHT - 42), ID.Enemy, Color.lightGray, handler));                               //SmartEnemy
			}
			
			if(scoreKeep == 4500){
				hud.setWave(10);  
				handler.clearEnemies();
				handler.addObject(new EnemyBoss1(Game.WIDTH / 2 + 38, -155, ID.Enemy, handler));                                                                              //EnemyBoss1
			}
			
			if(scoreKeep == 6000){
				hud.setWave(11);
				handler.clearEnemies();
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 20), r.nextInt(Game.HEIGHT - 46), ID.Enemy, Color.red, handler));
			}
			
			if(scoreKeep == 7000){
				hud.setWave(12);
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 20), r.nextInt(Game.HEIGHT - 46), ID.Enemy, Color.yellow, handler));                                  //BasicEnemy
			}
			
			if(scoreKeep == 8000){
				hud.setWave(13);
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 20), r.nextInt(Game.HEIGHT - 50), ID.Enemy, Color.magenta, handler));                                 //BasicEnemy
			}
			
			if(scoreKeep == 9000){
				hud.setWave(14);
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 20), r.nextInt(Game.HEIGHT - 55), ID.Enemy, Color.pink, handler));                                    //BasicEnemy
			}
			
			if(scoreKeep == 10000){
				hud.setWave(15);
				handler.addObject(new LeftRigthEnemy(r.nextInt(Game.WIDTH - 22), Game.HEIGHT - 44, ID.Enemy, Color.orange, handler));                                     //LeftRightEnemy (BOTTOM)
				handler.addObject(new LeftRigthEnemy(r.nextInt(Game.WIDTH - 22), 0, ID.Enemy, Color.orange, handler));                                                    //LeftRightEnemy (TOP)
			}
			
			if(scoreKeep == 11000){
				hud.setWave(16);
				handler.addObject(new UpDownEnemy(0, r.nextInt(Game.HEIGHT - 45), ID.Enemy, Color.orange, handler));                                                         //UpDownEnemy (LEFT)
				handler.addObject(new UpDownEnemy(Game.WIDTH - 22, r.nextInt(Game.HEIGHT - 45), ID.Enemy, Color.orange,  handler));                                          //UpDownEnemy (Right)
			}
			
			if(scoreKeep == 12000){
				hud.setWave(17); 
				handler.addObject(new VerticallyFastEnemy(r.nextInt(Game.WIDTH - 20), r.nextInt(Game.HEIGHT - 42), ID.Enemy, Color.cyan, handler));                  //VerticallyFastEnemy
			}
				
			if(scoreKeep == 13000){
				hud.setWave(18);  
				handler.addObject(new HorizontallyFastEnemy(r.nextInt(Game.WIDTH - 20), r.nextInt(Game.HEIGHT - 42), ID.Enemy, Color.green, handler));             //HorizontallyFastEnemy
			}
				
			if(scoreKeep == 14000){
				hud.setWave(19);   
				handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 20), r.nextInt(Game.HEIGHT - 42), ID.Enemy, Color.lightGray, handler));                               //SmartEnemy
			}
			
			if(scoreKeep == 15000){
				hud.setWave(20);  
				handler.clearEnemies();
				handler.addObject(new EnemyBoss1(Game.WIDTH / 2 + 38, -155, ID.Enemy, handler));                                                                              //EnemyBoss1
			}
	}
}
