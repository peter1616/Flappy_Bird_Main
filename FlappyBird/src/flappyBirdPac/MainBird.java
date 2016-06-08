package flappyBirdPac;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;
public class MainBird {

	private static JFrame window;
	public static Timer timer;
	
	private MainBird() {
		window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(GamePanel.WIDTH, GamePanel.HEIGHT);
		window.setLocationRelativeTo(null);
		window.setTitle("Flappy Bird");
		window.setResizable(false);
		window.setVisible(true);
	}
	
	private void  rendering(){
		MenuPanel mp = new MenuPanel();
		GamePanel gp = new GamePanel();
		
		timer = new Timer(20,new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				gp.repaint();
				gp.Move();
			}
		});
	
		window.add(mp);
		window.setVisible(true);
		
		while(mp.StartingPoint==false){
			try{
				Thread.sleep(10);
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		
		window.remove(mp);
		window.add(gp);
		gp.setVisible(true);
		window.revalidate();
		
		timer.start();
		
	}
	public static JFrame getWindow(){
		return window;
	}
	
	public static void main(String[] args) {
		MainBird mb = new MainBird();
		mb.rendering();
		

	}

}
