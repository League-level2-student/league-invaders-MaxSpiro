import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
final int MENU = 0;
final int GAME = 1;
final int END = 2;
int currentState = MENU;
Timer frameDraw;
Font titlefont;
Font smallfont;
Rocketship rocket = new Rocketship(250,750,50,50);
ObjectManager objectmanager = new ObjectManager(rocket);
GamePanel(){
	titlefont = new Font("Calibri",Font.PLAIN,48);
	smallfont = new Font("Calibri",Font.PLAIN,18);
	frameDraw = new Timer(1000/60,this);
	frameDraw.start();
}

void updateMenuState(){
	
}
void updateGameState() {
	objectmanager.update();
}
void updateEndState() {
	
}
void drawMenuState(Graphics g) {
	g.setColor(Color.BLUE);
	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
	g.setFont(titlefont);
	g.setColor(Color.YELLOW);
	g.drawString("Leag Invaders",100,100);
	g.setFont(smallfont);
	g.drawString("Press ENTER to start", 150, 400);
	g.drawString("Press Space for instructions", 125, 600);
}
void drawGameState(Graphics g) {
	g.setColor(Color.BLACK);
	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
	objectmanager.draw(g);
}
void drawEndState(Graphics g) {
	g.setColor(Color.RED);
	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
	g.setFont(titlefont);
	g.setColor(Color.BLACK);
	g.drawString("Game Over!", 115,100);
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

@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void keyPressed(KeyEvent e) {
	if (e.getKeyCode()==KeyEvent.VK_ENTER) {
	    if (currentState == END) {
	        currentState = MENU;
	    } else {
	        currentState++;
	    }
	}   
	if(currentState == GAME) {
		if(rocket.y>0+rocket.speed) {
		if (e.getKeyCode()==KeyEvent.VK_UP) {
		    rocket.up();
		    
		}
		}
		if(rocket.y+rocket.height<LeagueInvaders.HEIGHT-rocket.speed) {
		if (e.getKeyCode()==KeyEvent.VK_DOWN) {
		    rocket.down();
		    
		    
		}
		}
		if(rocket.x>0+rocket.speed) {
		if (e.getKeyCode()==KeyEvent.VK_LEFT) {
		    rocket.left();
		}
		}
		if(rocket.x+rocket.width<LeagueInvaders.WIDTH-rocket.speed) {
		if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
		    rocket.right();
		}
		}
	}
	
}

@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
}