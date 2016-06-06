package flappyBirdPac;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
	
	BirdImage bi = new BirdImage();
	
	WallImage wi = new WallImage(GamePanel.WIDTH);
	WallImage wi2 = new WallImage(GamePanel.WIDTH+(GamePanel.WIDTH/2));
	
	public GamePanel(){
		LoadImage();
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mousePressed(e);
				bi.goUpwards();
			}
		});
	}

	private void LoadImage() {
		
		try{
			img = ImageIO.read(new File("C:/Users/Piotr/git1/FlappyBird/Images/gamePanel.png"));
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		g.drawImage(img, xCoor, 0, null);
		
		bi.drawBird(g);
		wi.drawWall(g);
		wi2.drawWall(g);
	}
	public void Move(){
		bi.birdMovement();
	}

}
