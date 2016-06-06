package flappyBirdPac;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class BirdImage {
	
	private BufferedImage img = null;
	private static int bird_dia = 40;
	public static int x = (GamePanel.WIDTH/2)-bird_dia/2;
	public static int y = GamePanel.HEIGHT/2;
	
	private static int speed = 2;
	private int acce = 1;
	
	
	public BirdImage(){
		LoadImage();
	}


	private void LoadImage() {
		
		try{
			img = ImageIO.read(new File("C:/Users/Piotr/git1/FlappyBird/Images/Bird.png"));
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
	public void drawBird(Graphics g){
		
		g.drawImage(img, x, y, null);
	}
	
	public void birdMovement(){
		
		if(y>=0 && y<=GamePanel.HEIGHT){
			speed += acce;
			y+= speed;
		}else{
			reset();
		}
	}

	public void goUpwards(){
		speed = -17;
	}
	
	private void reset() {
		speed = 2;
		y = GamePanel.HEIGHT/2;
		
	}
}
