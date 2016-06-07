package flappyBirdPac;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

import javax.imageio.ImageIO;

public class WallImage {
	
	private Random r = new Random();
	public int X;
	public int Y = r.nextInt(GamePanel.HEIGHT-400)+200;
	private int width_Wall = 45;
	private int height = GamePanel.HEIGHT-Y;
	private int gap = 200;
	
	public static int speed = -6;
	
	private BufferedImage img = null;
	
	public WallImage(int X){
		this.X=X;
		
		LoadImage();
		
	}

	private void LoadImage() {
		try{
			img = ImageIO.read(new File("C:/Users/Piotr/git1/FlappyBird/Images/Wall.png"));
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
	
	public void drawWall(Graphics g){
		
		g.drawImage(img, X, Y, null);
		g.drawImage(img, X, (-GamePanel.HEIGHT)+(Y-gap), null);
	}
	public void wallMovement(){
		X+= speed;
		
		if(X<=-width_Wall){
			X = GamePanel.WIDTH;
			Y = r.nextInt(GamePanel.HEIGHT-400)+200;
			height = GamePanel.HEIGHT-Y;
		}
		Rectangle lowerRect = new Rectangle(X,Y,width_Wall,height);
		Rectangle upperRect = new Rectangle(X,0,width_Wall,GamePanel.HEIGHT-(height+gap));
		
		if(lowerRect.intersects(BirdImage.getBirdRect())||upperRect.intersects(BirdImage.getBirdRect())){
			
			try{
				Thread.sleep(500);
			}catch(Exception ex){
				ex.printStackTrace();
			}
			BirdImage.reset();
			wall_Reset();
		}
	}

	private void wall_Reset() {
		
		Y = r.nextInt(GamePanel.HEIGHT-400)+200;
		height = GamePanel.HEIGHT-Y;
		GamePanel.GameOver = true;
	}
}
