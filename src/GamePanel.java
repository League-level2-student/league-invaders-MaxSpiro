import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel{
final int MENU = 0;
final int GAME = 1;
final int END = 2;
int currentState = MENU;
Font titlefont;
Font smallfont;
GamePanel(){
	titlefont = new Font("Calibri",Font.PLAIN,48);
	smallfont = new Font("Calibri",Font.PLAIN,18);
}

void updateMenuState(){
	
}
void updateGameState() {
	
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
}