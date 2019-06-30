import javax.swing.JFrame;

public class LeagueInvaders {
	JFrame frame;
	public static final int WIDTH = 500;
	public static final int HEIGHT = 800;
	GamePanel gamepanel;
	LeagueInvaders(){
		frame = new JFrame();
		gamepanel = new GamePanel();
	}
	void setup() {
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(gamepanel);
		frame.addKeyListener(gamepanel);
		frame.setVisible(true);
	}
public static void main(String[] args) {
	LeagueInvaders invaders = new LeagueInvaders();
	invaders.setup();
}
}
