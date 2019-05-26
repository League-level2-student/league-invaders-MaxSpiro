import java.awt.Color;
import java.awt.Graphics;

public class Alien extends GameObject{

	Alien(int x, int y , int width, int height){
		x = x;
		y = y;
		width = width;
		height = height;
		speed = 1;
		isActive = true;
	}
	void update() {
		y+=speed;
	}
	void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.drawRect(x, y, width, height);
	}
	
}
