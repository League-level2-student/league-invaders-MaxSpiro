import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;
	Font titleFont;
	Font smallFont;
	Timer frameDraw;
	Timer alienSpawn;
	Rocketship rocketship = new Rocketship(250,700,50,50);
	ObjectManager objectmanager = new ObjectManager(rocketship);
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	GamePanel(){
		titleFont = new Font("Arial",Font.PLAIN,48);
		smallFont = new Font("Arial",Font.PLAIN,32);
		frameDraw = new Timer(1000/60,this);
		frameDraw.start();
		if (needImage) {
		    loadImage ("space.png");
		}
	}
	@Override
	public void paintComponent(Graphics g){
		if(currentState == MENU){
		    drawMenuState(g);
		}else if(currentState == GAME){
		    drawGameState(g);
		}else if(currentState == END){
		    drawEndState(g);
		}
	}
	void updateMenuState() {
		
	}
	void updateGameState() {
		objectmanager.update();
		if(rocketship.isActive==false) {
			currentState=END;
		}
	}
	void updateEndState() {
		
	}
	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("League Invaders", 75, 100);
		g.setFont(smallFont);
		g.drawString("Press ENTER to start",100,350);
		g.drawString("Press SPACE for instructions", 50, 500);
	}
	void drawGameState(Graphics g) {
		g.drawImage(image,0,0,LeagueInvaders.WIDTH,LeagueInvaders.HEIGHT,null);
		objectmanager.draw(g);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("Score: "+objectmanager.getScore(), 75, 100);
	}
	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("Game Over", 125, 100);
		g.setFont(smallFont);
		g.drawString("Press ENTER to restart",100,500);
		g.drawString("Your score was "+objectmanager.getScore(),100,300);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(currentState == MENU){
		    updateMenuState();
		}else if(currentState == GAME){
		    updateGameState();
		}else if(currentState == END){
		    updateEndState();
		}
		repaint();
		
	}
	void startGame(){
		alienSpawn = new Timer(1000 , objectmanager);
	    alienSpawn.start();
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			if(currentState==END) {
				rocketship = new Rocketship(250,700,50,50);
				objectmanager = new ObjectManager(rocketship);
			}
		}
		if(e.getKeyCode()==KeyEvent.VK_SPACE) {
			if(currentState==MENU){
				JOptionPane.showMessageDialog(null, " Move with arrow keys \n "
						+ "Press space to shoot \n Shoot aliens before they crash into you!");
			}
		}
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
		    if (currentState == END) {
		        currentState = MENU;
		    } 
		    else if(currentState == MENU) {
		    	currentState=GAME;
		    	startGame();
		    }
		    else if(currentState == GAME){
		        currentState=END;
		        alienSpawn.stop();
		    }
		}
		
		if(currentState==GAME) {
			if (rocketship.y>0 && e.getKeyCode()==KeyEvent.VK_UP) {
			    rocketship.up();
			}
			if (rocketship.y<LeagueInvaders.HEIGHT && e.getKeyCode()==KeyEvent.VK_DOWN) {
				rocketship.down();
			}
			if (rocketship.x>0 && e.getKeyCode()==KeyEvent.VK_LEFT) {
				rocketship.left();
			}
			if (rocketship.x<LeagueInvaders.WIDTH && e.getKeyCode()==KeyEvent.VK_RIGHT) {
				rocketship.right();
			}
			if(e.getKeyCode()==KeyEvent.VK_SPACE) {
				objectmanager.addProjectile(rocketship.getProjectile());
			}

		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } catch (Exception e) {
	            
	        }
	        needImage = false;
	    }
	}
}
