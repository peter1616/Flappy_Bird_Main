package flappyBirdPac;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int WIDTH=600;
	public static final int HEIGHT=800;
	
	private int xCoor=0;
	private BufferedImage img;
	
	public GamePanel(){
		LoadImage();
	}

	private void LoadImage() {
		
		try{
			img = ImageIO.read(new File("C:/Users/Piotr/Desktop/FlappyBird/FlappyBird/Images/gamePanel.png"));
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		g.drawImage(img, xCoor, 0, null);
	}

}
