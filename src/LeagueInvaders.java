import javax.swing.JFrame;

public class LeagueInvaders {
	JFrame frame;
	GamePanel gamepanel;
	public static final int WIDTH = 500;
	public static final int HEIGHT = 800;
	LeagueInvaders(){
	frame = new JFrame();
	gamepanel = new GamePanel();
	}
public static void main(String[] args) {
	LeagueInvaders l = new LeagueInvaders();
	l.setup();
	
}
void setup() {
	frame.add(gamepanel);
frame.setSize(WIDTH,HEIGHT);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setVisible(true);
frame.addKeyListener(gamepanel);
}
}
