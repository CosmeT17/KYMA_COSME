package Game.main;

import java.awt.event.KeyEvent;

public class CheatCode {

	static private boolean [] ATTARI = new boolean [8]; //UP UP DOWN DOWN LEFT RIGHT ENTER . <- resets code
	CheatCode(){
		resetATTARI();
	}
	
	
	public static void resetATTARI(){
		ATTARI = KeyInput.memset(ATTARI, 8, false);
	}
	static public boolean checkCode(int key){
		
		
		if(ATTARI[0]){
			if(ATTARI[1]){
				if(ATTARI[2]){
					if(ATTARI[3]){
						if(ATTARI[4]){
							if(ATTARI[5]){
								if(ATTARI[6]){
									resetATTARI();
									return true;
								} else if(key == KeyEvent.VK_ENTER){
									ATTARI[6] = true;
									System.out.println("ENTER");
								}
							} else if(key == KeyEvent.VK_RIGHT){
								ATTARI[5] = true;
								System.out.println("RIGHT");
							}
						}else if(key == KeyEvent.VK_LEFT){
							ATTARI[4] = true;
							System.out.println("LEFT");
						}
					}else if(key == KeyEvent.VK_DOWN){
						ATTARI[3] = true;
						System.out.println("DOWN");
					}
				}else if(key == KeyEvent.VK_DOWN){
					ATTARI[2] = true;
					System.out.println("DOWN");
				}
			}else if(key == KeyEvent.VK_UP){
				ATTARI[1] = true;
				System.out.println("UP");
			}
		}else if(key == KeyEvent.VK_UP){
			ATTARI[0] = true;
			System.out.println("UP");
		}else {
			resetATTARI();
		}
		return false;	
	}
	static public boolean exit(int key){
		if(key == KeyEvent.VK_PERIOD){
			return true;
		}
		return false;
	}
}
