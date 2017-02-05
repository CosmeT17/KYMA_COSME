package Game.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Random;

import Game.main.Game.STATE;
import Enemies.BasicEnemy;

public class Menu extends MouseAdapter{

	private Game game;
	private Handler handler;
	private Random r = new Random();
	private boolean[] mouseDown = new boolean[2];
	private Font MU;
	private FontMetrics MU_SIZE;
	private Font title;
	private Font mainMenu;
		
	private int HP_UP = 0;
	
	public Menu(Game game, Handler handler){
		this.game = game;
		this.handler = handler;
		
		mouseDown[0] = true;
		mouseDown[1] = false;
	}
	
	public void mousePressed(MouseEvent e){
		int mx = e.getX();
		int my = e.getY();
		
		if(Game.gameRun == false){
			if(mouseDown[0] == true){
				//PLAY BUTTON
				if(mouseOver(mx, my, Game.WIDTH/4, Game.HEIGHT * 2/6 - (MU_SIZE.getHeight() / 2) - 40, Game.WIDTH * 3 / 4 - Game.WIDTH/4 , MU_SIZE.getHeight() + 20)){
					game.gameState = STATE.GAME;
					handler.clear(); // INSTA DEATH
					Game.FPStrace = 0;
					
					handler.addObject(new Player(Game.WIDTH/2-30, Game.HEIGHT/2-30, ID.Player, handler));
					handler.addObject(new BasicEnemy(Game.WIDTH / 2 + 40, Game.HEIGHT / 2 - 30, ID.Enemy, Color.red, handler));
					
					mouseDown[0] = false;
					mouseDown[1] = true;
				}	
				
				//INFO BUTTON
				if(mouseOver(mx, my, Game.WIDTH/4, Game.HEIGHT * 3/6 - (MU_SIZE.getHeight() / 2) - 40, Game.WIDTH * 3 / 4 - Game.WIDTH/4 , MU_SIZE.getHeight() + 20)){
					game.gameState = STATE.INFO;
					
					mouseDown[0] = false;
					mouseDown[1] = true;
				}
				
				//EXTRA BUTTON
				if(mouseOver(mx, my, Game.WIDTH/4, Game.HEIGHT * 4/6 - (MU_SIZE.getHeight() / 2) - 40, Game.WIDTH * 3 / 4 - Game.WIDTH/4 , MU_SIZE.getHeight() + 20)){
					game.gameState = STATE.EXTRA;
					
					mouseDown[0] = false;
					mouseDown[1] = true;
				}
				
				//EXIT BUTTON
				if(mouseOver(mx, my, Game.WIDTH/4, Game.HEIGHT * 5/6 - (MU_SIZE.getHeight() / 2) - 40, Game.WIDTH * 3 / 4 - Game.WIDTH/4 , MU_SIZE.getHeight() + 20)){
					System.exit(1);
					
					mouseDown[0] = false;
					mouseDown[1] = true;
				}
			}
			
			else{
				//BACK BUTTONS
				 if(mouseDown[1] == true){
					if(mouseOver(mx, my, Game.WIDTH/3, Game.HEIGHT * 5/6 - (MU_SIZE.getHeight() / 2) - 40, Game.WIDTH / 3, MU_SIZE.getHeight() + 20)){
						if(game.gameState == STATE.END){
							Game.gameOver = true;
						}else{
							game.gameState = STATE.MENU;
						}
						
						mouseDown[0] = true;
						mouseDown[1] = false;
					}
				}
				 
				//SHOP BUTTON
				 if(mouseDown[1] == true){
					if(mouseOver(mx, my, Game.WIDTH/4, Game.HEIGHT * 4/6 - (MU_SIZE.getHeight() / 2) - 40, Game.WIDTH * 3 / 4 - Game.WIDTH/4 , MU_SIZE.getHeight() + 20)){
						
						game.gameState = STATE.SHOP;
						
						mouseDown[0] = false;
						mouseDown[1] = false;
					}
				}
			}
		}
	}
	
