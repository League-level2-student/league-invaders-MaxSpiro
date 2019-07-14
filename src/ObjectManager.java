import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener{
	Rocketship rocket;
	ArrayList <Projectile> projectiles = new ArrayList();
	ArrayList <Alien> aliens = new ArrayList();
	Random random = new Random();
	int score = 0;
	ObjectManager(Rocketship rocket){
		this.rocket = rocket;
	}
 void addProjectile(Projectile projectile) {
	 projectiles.add(projectile);
 }
 	void addAlien() {
 		aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH),0,50,50));
 	}
 	void update() {
 		for(int i=0; i<aliens.size(); i++) {
 			aliens.get(i).update();
 			if(aliens.get(i).y>LeagueInvaders.HEIGHT || aliens.get(i).y<0 || aliens.get(i).x>LeagueInvaders.WIDTH || aliens.get(i).x<0) {
 				aliens.get(i).isActive = false;
 			}
 		}
 		for(int i=0; i<projectiles.size(); i++) {
 			projectiles.get(i).update();
 			if(projectiles.get(i).y>LeagueInvaders.HEIGHT || projectiles.get(i).y<0 || projectiles.get(i).x>LeagueInvaders.WIDTH || projectiles.get(i).x<0) {
 				projectiles.get(i).isActive = false;
 			}
 		}
 		rocket.update();
 		checkCollision();
 		purgeObjects();
 	}
 	int getScore() {
 		return this.score;
 	}
 	void draw(Graphics g) {
 		rocket.draw(g);
 		for(int i=0;i<aliens.size();i++) {
 			aliens.get(i).draw(g);
 		}
 		for(int i=0;i<projectiles.size();i++) {
 			projectiles.get(i).draw(g);
 		}
 	}
 	void purgeObjects() {
 		for(int i=0;i<aliens.size();i++) {
 			if(aliens.get(i).isActive==false) {
 				aliens.remove(i);
 			}
 		}
 		for(int i=0;i<projectiles.size();i++) {
 			if(projectiles.get(i).isActive==false) {
 				projectiles.remove(i);
 			}
 		}
 	}
 	void checkCollision() {
 		for(int i=0;i<aliens.size();i++) {
 			if(aliens.get(i).collisionBox.intersects(rocket.collisionBox)) {
 				rocket.isActive = false;
 				System.out.println("collided");
 			}
 			for(int j=0;j<projectiles.size();j++) {
 				if(aliens.get(i).collisionBox.intersects(projectiles.get(j).collisionBox)) {
 					aliens.get(i).isActive=false;
 					projectiles.get(j).isActive=false;
 					score+=1;
 				}
 			}
 		}
 	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		addAlien();
	}
}
