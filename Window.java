package Game.main;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Window extends Canvas{

	private static final long serialVersionUID = -1864215488270890922L;
	
	public Window(int width, int height, String title, Game game){
		JFrame frame = new JFrame(title);                            // Create New JFrame frame
		
		frame.setPreferredSize(new Dimension(width, height));        // Set Frame Dimensions
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        // Makes Sure That Top Right X Works
		frame.setResizable(false);                                   // Not Resizable
		frame.setLocationRelativeTo(null);                           // Frame Positioned in Middle of Screen
		frame.add(game);                                             // Adding game Class Into Frame
		frame.setVisible(true);                                      // Can Actually See The Frame
		game.start();                                                // Runs Game Start Method
	}	
}