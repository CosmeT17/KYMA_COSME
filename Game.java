package Game.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

import Enemies.ParticleEffect;
import Enemies.Spawn;
public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = -4201078827097160085L;
	
	public static final int WIDTH = 1000;
	public static final int HEIGHT = WIDTH / 12 * 9;
	public static int FPStrace = 20; // Modify to modify FPS
	public static boolean gameOver = false;
	public static boolean gameRun = false;
	private Thread thread;
	private boolean running = false;
	
	private Random r;
	private Handler handler;                                       //UPDATES AND RENDERS EVERY SINGLE GAME OBJECT
	
	private HUD hud;
	private Spawn spawner;
	
	public Menu menu;
	public ParticleEffect particle;
	
	public enum STATE{
		MENU,
		INFO,
		EXTRA,
		SHOP,
		END,
		GAME,
		PAUSE,
		REVERSEHIDE
	};
	
	public STATE gameState;
	
	public Game(){
		
		inGame();
		new Window(WIDTH, HEIGHT, "Kyma 1.5.0", this);
		gameState = STATE.MENU;
	}
	
	public void inGame(){
		gameOver = false;
		handler = new Handler();
		menu = new Menu(this, handler);
		particle = new ParticleEffect(this, handler);
		this.addKeyListener(new KeyInput(this, handler));
		this.addMouseListener(menu);

		hud = new HUD(this, handler);
		spawner = new Spawn(handler, hud);
		r = new Random();
		
	}

	public synchronized void start(){
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop(){
		try{
			thread.join();
			running = false;
			
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void run(){
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running){
			 long now = System.nanoTime();
			 delta += (now - lastTime) / ns;
			 lastTime = now;
			 while(delta >= 1){
				 tick();
				 delta--;
			 }
			 if(running)
				 render();
			 frames++;
			 
			 if(System.currentTimeMillis() - timer > 1000){
				 timer += 1000;
				 System.out.println("FPS: " + frames);
				 frames = 0;
			 }
			 try{
				 Thread.sleep(FPStrace);
			 }catch(Exception e){
				 e.printStackTrace();
			 }
		 }
		 stop();
	}
	
	private void tick(){
		
		if(gameState == STATE.END){
			if(gameOver){
				inGame();
				gameState = STATE.MENU;
			}
		}
		
		if(gameState == STATE.MENU || gameState == STATE.END || gameState == STATE.INFO || gameState == STATE.EXTRA || gameState == STATE.SHOP) {
			handler.tick();
			menu.tick();
		}
		
		else if(gameState == STATE.GAME){
			gameRun = true;
			spawner.tick();
			handler.tick();
			if(hud.tick()){
				gameState = STATE.END;
			}
		}
		else if(gameState == STATE.PAUSE){
			menu.pauseTick();
		}
	}
	
	private void render(){                              //BACKGROUND
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		if(gameState == STATE.MENU || gameState == STATE.INFO || gameState == STATE.EXTRA || gameState == STATE.END || gameState == STATE.SHOP){
			handler.render(g);
			menu.render(g);
			particle.render(g);
			
		}
		if(gameState == STATE.GAME){
			handler.render(g);
			hud.render(g);		
		}
		if(gameState == STATE.PAUSE) menu.renderPause(g);
		if(gameState == STATE.REVERSEHIDE){
				handler.restore(g);
				FPStrace = 1;
				gameState = STATE.GAME;
		}
		
		
		g.dispose();
		bs.show();
	}
	
	public static float clamp(float var, float min, float max){
		if(var >= max) return var = max;
		else if(var <= min) return var = min;
		else return var;
	}
	
	public int getScore(){
		return hud.getScore();
	}
	
	public int getWave(){
		return hud.getWave();
	}
	
	public static void main(String args[]){
		new Game();
	}
	
}
