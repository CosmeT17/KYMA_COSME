package Game.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import Game.main.Game.STATE;

public class HUD{

	private Game game;
	private Handler handler;
	public static float HEALTH = 100;
	private float greenValue = 255;

	private boolean[] mouseDown = new boolean[2];
	private int score = 0;
	private int wave = 1;
	private Font J;
	private Font INFO;
	private FontMetrics J_SIZE;
	
	
	public HUD(Game game, Handler handler){
		this.game = game;
		this.handler = handler;
		
		mouseDown[0] = true;
		mouseDown[1] = false;
		
		try{
			J = J.createFont(Font.TRUETYPE_FONT, new File("Justo St.ttf"));
		}
		catch(Exception e){}
	}
	
	public boolean tick(){
		HEALTH = Game.clamp(HEALTH, 0, 100);
		greenValue = Game.clamp(greenValue, 0, 255);
		greenValue = HEALTH * 2;
		score++;
		if(HEALTH == 0){
			HEALTH = 100;
			return true;
		}
		return false;
	}
	
	public void render(Graphics g){
		
		g.setColor(Color.gray);
		g.fillRect(15, 15, 300, 32);
		
		g.setColor(new Color(75, (int)greenValue, 0));
		g.fillRect(15, 15, (int)HEALTH * 3, 32);
		
		g.setColor(Color.white);
		g.drawRect(15, 15, 300, 32);
		
		INFO = J.deriveFont(Font.BOLD, 10);

		J_SIZE = g.getFontMetrics(J);
		
		g.setFont(INFO);
		
		g.drawString("Score: " + score, 18, 64);
		g.drawString("Wave: " + wave, 19, 80);
	}
	
	
	public void setScore(int score){                       //MUTATOR (SETTER)
		this.score = score;
	}
	
	public int getScore(){                                 //ACCESSOR (GETTER)
		return score;
	}
	
	public void setWave(int level){                       //MUTATOR (SETTER)
		this.wave = level;
	}
	
	public int getWave(){                                 //ACCESSOR (GETTER)
		return wave;
	}
}
