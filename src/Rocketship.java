import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject{

	Rocketship(int x, int y, int width, int height){
		x = x;
		y = y;
		width = width;
		height = height;
		speed = 10;
	}
	
	void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
	}
	public void right() {
        x+=speed;
    }
	public void left() {
        x-=speed;
    }
	public void up() {
        y-=speed;
    }
	public void down() {
        y+=speed;
    }

}