	public void mouseReleased(MouseEvent e){
		
	}
	
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height){
		if(mx >= x && mx <= x + width){
			if(my >= y && my <= y + height){
				return true;
			} else return false; 
		} else return false;
	}
	
	public void tick(){
	}
	
	public void pauseTick(){
	}
	
	public void renderPause(Graphics g) {
		if(Game.gameRun){
		handler.hide(g);
		Game.gameRun = false;
		System.out.println("gameRun reached");
		}
		try{
			MU = MU.createFont(Font.TRUETYPE_FONT, new File("Mestizos Unidos.otf"));
		}
		catch(Exception e){}

		Font fnt = MU.deriveFont(Font.PLAIN, 85);
		g.setColor(Color.WHITE);
		g.setFont(fnt);
		g.drawString("PAUSE", Game.WIDTH/2 - MU_SIZE.stringWidth("PAUSE") / 2, /*Game.HEIGHT/7*/ Game.HEIGHT/2);
	}
	
	@SuppressWarnings("static-access")
	public void render(Graphics g){
		if(game.gameState == STATE.MENU){
			
						
			try{
				MU = MU.createFont(Font.TRUETYPE_FONT, new File("Mestizos Unidos.otf"));
			}
			catch(Exception e){}

			g.setColor(Color.white);
			title = MU.deriveFont(Font.BOLD, 100);
			mainMenu = MU.deriveFont(Font.PLAIN, 75);
			
			MU_SIZE = g.getFontMetrics(title);
			
			g.setFont(title);
			g.drawString("KYMA", Game.WIDTH/2 - MU_SIZE.stringWidth("KYMA") / 2, Game.HEIGHT/7);      //TITLE
			
			g.setFont(mainMenu);
			MU_SIZE = g.getFontMetrics(mainMenu); 
			
			g.drawRect(Game.WIDTH/4, Game.HEIGHT * 2/6 - (MU_SIZE.getHeight() / 2) - 40, Game.WIDTH * 3 / 4 - Game.WIDTH/4 , MU_SIZE.getHeight() + 20);    //PLAY
			g.drawString("PLAY", Game.WIDTH/2 - MU_SIZE.stringWidth("PLAY") / 2,  Game.HEIGHT * 2/6);
			
			g.drawRect(Game.WIDTH/4, Game.HEIGHT * 3/6 - (MU_SIZE.getHeight() / 2) - 40, Game.WIDTH * 3 / 4 - Game.WIDTH/4 , MU_SIZE.getHeight() + 20);       //INFO
			g.drawString("INFO", Game.WIDTH/2 - MU_SIZE.stringWidth("INFO") / 2,  Game.HEIGHT * 3/6);
			
			g.drawRect(Game.WIDTH/4, Game.HEIGHT * 4/6 - (MU_SIZE.getHeight() / 2) - 40, Game.WIDTH * 3 / 4 - Game.WIDTH/4 , MU_SIZE.getHeight() + 20);       //EXTRA
			g.drawString("EXTRA", Game.WIDTH/2 - MU_SIZE.stringWidth("EXTRA") / 2,  Game.HEIGHT * 4/6);
			
			g.drawRect(Game.WIDTH/4, Game.HEIGHT * 5/6 - (MU_SIZE.getHeight() / 2) - 40, Game.WIDTH * 3 / 4 - Game.WIDTH/4 , MU_SIZE.getHeight() + 20);
			g.drawString("EXIT", Game.WIDTH/2 - MU_SIZE.stringWidth("EXIT") / 2,  Game.HEIGHT * 5/6);
		}
		
		if(game.gameState == STATE.INFO){
			
			try{
				MU = MU.createFont(Font.TRUETYPE_FONT, new File("Mestizos Unidos.otf"));
			}
			catch(Exception e){}
			
			//Font fnt = new Font("MESTIZOS UNIDOS -URBAN HOOKUPZ", 1, 70);
			Font fnt = MU.deriveFont(Font.PLAIN, 85);
			//Font fnt2 = new Font("MESTIZOS UNIDOS -URBAN HOOKUPZ", 1, 50);
			Font fnt2 = new Font("Papyrus", 1, 25);
			
			g.setColor(Color.white);
			
			MU_SIZE = g.getFontMetrics(fnt);
			g.setFont(fnt);
			//g.drawString("INFO", 270, 110);      //INFO
			g.drawString("INFO", Game.WIDTH/2 - MU_SIZE.stringWidth("INFO") / 2, Game.HEIGHT/7);
			
			MU_SIZE = g.getFontMetrics(mainMenu);      //BACK
			g.setFont(mainMenu);
			g.drawRect(Game.WIDTH/4, Game.HEIGHT * 5/6 - (MU_SIZE.getHeight() / 2) - 40, Game.WIDTH * 3 / 4 - Game.WIDTH/4 , MU_SIZE.getHeight() + 20);
			g.drawString("BACK", Game.WIDTH/2 - MU_SIZE.stringWidth("BACK") / 2,  Game.HEIGHT * 5/6);
			
			//INSTRUCTIONS & INFO TEXT
			g.setFont(fnt2);
			g.drawString("Use the WASD keys to move the player and evade all enemies", 60, 175);
			g.drawString("Each bullet trail does no damage, only the bullet point", 60, 205);
			g.drawString("Every 10th wave has a unique STAGE BOSS", 60, 235);
			g.drawString("Once you defeat a boss, a checkpoint will appear", 60, 265);
			g.drawString("The final wave is wave 100", 60, 295);
			g.drawString("Have Fun!", 340, 495);
			
			try{
				MU = MU.createFont(Font.TRUETYPE_FONT, new File("aaron.ttf"));
			}
			catch(Exception e){}
			
			//Font fnt4 = new Font("aaronfaces", 1, 60);
			Font fnt3 = MU.deriveFont(Font.PLAIN, 60);
			
			//EMOJI
			g.setColor(Color.yellow);
			g.setFont(fnt3);
			g.drawString("flx", 480, 515);
		}
		
		if(game.gameState == STATE.EXTRA){
			Font fnt = MU.deriveFont(Font.PLAIN, 85);
			g.setColor(Color.white);
			
			g.setFont(fnt);
			g.drawString("EXTRA", Game.WIDTH/2 - MU_SIZE.stringWidth("EXTRA") / 2, Game.HEIGHT/7);      //EXTRA
			
			g.setFont(mainMenu);
			
			g.drawRect(Game.WIDTH/4, Game.HEIGHT * 4/6 - (MU_SIZE.getHeight() / 2) - 40, Game.WIDTH * 3 / 4 - Game.WIDTH/4 , MU_SIZE.getHeight() + 20);     // BACK
			g.drawString("SHOP", Game.WIDTH/2 - MU_SIZE.stringWidth("SHOP") / 2,  Game.HEIGHT * 4/6);
			
			g.drawRect(Game.WIDTH/4, Game.HEIGHT * 5/6 - (MU_SIZE.getHeight() / 2) - 40, Game.WIDTH * 3 / 4 - Game.WIDTH/4 , MU_SIZE.getHeight() + 20);     // BACK
			g.drawString("BACK", Game.WIDTH/2 - MU_SIZE.stringWidth("BACK") / 2,  Game.HEIGHT * 5/6);
		}
		
		if(game.gameState == STATE.SHOP){
			g.setColor(Color.white);
			
			try{
				MU = MU.createFont(Font.TRUETYPE_FONT, new File("Mestizos Unidos.otf"));
			}
			catch(Exception e){}
			
			Font fnt = MU.deriveFont(Font.PLAIN, 85);
			g.setFont(fnt);
			
			g.drawString("SHOP", Game.WIDTH/2 - MU_SIZE.stringWidth("SHOP") / 2, Game.HEIGHT/7);
			
			Font fnt2 = MU.deriveFont(Font.PLAIN, 50);
			g.setFont(fnt2);
			
			g.drawString("HEALTH", 50, 220);
			g.drawString("SPEED", 50, 320);
			//g.drawString("DEFENCE", 50, 420);
			//g.drawString("TELEPORT", 50, 520);
			
			try{
				MU = MU.createFont(Font.TRUETYPE_FONT, new File("Justo St.ttf"));
			}
			catch(Exception e){}
			
			Font stats = MU.deriveFont(Font.PLAIN, 35);
			g.setFont(stats);
			
			g.drawString("" + (int)HUD.HEALTH + "  P", 400, 215);
			g.drawString("" + HP_UP, 535, 215);
			
			g.drawPolygon(new int[] {370, 370, 347}, new int[] {184, 214, 199}, 3);
			g.drawPolygon(new int[] {371, 371, 348}, new int[] {184, 214, 199}, 3);
			g.drawPolygon(new int[] {372, 372, 349}, new int[] {184, 214, 199}, 3);
			
			g.drawPolygon(new int[] {625, 625, 648}, new int[] {184, 214, 199}, 3);
			g.drawPolygon(new int[] {626, 626, 649}, new int[] {184, 214, 199}, 3);
			g.drawPolygon(new int[] {627, 627, 650}, new int[] {184, 214, 199}, 3);
			
			g.setFont(mainMenu);
			g.drawRect(Game.WIDTH/4, Game.HEIGHT * 5/6 - (MU_SIZE.getHeight() / 2) - 40, Game.WIDTH * 3 / 4 - Game.WIDTH/4 , MU_SIZE.getHeight() + 20);     // BACK
			g.drawString("BACK", Game.WIDTH/2 - MU_SIZE.stringWidth("BACK") / 2,  Game.HEIGHT * 5/6);
		}
		
		if(game.gameState == STATE.END){
			handler.clear();
			g.setColor(Color.WHITE);
			Game.FPStrace = 20;
			
			MU_SIZE = g.getFontMetrics(title);
			g.setFont(title);
			
			g.drawString("GAME OVER", Game.WIDTH/2 - MU_SIZE.stringWidth("GAME OVER") / 2, Game.HEIGHT/7);
			
			try{
				MU = MU.createFont(Font.TRUETYPE_FONT, new File("Justo St.ttf"));
			}
			catch(Exception e){}
			
			Font score = MU.deriveFont(Font.PLAIN, 40);
			g.setFont(score);
			
			String tempStr = "Score: " + game.getScore();
			g.drawString(tempStr, Game.WIDTH / 2 - 100 , Game.HEIGHT * 2/7);
			
			tempStr = "Wave: " + game.getWave();
			g.drawString(tempStr, Game.WIDTH / 2 - 100, Game.HEIGHT * 3/7 - 50);
			
			MU_SIZE = g.getFontMetrics(mainMenu);
			g.setFont(mainMenu);
			
			g.drawRect(Game.WIDTH/4, Game.HEIGHT * 3/6 - (MU_SIZE.getHeight() / 2), Game.WIDTH * 3 / 4 - Game.WIDTH/4 , MU_SIZE.getHeight() + 20);
			g.drawString("SHOP", Game.WIDTH/2 - MU_SIZE.stringWidth("SHOP") / 2,  Game.HEIGHT * 3/6 + 40);
			
			g.drawRect(Game.WIDTH/4, Game.HEIGHT * 4/6 - (MU_SIZE.getHeight() / 2), Game.WIDTH * 3 / 4 - Game.WIDTH/4 , MU_SIZE.getHeight() + 20);
			g.drawString("RETRY", Game.WIDTH/2 - MU_SIZE.stringWidth("RETRY") / 2,  Game.HEIGHT * 4/6 + 40);
			
			g.drawRect(Game.WIDTH/4, Game.HEIGHT * 5/6 - (MU_SIZE.getHeight() / 2), Game.WIDTH * 3 / 4 - Game.WIDTH/4 , MU_SIZE.getHeight() + 20);
			g.drawString("BACK", Game.WIDTH/2 - MU_SIZE.stringWidth("BACK") / 2,  Game.HEIGHT * 5/6 + 40);
		}
	}
}
