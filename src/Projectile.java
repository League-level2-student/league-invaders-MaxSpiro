import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GameObject{

	Projectile(int x, int y, int width, int height){
		x = x;
		y = y;
		width = width;
		height = height;
		speed = 10;
	}
	void update() {
		y-=speed;
	}
	void draw(Graphics g) {
		g.setColor(Color.RED);
		g.drawRect(x, y, width, height);
	}
	
}
